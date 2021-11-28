package com.leverx.dealers.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
public class AddGameRequest {

    @NotNull
    private UUID id;
    @NotNull
    private String name;


}
