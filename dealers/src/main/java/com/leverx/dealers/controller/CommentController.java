package com.leverx.dealers.controller;

import com.leverx.dealers.dto.CommentRequest;
import com.leverx.dealers.dto.ListCommentResponse;
import org.springframework.http.ResponseEntity;

public interface CommentController {

    ResponseEntity<Void> addComment(CommentRequest commentRequest, Integer userId);

    CommentRequest getCommentById(Integer userId,Integer commentId);

    ListCommentResponse getAllCommentsByGameObjectId(Integer id);

    ListCommentResponse getAllCommentsByUserId(Integer id);

    ListCommentResponse getAllComments();

    ResponseEntity<Void> deleteComment(Integer userId,Integer commentId);

    ResponseEntity<Void> updateComment(CommentRequest commentRequest, Integer integer);
}
