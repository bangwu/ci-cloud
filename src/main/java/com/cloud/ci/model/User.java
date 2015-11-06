package com.cloud.ci.model;

import java.util.UUID;

public class User {
    private UUID id;
    private String username;
    private String password;

    public UUID getId() {
        return id;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }
}
