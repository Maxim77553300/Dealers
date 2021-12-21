package com.leverx.dealers.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

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
