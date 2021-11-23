package com.leverx.dealers.service;

import com.leverx.dealers.dto.AddCommentRequest;
import com.leverx.dealers.dto.AddGameObjectRequest;
import com.leverx.dealers.entity.Comment;
import com.leverx.dealers.entity.GameObject;

import java.util.List;

public interface GameObjectService {

    boolean redactGameObject(AddGameObjectRequest addGameObjectRequest);

    boolean addGameObject(AddGameObjectRequest addGameObjectRequest);

    List<GameObject> findAllGameObject();

    List<Comment> getListCommentsOfAuthor();

    String deleteGameObject(AddGameObjectRequest addGameObjectRequest);
}
