package com.readbook.pojo;

import java.util.Date;

public class RbShare {
    private Integer shareId;

    private String userId;

    private Date proposedDate;

    private String bookName;

    private String author;

    private String phone;

    private Integer state;

    private Integer delieverWay;

    private String location;

    private String pubHouse;

    private String bookId;
    
    private RbBook rbBook;
    
    public RbBook getRbBook() {
		return rbBook;
	}

	public void setRbBook(RbBook rbBook) {
		this.rbBook = rbBook;
	}

	public Integer getShareId() {
        return shareId;
    }

    public void setShareId(Integer shareId) {
        this.shareId = shareId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getProposedDate() {
        return proposedDate;
    }

    public void setProposedDate(Date proposedDate) {
        this.proposedDate = proposedDate;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getDelieverWay() {
        return delieverWay;
    }

    public void setDelieverWay(Integer delieverWay) {
        this.delieverWay = delieverWay;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getPubHouse() {
        return pubHouse;
    }

    public void setPubHouse(String pubHouse) {
        this.pubHouse = pubHouse == null ? null : pubHouse.trim();
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId == null ? null : bookId.trim();
    }
}