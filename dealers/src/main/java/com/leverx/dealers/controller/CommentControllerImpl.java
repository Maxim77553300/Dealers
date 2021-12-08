package com.leverx.dealers.controller;

import com.leverx.dealers.dto.CommentRequest;
import com.leverx.dealers.dto.ListCommentResponse;
import com.leverx.dealers.entity.Comment;
import com.leverx.dealers.exceptions.NoSuchException;
import com.leverx.dealers.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class CommentControllerImpl implements CommentController {

    private final CommentService commentService;

    public CommentControllerImpl(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/articles/{id}/comments")
    @Override
    public ResponseEntity<Void> addComment(@RequestBody @Valid CommentRequest commentRequest, @PathVariable("id") Integer userId) {
        commentService.addComment(commentRequest, userId);
        return ResponseEntity.status(202).build();
    }


    @GetMapping("users/{userId}/comments/{commentId}")
    @Override
    public CommentRequest getCommentById(@PathVariable("userId") Integer userId, @PathVariable("commentId") Integer commentId) {
        Comment comment = commentService.getCommentById(commentId);
        CommentRequest commentRequest = mapGetCommentById(comment, userId);
        return commentRequest;
    }

    @GetMapping("/objects/{id}/comments")
    @Override
    public ListCommentResponse getAllCommentsByGameObjectId(@PathVariable("id") Integer id) {
        ListCommentResponse listCommentResponse = new ListCommentResponse();
        listCommentResponse.setListComment(commentService.findAllCommentsByGameObjectId(id));
        if (listCommentResponse.getListComment().size() == 0) {
            throw new NoSuchException();
        }
        return listCommentResponse;
    }

    @GetMapping("users/{userId}/comments")
    @Override
    public ListCommentResponse getAllCommentsByUserId(@PathVariable("userId") Integer id) {
        List<Comment> commentList = commentService.findAllCommentByUserId(id);
        return mapToListCommentResponse(commentList);
    }

    @GetMapping("/comments")
    @Override
    public ListCommentResponse getAllComments() {
        ListCommentResponse listCommentResponse = new ListCommentResponse();
        listCommentResponse.setListComment(commentService.getAllComments());
        return listCommentResponse;
    }


    @DeleteMapping("users/{userId}/comments/{commentId}")
    @Override
    public ResponseEntity<Void> deleteComment(@PathVariable("userId") Integer userId, @PathVariable("commentId") Integer commentId) {
        commentService.deleteComment(commentId, userId);
        return ResponseEntity.status(202).build();
    }

    @PutMapping("/articles/{id}/comments")
    @Override
    public ResponseEntity<Void> updateComment(@RequestBody CommentRequest commentRequest, @PathVariable Integer id) {
        commentService.updateComment(commentRequest, id);
        return ResponseEntity.status(202).build();
    }

    private CommentRequest mapGetCommentById(Comment comment, Integer userId) {
        CommentRequest commentRequest = new CommentRequest();
        commentRequest.setMessage(comment.getMessage());
        commentRequest.setUserId(userId);
        commentRequest.setApproved(comment.getApproved());
        commentRequest.setRating(comment.getRating());
        commentRequest.setGameObjectId(commentRequest.getGameObjectId());
        return commentRequest;
    }

    private ListCommentResponse mapToListCommentResponse(List<Comment> commentList) {
        ListCommentResponse listCommentResponse = new ListCommentResponse();
        listCommentResponse.setListComment(commentList);
        return listCommentResponse;
    }

}
