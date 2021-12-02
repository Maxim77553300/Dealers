package com.leverx.dealers.service;

import com.leverx.dealers.dto.GameObjectRequest;
import com.leverx.dealers.dto.ListGameObjectResponse;
import com.leverx.dealers.entity.GameObject;

import java.util.List;

public interface GameObjectService {

    List<GameObject> findAllGameObject();

    ListGameObjectResponse findAllGameObjectByUser(Integer id);

    ListGameObjectResponse findAllGameObjectByGame(Integer gameId);

    void addGameObject(GameObjectRequest gameObjectRequest);

    void editGameObject(GameObjectRequest gameObjectRequest, Integer id);

    void deleteGameObject(Integer id);




   // ListCommentResponse getListCommentsOfAuthor(AddUserRequest user);

}
