package com.leverx.dealers.dto;

import com.leverx.dealers.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class ListUserResponse {

    List<User> listUser;
}
