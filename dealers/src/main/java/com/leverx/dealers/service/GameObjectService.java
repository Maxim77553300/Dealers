package com.leverx.dealers.service;

import com.leverx.dealers.dto.AddGameObjectRequest;
import com.leverx.dealers.dto.AddUserRequest;
import com.leverx.dealers.dto.ListCommentResponse;
import com.leverx.dealers.entity.GameObject;

import java.util.List;

public interface GameObjectService {

    void redactGameObject(AddGameObjectRequest addGameObjectRequest);

    void addGameObject(AddGameObjectRequest addGameObjectRequest);

    List<GameObject> findAllGameObject();

    ListCommentResponse getListCommentsOfAuthor(AddUserRequest user);

    void deleteGameObject(AddGameObjectRequest addGameObjectRequest);
}
