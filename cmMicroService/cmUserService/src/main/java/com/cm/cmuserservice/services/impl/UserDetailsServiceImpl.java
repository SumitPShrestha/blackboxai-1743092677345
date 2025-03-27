package com.cm.cmuserservice.services.impl;

import com.cm.cmuserservice.dto.UserDetailsRequestDto;
import com.cm.cmuserservice.models.UserDetails;
import com.cm.cmuserservice.repositories.IUserDetailsRepository;
import com.cm.cmuserservice.services.api.IUserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements IUserDetailsService {

    private final IUserDetailsRepository userDetailsRepo;

    public UserDetailsServiceImpl(IUserDetailsRepository userDetailsRepository) {
        this.userDetailsRepo = userDetailsRepository;
    }

    @Override
    public void saveUserDetails(UserDetailsRequestDto dto) {
        userDetailsRepo.save(UserDetails.builder().firstName(dto.firstName()).middleName(dto.middleName()).lastName(dto.lastName()).gender(dto.gender()).birthDate(dto.birthDate()).build());
    }
}
