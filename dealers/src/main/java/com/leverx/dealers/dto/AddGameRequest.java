package com.leverx.dealers.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AddGameRequest {

    @NotNull
    private Integer id;
    @NotNull
    private String name;
}
