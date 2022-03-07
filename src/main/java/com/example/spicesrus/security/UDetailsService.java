package com.example.spicesrus.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UDetailsService implements UserDetailsService {

    @Autowired
    private UDetailsRepo repo;

    private SimpleGrantedAuthority basic = new SimpleGrantedAuthority("BASIC");
    private SimpleGrantedAuthority novice = new SimpleGrantedAuthority("NOVICE");
    private SimpleGrantedAuthority expert = new SimpleGrantedAuthority("EXPERT");
    private SimpleGrantedAuthority admin = new SimpleGrantedAuthority("ADMIN");
    private List<SimpleGrantedAuthority> roles = List.of(basic, novice, expert, admin);

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UDetails details = repo.findByUsername(login);
        if (details == null) throw new UsernameNotFoundException("Credentials Invalid");

        List<SimpleGrantedAuthority> matched = new ArrayList<>();
        matched.add(basic);

        roles.forEach(role -> {
            if (details.getAuthorities().contains(role.getAuthority())) matched.add(role);
        });

        return new User(details.getUsername(), details.getPassword(), true, true, true, true, matched);
    }

    /**
     * Changes the user to another plan
     *
     * @param user - The user to modify
     * @param plan - The plan to change them to (basic, novice, expert)
     */
    public void updateUser(UDetails user, String plan) {
        List<String> l = user.getAuthorities();
        l.removeAll(List.of("BASIC", "NOVICE", "EXPERT"));
        l.add(plan);
        user.setAuthorities(l);

        List<SimpleGrantedAuthority> matched = new ArrayList<>();
        matched.add(basic);

        roles.forEach(role -> {
            if (l.contains(role.getAuthority())) matched.add(role);
        });

        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(SecurityContextHolder.getContext().getAuthentication().getPrincipal(), SecurityContextHolder.getContext().getAuthentication().getCredentials(), matched));
        user.setAuthorities(l);
        repo.save(user);
    }
}
