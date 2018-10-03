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
		List<RbBook> bookList=rbBookMapper.getBooksByCondition(randby, index, count);
		pageBean.setPageData(bookList);	
	}
	private int getTotalCount() {
		int count=rbBookMapper.getTotalCount();
		return count;
	}

}
