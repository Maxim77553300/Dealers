package com.leverx.dealers.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ANONYMOUS("User"),ADMIN("Admin"),TRADER("Trader");

    private String name;

    Role(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return null;
    }
}
