package com.readbook.pojo;

public class RbUserprotocol {
    private Integer id;

    private String userProtocol;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserProtocol() {
        return userProtocol;
    }

    public void setUserProtocol(String userProtocol) {
        this.userProtocol = userProtocol == null ? null : userProtocol.trim();
    }
}