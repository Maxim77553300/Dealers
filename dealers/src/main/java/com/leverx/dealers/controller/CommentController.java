package com.leverx.dealers.controller;

import com.leverx.dealers.dto.CommentRequest;
import com.leverx.dealers.dto.ListCommentResponse;
import org.springframework.http.ResponseEntity;

import javax.persistence.criteria.CriteriaBuilder;

public interface CommentController {

    ResponseEntity<Void> addComment(CommentRequest commentRequest);


    CommentRequest getCommentById(Integer id);

    ListCommentResponse getAllCommentsByGameObjectId(Integer id);

    ListCommentResponse getAllCommentsByUserId(Integer id);

    ListCommentResponse getAllComments();



    ResponseEntity<Void> deleteComment(Integer id);

    ResponseEntity<Void> updateComment(CommentRequest commentRequest, Integer integer);
}
