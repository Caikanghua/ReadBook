package com.readbook.pojo;

public class VoteBook {
    private Integer voteBookId;

    private String bookName;

    private String author;

    private String pubHouse;

    private Integer votes;

    private String bookImg;

    private String voteReason;

    public Integer getVoteBookId() {
        return voteBookId;
    }

    public void setVoteBookId(Integer voteBookId) {
        this.voteBookId = voteBookId;
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

    public String getPubHouse() {
        return pubHouse;
    }

    public void setPubHouse(String pubHouse) {
        this.pubHouse = pubHouse == null ? null : pubHouse.trim();
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public String getBookImg() {
        return bookImg;
    }

    public void setBookImg(String bookImg) {
        this.bookImg = bookImg == null ? null : bookImg.trim();
    }

    public String getVoteReason() {
        return voteReason;
    }

    public void setVoteReason(String voteReason) {
        this.voteReason = voteReason == null ? null : voteReason.trim();
    }
}