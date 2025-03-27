package com.cm.cmuserservice.services.api;

import com.cm.cmuserservice.dto.UserDetailsRequestDto;

public interface IUserDetailsService {
    void saveUserDetails(UserDetailsRequestDto dto);
}
