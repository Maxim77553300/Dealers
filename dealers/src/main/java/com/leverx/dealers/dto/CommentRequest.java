package com.leverx.dealers.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CommentRequest {
    @NotNull
    private String message;
    @NotNull
    private Boolean approved;
    @NotNull
    @Max(100)
    @Min(0)
    private Integer rating;
    @NotNull
    private Integer gameObjectId;
}
