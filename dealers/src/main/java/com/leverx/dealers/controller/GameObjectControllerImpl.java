package com.leverx.dealers.controller;

import com.leverx.dealers.dto.AddCommentRequest;
import com.leverx.dealers.dto.AddGameObjectRequest;
import com.leverx.dealers.dto.ListCommentResponse;
import com.leverx.dealers.dto.ListGameObjectResponse;
import com.leverx.dealers.entity.Comment;
import com.leverx.dealers.entity.GameObject;
import com.leverx.dealers.service.CommentService;
import com.leverx.dealers.service.GameObjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class GameObjectControllerImpl implements GameObjectController {

    GameObjectService gameObjectService;
    CommentService commentService;

    @PutMapping("/object/{id}")
    @Override
    public ResponseEntity<?> redactGameObject(AddGameObjectRequest addGameObjectRequest) {
        gameObjectService.redactGameObject(addGameObjectRequest);
        return ResponseEntity.status(202).build();
    }

    @Override
    @PostMapping("/object")
    public ResponseEntity<?> addGameObject(AddGameObjectRequest addGameObjectRequest) {
        gameObjectService.addGameObject(addGameObjectRequest);
        return ResponseEntity.status(202).build();
    }

    @GetMapping("/object")
    @Override
    public ListGameObjectResponse findAllGameObject() {

        return mapFindAllGameObject(gameObjectService.findAllGameObject());
    }


    @GetMapping("/my")
    @Override
    public ListCommentResponse findAllPostsAuthor(@RequestBody AddCommentRequest addCommentRequest) {

        return mapFindAllPostsAuthor(commentService.findAllCommentByTraderId(addCommentRequest));
    }

    @DeleteMapping("/object/{id}")
    @Override
    public ResponseEntity<?> deleteGameObject(@RequestBody AddGameObjectRequest addGameObjectRequest) {
        gameObjectService.deleteGameObject(addGameObjectRequest);
        return ResponseEntity.status(202).build();

    }

    private ListGameObjectResponse mapFindAllGameObject(List<GameObject> gameObjects) {
        return ListGameObjectResponse.builder().listGameObject(gameObjects).build();
    }

    private ListCommentResponse mapFindAllPostsAuthor(List<Comment> commentList) {

        return ListCommentResponse.builder().listComment(commentList).build();
    }
}
