package com.leverx.dealers.service;

import com.leverx.dealers.dto.AddGameRequest;
import com.leverx.dealers.entity.Game;
import com.leverx.dealers.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    GameRepository gameRepository;

    @Override
    public List<Game> findAllGame() {
        return gameRepository.findAll();
    }

    @Override
    public boolean addGame(AddGameRequest addGameRequest) {
        try {
            gameRepository.save(mapAddGameToRequest(addGameRequest));
            return true;
        } catch (Exception e) {
            return false;
        }

    }


    @Override
    public boolean updateGame(AddGameRequest addGameRequest) {
        if (gameRepository.findAllById(Collections.singleton(addGameRequest.getId())).isEmpty()) {
            //System.out.println("Error! This game is not found");
            return false;
        } else {
            gameRepository.save(updateGameToRequest(addGameRequest));
        }
        return true;
    }

    private Game mapAddGameToRequest(AddGameRequest addGameRequest) {
        Game game = new Game();
        game.setName(addGameRequest.getName());
        return game;
    }

    private Game updateGameToRequest(AddGameRequest addGameRequest) {
        Game game = new Game();
        UUID id = addGameRequest.getId();
        game.setId(id);
        game.setName(addGameRequest.getName());
        return game;
    }
}
