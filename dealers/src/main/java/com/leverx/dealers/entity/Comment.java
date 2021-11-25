package com.leverx.dealers.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.w3c.dom.Text;

import javax.persistence.*;
import java.awt.*;
import java.util.Date;
import java.util.UUID;

@Entity(name = "comment")
@Getter
@Setter
@ToString
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "message")
    private TextArea message;
    @Column(name = "author_id")
    private Integer author_id;
    @Column(name = "created_at")
    private Date created_at;
    @Column(name = "approved")
    private Boolean approved;

}
