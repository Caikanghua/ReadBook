package com.readbook.pojo;

import java.util.Date;

public class RbUser {
    private String userId;

    private String name;

    private String nickName;

    private String stuNum;

    private String college;

    private String phone;

    private Boolean sex;

    private String password;

    private String wechat;

    private Integer readCnt;

    private Integer shareCnt;

    private Integer starCnt;

    private String likesTag;

    private Date registerTime;

    private Date loginTime;

    private Boolean isLegal;
    
    private String pictureUrl;
    
    public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum == null ? null : stuNum.trim();
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public Integer getReadCnt() {
        return readCnt;
    }

    public void setReadCnt(Integer readCnt) {
        this.readCnt = readCnt;
    }

    public Integer getShareCnt() {
        return shareCnt;
    }

    public void setShareCnt(Integer shareCnt) {
        this.shareCnt = shareCnt;
    }

    public Integer getStarCnt() {
        return starCnt;
    }

    public void setStarCnt(Integer starCnt) {
        this.starCnt = starCnt;
    }

    public String getLikesTag() {
        return likesTag;
    }

    public void setLikesTag(String likesTag) {
        this.likesTag = likesTag == null ? null : likesTag.trim();
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Boolean getIsLegal() {
        return isLegal;
    }

    public void setIsLegal(Boolean isLegal) {
        this.isLegal = isLegal;
    }
}