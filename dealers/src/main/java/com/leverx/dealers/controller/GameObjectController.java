package com.leverx.dealers.controller;

import com.leverx.dealers.dto.AddGameObjectRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

public interface GameObjectController {

    ResponseEntity<?> redactGameObject(AddGameObjectRequest addGameObjectRequest);

    ResponseEntity<?> addGameObject(AddGameObjectRequest addGameObjectRequest);

    String findAllGameObject(String name,Model model);

    String findAllPostsAuthor(String nameAuthor,Model model);

    String deleteGameObject(String nameGAmeObject,Model model);
}
