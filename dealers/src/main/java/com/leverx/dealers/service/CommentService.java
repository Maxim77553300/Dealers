package com.leverx.dealers.service;

import com.leverx.dealers.dto.CommentRequest;
import com.leverx.dealers.dto.ListCommentResponse;
import com.leverx.dealers.entity.Comment;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

public interface CommentService {

    void addComment(CommentRequest commentRequest,Integer userId);

    List<Comment> findAllCommentByUserId(Integer userId);

    Comment getCommentById(Integer id);

    void deleteComment(Integer commentId,Integer userId);

    void updateComment(CommentRequest commentRequest,Integer id);

    List<Comment> getAllComments();

    List<Comment> findAllCommentsByGameObjectId(Integer gameObjectId);
}
