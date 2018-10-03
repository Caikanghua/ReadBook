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
	@Scheduled(cron="0 0 12 * * ?") // 每天中午12点执行一次
	public void sendDeadlineMessage() {
		 long nd = 1000 * 24 * 60 * 60;
		  // long ns = 1000;
		  // 获得两个时间的毫秒时间差异
		 Date nowDate = new Date();
		List<RbReservation> list = reservationService.getBeforeReturnReservations();
		for (RbReservation rbReservation : list) {
			Date takenDate = rbReservation.getTakenDate();
		    long diff =  nowDate.getTime() - takenDate.getTime();
		    // 计算差多少天
		    long day = diff / nd;
		    if (day>=25) {
		    	// 提醒用户还书
		    	String bookId = rbReservation.getBookId();
				String bookName = bookService.getBookNameById(bookId);
				// 发送短信消息
				String msg = "尊敬的用户，您所借的《"+bookName+"》书，距离还书日期还有5天噢，请尽快预约还书，避免超期，谢谢您的合作!【深大书屋】";
				// 获取用户手机号
				String phone = rbReservation.getPhone();
				System.out.println("phone:"+phone);
				SendMsgUtil.sendMsg(phone, msg);
				// 更新该预约书为
				reservationService.updateRemind(1,rbReservation.getReservationId());
		    }
		}
	}
}
