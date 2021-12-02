package com.leverx.dealers.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class CommentRequest {

    @NotNull
    private String message;
    @NotNull
    private Integer userId;
    @NotNull
    private LocalDateTime createdAt;
    @NotNull
    private Boolean approved;
    @NotNull
    private Integer rating;
    @NotNull
    private Integer gameObjectId;


}
