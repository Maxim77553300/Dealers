package com.leverx.dealers.controller;

import com.leverx.dealers.entity.User;
import org.springframework.ui.Model;
import org.w3c.dom.Text;

public class CommentControllerImpl implements CommentController{

    @Override
    public String addComment(User user, Text comment, Model model) {
        return null;
    }

    @Override
    public String findAllCommentsTrader(String nameTrader, Model model) {
        return null;
    }

    @Override
    public String showComment(User user, Model model) {
        return null;
    }

    @Override
    public String deleteComment(User user, Integer idComment, Model model) {
        return null;
    }

    @Override
    public String updateComment(User user, Integer idComment, Model model) {
        return null;
    }
}
