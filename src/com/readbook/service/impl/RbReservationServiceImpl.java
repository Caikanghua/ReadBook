package com.readbook.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.readbook.mapper.RbReservationMapper;
import com.readbook.pagehelper.PageBean;
import com.readbook.pojo.RbBook;
import com.readbook.pojo.RbReservation;
import com.readbook.pojo.RbReservationExample;
import com.readbook.pojo.RbReservationExample.Criteria;
import com.readbook.service.RbReservationService;
@Service
public class RbReservationServiceImpl implements RbReservationService {
	@Autowired
	private RbReservationMapper rbReservationMapper;
	@Override
	public List<RbReservation> getReservations(String rankby) {
		List<RbReservation> list=rbReservationMapper.getReservationsByRankby(rankby);
		return list;
	}
	@Override
	public void updateSuccessCheckState(RbReservation rb) {
		rbReservationMapper.updateByPrimaryKeySelective(rb);
	}
	@Override
	public void updateStateToReceive(String reservationId) {
		rbReservationMapper.updateStateToThree(reservationId);
	}
	@Override
	public void updateStateToReturn(String reservationId) {
		rbReservationMapper.updateStateToFive(reservationId);
	}
	@Override
	public void updateTDateAndState(RbReservation rbReservation) {
		rbReservationMapper.updateByPrimaryKeySelective(rbReservation);
	}
	@Override
	public void updateRDateAndState(RbReservation rbReservation) {
		rbReservationMapper.updateByPrimaryKeySelective(rbReservation);
	}
	@Override
	public RbReservation getReservationById(String reservationId) {
		return rbReservationMapper.selectByPrimaryKey(reservationId);
	}
	@Override
	public void updateReservation(RbReservation result) {
		rbReservationMapper.updateByPrimaryKeySelective(result);
	}
	@Override
	public void getAllReservation(PageBean<RbReservation> pageBean, int randby) {
		//2. 查询总记录数;  设置到pb对象中
		int totalCount = this.getTotalCount(randby);
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
		List<RbReservation> bookList=rbReservationMapper.getReservationList(randby, index, count);
		pageBean.setPageData(bookList);	
	}
	private int getTotalCount(int randby) {
		int result=rbReservationMapper.getTotalCount(randby);
		return result;
	}
	@Override
	public void deleteReservation(String reservationId) {
		rbReservationMapper.deleteByPrimaryKey(reservationId);
	}
	@Override
	public void updateFailCheckState(RbReservation rb) {
		rb.setState(2);
		rbReservationMapper.updateByPrimaryKeySelective(rb);
	}
	@Override
	public List<RbReservation> getBeforeReturnReservations() {
		List<RbReservation> list = rbReservationMapper.getBeforeResturnReservation();
		return list;
	}
	@Override
	public void updateRemind(int i,String id) {
		rbReservationMapper.updateRemind(i,id);
	}

}
