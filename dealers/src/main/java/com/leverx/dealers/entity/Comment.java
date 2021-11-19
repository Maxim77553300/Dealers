package com.leverx.dealers.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.w3c.dom.Text;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "comment")
@Getter
@Setter
@ToString
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "message")
    private Text message;
    @Column(name = "author_id")
    private Integer author_id;
    @Column(name = "created_at")
    private Date created_at;
    @Column(name = "approved")
    private Boolean approved;

}