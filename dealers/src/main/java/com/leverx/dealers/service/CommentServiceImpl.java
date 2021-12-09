package com.leverx.dealers.service;

import com.leverx.dealers.dto.CommentRequest;
import com.leverx.dealers.dto.GameObjectRequest;
import com.leverx.dealers.entity.Comment;
import com.leverx.dealers.entity.Game;
import com.leverx.dealers.entity.GameObject;
import com.leverx.dealers.entity.User;
import com.leverx.dealers.exceptions.NoSuchException;
import com.leverx.dealers.repository.CommentRepository;
import com.leverx.dealers.repository.GameObjectRepository;
import com.leverx.dealers.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;


@Service
public class CommentServiceImpl implements CommentService {


    private final CommentRepository commentRepository;

    private final UserRepository userRepository;

    private final GameObjectRepository gameObjectRepository;

    public CommentServiceImpl(CommentRepository commentRepository, UserRepository userRepository, GameObjectRepository gameObjectRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.gameObjectRepository = gameObjectRepository;
    }

    @Override
    public void addComment(CommentRequest commentRequest, Integer userId) {
        Comment comment = new Comment();
        User user = createUser(commentRequest,userId);
        GameObject gameObject = createGameObject(commentRequest);
        commentRepository.save(mapAddCommentToRequest(commentRequest, comment, user, gameObject));
        user.getComments().add(comment);
        userRepository.save(user);

    }

    @Override
    public List<Comment> findAllCommentByUserId(Integer userId) {
        List<Comment> commentList = commentRepository.findAllByUserId(userId);
        return commentList;
    }


    @Override
    public Comment getCommentById(Integer id) {
        return commentRepository.findCommentById(id).orElseThrow(NoSuchException::new);
    }

    @Override
    public List<Comment> findAllCommentsByGameObjectId(Integer gameObjectId) {
        return commentRepository.findCommentByGameObjectId(gameObjectId);
    }


    @Override
    public void deleteComment(Integer commentId, Integer userId) throws NoSuchException {
        commentRepository.deleteById(commentId);
    }

    @Override
    public void updateComment(CommentRequest commentRequest, Integer id) {
        Comment comment = commentRepository.findCommentById(id).orElseThrow(RuntimeException::new);
        GameObject gameObject = createGameObject(commentRequest);
        commentRepository.save(mapAddCommentToRequest(commentRequest, comment,gameObject));
        userRepository.getById(id).addCommentToUser(comment);
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    private Comment mapAddCommentToRequest(CommentRequest commentRequest, Comment comment,GameObject gameObject) {

        comment.setMessage(commentRequest.getMessage());
        comment.setApproved(commentRequest.getApproved());
        comment.setRating(commentRequest.getRating());
        comment.setGameObject(gameObject);
        return comment;
    }

    private Comment mapAddCommentToRequest(CommentRequest commentRequest, Comment comment, User user,GameObject gameObject) {
        user.addCommentToUser(comment);
        comment.setUser(user);

        comment.setMessage(commentRequest.getMessage());
        comment.setApproved(commentRequest.getApproved());
        comment.setRating(commentRequest.getRating());
        comment.setGameObject(gameObject);
        return comment;
    }

    private User createUser(CommentRequest commentRequest,Integer userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        User user = userOptional.orElseThrow((Supplier<RuntimeException>) () -> new NoSuchException());
        return user;
    }

    private GameObject createGameObject(CommentRequest commentRequest){
        Optional<GameObject> gameObjectOptional = gameObjectRepository.findById(commentRequest.getGameObjectId());
        GameObject gameObject = gameObjectOptional.orElseThrow((Supplier<RuntimeException>) () -> new NoSuchException());
        return gameObject;
    }

}
