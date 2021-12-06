package com.leverx.dealers.service;

import com.leverx.dealers.dto.CommentIncorrectData;
import com.leverx.dealers.dto.CommentRequest;
import com.leverx.dealers.entity.Comment;
import com.leverx.dealers.entity.User;
import com.leverx.dealers.exceptions.NoSuchException;
import com.leverx.dealers.repository.CommentRepository;
import com.leverx.dealers.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;


@Service
public class CommentServiceImpl implements CommentService {


    private final CommentRepository commentRepository;

    private final UserRepository userRepository;

    public CommentServiceImpl(CommentRepository commentRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void addComment(CommentRequest commentRequest, Integer userId) {
        Comment comment = new Comment();
        Optional<User> userOptional = userRepository.findById(userId);
        User user = userOptional.orElseThrow((Supplier<RuntimeException>) () -> new NoSuchException());
        commentRepository.save(mapAddCommentToRequest(commentRequest, comment, user));
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
        commentRepository.save(mapAddCommentToRequest(commentRequest, comment));
        userRepository.getById(id).addCommentToUser(comment);
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    private Comment mapAddCommentToRequest(CommentRequest commentRequest, Comment comment) {

        comment.setMessage(commentRequest.getMessage());
        comment.setCreatedAt(commentRequest.getCreatedAt());
        comment.setApproved(commentRequest.getApproved());
        comment.setRating(commentRequest.getRating());
        comment.setGameObjectId(commentRequest.getGameObjectId());
        return comment;
    }

    private Comment mapAddCommentToRequest(CommentRequest commentRequest, Comment comment, User user) {
        user.addCommentToUser(comment);
        comment.setUser(user);
        comment.setMessage(commentRequest.getMessage());
        comment.setCreatedAt(commentRequest.getCreatedAt());
        comment.setApproved(commentRequest.getApproved());
        comment.setRating(commentRequest.getRating());
        comment.setGameObjectId(commentRequest.getGameObjectId());
        return comment;
    }

}
