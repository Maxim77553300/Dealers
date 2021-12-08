package com.leverx.dealers.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;


@Getter
@Setter
public class RegistrationRequest {

    @NotNull
    String firstName;
    @NotNull
    String lastName;

}
