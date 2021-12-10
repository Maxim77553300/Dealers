package com.leverx.dealers.controller;

import com.leverx.dealers.dto.AddGameRequest;
import com.leverx.dealers.dto.FilterResultGameDto;
import com.leverx.dealers.dto.ListGameResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GameController {

    ListGameResponse findAllGame();

    ResponseEntity<?> addGame(AddGameRequest addGameRequest);

    ResponseEntity<?> updateGame(AddGameRequest addGameRequest,Integer id);

    List<FilterResultGameDto> findAllGamesByMinRating();

    List<FilterResultGameDto> findAllGamesByMaxRating();
}
