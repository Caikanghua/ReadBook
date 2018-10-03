package com.readbook.pojo;

import java.util.Date;

public class RbFeedback {
    private Integer feedbackId;

    private String userId;

    private Date proposedDate;

    private String title;

    private String printscreen;

    private String feedbackResult;

    private Integer hasDealed;

    private String detail;

    public Integer getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getPrintscreen() {
        return printscreen;
    }

    public void setPrintscreen(String printscreen) {
        this.printscreen = printscreen == null ? null : printscreen.trim();
    }

    public String getFeedbackResult() {
        return feedbackResult;
    }

    public void setFeedbackResult(String feedbackResult) {
        this.feedbackResult = feedbackResult == null ? null : feedbackResult.trim();
    }

    public Integer getHasDealed() {
        return hasDealed;
    }

    public void setHasDealed(Integer hasDealed) {
        this.hasDealed = hasDealed;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}