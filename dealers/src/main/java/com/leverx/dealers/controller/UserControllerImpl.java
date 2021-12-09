package com.leverx.dealers.controller;

import com.leverx.dealers.dto.AddUserRequest;
import com.leverx.dealers.dto.CheckCodeResponse;
import com.leverx.dealers.dto.ForgotPasswordRequest;
import com.leverx.dealers.dto.ResetRequest;
import com.leverx.dealers.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserControllerImpl implements UserController{

    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    @PostMapping("/register")
    public void register(@RequestBody @Valid AddUserRequest addUserRequest) {
        userService.registration(addUserRequest);
    }

    @Override
    @GetMapping("/confirm/{code}")
    public void confirm(@PathVariable("code") String code) {
        userService.confirm(code);
    }

    @GetMapping("/users")
    @Override
    @PostMapping("/forgot_password")
    public void forgotPassword(@RequestBody @Valid ForgotPasswordRequest emailDto) {
        userService.forgotPassword(emailDto.getEmail());
    }

    @Override
    @GetMapping("/check_code/{code}")
    public CheckCodeResponse checkCode(@PathVariable("code") String code) {
        return new CheckCodeResponse(userService.checkCode(code));
    }

    @Override
    @PostMapping("/reset")
    public void reset(@RequestBody @Valid ResetRequest request) {
        userService.reset(request.getCode(), request.getPassword());
    }
}
