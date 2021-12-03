package com.leverx.dealers.service;

import com.leverx.dealers.dto.CommentRequest;
import com.leverx.dealers.dto.ListCommentResponse;
import com.leverx.dealers.entity.Comment;
import com.leverx.dealers.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommentServiceImpl implements CommentService {


    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void addComment(CommentRequest commentRequest) {
        Comment comment = new Comment();
        commentRepository.save(mapAddCommentToRequest(commentRequest,comment));
    }

    @Override
    public ListCommentResponse findAllCommentByUserId(Integer userId) {
        List<Comment> commentList = commentRepository.findAllByUserId(userId);
        ListCommentResponse listCommentResponse = new ListCommentResponse();
        listCommentResponse.setListComment(commentList);
        return listCommentResponse;
    }

    @Override
    public Comment getCommentById(Integer id) {
        return commentRepository.findCommentById(id).orElseThrow(RuntimeException::new);
    }

    public ListCommentResponse getAllCommentsByGameObjectId(Integer id) {
        ListCommentResponse listCommentResponse = new ListCommentResponse();
        listCommentResponse.setListComment(commentRepository.findCommentByGameObjectId(id));
        return listCommentResponse;
    }


    @Override
    public void deleteComment(Integer id) {
        commentRepository.deleteById(id);
    }

    @Override
    public void updateComment(CommentRequest commentRequest,Integer id) {
        Comment comment = commentRepository.findCommentById(id).orElseThrow(RuntimeException::new);
        commentRepository.save(mapAddCommentToRequest(commentRequest,comment));
    }

    @Override
    public ListCommentResponse getAllComments() {
        ListCommentResponse listCommentResponse = new ListCommentResponse();
        listCommentResponse.setListComment(commentRepository.findAll());
        return listCommentResponse;
    }

    private Comment mapAddCommentToRequest(CommentRequest commentRequest,Comment comment) {
        comment.setUserId(commentRequest.getUserId());
        comment.setMessage(commentRequest.getMessage());
        comment.setCreatedAt(commentRequest.getCreatedAt());
        comment.setApproved(commentRequest.getApproved());
        comment.setRating(commentRequest.getRating());
        comment.setGameObjectId(commentRequest.getGameObjectId());
        return comment;
    }

}
