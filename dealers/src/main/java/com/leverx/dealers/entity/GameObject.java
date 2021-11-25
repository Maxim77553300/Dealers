package com.leverx.dealers.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity(name = "gameobject")
@Getter
@Setter
@ToString
public class GameObject {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "title")
    private String title;
    @Column(name = "author_id")
    private Integer author_id;
    @Column(name = "created_at")
    private Date created_at;
    @Column(name = "updated_at")
    private Date updated_at;
    @Column(name = "game_id")
    private Integer game_id;


}
