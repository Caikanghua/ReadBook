package com.readbook.service;

import java.util.List;

import com.readbook.pojo.RbMessage;

public interface RbMessageService {

	void sendFeedbackMessage(String userId, String feedbackResult);

	void sendReportMessage(String userId);

	void sendCheckSuccessMessage(String userId, String bookName);

	void sendCheckFailMessage(String userId, String name);

	void sendWishStorageMessage(String userId, String bookName);

	RbMessage getMessageDetailById(String messageId);

	void updateHasRead(String messageId);

	List<RbMessage> getUserAllMessage(String userId, String isRead,
			int start_num, int page_size);

	void sendAttentionPost(RbMessage message);


}
