package com.readbook.pojo;

import java.util.Date;
import java.util.List;

public class RbUsercomment {
	 private String uCommentId;

    private Integer commentType;

    private String fromId;

    private String fromName;

    private String toCommentId;

    private String atId;

    private String atName;

    private Date time;

    private String commentId;

    private String ucontent;
    
    private String fromIdPic;
    

	public String getFromIdPic() {
		return fromIdPic;
	}

	public void setFromIdPic(String fromIdPic) {
		this.fromIdPic = fromIdPic;
	}

	public String getuCommentId() {
        return uCommentId;
    }

    public void setuCommentId(String uCommentId) {
        this.uCommentId = uCommentId == null ? null : uCommentId.trim();
    }

    public Integer getCommentType() {
        return commentType;
    }

    public void setCommentType(Integer commentType) {
        this.commentType = commentType;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId == null ? null : fromId.trim();
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName == null ? null : fromName.trim();
    }

    public String getToCommentId() {
        return toCommentId;
    }

    public void setToCommentId(String toCommentId) {
        this.toCommentId = toCommentId == null ? null : toCommentId.trim();
    }

    public String getAtId() {
        return atId;
    }

    public void setAtId(String atId) {
        this.atId = atId == null ? null : atId.trim();
    }

    public String getAtName() {
        return atName;
    }

    public void setAtName(String atName) {
        this.atName = atName == null ? null : atName.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId == null ? null : commentId.trim();
    }

    public String getUcontent() {
        return ucontent;
    }

    public void setUcontent(String ucontent) {
        this.ucontent = ucontent == null ? null : ucontent.trim();
    }

}