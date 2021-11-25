package com.leverx.dealers.service;

import com.leverx.dealers.dto.AddCommentRequest;
import com.leverx.dealers.entity.Comment;
import com.leverx.dealers.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void addComment(AddCommentRequest addCommentRequest) {

        commentRepository.save(mapAddCommentToRequest(addCommentRequest));

    }

    @Override
    public List<Comment> findAllCommentByTraderId(AddCommentRequest addCommentRequest) {
        List<Comment> commentList = commentRepository.findAll().stream().filter((a) -> a.getAuthor_id() == addCommentRequest.getAuthor_id()).collect(Collectors.toList());
        return commentList;
    }

    @Override
    public List<Comment> showCommentById(AddCommentRequest addCommentRequest) {
        List<Comment> commentList = new ArrayList<>();
        commentList.add(mapAddCommentToRequest(addCommentRequest));
        return commentList;
    }

    @Override
    public void deleteComment(AddCommentRequest addCommentRequest) {

        commentRepository.delete(mapAddCommentToRequest(addCommentRequest));

    }

    @Override
    public void updateComment(AddCommentRequest addCommentRequest) {

        commentRepository.save(mapAddCommentToRequest(addCommentRequest));

    }

    private Comment mapAddCommentToRequest(AddCommentRequest addCommentRequest) {

        return Comment.
                builder()
                .id(addCommentRequest.getId())
                .author_id(addCommentRequest.getAuthor_id())
                .message(addCommentRequest.getMessage())
                .created_at(addCommentRequest.getCreated_at())
                .approved(addCommentRequest.getApproved())
                .build();

    }


}
