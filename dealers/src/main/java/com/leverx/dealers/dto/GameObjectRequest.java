package com.leverx.dealers.dto;

import com.leverx.dealers.entity.Game;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class GameObjectRequest {


    @NotNull
    private String title;
    @NotNull
    private Integer userId;
    @NotNull
    private LocalDateTime createdAt;
    @NotNull
    private LocalDateTime updatedAt;
    @NotNull
    private Integer gameId;


}
