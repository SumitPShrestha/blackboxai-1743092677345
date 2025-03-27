package com.cm.securityservice.controllers;

import com.cm.securityservice.dtos.Credentials;
import com.cm.securityservice.dtos.UserPrinciple;
import com.cm.securityservice.services.api.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private IAuthService authService;

    // Build Login REST API
    @PostMapping("/login")
    public ResponseEntity<UserPrinciple> login(@RequestBody Credentials loginDto) {

        //01 - Receive the token from AuthService
        UserPrinciple userPrinciple = authService.doLogin(loginDto);

        //02 - Set the token as a response using JwtAuthResponse Dto class

        //03 - Return the response to the user
        return ResponseEntity.ok(userPrinciple);
    }

    @GetMapping("/login")
    public String test() {
        return "ABCDEFG";
    }

}
