package com.leverx.dealers.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RegistrationResponse {

    @NotNull
    String link;

    public RegistrationResponse(@NotNull String link) {
        this.link = link;
    }
}
