package com.readbook.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.readbook.pojo.RbReservation;
import com.readbook.service.RbBookService;
import com.readbook.service.RbReservationService;
@Lazy(false)
@Component
public class DeadlineMessageTask {
	@Autowired
	private RbReservationService reservationService;
	@Autowired
	private RbBookService bookService;
	@Scheduled(cron="0 0 12 * * ?") // ÿ������12��ִ��һ��
	public void sendDeadlineMessage() {
		 long nd = 1000 * 24 * 60 * 60;
		  // long ns = 1000;
		  // �������ʱ��ĺ���ʱ�����
		 Date nowDate = new Date();
		List<RbReservation> list = reservationService.getBeforeReturnReservations();
		for (RbReservation rbReservation : list) {
			Date takenDate = rbReservation.getTakenDate();
		    long diff =  nowDate.getTime() - takenDate.getTime();
		    // ����������
		    long day = diff / nd;
		    if (day>=25) {
		    	// �����û�����
		    	String bookId = rbReservation.getBookId();
				String bookName = bookService.getBookNameById(bookId);
				// ���Ͷ�����Ϣ
				String msg = "�𾴵��û���������ġ�"+bookName+"���飬���뻹�����ڻ���5���ޣ��뾡��ԤԼ���飬���ⳬ�ڣ�лл���ĺ���!��������ݡ�";
				// ��ȡ�û��ֻ���
				String phone = rbReservation.getPhone();
				System.out.println("phone:"+phone);
				SendMsgUtil.sendMsg(phone, msg);
				// ���¸�ԤԼ��Ϊ
				reservationService.updateRemind(1,rbReservation.getReservationId());
		    }
		}
	}
}
