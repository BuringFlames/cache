package com.hwy.cache.entity;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

public class BUser implements Serializable {
    @NotNull
    private Integer id;

    private String password;

    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
}