package com.leverx.dealers.controller;

import org.springframework.ui.Model;

public interface GameObjectController {

    String redactGameObject(String nameGameObject, Model model);

    String addGameObject(String nameObject,Model model);

    String findAllGameObject(String name,Model model);

    String findAllPostsAuthor(String nameAuthor,Model model);

    String deleteGameObject(String nameGAmeObject,Model model);
}
