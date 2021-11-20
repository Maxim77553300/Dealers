package com.leverx.dealers.controller;

import org.springframework.ui.Model;

public interface GameController {

    String findAllGame(String gameName, Model model);

    String addGame(String gameName, Model model);

    String updateGame(String gameName, Model model);
}
