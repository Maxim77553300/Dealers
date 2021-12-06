package com.leverx.dealers.entity;


import javax.persistence.*;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "name")
    private String name;

//    @OneToMany(cascade = CascadeType.ALL) // Uni-Directional
//    @JoinColumn(name = "game_id")
//    private List<GameObject> gameObjectList;
//
//    public void addGameObjectToGame(GameObject gameObject){
//       if(gameObjectList == null){
//           gameObjectList = new ArrayList<>();
//       }
//       gameObjectList.add(gameObject);
//
//
//    }

    public Game() {
    }

    public Integer getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<GameObject> getGameObjectList() {
//        return gameObjectList;
//    }
//
//    public void setGameObjectList(List<GameObject> gameObjectList) {
//        this.gameObjectList = gameObjectList;
//    }
}
