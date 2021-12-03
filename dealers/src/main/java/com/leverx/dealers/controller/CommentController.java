package com.leverx.dealers.controller;

import com.leverx.dealers.dto.CommentRequest;
import com.leverx.dealers.dto.ListCommentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.criteria.CriteriaBuilder;

public interface CommentController {

    ResponseEntity<Void> addComment(CommentRequest commentRequest,@PathVariable("id") Integer userId);


    CommentRequest getCommentById(Integer userId,Integer commentId);

    ListCommentResponse getAllCommentsByGameObjectId(Integer id);

    ListCommentResponse getAllCommentsByUserId(Integer id);

    ListCommentResponse getAllComments();



    ResponseEntity<Void> deleteComment(Integer id);

    ResponseEntity<Void> updateComment(CommentRequest commentRequest, Integer integer);
}
