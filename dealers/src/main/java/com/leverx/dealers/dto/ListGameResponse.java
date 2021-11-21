package com.leverx.dealers.dto;

import com.leverx.dealers.entity.Game;

import java.util.List;


public class ListGameResponse {

    List<Game> listGame;

    public List<Game> getListCame() {
        return listGame;
    }

    public void setListGame(List<Game> listCame) {
        this.listGame = listCame;
    }


}
