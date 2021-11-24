package com.leverx.dealers.dto;

import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.Text;

import javax.validation.constraints.NotNull;
import java.awt.*;
import java.util.Date;

@Getter
@Setter
public class AddCommentRequest {

    @NotNull
    private Integer id;
    @NotNull
    private TextArea message;
    @NotNull
    private Integer author_id;
    @NotNull
    private Date created_at;
    @NotNull
    private Boolean approved;


}
