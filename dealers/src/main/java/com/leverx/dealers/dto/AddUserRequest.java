package com.leverx.dealers.dto;

import com.leverx.dealers.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AddUserRequest {

    private Integer id;
    private String first_name;
    private String last_name;
    private String password;
    private String email;
    private Date created_at;
    private Role role;
}
