package com.leverx.dealers.service;

import com.leverx.dealers.dto.AddGameRequest;
import com.leverx.dealers.entity.Game;

import java.util.List;

public interface GameService {

    List<Game> findAllGame();

    void addGame(AddGameRequest addGameRequest);

    void updateGame(AddGameRequest addGameRequest,Integer id);
}
