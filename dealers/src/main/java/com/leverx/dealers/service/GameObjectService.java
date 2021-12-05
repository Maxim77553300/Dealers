package com.leverx.dealers.service;

import com.leverx.dealers.dto.GameObjectRequest;
import com.leverx.dealers.dto.ListGameObjectResponse;
import com.leverx.dealers.dto.RatingDto;
import com.leverx.dealers.entity.GameObject;

import java.util.List;

public interface GameObjectService {

    List<GameObject> findAllGameObject();

    List<GameObject> findAllGameObjectByUser(Integer id);

    List<GameObject> findAllGameObjectByGame(Integer gameId);

    void addGameObject(GameObjectRequest gameObjectRequest);

    void editGameObject(GameObjectRequest gameObjectRequest, Integer id);

    void deleteGameObject(Integer id);

    String getRating(Integer gameObjectId);

    List<String> getTop();


    // ListCommentResponse getListCommentsOfAuthor(AddUserRequest user);

}
