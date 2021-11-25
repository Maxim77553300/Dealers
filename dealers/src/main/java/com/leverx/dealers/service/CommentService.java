package com.leverx.dealers.service;

import com.leverx.dealers.dto.AddCommentRequest;
import com.leverx.dealers.entity.Comment;

import java.util.List;

public interface CommentService {

    void addComment(AddCommentRequest addCommentRequest);

    List<Comment> findAllCommentByTraderId(AddCommentRequest addCommentRequest);

    List<Comment> showCommentById(AddCommentRequest addCommentRequest);

    void deleteComment(AddCommentRequest addCommentRequest);

    void updateComment(AddCommentRequest addCommentRequest);

}
