package com.leverx.dealers.dto;

import com.leverx.dealers.entity.Game;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ListGameResponse {

    List<Game> listGame;

}
