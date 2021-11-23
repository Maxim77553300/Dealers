package com.leverx.dealers.service;

import com.leverx.dealers.dto.AddGameObjectRequest;
import com.leverx.dealers.entity.Comment;
import com.leverx.dealers.entity.GameObject;
import com.leverx.dealers.repository.GameObjectRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class GameObjectServiceImpl implements GameObjectService {


    GameObjectRepository gameObjectRepository;


    @Override
    public boolean redactGameObject(AddGameObjectRequest addGameObjectRequest) {
        if (gameObjectRepository.findAllById(Collections.singleton(addGameObjectRequest.getId())).isEmpty()) {
            System.out.println("Error! This gameObject is not found");
            return false;
        } else {
            gameObjectRepository.deleteById(addGameObjectRequest.getId());
            gameObjectRepository.save(redactGameObjectToRequest(addGameObjectRequest));
        }
        return true;
    }


    @Override
    public boolean addGameObject(AddGameObjectRequest addGameObjectRequest) {
        try {
            gameObjectRepository.save(mapGameObjectToRequest(addGameObjectRequest));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<GameObject> findAllGameObject() {
        return gameObjectRepository.findAll();
    }

    @Override
    public List<Comment> getListCommentsOfAuthor() {
        return null;
    }


    @Override
    public String deleteGameObject(AddGameObjectRequest addGameObjectRequest) {
        String name = addGameObjectRequest.getTitle();
        gameObjectRepository.deleteById(addGameObjectRequest.getId());

        return "Add was " + name + " removed ";
    }

    private GameObject mapGameObjectToRequest(AddGameObjectRequest addGameObjectRequest) {
        GameObject gameObject = new GameObject();
        Integer id = addGameObjectRequest.getId();
        gameObject.setTitle(addGameObjectRequest.getTitle());
        gameObject.setAuthor_id(addGameObjectRequest.getAuthor_id());
        gameObject.setCreated_at(Date.from(java.time.ZonedDateTime.now().toInstant()));
        gameObject.setUpdated_at(Date.from(java.time.ZonedDateTime.now().toInstant()));
        gameObject.setGame_id(addGameObjectRequest.getGame_id());

        return gameObject;

    }

    private GameObject redactGameObjectToRequest(AddGameObjectRequest addGameObjectRequest) {
        GameObject gameObject = new GameObject();
        Integer id = addGameObjectRequest.getId();
        gameObject.setTitle(addGameObjectRequest.getTitle());
        gameObject.setUpdated_at(addGameObjectRequest.getUpdated_at());
        return gameObject;
    }
}
