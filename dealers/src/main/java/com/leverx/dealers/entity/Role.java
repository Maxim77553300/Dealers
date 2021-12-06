package com.leverx.dealers.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ANONYMOUS("ANONYMOUS"),ADMIN("ADMIN"),TRADER("TRADER");

    private String name;

    Role(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return null;
    }
}
