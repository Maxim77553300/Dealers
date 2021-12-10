package com.leverx.dealers.service;

import com.leverx.dealers.dto.AddUserRequest;
import org.springframework.security.core.userdetails.UserDetailsService;



    void confirm(String code);

    void forgotPassword(String email);

    boolean checkCode(String code);

    void reset(String code, String password);
}
