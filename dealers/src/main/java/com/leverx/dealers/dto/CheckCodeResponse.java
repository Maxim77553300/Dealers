package com.leverx.dealers.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CheckCodeResponse {

    public CheckCodeResponse(boolean result) {
        this.result = result;
    }

    private boolean result;


}
