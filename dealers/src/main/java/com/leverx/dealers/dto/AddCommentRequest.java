package com.leverx.dealers.dto;

import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.Text;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
public class AddCommentRequest {

    private Integer id;
    private Text message;
    private Integer author_id;
    private Date created_at;
    private Boolean approved;


}
