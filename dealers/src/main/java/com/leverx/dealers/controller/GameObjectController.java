package com.leverx.dealers.controller;

import com.leverx.dealers.dto.GameObjectRequest;
import com.leverx.dealers.dto.ListGameObjectResponse;
import org.springframework.http.ResponseEntity;

public interface GameObjectController {

    ListGameObjectResponse findAllGameObject();

    ListGameObjectResponse findAllGameObjectByUser(Integer userId);

    ListGameObjectResponse findAllGameObjectByGame(Integer gameId);

    ResponseEntity<Void> addGameObject(GameObjectRequest gameObjectRequest);

    ResponseEntity<Void> editGameObject(GameObjectRequest gameObjectRequest, Integer id);

    ResponseEntity<Void> deleteGameObject(Integer id);

    //RatingDto getRating();


}
