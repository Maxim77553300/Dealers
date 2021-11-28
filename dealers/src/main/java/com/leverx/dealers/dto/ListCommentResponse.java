package com.leverx.dealers.dto;

import com.leverx.dealers.entity.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
public class ListCommentResponse  {

    @NotNull
    List<Comment> listComment;


}
