package com.leverx.dealers.entity;

import javax.persistence.*;
import java.awt.*;
import java.time.LocalDateTime;

@Entity(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "message")
    private String message;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "approved")
    private Boolean approved;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "game_object_id")
    private Integer gameObjectId;


    public Comment() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getGameObjectId() {
        return gameObjectId;
    }

    public void setGameObjectId(Integer gameObjectId) {
        this.gameObjectId = gameObjectId;
    }
}
