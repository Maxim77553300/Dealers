package com.leverx.dealers.service;

import com.leverx.dealers.entity.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> findAllComment();

    List<Comment> findAllCommentByTraderId();
}
