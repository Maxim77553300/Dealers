package com.leverx.dealers.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
public class AddGameObjectRequest {

    private Integer id;
    private String title;
    private Integer author_id;
    private Date created_at;
    private Date updated_at;
    private Integer game_id;
}
