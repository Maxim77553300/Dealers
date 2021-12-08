package com.leverx.dealers.service;

import com.leverx.dealers.dto.AddUserRequest;
import com.leverx.dealers.dto.RegistrationRequest;
import org.springframework.security.core.userdetails.UserDetailsService;



public interface UserService extends UserDetailsService {

    void addUser(AddUserRequest addUserRequest);

    String registration(AddUserRequest addUserRequest);

    boolean continueRegistration(String registrationUuid);
}
