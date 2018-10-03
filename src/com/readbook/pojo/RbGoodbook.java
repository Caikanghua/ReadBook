package com.readbook.pojo;

import java.util.Date;

public class RbGoodbook {
    private Integer goodbookId;

    private String title;

    private String picture;

    private Date date;

    private Boolean isDelete;

    private String description;

    public Integer getGoodbookId() {
        return goodbookId;
    }

    public void setGoodbookId(Integer goodbookId) {
        this.goodbookId = goodbookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}