package com.leverx.dealers.dto;

import com.leverx.dealers.entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;


@Getter
@Setter
@ToString
public class ListUserResponse {
    @NotNull
    List<User> listUser;
}
