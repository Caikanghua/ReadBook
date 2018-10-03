package com.readbook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.readbook.mapper.RbWishMapper;
import com.readbook.pagehelper.PageBean;
import com.readbook.pojo.RbFeedback;
import com.readbook.pojo.RbWish;
import com.readbook.pojo.RbWishExample;
import com.readbook.service.WishService;
@Service
public class WishServiceImpl implements WishService {
	@Autowired
	private RbWishMapper wishMapper;
	@Override
	public void addWishBook(RbWish wish) {
		wishMapper.insertSelective(wish);
	}
	@Override
	public void getWishList(PageBean<RbWish> pageBean, int type) {
		//2. ��ѯ�ܼ�¼��;  ���õ�pb������
		int totalCount = this.getTotalCount(type);
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
		List<RbWish> feedbackList=wishMapper.getWishList(type,index, count);
		pageBean.setPageData(feedbackList);	
	}
	private int getTotalCount(int type) {
		int result = wishMapper.getTotalCount(type);
		return result;
	}
	@Override
	public void storage(int wishId) {
		RbWish wish=new RbWish();
		wish.setWishId(wishId);
		wish.setHasCheck(1);
		wishMapper.updateByPrimaryKeySelective(wish);
	}
	@Override
	public String getWishBookName(int wishId) {
		String bookName=wishMapper.getWishBookName(wishId);
		return bookName;
	}
	@Override
	public void ignore(int wishId) {
		RbWish wish = new RbWish();
		wish.setWishId(wishId);
		wish.setHasCheck(1);
		wishMapper.updateByPrimaryKeySelective(wish);
	}

}
