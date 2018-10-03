package com.readbook.pojo;

public class Attention {
    private Integer aId;

    private String attentionUser;

    private String beAttentionUser;

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getAttentionUser() {
        return attentionUser;
    }

    public void setAttentionUser(String attentionUser) {
        this.attentionUser = attentionUser == null ? null : attentionUser.trim();
    }

    public String getBeAttentionUser() {
        return beAttentionUser;
    }

    public void setBeAttentionUser(String beAttentionUser) {
        this.beAttentionUser = beAttentionUser == null ? null : beAttentionUser.trim();
    }
}