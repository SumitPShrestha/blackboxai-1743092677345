package com.cm.securityservice.services.impl;

import com.cm.securityservice.config.JwtTokenProvider;
import com.cm.securityservice.dtos.Credentials;
import com.cm.securityservice.dtos.UserPrinciple;
import com.cm.securityservice.services.api.IAuthService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthServiceImpl implements IAuthService {
    @Autowired
    public AuthenticationManager authenticationManager;
    @Autowired
    public JwtTokenProvider jwtTokenProvider;

    public UserPrinciple doLogin(Credentials credentials) {
        // 01 - AuthenticationManager is used to authenticate the user
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(credentials.username(), credentials.password()));

        /* 02 - SecurityContextHolder is used to allows the rest of the application to know
        that the user is authenticated and can use user data from Authentication object */
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // 03 - Generate the token based on username and secret key
        String token = jwtTokenProvider.generateToken(authentication);

        // 04 - Return the token to controller
        return UserPrinciple.builder().username(credentials.username()).token(token).build();
    }

}
