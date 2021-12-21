package com.leverx.dealers.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkResponse {

    private String link;

    public LinkResponse(String link) {
        this.link = link;
    }

}
