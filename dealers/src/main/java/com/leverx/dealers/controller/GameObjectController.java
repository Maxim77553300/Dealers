package com.leverx.dealers.controller;

import com.leverx.dealers.dto.AddGameObjectRequest;
import com.leverx.dealers.dto.ListCommentResponse;
import com.leverx.dealers.dto.ListGameObjectResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

public interface GameObjectController {

    ResponseEntity<?> redactGameObject(AddGameObjectRequest addGameObjectRequest);

    ResponseEntity<?> addGameObject(AddGameObjectRequest addGameObjectRequest);

    ListGameObjectResponse findAllGameObject();

    ListCommentResponse findAllPostsAuthor(AddGameObjectRequest addGameObjectRequest);

    ResponseEntity<?> deleteGameObject(AddGameObjectRequest addGameObjectRequest);
}
