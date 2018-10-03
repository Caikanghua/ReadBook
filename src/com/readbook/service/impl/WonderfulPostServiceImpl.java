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
		List<RbWonderfulPost> postList=wonderfulPostMapper.getWonderfulPostList(index, count);
		pageBean.setPageData(postList);	
	}
	private int getTotalCount() {
		return wonderfulPostMapper.getTotalCount();
	}

}
