package com.cm.cmuserservice.controllers;


import com.cm.cmuserservice.dto.UserDetailsRequestDto;
import com.cm.cmuserservice.services.api.IUserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("UserDetails")
public class UserDetailsController {
    private final IUserDetailsService userDetailsService;

    public UserDetailsController(IUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void saveUserDetails(@RequestBody UserDetailsRequestDto userDetailsRequestDto) {
        userDetailsService.saveUserDetails(userDetailsRequestDto);
    }
}
