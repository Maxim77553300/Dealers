package com.leverx.dealers.dto;

import com.leverx.dealers.entity.Game;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class ListGameResponse {
    @NotNull
    List<Game> listGame;

}
