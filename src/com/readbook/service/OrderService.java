package com.readbook.service;

import com.readbook.pojo.RbReservation;

public interface OrderService {

	public void orderBook(RbReservation reservation);

	public boolean checkIfOrdered(String userId, String bookId);

	public boolean checkIsTwoBook(String userId, String bookId);

	public void cancleOrder(String reservationId);

	public String getStateById(String reservationId);
	
}
