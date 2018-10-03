package com.readbook.service;

import java.util.List;

import com.readbook.pojo.RbUser;

public interface AttentionService {

	void attention(String attentionUserId, String beAttentionUserId);

	void cancleAttention(String attentionUserId, String beAttentionUserId);

	boolean checkAttention(String attentionUserId, String beAttentionUserId);

	boolean checkAttentionNum(String attentionUserId);

	List<RbUser> getAllAttention(String userId);

	List<String> getAllUserId(String beAttentionUser);

}
