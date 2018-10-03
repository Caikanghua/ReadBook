package com.readbook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.readbook.mapper.RbShareMapper;
import com.readbook.pagehelper.PageBean;
import com.readbook.pojo.RbBook;
import com.readbook.pojo.RbPost;
import com.readbook.pojo.RbShare;
import com.readbook.service.RbShareService;
@Service
public class RbShareServiceImpl implements RbShareService {
	@Autowired
	private RbShareMapper rbShareMapper;
	@Override
	public List<RbShare> getAllShares(String rankby) {
		List<RbShare> list = rbShareMapper.getAllSharesByRankby(rankby);
		return list;
	}
	@Override
	public int addShare(RbShare share) {
		rbShareMapper.insertSelective(share);
		return share.getShareId();
	}
	@Override
	public void cancleMyShares(String shareId) {
		rbShareMapper.deleteByPrimaryKey(Integer.parseInt(shareId));
	}
	@Override
	public RbShare getShareById(String shareId) {
		RbShare share = rbShareMapper.selectByPrimaryKey(Integer.parseInt(shareId));
		return share;
	}
	@Override
	public void updateStateToCancle(String shareId) {
		rbShareMapper.updateStateToCancle(shareId);
	}
	@Override
	public void addBookId(String isbn,String shareId) {
		RbShare record=new RbShare();
		record.setBookId(isbn);
		record.setShareId(Integer.parseInt(shareId));
		rbShareMapper.updateByPrimaryKeySelective(record);
	}
	@Override
	public String getUserIdByShareId(String shareId) {
		String userId=rbShareMapper.getUserIdByShareId(shareId);
		return userId;
	}
	@Override
	public void updateStateToPut(String shareId) {
		rbShareMapper.updateStateToPut(shareId);
	}
	@Override
	public void updateStateToGetBook(String shareId) {
		rbShareMapper.updateStateToGetBook(shareId);
	}
	@Override
	public List<RbShare> getShareByPhone(String phone,int start_num,int page_size) {
		List<RbShare>  rbShare=rbShareMapper.getShareByPhone(phone,start_num,page_size);
		return rbShare;
	}
//	@Override
//	public List<RbShare> searhUserShareBook(String state) {
//		List<RbShare>  rbShare=rbShareMapper.searhUserShareBook(state);
//		return rbShare;
//	}
	@Override
	public List<RbShare> searhUserShareBook(String state, int start_num,
			int page_size) {
		List<RbShare>  rbShare=rbShareMapper.searhUserShareBook(state,start_num,page_size);
		return rbShare;
	}
	@Override
	public void getShareList(PageBean<RbShare> pageBean,int rankby) {
		//2. 查询总记录数;  设置到pb对象中
		int totalCount = this.getTotalCount(rankby);
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
		List<RbShare> allPost = rbShareMapper.getShareList(rankby,index, count);
		pageBean.setPageData(allPost);	
	}
	private int getTotalCount(int rankby) {
		return rbShareMapper.getTotalCount(rankby);
	}

}
