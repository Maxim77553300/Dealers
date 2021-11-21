package com.leverx.dealers.controller;

import com.leverx.dealers.dto.AddGameRequest;
import com.leverx.dealers.dto.ListGameResponse;
import com.leverx.dealers.entity.Game;
import com.leverx.dealers.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameControllerImpl implements GameController {


    GameService gameService;

    public GameControllerImpl(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    @GetMapping("/games")
    public ListGameResponse findAllGame() {
        List<Game> allGames = gameService.findAllGame();
        ListGameResponse listGameResponse = new ListGameResponse();
        listGameResponse.setListGame(allGames);
        return listGameResponse;
    }

    @Override
    @PostMapping("/games")
    public ResponseEntity<?> addGame(@RequestBody AddGameRequest addGameRequest) {
        gameService.addGame(addGameRequest);
        return ResponseEntity.status(202).build();
    }

    @Override
    @PutMapping("/games")
    public ResponseEntity<?> updateGame(@RequestBody AddGameRequest addGameRequest) {
        gameService.updateGame(addGameRequest);
        return ResponseEntity.status(202).build();
    }
}
