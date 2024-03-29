package com.leverx.dealers.controller;

import com.leverx.dealers.dto.GameObjectRequest;
import com.leverx.dealers.dto.ListGameObjectResponse;
import com.leverx.dealers.dto.RatingDto;
import com.leverx.dealers.dto.RatingResultForTradersDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GameObjectController {

    ListGameObjectResponse findAllGameObject();

    ListGameObjectResponse findAllGameObjectByUser(Integer userId);

    ListGameObjectResponse findAllGameObjectByGame(Integer gameId);

    ResponseEntity<Void> addGameObject(GameObjectRequest gameObjectRequest);

    ResponseEntity<Void> editGameObject(GameObjectRequest gameObjectRequest, Integer id);

    ResponseEntity<Void> deleteGameObject(Integer id);

    RatingDto getRating(Integer gameObjectId);

    List<RatingResultForTradersDto> getTop();


}
