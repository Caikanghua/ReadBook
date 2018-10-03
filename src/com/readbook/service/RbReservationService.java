package com.readbook.service;

import java.util.Date;
import java.util.List;

import com.readbook.pagehelper.PageBean;
import com.readbook.pojo.RbReservation;

public interface RbReservationService {

	List<RbReservation> getReservations(String rankby);

	void updateSuccessCheckState(RbReservation rb);

	void updateStateToReceive(String reservationId);

	void updateStateToReturn(String reservationId);

	void updateTDateAndState(RbReservation rbReservation);

	void updateRDateAndState(RbReservation rbReservation);

	RbReservation getReservationById(String reservationId);

	void updateReservation(RbReservation result);

	void getAllReservation(PageBean<RbReservation> pageBean, int randby);

	void deleteReservation(String reservationId);

	void updateFailCheckState(RbReservation rb);

	List<RbReservation> getBeforeReturnReservations();

	void updateRemind(int i, String string);


}
