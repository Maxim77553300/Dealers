package com.leverx.dealers.dto;

import com.leverx.dealers.entity.Game;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@ToString
public class ListGameResponse {

    @NotNull
    List<Game> games;


}
