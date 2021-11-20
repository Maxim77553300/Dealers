package com.leverx.dealers.service;

import com.leverx.dealers.dto.AddGameObjectRequest;
import com.leverx.dealers.entity.Comment;
import com.leverx.dealers.entity.GameObject;

import java.util.List;

public class GameObjectServiceImpl implements GameObjectService{
    @Override
    public GameObject redactGameObject(AddGameObjectRequest addGameObjectRequest) {
        return null;
    }

    @Override
    public boolean addGameObject(AddGameObjectRequest addGameObjectRequest) {
        return false;
    }

    @Override
    public List<GameObject> findAllGameObject(AddGameObjectRequest addGameObjectRequest) {
        return null;
    }

    @Override
    public List<Comment> getListCommentsOfAuthor() {
        return null;
    }

    @Override
    public boolean deleteGameObject(AddGameObjectRequest addGameObjectRequest) {
        return false;
    }
}
