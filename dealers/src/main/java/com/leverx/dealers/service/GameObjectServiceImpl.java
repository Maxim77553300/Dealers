package com.leverx.dealers.service;

import com.leverx.dealers.dto.GameObjectRequest;
import com.leverx.dealers.entity.Comment;
import com.leverx.dealers.entity.Game;
import com.leverx.dealers.entity.GameObject;
import com.leverx.dealers.entity.User;
import com.leverx.dealers.exceptions.NoSuchException;
import com.leverx.dealers.repository.CommentRepository;
import com.leverx.dealers.repository.GameObjectRepository;
import com.leverx.dealers.repository.GameRepository;
import com.leverx.dealers.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

@Service
public class GameObjectServiceImpl implements GameObjectService {


    private final GameObjectRepository gameObjectRepository;

    private final CommentRepository commentRepository;

    private final UserRepository userRepository;

    private final GameRepository gameRepository;

    public GameObjectServiceImpl(GameObjectRepository gameObjectRepository, CommentRepository commentRepository, UserRepository userRepository, GameRepository gameRepository) {
        this.gameObjectRepository = gameObjectRepository;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
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
        Optional<User> userOptional = userRepository.findById(gameObjectRequest.getUserId());
        User user = userOptional.orElseThrow((Supplier<RuntimeException>) () -> new NoSuchException());


        Optional<Game> gameOptional = gameRepository.findById(gameObjectRequest.getGameId());
        Game game = gameOptional.orElseThrow((Supplier<RuntimeException>) () -> new NoSuchException());


        gameObjectRepository.save(mapGameObjectRequestToGameObject(gameObjectRequest, gameObject, user, game));

        game.addGameObjectToGame(gameObject);
        gameRepository.save(game);

        user.getGameObjects().add(gameObject);
        userRepository.save(user);

    }

    @Override
    public void editGameObject(GameObjectRequest gameObjectRequest, Integer gameObjectId) {
        GameObject gameObject = gameObjectRepository.findById(gameObjectId).orElseThrow(NoSuchException::new);
        Optional<User> userOptional = userRepository.findById(gameObjectRequest.getUserId());
        User user = userOptional.orElseThrow((Supplier<RuntimeException>) () -> new NoSuchException());

        Optional<Game> gameOptional = gameRepository.findById(gameObjectRequest.getGameId());
        Game game = gameOptional.orElseThrow((Supplier<RuntimeException>) () -> new NoSuchException());


        if (user == gameObject.getUser()) {
//            gameObjectRepository.save(mapGameObjectRequestToGameObject(gameObjectRequest, gameObject, user, game));
//
//            game.addGameObjectToGame(gameObject);
//            gameRepository.save(game);
//
//            user.getGameObjects().add(gameObject);
//            userRepository.save(user);

        } else {
            throw new NoSuchException();
        }
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
    public Map<User, Integer> getTop() {

//        List<GameObject> allGameObjects = gameObjectRepository.findAll();
        List<Comment> commentList = commentRepository.getRatingGameObjectList();
        Map<User, Integer> ratingForTraders = getRatingForTraders(commentList);
//        List<Map.Entry<User, Integer>> collect = ratingForTraders.entrySet().stream().sorted(Map.Entry.<User, Integer>comparingByValue().reversed()).collect(Collectors.toList());

        return ratingForTraders;
    }

    public Map<User, Integer> getRatingForTraders(List<Comment> comments) {
        Map<User, Integer> maps = new HashMap<>();
        for (Comment comment : comments) {
            if (maps.containsKey(comment.getUser())) {
                maps.put(comment.getUser(), comment.getRating() + maps.get(comment.getRating()));
            } else {
                maps.put(comment.getUser(), comment.getRating());
            }
        }
        return maps;
    }


    private GameObject mapGameObjectRequestToGameObject(GameObjectRequest gameObjectRequest, GameObject gameObject, User user,Game game) {
        user.addGameObjectToUser(gameObject);
        game.addGameObjectToGame(gameObject);
        gameObject.setTitle(gameObjectRequest.getTitle());
        gameObject.setCreatedAt(gameObjectRequest.getCreatedAt());
        gameObject.setUpdatedAt(gameObjectRequest.getUpdatedAt());
        gameObject.setGame(game);
        gameObject.setUser(user);
        return gameObject;
    }


}
