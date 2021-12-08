package com.leverx.dealers.entity;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "password")
    private String password;
    @Column(name = "email", nullable = false)
    private String email;
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime created_at;
    @CollectionTable(name = "role",joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Role role;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Comment> comments;

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public void setGameObjects(List<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<GameObject> gameObjects;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    // метод для OneToMany -BiDirectional
    public void addCommentToUser(Comment comment){
        if(comments==null){
            comments = new ArrayList<>();
        }
        comments.add(comment);
        comment.setUser(this);
    }

    // метод для OneToMany -BiDirectional
    public void addGameObjectToUser(GameObject gameObject){
        if(gameObjects==null){
            gameObjects = new ArrayList<>();
        }
        gameObjects.add(gameObject);
        gameObject.setUser(this);
    }
}
