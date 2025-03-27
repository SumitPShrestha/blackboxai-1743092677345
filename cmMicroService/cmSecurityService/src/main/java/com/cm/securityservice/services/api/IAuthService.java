package com.cm.securityservice.services.api;

import com.cm.securityservice.dtos.Credentials;
import com.cm.securityservice.dtos.UserPrinciple;

public interface IAuthService {
    UserPrinciple doLogin(Credentials credentials);

}
