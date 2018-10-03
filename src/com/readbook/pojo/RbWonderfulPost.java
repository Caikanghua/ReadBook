package com.readbook.pojo;

import java.util.Date;

public class RbWonderfulPost {
    private Integer wonderfulPostId;

    private String postBookName;

    private Date postTime;

    private String postAuthor;

    private String postContent;

    public Integer getWonderfulPostId() {
        return wonderfulPostId;
    }

    public void setWonderfulPostId(Integer wonderfulPostId) {
        this.wonderfulPostId = wonderfulPostId;
    }

    public String getPostBookName() {
        return postBookName;
    }

    public void setPostBookName(String postBookName) {
        this.postBookName = postBookName == null ? null : postBookName.trim();
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public String getPostAuthor() {
        return postAuthor;
    }

    public void setPostAuthor(String postAuthor) {
        this.postAuthor = postAuthor == null ? null : postAuthor.trim();
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent == null ? null : postContent.trim();
    }
}