package com.leverx.dealers.controller;

import com.leverx.dealers.dto.AddUserRequest;
import com.leverx.dealers.dto.RegistrationRequest;
import com.leverx.dealers.dto.RegistrationResponse;
import com.leverx.dealers.dto.RegistrationResultResponse;
import com.leverx.dealers.entity.User;
import com.leverx.dealers.repository.UserRepository;
import com.leverx.dealers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
public class UserControllerImpl implements UserController{

    private UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    @Override
    public ResponseEntity<Void> addUser(@RequestBody @Valid AddUserRequest addUserRequest) {
        userService.addUser(addUserRequest);
        return ResponseEntity.status(202).build();
    }

    @GetMapping("/users")
    @Override
    public List<User> allUsers() {


        return null;
    }

    @PostMapping("user/registration")
    RegistrationResponse registration(@RequestBody @Valid AddUserRequest addUserRequest) {
        String link = userService.registration(addUserRequest);
        return new RegistrationResponse(link);

    }


    @GetMapping("user/registration/{uuid}")
    RegistrationResultResponse continueRegistration(@PathVariable("uuid") String uuid) {
        return new RegistrationResultResponse(userService.continueRegistration(uuid));
    }


//    @Override
//    @PostMapping("/auth/forgot_password")
//    RegistrationResponse sendEmailPassword(@RequestBody @Valid RegistrationRequest request){
//        return null;
//    }
//    @Override
//    @PostMapping("/auth/reset")
//    RegistrationResponse resetPassword(@RequestBody @Valid RegistrationRequest request){
//        return null;
//    }
//    @Override
//    @GetMapping("/auth/check_code/{code}")
//    RegistrationResponse checkCode(@PathVariable UUID code){
//        return null;
//    }
}
