package com.leverx.dealers.controller;

import com.leverx.dealers.dto.AddGameObjectRequest;
import com.leverx.dealers.service.GameObjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GameObjectControllerImpl implements GameObjectController {

    GameObjectService gameObjectService;

    @PutMapping("/gameobjects")
    @Override
    public ResponseEntity<?> redactGameObject(AddGameObjectRequest addGameObjectRequest) {
        gameObjectService.redactGameObject(addGameObjectRequest);
        return ResponseEntity.status(202).build();
    }


    @Override
    @PostMapping("/gameobjects")
    public ResponseEntity<?> addGameObject(AddGameObjectRequest addGameObjectRequest) {
        gameObjectService.addGameObject(addGameObjectRequest);
        return ResponseEntity.status(202).build();
    }

    @Override
    public String findAllGameObject(String name, Model model) {
        return null;
    }

    @Override
    public String findAllPostsAuthor(String nameAuthor, Model model) {
        return null;
    }

    @Override
    public String deleteGameObject(String nameGAmeObject, Model model) {
        return null;
    }
}
