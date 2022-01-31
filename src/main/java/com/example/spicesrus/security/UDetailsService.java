package com.example.spicesrus.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UDetailsService implements UserDetailsService {

    @Autowired
    private UDetailsRepo repo;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UDetails details = repo.findByUsername(login);
        return new User(details.getUsername(), details.getPassword(), true, true, true, true, Collections.emptyList());
    }
}
