package com.readbook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.readbook.mapper.RbBookMapper;
import com.readbook.pagehelper.PageBean;
import com.readbook.pojo.RbBook;
import com.readbook.service.SeachBookService;
@Service
public class SeachBookServiceImpl implements SeachBookService {
	@Autowired
	private RbBookMapper rbBookMapper;
	@Override
	public List<RbBook> searchBookByKey(String key, int start_num, int page_size) {
		List<RbBook> list=rbBookMapper.searchBookByKey(key,start_num,page_size);
		return list;
	}
	@Override
	public List<RbBook> getBooks(int randby, int start_num, int page_size) {
		List<RbBook> list=rbBookMapper.getBooksByCondition(randby,start_num,page_size);
		return list;
	}
	@Override
	public void getAllBook(PageBean<RbBook> pageBean, int randby) {
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
		List<RbBook> bookList=rbBookMapper.getBooksByCondition(randby, index, count);
		pageBean.setPageData(bookList);	
	}
	private int getTotalCount() {
		int count=rbBookMapper.getTotalCount();
		return count;
	}

}
