package com.leverx.dealers.service;

import com.leverx.dealers.dto.AddGameRequest;
import com.leverx.dealers.entity.Game;

import java.util.List;

public interface GameService {

    List<Game> findAllGame(AddGameRequest addGameRequest);

    boolean addGame(AddGameRequest addGameRequest);

    Game updateGame(AddGameRequest addGameRequest);
}
