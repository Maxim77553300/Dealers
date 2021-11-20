package com.leverx.dealers.controller;

import com.leverx.dealers.entity.User;
import org.springframework.ui.Model;
import org.w3c.dom.Text;

import javax.persistence.criteria.CriteriaBuilder;

public interface CommentController {

    String addComment(User user,Text comment, Model model);

    String findAllCommentsTrader(String nameTrader,Model model);

    String showComment(User user, Model model);

    String deleteComment(User user,Integer idComment, Model model);

    String updateComment(User user,Integer idComment, Model model);
}
