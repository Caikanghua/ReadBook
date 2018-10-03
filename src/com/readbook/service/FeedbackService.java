package com.readbook.service;

import java.util.List;

import com.readbook.pagehelper.PageBean;
import com.readbook.pojo.RbFeedback;

/**
 * ”√ªß∑¥¿°service
 * @author caikanghua
 *
 */
public interface FeedbackService {
	public void addUserFeedback(RbFeedback rbFeedback);

	public List<RbFeedback> getFeedbacks();

	public void dealFeedback(int feedbackId, String userId,
			String feedbackResult);

	public void getFeedbackList(PageBean<RbFeedback> pageBean);
}
