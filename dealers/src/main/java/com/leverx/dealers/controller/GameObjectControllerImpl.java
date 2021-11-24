package com.leverx.dealers.controller;

import com.leverx.dealers.dto.AddGameObjectRequest;
import com.leverx.dealers.dto.AddUserRequest;
import com.leverx.dealers.dto.ListCommentResponse;
import com.leverx.dealers.dto.ListGameObjectResponse;
import com.leverx.dealers.entity.Comment;
import com.leverx.dealers.entity.GameObject;
import com.leverx.dealers.service.GameObjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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


    @GetMapping("/gameobjects")
    @Override
    public ListGameObjectResponse findAllGameObject() {
        List<GameObject> gameObjects = gameObjectService.findAllGameObject();
        ListGameObjectResponse listGameObjectResponse = new ListGameObjectResponse();
        listGameObjectResponse.setListGameObject(gameObjects);
        return listGameObjectResponse;
    }



    @GetMapping("/comments")
    @Override
    public ListCommentResponse findAllPostsAuthor(AddUserRequest addUserRequest) {
        List<Comment> allGameObjectCommentByAuthor = gameObjectService.getListCommentsOfAuthor(addUserRequest);
        ListCommentResponse listCommentResponse = new ListCommentResponse();
        listCommentResponse.setListComment(allGameObjectCommentByAuthor);

        return listCommentResponse;
    }


    @DeleteMapping("/gameobjects")
    @Override
    public ResponseEntity<?> deleteGameObject(@RequestBody AddGameObjectRequest addGameObjectRequest) {
        gameObjectService.deleteGameObject(addGameObjectRequest);
        return ResponseEntity.status(202).build();

    }
}
