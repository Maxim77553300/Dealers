package com.leverx.dealers.dto;

import com.leverx.dealers.entity.GameObject;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ListGameObjectResponse {

    List<GameObject> listGameObject;
}
