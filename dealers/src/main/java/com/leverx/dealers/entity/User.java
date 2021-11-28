package com.leverx.dealers.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity(name = "user")
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "password")
    private String password;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "created_at")
    private Date created_at;
    @Column(name = "role")
    private Role role;

    @OneToMany(cascade = CascadeType.ALL) // Uni-Directional
    @JoinColumn(name = "author_id")
    private List<GameObject> gameObjectList;

    public void addGameObjectToUser(GameObject gameObject){
        if(gameObjectList == null){
            gameObjectList = new ArrayList<>();
        }
        gameObjectList.add(gameObject);
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private List<Comment> commentList;

    public void addCommentToUser(Comment comment){
        if(commentList == null){
            commentList = new ArrayList<>();
        }
        commentList.add(comment);
    }

}
