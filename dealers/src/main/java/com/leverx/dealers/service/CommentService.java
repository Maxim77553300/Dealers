package com.leverx.dealers.service;

import com.leverx.dealers.dto.AddCommentRequest;
import com.leverx.dealers.entity.Comment;

import java.util.List;

public interface CommentService {

    Comment addComment(AddCommentRequest addCommentRequest);

    List<Comment> findAllCommentByTraderId(AddCommentRequest addCommentRequest);

    Comment findCommentById(AddCommentRequest addCommentRequest);

    boolean deleteComment(AddCommentRequest addCommentRequest);

    Comment updateComment(AddCommentRequest addCommentRequest);

}
