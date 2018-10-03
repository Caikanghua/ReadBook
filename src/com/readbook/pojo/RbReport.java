package com.readbook.pojo;

import java.util.Date;

public class RbReport {
    private Integer reportId;

    private String userId;// �û�id

    private String commentId;// ����id

    private Date proposedDate;// �ύʱ��

    private String title;// ��������

    private String detail;// Ͷ�ߵ���ϸԭ��

    private Boolean isdone;// 0|û���� 1|�Ѿ�����

    private Boolean type; // �ٱ������� 0|���� 1|����

    private String uCommentId; // ����id

    private String content; // �ٱ�����������������

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