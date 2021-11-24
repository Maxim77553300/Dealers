package com.leverx.dealers.dto;

import com.leverx.dealers.entity.Comment;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class ListCommentResponse {

    @NotNull
    List<Comment> listComment;
}
