package com.leverx.dealers.dto;

import com.leverx.dealers.entity.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@ToString
public class AddUserRequest {
    @NotNull
    private String first_name;
    @NotNull
    private String last_name;
    @NotNull
    private String password;
    @NotNull
    private String email;
}
