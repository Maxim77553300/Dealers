package com.leverx.dealers.service;

import com.leverx.dealers.dto.AddCommentRequest;
import com.leverx.dealers.entity.Comment;
import com.leverx.dealers.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    @Override
    public boolean addComment(AddCommentRequest addCommentRequest) {

        try {
            commentRepository.save(mapAddCommentToRequest(addCommentRequest));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public List<Comment> findAllCommentByTraderId(AddCommentRequest addCommentRequest) {
        List<Comment> commentList = commentRepository.findAll().stream().filter((a) -> a.getAuthor_id() == addCommentRequest.getAuthor_id()).collect(Collectors.toList());
        return commentList;
    }

    @Override
    public Comment findCommentById(AddCommentRequest addCommentRequest) {
        return null;
    }

    @Override
    public boolean deleteComment(AddCommentRequest addCommentRequest) {
        return false;
    }

    @Override
    public Comment updateComment(AddCommentRequest addCommentRequest) {
        return null;
    }

    private Comment mapAddCommentToRequest(AddCommentRequest addCommentRequest) {
        Comment comment = new Comment();
        comment.setAuthor_id(addCommentRequest.getAuthor_id());
        comment.setMessage(addCommentRequest.getMessage());
        comment.setCreated_at(addCommentRequest.getCreated_at());
        comment.setApproved(addCommentRequest.getApproved());
        return comment;
    }

}
