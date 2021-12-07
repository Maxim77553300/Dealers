package com.leverx.dealers.controller;

import com.leverx.dealers.dto.*;
import com.leverx.dealers.entity.GameObject;
import com.leverx.dealers.service.GameObjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class GameObjectControllerImpl implements GameObjectController {

    GameObjectService gameObjectService;

    public GameObjectControllerImpl(GameObjectService gameObjectService) {
        this.gameObjectService = gameObjectService;
    }

    @GetMapping("/objects")
    @Override
    public ListGameObjectResponse findAllGameObject() {
        return mapToListGameObjectResponse(gameObjectService.findAllGameObject());
    }

    @PutMapping("/object/{id}")
    @Override
    public ResponseEntity<Void> editGameObject(@RequestBody @Valid GameObjectRequest gameObjectRequest, @PathVariable("id") Integer id) {
        gameObjectService.editGameObject(gameObjectRequest, id);
        return ResponseEntity.status(202).build();
    }

    @Override
    @PostMapping("/object")
    public ResponseEntity<Void> addGameObject(@RequestBody @Valid GameObjectRequest gameObjectRequest) {
        gameObjectService.addGameObject(gameObjectRequest);
        return ResponseEntity.status(202).build();
    }

    @DeleteMapping("/object/{id}")
    @Override
    public ResponseEntity<Void> deleteGameObject(@PathVariable("id") Integer id) {
        gameObjectService.deleteGameObject(id);
        return ResponseEntity.status(202).build();
    }

    @GetMapping("/object/{id}/rating")
    @Override
    public RatingDto getRating(@PathVariable("id") Integer gameObjectId) {
        RatingDto ratingDto = new RatingDto();
        ratingDto.setRating(gameObjectService.getRating(gameObjectId));
        return ratingDto;
    }

    @GetMapping("/objects/top")
    @Override
    public List<RatingResultDto> getTop() {

        return gameObjectService.getTop();
    }

    @GetMapping("/object/user/{id}")
    @Override
    public ListGameObjectResponse findAllGameObjectByUser(@PathVariable("id") Integer userId) {
        return mapToListGameObjectResponse(gameObjectService.findAllGameObjectByUser(userId));
    }

    @GetMapping("/object/game/{id}")
    @Override
    public ListGameObjectResponse findAllGameObjectByGame(@PathVariable("id") Integer gameId) {
        return mapToListGameObjectResponse(gameObjectService.findAllGameObjectByGame(gameId));
    }

    private ListGameObjectResponse mapToListGameObjectResponse(List<GameObject> gameObjectList) {
        ListGameObjectResponse listGameObjectResponse = new ListGameObjectResponse();
        listGameObjectResponse.setListGameObject(gameObjectList);
        return listGameObjectResponse;
    }

}
