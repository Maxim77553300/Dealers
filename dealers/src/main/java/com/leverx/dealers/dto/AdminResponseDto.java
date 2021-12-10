package com.leverx.dealers.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AdminResponseDto {

    @NotNull
    @Min(0)
    @Max(1)
    private Integer adminResponse = 0;
}
