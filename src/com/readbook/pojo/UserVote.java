package com.readbook.pojo;

public class UserVote {
    private String userVoteId;

    private Integer voteTimes;

    public String getUserVoteId() {
        return userVoteId;
    }

    public void setUserVoteId(String userVoteId) {
        this.userVoteId = userVoteId == null ? null : userVoteId.trim();
    }

    public Integer getVoteTimes() {
        return voteTimes;
    }

    public void setVoteTimes(Integer voteTimes) {
        this.voteTimes = voteTimes;
    }
}