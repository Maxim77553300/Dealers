package com.leverx.dealers.controller;

import com.leverx.dealers.dto.CommentRequest;
import com.leverx.dealers.dto.ListCommentResponse;
import com.leverx.dealers.entity.Comment;
import com.leverx.dealers.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class CommentControllerImpl implements CommentController {

    private CommentService commentService;

    public CommentControllerImpl(CommentService commentService) {
        this.commentService = commentService;
    }

    // @PostMapping("/articles/{id}/comments")///????как то вставлять id в url для создаваемого коммента --по этому мапингу не работает-ошибка 405
    @PostMapping("/articles") // - --по этому адресу добавляет , но не добавляет rating, gameObjectId
    @Override
    public ResponseEntity<Void> addComment(@RequestBody @Valid CommentRequest commentRequest) {
        commentService.addComment(commentRequest);
        return ResponseEntity.status(202).build();
    }


    @GetMapping("users/{id}/comments/{id}") //???--как правильно разрулить 2 id
    @Override
    public CommentRequest getCommentById(@PathVariable("id") Integer id) {
        Comment comment = new Comment();
        comment = commentService.getCommentById(id);
        return mapGetCommentById(comment);
    }

    @GetMapping("/users/{id}/comments")//не то находит --надо по id gameobject ф оно по comment--
    @Override
    public ListCommentResponse getAllCommentsByGameObjectId(@PathVariable("id") Integer id) {
        ListCommentResponse listCommentResponse = commentService.findAllCommentByUserId(id);
        return listCommentResponse;
    }

    @GetMapping("/comments/{id}")  //работает!!! находит по userId !!!
    @Override
    public ListCommentResponse getAllCommentsByUserId(@PathVariable("id") Integer id) {
        return commentService.findAllCommentByUserId(id);
    }

    @GetMapping("/comments") // работает
    @Override
    public ListCommentResponse getAllComments() {
        return commentService.getAllComments();
    }


    //    @DeleteMapping("users/{id}/comments/{id}") // по этому не работает
    @DeleteMapping("comments/{id}") // по этому адресу работает
    @Override
    public ResponseEntity<Void> deleteComment(@PathVariable("id") Integer id) {
        commentService.deleteComment(id);
        return ResponseEntity.status(202).build();
    }

    @PutMapping("/articles/{id}/comments") // ok
    @Override
    public ResponseEntity<Void> updateComment(@RequestBody CommentRequest commentRequest, @PathVariable Integer id) {
        commentService.updateComment(commentRequest, id);
        return ResponseEntity.status(202).build();
    }

    private CommentRequest mapGetCommentById(Comment comment) {
        CommentRequest commentRequest = new CommentRequest();
        commentRequest.setMessage(comment.getMessage());
        commentRequest.setUserId(comment.getUserId());
        commentRequest.setCreatedAt(comment.getCreatedAt());
        commentRequest.setApproved(comment.getApproved());
        commentRequest.setRating(comment.getRating());
        commentRequest.setGameObjectId(commentRequest.getGameObjectId());
        return commentRequest;
    }

}
