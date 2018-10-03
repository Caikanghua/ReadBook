package com.readbook.pojo;

import java.util.Date;

public class RbWish {
    private Integer wishId;

    private String userId;

    private String bookName;

    private String pubHouse;

    private String wishDetail;

    private Integer hasCheck;

    private Date wishDate;

    private String author;

    public Integer getWishId() {
        return wishId;
    }

    public void setWishId(Integer wishId) {
        this.wishId = wishId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getPubHouse() {
        return pubHouse;
    }

    public void setPubHouse(String pubHouse) {
        this.pubHouse = pubHouse == null ? null : pubHouse.trim();
    }

    public String getWishDetail() {
        return wishDetail;
    }

    public void setWishDetail(String wishDetail) {
        this.wishDetail = wishDetail == null ? null : wishDetail.trim();
    }

    public Integer getHasCheck() {
        return hasCheck;
    }

    public void setHasCheck(Integer hasCheck) {
        this.hasCheck = hasCheck;
    }

    public Date getWishDate() {
        return wishDate;
    }

    public void setWishDate(Date wishDate) {
        this.wishDate = wishDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }
}