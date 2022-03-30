package com.spicesrus.service;

import com.spicesrus.model.UDetails;
import com.spicesrus.repository.UDetailsRepo;
import com.spicesrus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    private SimpleGrantedAuthority basic = new SimpleGrantedAuthority("BASIC");
    private SimpleGrantedAuthority novice = new SimpleGrantedAuthority("NOVICE");
    private SimpleGrantedAuthority expert = new SimpleGrantedAuthority("EXPERT");
    private SimpleGrantedAuthority admin = new SimpleGrantedAuthority("ADMIN");
    private List<SimpleGrantedAuthority> roles = List.of(basic, novice, expert, admin);


    public List<SimpleGrantedAuthority> getRoles() {
        return roles;
    }
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<com.spicesrus.model.User> query = userRepository.findByUsername(login);
        com.spicesrus.model.User user = query.get();
        if (user == null) throw new UsernameNotFoundException("Credentials Invalid");

        List<SimpleGrantedAuthority> matched = new ArrayList<>();
        matched.add(basic);

        roles.forEach(role -> {
            if (user.getAuthorities().contains(role.getAuthority())) matched.add(role);
        });

        return new User(user.getUsername(), user.getPassword(), true, true, true, true, matched);
    }

    public void update(com.spicesrus.model.User user) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<SimpleGrantedAuthority> matched = new ArrayList<>();
        matched.add(basic);

        roles.forEach(role -> {
            if (user.getAuthorities().contains(role.getAuthority())) matched.add(role);
        });

        Authentication tmp = new UsernamePasswordAuthenticationToken(auth.getPrincipal(), auth.getCredentials(), matched);
        SecurityContextHolder.getContext().setAuthentication(tmp);
    }

}
