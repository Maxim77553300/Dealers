package com.leverx.dealers.service;

import com.leverx.dealers.dto.AddGameRequest;
import com.leverx.dealers.entity.Game;
import com.leverx.dealers.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Override
    public List<Game> findAllGame() {
        return gameRepository.findAll();
    }

    @Override
    public void addGame(AddGameRequest addGameRequest) {

        gameRepository.save(mapAddGameToRequest(addGameRequest));

    }

    @Override
    public void updateGame(AddGameRequest addGameRequest) {
        gameRepository.save(updateGameToRequest(addGameRequest));
    }

    private Game mapAddGameToRequest(AddGameRequest addGameRequest) {

        return Game.builder().name(addGameRequest.getName()).build();

    }

    private Game updateGameToRequest(AddGameRequest addGameRequest) {

        return Game.builder().id(addGameRequest.getId()).name(addGameRequest.getName()).build();

    }
}
