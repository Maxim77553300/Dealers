package com.leverx.dealers.service;

import com.leverx.dealers.dto.AddUserRequest;
import com.leverx.dealers.dto.AdminResponseDto;




    void confirm(String code);

    void forgotPassword(String email);

    boolean checkCode(String code);

    void reset(String code, String password);

    AdminResponseDto confirmForAdmin(String code);
}
