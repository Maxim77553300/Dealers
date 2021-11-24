package com.leverx.dealers.controller;

import com.leverx.dealers.dto.AddCommentRequest;
import com.leverx.dealers.dto.ListCommentResponse;
import com.leverx.dealers.entity.Comment;
import com.leverx.dealers.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class CommentControllerImpl implements CommentController {

    private CommentService commentService;

    @PostMapping("/comments")
    @Override
    public ResponseEntity<?> addComment(AddCommentRequest addCommentRequest) {
        commentService.addComment(addCommentRequest);
        return ResponseEntity.status(202).build();
    }

    @GetMapping("/comments")
    @Override
    public ListCommentResponse findAllCommentsTrader(AddCommentRequest addCommentRequest) {
        List<Comment> commentList = commentService.findAllCommentByTraderId(addCommentRequest);
        ListCommentResponse listCommentResponse = new ListCommentResponse();
        listCommentResponse.setListComment(commentList);
        return listCommentResponse;
    }

    @Override
    public ListCommentResponse showComment(AddCommentRequest addCommentRequest) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteComment(AddCommentRequest addCommentRequest) {
        return null;
    }

    @Override
    public ResponseEntity<?> updateComment(AddCommentRequest addCommentRequest) {
        return null;
    }
}
