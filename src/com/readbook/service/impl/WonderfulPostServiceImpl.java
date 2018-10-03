package com.readbook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.readbook.mapper.RbWonderfulPostMapper;
import com.readbook.pagehelper.PageBean;
import com.readbook.pojo.RbReservation;
import com.readbook.pojo.RbWonderfulPost;
import com.readbook.service.WonderfulPostService;
@Service
public class WonderfulPostServiceImpl implements WonderfulPostService {
	@Autowired
	private RbWonderfulPostMapper wonderfulPostMapper;
	@Override
	public void addWonderfulPost(RbWonderfulPost wonderfulPost) {
		wonderfulPostMapper.insertSelective(wonderfulPost);
	}
	@Override
	public void deleteWonderfulPost(String wonderfulPostId) {
		wonderfulPostMapper.deleteByPrimaryKey(Integer.parseInt(wonderfulPostId));
	}
	@Override
	public void updateWonderfulPost(RbWonderfulPost wonderfulPost) {
		wonderfulPostMapper.updateByPrimaryKeyWithBLOBs(wonderfulPost);
	}
	@Override
	public List<RbWonderfulPost> getWonderfulPost(int start_num, int page_size) {
		List<RbWonderfulPost> list= wonderfulPostMapper.getWonderfulPost(start_num,page_size);
		return list;
	}
	@Override
	public void getWonderfulPostList(PageBean<RbWonderfulPost> pageBean) {
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
		List<RbWonderfulPost> postList=wonderfulPostMapper.getWonderfulPostList(index, count);
		pageBean.setPageData(postList);	
	}
	private int getTotalCount() {
		return wonderfulPostMapper.getTotalCount();
	}

}
