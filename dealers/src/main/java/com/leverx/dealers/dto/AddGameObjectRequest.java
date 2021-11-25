package com.leverx.dealers.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class AddGameObjectRequest {

    @NotNull
    private UUID id;
    @NotNull
    private String title;
    @NotNull
    private Integer author_id;
    @NotNull
    private Date created_at;
    @NotNull
    private Date updated_at;
    @NotNull
    private Integer game_id;
}
