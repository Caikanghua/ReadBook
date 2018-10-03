package com.readbook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.readbook.mapper.RbFeedbackMapper;
import com.readbook.pagehelper.PageBean;
import com.readbook.pojo.RbBook;
import com.readbook.pojo.RbFeedback;
import com.readbook.pojo.RbFeedbackExample;
import com.readbook.service.FeedbackService;
import com.readbook.utils.IDUtils;
@Service
public class FeedbackServiceImpl implements FeedbackService {
	@Autowired
	private RbFeedbackMapper rbFeedbackMapper;
	@Override
	public void addUserFeedback(RbFeedback rbFeedback) {
		rbFeedbackMapper.insertSelective(rbFeedback);
	}
	@Override
	public List<RbFeedback> getFeedbacks() {
		RbFeedbackExample example=new RbFeedbackExample();
		List<RbFeedback> list = rbFeedbackMapper.selectByExampleWithBLOBs(example);
		return list;
	}
	@Override
	public void dealFeedback(int feedbackId, String userId,
			String feedbackResult) {
		RbFeedback feedback=new RbFeedback();
		feedback.setFeedbackId(feedbackId);
		feedback.setHasDealed(1);
		feedback.setFeedbackResult(feedbackResult);
		rbFeedbackMapper.updateByPrimaryKeySelective(feedback);
	}
	@Override
	public void getFeedbackList(PageBean<RbFeedback> pageBean) {
		//2. ��ѯ�ܼ�¼��;  ���õ�pb������
		int totalCount = this.getTotalCount();
		pageBean.setTotalCount(totalCount);
		
		/*
		 * ���⣺ jspҳ�棬�����ǰҳΪ��ҳ���ٵ����һҳ����
		 *              �����ǰҳΪĩҳ���ٵ���һҳ��ʾ�����⣡
		 * �����
		 * 	   1. �����ǰҳ <= 0;       ��ǰҳ���õ�ǰҳΪ1;
		 * 	   2. �����ǰҳ > ���ҳ����  ��ǰҳ����Ϊ���ҳ��
		 */
		// �ж�
		if (pageBean.getCurrentPage() <=0) {
			pageBean.setCurrentPage(1);					    // �ѵ�ǰҳ����Ϊ1
		} else if (pageBean.getCurrentPage() > pageBean.getTotalPage()){
			pageBean.setCurrentPage(pageBean.getTotalPage());		// �ѵ�ǰҳ����Ϊ���ҳ��
		}
		
		//1. ��ȡ��ǰҳ�� �����ѯ����ʼ�С����ص�����
		int currentPage = pageBean.getCurrentPage();
		int index = (currentPage -1 ) * pageBean.getPageCount();// ��ѯ����ʼ��
		int count = pageBean.getPageCount();// ��ѯ���ص�����
		List<RbFeedback> feedbackList=rbFeedbackMapper.getFeedbackList(index, count);
		pageBean.setPageData(feedbackList);	
	}
	private int getTotalCount() {
		int count=rbFeedbackMapper.getTotalCount();
		return count;
	}

}
