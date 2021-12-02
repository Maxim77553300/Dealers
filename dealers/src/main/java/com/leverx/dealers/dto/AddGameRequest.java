package com.leverx.dealers.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class AddGameRequest {


    @NotBlank
    private String name;


}
