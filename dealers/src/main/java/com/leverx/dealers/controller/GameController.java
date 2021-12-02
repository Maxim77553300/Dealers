package com.leverx.dealers.controller;

import com.leverx.dealers.dto.AddGameRequest;
import com.leverx.dealers.dto.ListGameResponse;
import org.springframework.http.ResponseEntity;

public interface GameController {

    ListGameResponse findAllGame();

    ResponseEntity<?> addGame(AddGameRequest addGameRequest);

    ResponseEntity<?> updateGame(AddGameRequest addGameRequest,Integer id);
}
