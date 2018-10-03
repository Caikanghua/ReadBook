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
		//2. 查询总记录数;  设置到pb对象中
		int totalCount = this.getTotalCount();
		pageBean.setTotalCount(totalCount);
		
		/*
		 * 问题： jsp页面，如果当前页为首页，再点击上一页报错！
		 *              如果当前页为末页，再点下一页显示有问题！
		 * 解决：
		 * 	   1. 如果当前页 <= 0;       当前页设置当前页为1;
		 * 	   2. 如果当前页 > 最大页数；  当前页设置为最大页数
		 */
		// 判断
		if (pageBean.getCurrentPage() <=0) {
			pageBean.setCurrentPage(1);					    // 把当前页设置为1
		} else if (pageBean.getCurrentPage() > pageBean.getTotalPage()){
			pageBean.setCurrentPage(pageBean.getTotalPage());		// 把当前页设置为最大页数
		}
		
		//1. 获取当前页： 计算查询的起始行、返回的行数
		int currentPage = pageBean.getCurrentPage();
		int index = (currentPage -1 ) * pageBean.getPageCount();// 查询的起始行
		int count = pageBean.getPageCount();// 查询返回的行数
		List<RbFeedback> feedbackList=rbFeedbackMapper.getFeedbackList(index, count);
		pageBean.setPageData(feedbackList);	
	}
	private int getTotalCount() {
		int count=rbFeedbackMapper.getTotalCount();
		return count;
	}

}
