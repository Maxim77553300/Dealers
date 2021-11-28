package com.leverx.dealers.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "game")
@Getter
@Setter
@ToString
@Builder
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;


    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL) // Uni-Directional
    @JoinColumn(name = "game_id")
    private List<GameObject> gameObjectList;

    public void addGameObjectToGame(GameObject gameObject){
       if(gameObjectList == null){
           gameObjectList = new ArrayList<>();
       }
       gameObjectList.add(gameObject);


    }

}
