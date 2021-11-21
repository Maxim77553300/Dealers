package com.leverx.dealers.service;

import com.leverx.dealers.dto.AddGameRequest;
import com.leverx.dealers.entity.Game;

import java.util.List;

public interface GameService {

    List<Game> findAllGame();

    boolean addGame(AddGameRequest addGameRequest);

    boolean updateGame(AddGameRequest addGameRequest);
}
