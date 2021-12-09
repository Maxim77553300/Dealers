package com.leverx.dealers.controller;

import com.leverx.dealers.dto.AddUserRequest;
import com.leverx.dealers.dto.CheckCodeResponse;
import com.leverx.dealers.dto.ForgotPasswordRequest;
import com.leverx.dealers.dto.ResetRequest;

public interface UserController {

    void register(AddUserRequest addUserRequest);

    void confirm(String code);

    void forgotPassword(ForgotPasswordRequest request);

    CheckCodeResponse checkCode(String code);

    void reset(ResetRequest resetRequest);
}