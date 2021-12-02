package com.leverx.dealers.service;

import com.leverx.dealers.dto.CommentRequest;
import com.leverx.dealers.dto.ListCommentResponse;
import com.leverx.dealers.entity.Comment;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

public interface CommentService {

    void addComment(CommentRequest commentRequest);

    ListCommentResponse findAllCommentByUserId(Integer userId);

    Comment getCommentById(Integer id);

    void deleteComment(Integer id);

    void updateComment(CommentRequest commentRequest,Integer id);

    ListCommentResponse getAllComments();

}
