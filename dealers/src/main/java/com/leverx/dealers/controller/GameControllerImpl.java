package com.leverx.dealers.controller;

import com.leverx.dealers.dto.AddGameRequest;
import com.leverx.dealers.dto.ListGameResponse;
import com.leverx.dealers.entity.Game;
import com.leverx.dealers.service.GameService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        return mapFindAllGame(gameService.findAllGame());
    }

    @Override
    @PostMapping("/games")
    public ResponseEntity<Void> addGame(@RequestBody @Valid AddGameRequest addGameRequest) {
        gameService.addGame(addGameRequest);
        return ResponseEntity.status(202).build();
    }

    @Override
    @PutMapping("/games/{id}")
    public ResponseEntity<Void> updateGame(@RequestBody @Valid AddGameRequest addGameRequest,@PathVariable("id") Integer id) {
        gameService.updateGame(addGameRequest,id);
        return ResponseEntity.status(202).build();
    }

    private ListGameResponse mapFindAllGame(List<Game> allGames) {
        return ListGameResponse.builder().games(allGames).build();
    }
}
