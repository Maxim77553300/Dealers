package com.leverx.dealers.service;

import com.leverx.dealers.dto.GameObjectRequest;
import com.leverx.dealers.dto.ListGameObjectResponse;
import com.leverx.dealers.entity.GameObject;
import com.leverx.dealers.repository.GameObjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameObjectServiceImpl implements GameObjectService {


    private GameObjectRepository gameObjectRepository;

    public GameObjectServiceImpl(GameObjectRepository gameObjectRepository) {
        this.gameObjectRepository = gameObjectRepository;
    }

    @Override
    public List<GameObject> findAllGameObject() {
        return gameObjectRepository.findAll();
    }


    @Override
    public ListGameObjectResponse findAllGameObjectByUser(Integer id) {
        ListGameObjectResponse listGameObjectResponse = new ListGameObjectResponse();
        listGameObjectResponse.setListGameObject(gameObjectRepository.findByUserId(id));
        return listGameObjectResponse;
    }

    @Override
    public ListGameObjectResponse findAllGameObjectByGame(Integer gameId) {
        List<GameObject> byGameId = gameObjectRepository.findByGameId(gameId);
        ListGameObjectResponse listGameObjectResponse = new ListGameObjectResponse();
        listGameObjectResponse.setListGameObject(byGameId);
        return listGameObjectResponse;
    }

    @Override
    public void addGameObject(GameObjectRequest gameObjectRequest) {
        GameObject gameObject = new GameObject();
        gameObjectRepository.save(mapGameObjectRequestToGameObject(gameObjectRequest, gameObject));
    }

    @Override
    public void editGameObject(GameObjectRequest gameObjectRequest, Integer id) {
        GameObject gameObject = gameObjectRepository.findById(id).orElseThrow(RuntimeException::new);
        mapGameObjectRequestToGameObject(gameObjectRequest, gameObject);
        gameObjectRepository.save(gameObject);
    }

    @Override
    public void deleteGameObject(Integer id) {
        gameObjectRepository.deleteById(id);
    }

    private GameObject mapGameObjectRequestToGameObject(GameObjectRequest gameObjectRequest, GameObject gameObject) {
        gameObject.setTitle(gameObjectRequest.getTitle());
        gameObject.setCreatedAt(gameObjectRequest.getCreatedAt());
        gameObject.setUpdatedAt(gameObjectRequest.getUpdatedAt());
        gameObject.setGameId(gameObjectRequest.getGameId());
        gameObject.setUserId(gameObject.getUserId());
        return gameObject;
    }

}
