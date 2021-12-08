package com.leverx.dealers.controller;

import com.leverx.dealers.dto.AddUserRequest;
import com.leverx.dealers.dto.RegistrationRequest;
import com.leverx.dealers.dto.RegistrationResponse;
import com.leverx.dealers.dto.RegistrationResultResponse;
import com.leverx.dealers.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

public interface UserController {

    ResponseEntity<Void> addUser(AddUserRequest addUserRequest);

    List<User> allUsers();

    RegistrationResultResponse continueRegistration(String uuid);

    RegistrationResponse registration(RegistrationRequest request);

//    RegistrationResponse sendEmailPassword(RegistrationRequest request)
//
//    RegistrationResponse resetPassword(RegistrationRequest request)
//
//    RegistrationResponse checkCode(UUID code);
}