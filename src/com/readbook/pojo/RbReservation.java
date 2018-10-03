package com.readbook.pojo;

import java.util.Date;

public class RbReservation {
    private String reservationId;

    private String userId;

    private String bookId;

    private Integer state;

    private Date deadline;

    private Date takenDate;

    private Date returnDate;

    private String phone;
    
    private RbBook rbBook;
    
    private RbUser rbUser;
    
    private int remind;
    
    public int getRemind() {
		return remind;
	}

	public void setRemind(int remind) {
		this.remind = remind;
	}

	public RbUser getRbUser() {
		return rbUser;
	}

	public void setRbUser(RbUser rbUser) {
		this.rbUser = rbUser;
	}

	public RbBook getRbBook() {
		return rbBook;
	}

	public void setRbBook(RbBook rbBook) {
		this.rbBook = rbBook;
	}

	public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId == null ? null : reservationId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId == null ? null : bookId.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getTakenDate() {
        return takenDate;
    }

    public void setTakenDate(Date takenDate) {
        this.takenDate = takenDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}