package com.leverx.dealers.controller;

import com.leverx.dealers.dto.AddCommentRequest;
import com.leverx.dealers.dto.ListCommentResponse;
import org.springframework.http.ResponseEntity;

public interface CommentController {

    ResponseEntity<?> addComment(AddCommentRequest addCommentRequest);

    ListCommentResponse findAllCommentsTrader(AddCommentRequest addCommentRequest);

    ListCommentResponse showComment(AddCommentRequest addCommentRequest);

    ResponseEntity<?> deleteComment(AddCommentRequest addCommentRequest);

    ResponseEntity<?> updateComment(AddCommentRequest addCommentRequest);
}
