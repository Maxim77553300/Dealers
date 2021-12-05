package com.leverx.dealers.service;

import com.leverx.dealers.dto.GameObjectRequest;
import com.leverx.dealers.entity.Comment;
import com.leverx.dealers.entity.GameObject;
import com.leverx.dealers.repository.CommentRepository;
import com.leverx.dealers.repository.GameObjectRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class GameObjectServiceImpl implements GameObjectService {


    private final GameObjectRepository gameObjectRepository;

    private final CommentRepository commentRepository;

    public GameObjectServiceImpl(GameObjectRepository gameObjectRepository, CommentRepository commentRepository) {
        this.gameObjectRepository = gameObjectRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public List<GameObject> findAllGameObject() {
        return gameObjectRepository.findAll();
    }


    @Override
    public List<GameObject> findAllGameObjectByUser(Integer id) {
        return gameObjectRepository.findByUserId(id);
    }

    @Override
    public List<GameObject> findAllGameObjectByGame(Integer gameId) {
        return gameObjectRepository.findByGameId(gameId);
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

    @Override
    public String getRating(Integer gameObjectId) {
        return String.valueOf(commentRepository
                .findCommentByGameObjectId(gameObjectId)
                .stream().mapToInt(Comment::getRating)
                .average().orElse(0.00));

    }

    @Override
    public List<String> getTop() {
//        List<GameObject> allGameObjects = gameObjectRepository.findAll();
        List<String> ratingList = commentRepository.getRatingGameObjectList();

        return ratingList;
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
