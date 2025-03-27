package com.cm.securityservice.services.impl;


import com.cm.securityservice.models.CmUser;
import com.cm.securityservice.repositories.CmUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    CmUsersRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        CmUser user = userRepository.findByUsername(username);

        Set<GrantedAuthority> authorities = user.getRoles().stream().map((role) -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(username, user.getPassword(), authorities);
    }
}