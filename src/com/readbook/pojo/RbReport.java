package com.readbook.pojo;

import java.util.Date;

public class RbReport {
    private Integer reportId;

    private String userId;// 用户id

    private String commentId;// 书评id

    private Date proposedDate;// 提交时间

    private String title;// 书评标题

    private String detail;// 投诉的详细原因

    private Boolean isdone;// 0|没处理 1|已经处理

    private Boolean type; // 举报的类型 0|书评 1|评论

    private String uCommentId; // 评论id

    private String content; // 举报的书评或评论内容

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId == null ? null : commentId.trim();
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public Boolean getIsdone() {
        return isdone;
    }

    public void setIsdone(Boolean isdone) {
        this.isdone = isdone;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public String getuCommentId() {
        return uCommentId;
    }

    public void setuCommentId(String uCommentId) {
        this.uCommentId = uCommentId == null ? null : uCommentId.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}