package com.leverx.dealers.controller;

import com.leverx.dealers.dto.AddCommentRequest;
import com.leverx.dealers.dto.ListCommentResponse;
import com.leverx.dealers.entity.Comment;
import com.leverx.dealers.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CommentControllerImpl implements CommentController {

    private CommentService commentService;

    @PostMapping("/articles/{id}/comments")
    @Override
    public ResponseEntity<?> addComment(@RequestBody AddCommentRequest addCommentRequest) {
        commentService.addComment(addCommentRequest);
        return ResponseEntity.status(202).build();
    }

    @GetMapping("/users/{id}/comments")
    @Override
    public ListCommentResponse findAllCommentsTrader(@RequestBody AddCommentRequest addCommentRequest) {

        return mapFindAllCommentsTrader(commentService.findAllCommentByTraderId(addCommentRequest));
    }

    @GetMapping("users/{id}/comments/{id}")
    @Override
    public ListCommentResponse showComment(@RequestBody AddCommentRequest addCommentRequest) {

        List<Comment> list = commentService.showCommentById(addCommentRequest);
        return ListCommentResponse.builder().listComment(list).build();

    }

    @DeleteMapping("comments/{id}/comments/{id}")
    @Override
    public ResponseEntity<?> deleteComment(@RequestBody AddCommentRequest addCommentRequest) {
        commentService.deleteComment(addCommentRequest);
        return ResponseEntity.status(202).build();

    }

    @PutMapping("/articles/{id}/comments")
    @Override
    public ResponseEntity<?> updateComment(@RequestBody AddCommentRequest addCommentRequest) {
        commentService.updateComment(addCommentRequest);

        return ResponseEntity.status(202).build();
    }

    private ListCommentResponse mapFindAllCommentsTrader(List<Comment> commentList) {

        return ListCommentResponse.builder().listComment(commentList).build();
    }

}
