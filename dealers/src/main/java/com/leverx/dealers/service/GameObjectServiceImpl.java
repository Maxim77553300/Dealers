package com.leverx.dealers.service;

import com.leverx.dealers.dto.AddGameObjectRequest;
import com.leverx.dealers.dto.AddUserRequest;
import com.leverx.dealers.dto.ListCommentResponse;
import com.leverx.dealers.entity.Comment;
import com.leverx.dealers.entity.GameObject;
import com.leverx.dealers.repository.CommentRepository;
import com.leverx.dealers.repository.GameObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameObjectServiceImpl implements GameObjectService {

    @Autowired
    private GameObjectRepository gameObjectRepository;
    @Autowired
    private CommentRepository commentRepository;


    @Override
    public void redactGameObject(AddGameObjectRequest addGameObjectRequest) {

        gameObjectRepository.save(redactGameObjectToRequest(addGameObjectRequest));

    }


    @Override
    public void addGameObject(AddGameObjectRequest addGameObjectRequest) {

        gameObjectRepository.save(mapGameObjectToRequest(addGameObjectRequest));

    }

    @Override
    public List<GameObject> findAllGameObject() {
        return gameObjectRepository.findAll();
    }

    @Override
    public ListCommentResponse getListCommentsOfAuthor(AddUserRequest user) {

        List<Comment> listCommentsFilter = commentRepository.findAll().stream().filter((a) -> a.getAuthor_id().equals(user.getId())).collect(Collectors.toList());

        return ListCommentResponse.builder().listComment(listCommentsFilter).build();

    }


    @Override
    public void deleteGameObject(AddGameObjectRequest addGameObjectRequest) {

        gameObjectRepository.deleteById(addGameObjectRequest.getId());

    }

    private GameObject redactGameObjectToRequest(AddGameObjectRequest addGameObjectRequest) {

        return GameObject.builder().id(addGameObjectRequest.getId()).title(addGameObjectRequest.getTitle()).updated_at(addGameObjectRequest.getUpdated_at()).build();

    }

    private GameObject mapGameObjectToRequest(AddGameObjectRequest addGameObjectRequest) {

        return GameObject.
                builder()
                .title(addGameObjectRequest.getTitle())
                .author_id(addGameObjectRequest.getAuthor_id())
                .created_at(addGameObjectRequest.getCreated_at())
                .updated_at(addGameObjectRequest.getUpdated_at())
                .game_id(addGameObjectRequest.getGame_id()).build();

    }


}
