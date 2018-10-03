package com.readbook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.readbook.mapper.RbReservationMapper;
import com.readbook.pojo.RbReservation;
import com.readbook.service.OrderService;
import com.readbook.utils.IDUtils;
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private RbReservationMapper rbReservationMapper;
	@Override
	public void orderBook(RbReservation reservation) {
		rbReservationMapper.insertSelective(reservation);
	}
	@Override
	public boolean checkIfOrdered(String userId, String bookId) {
		List<RbReservation> list=rbReservationMapper.checkIfOrdered(userId,bookId);
		if(list!=null&&list.size()>0){
			return true;
		}
		return false;
	}
	@Override
	public boolean checkIsTwoBook(String userId, String bookId) {
		String books=rbReservationMapper.checkIsTwoBook(userId);
		if(books!=null&&"2".equals(books)){
			return true;
		}
		return false;
	}
	@Override
	public void cancleOrder(String reservationId) {
		rbReservationMapper.deleteByPrimaryKey(reservationId);
	}
	@Override
	public String getStateById(String reservationId) {
		String state=rbReservationMapper.getStateById(reservationId);
		return state;
	}

}
