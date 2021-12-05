package com.leverx.dealers.service;

import com.leverx.dealers.dto.CommentRequest;
import com.leverx.dealers.entity.Comment;
import com.leverx.dealers.exceptions.NoSuchException;
import com.leverx.dealers.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommentServiceImpl implements CommentService {


    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void addComment(CommentRequest commentRequest, Integer userId) {
        Comment comment = new Comment();
        commentRepository.save(mapAddCommentToRequest(commentRequest, comment, userId));
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
        if (commentRepository.getById(commentId).getUserId() == userId) {
            commentRepository.deleteById(commentId);
        } else {
            throw new NoSuchException();
        }
    }

    @Override
    public void updateComment(CommentRequest commentRequest, Integer id) {
        Comment comment = commentRepository.findCommentById(id).orElseThrow(RuntimeException::new);
        commentRepository.save(mapAddCommentToRequest(commentRequest, comment));
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    private Comment mapAddCommentToRequest(CommentRequest commentRequest, Comment comment, Integer userId) {
        comment.setUserId(userId);
        comment.setMessage(commentRequest.getMessage());
        comment.setCreatedAt(commentRequest.getCreatedAt());
        comment.setApproved(commentRequest.getApproved());
        comment.setRating(commentRequest.getRating());
        comment.setGameObjectId(commentRequest.getGameObjectId());
        return comment;
    }

    private Comment mapAddCommentToRequest(CommentRequest commentRequest, Comment comment) {
        comment.setUserId(commentRequest.getUserId());
        comment.setMessage(commentRequest.getMessage());
        comment.setCreatedAt(commentRequest.getCreatedAt());
        comment.setApproved(commentRequest.getApproved());
        comment.setRating(commentRequest.getRating());
        comment.setGameObjectId(commentRequest.getGameObjectId());
        return comment;
    }

}
