package com.readbook.pojo;

import java.util.Date;

public class RbQanda {
    private Integer qandaId;

    private Date pushDate;

    private String question;

    private String answer;

    private Integer helpfulCnt;

    private Boolean isDelete;

    public Integer getQandaId() {
        return qandaId;
    }

    public void setQandaId(Integer qandaId) {
        this.qandaId = qandaId;
    }

    public Date getPushDate() {
        return pushDate;
    }

    public void setPushDate(Date pushDate) {
        this.pushDate = pushDate;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Integer getHelpfulCnt() {
        return helpfulCnt;
    }

    public void setHelpfulCnt(Integer helpfulCnt) {
        this.helpfulCnt = helpfulCnt;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
}