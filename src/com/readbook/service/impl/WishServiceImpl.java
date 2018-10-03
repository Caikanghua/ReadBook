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
		//2. 查询总记录数;  设置到pb对象中
		int totalCount = this.getTotalCount(type);
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
