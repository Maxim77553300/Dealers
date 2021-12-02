package com.leverx.dealers.controller;

import com.leverx.dealers.dto.GameObjectRequest;
import com.leverx.dealers.dto.ListGameObjectResponse;
import com.leverx.dealers.service.GameObjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class GameObjectControllerImpl implements GameObjectController {

    GameObjectService gameObjectService;

    public GameObjectControllerImpl(GameObjectService gameObjectService) {
        this.gameObjectService = gameObjectService;
    }

    @GetMapping("/objects")
    @Override
    public ListGameObjectResponse findAllGameObject() {
        ListGameObjectResponse listGameObjectResponse = new ListGameObjectResponse();
        listGameObjectResponse.setListGameObject(gameObjectService.findAllGameObject());
        return listGameObjectResponse;
    }

    @PutMapping("/object/{id}")
    @Override
    public ResponseEntity<Void> editGameObject(@RequestBody @Valid GameObjectRequest gameObjectRequest,@PathVariable("id")  Integer id) {
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

    @GetMapping("/object/user/{id}")
    @Override
    public ListGameObjectResponse findAllGameObjectByUser(@PathVariable("id") Integer userId) {
        return gameObjectService.findAllGameObjectByUser(userId);
    }

    @GetMapping("/object/game/{id}")
    @Override
    public ListGameObjectResponse findAllGameObjectByGame(@PathVariable("id") Integer gameId) {
        return gameObjectService.findAllGameObjectByGame(gameId);
    }

}
