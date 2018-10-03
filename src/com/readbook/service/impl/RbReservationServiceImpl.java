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
		//2. ��ѯ�ܼ�¼��;  ���õ�pb������
		int totalCount = this.getTotalCount(randby);
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
