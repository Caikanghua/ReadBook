package com.readbook.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.readbook.pojo.RbReservation;
import com.readbook.service.OrderService;
import com.readbook.service.RbBookService;
import com.readbook.service.RbReservationService;
import com.readbook.service.RedisService;
import com.readbook.utils.CheckLoginUtil;
import com.readbook.utils.CheckUtils;
import com.readbook.utils.IDUtils;
import com.readbook.utils.RbResult;
import com.readbook.utils.SendMsgUtil;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
/**
 * �û�Ԥ���������
 * @author ckh
 * @date 2018-4-21 ����10:48:59
 */
@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private RedisService redisService;
	@Autowired
	private RbBookService rbBookService;
	@Autowired
	private RbReservationService reservationService;
	@Value("${LOCATION}")
	private String LOCATION;
	/**
	 * Ԥ����
	 * @param reservation
	 * @return
	 */
	@RequestMapping("/order")
	@ResponseBody
	public RbResult orderBook(RbReservation reservation,String taken_date,String timeSlot,HttpServletRequest request){
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�¼�����¼!");
		}
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date takenDate=null;
		try {
			 takenDate = format.parse(taken_date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String bookId = reservation.getBookId();
		//�������Ƿ��п��
		boolean bookStock=rbBookService.checkIsStock(bookId);
		if(bookStock==false){
			return RbResult.build(0, "������˼���������޿��");
		}
		String phone = reservation.getPhone();
		boolean checkMobile = CheckUtils.checkMobile(phone);
		//����û��ظ�ԤԼ����ͬ����
		boolean ifOrdered=orderService.checkIfOrdered(reservation.getUserId(),bookId);
		boolean twoBooks=orderService.checkIsTwoBook(reservation.getUserId(), bookId);
		if(ifOrdered==true){
			return RbResult.build(1, "���Ѿ�ԤԼ�˸��� �������ظ�����");
		}else if(twoBooks){
			return RbResult.build(2, "ԤԼʧ�ܣ�ÿ���ڽ����������ܳ�������");
		}
		if(checkMobile==true){
			try {
				reservation.setReservationId(IDUtils.getId());
				//�������һ
				rbBookService.minusBook(bookId);
				//���ԤԼȡ��ʱ��
				reservation.setTakenDate(takenDate);
				orderService.orderBook(reservation);
				redisService.addTimeSlot("timeSlot:"+reservation.getReservationId(),timeSlot);
				return RbResult.build(102, "ԤԼ�ɹ����ȴ����");
			} catch (Exception e) {
				e.printStackTrace();
				return RbResult.build(-1, "ԤԼʧ�ܣ�������");
			}
		}
		return RbResult.build(3, "ԤԼʧ��,���Ϸ����ֻ���");
	}
	/**
	 * �û�ȡ����Ԥ����
	 * @param reservationId
	 * @return
	 */
	@RequestMapping("/cancleOrder")
	@ResponseBody
	public RbResult cancleOrder(String reservationId,String bookId,HttpServletRequest request){
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
		//��ѯ�����Ƿ���ԤԼ״̬
		String state = orderService.getStateById(reservationId);
		try {
			if ("0".equals(state)) {
				orderService.cancleOrder(reservationId);
				rbBookService.updateStock(bookId);
				//ɾ��ʱ�仺��
				redisService.deleteByKey("timeSlot:"+reservationId);
				return RbResult.build(102, "ȡ��ԤԼ�ɹ�");
			} else {
				return RbResult.build(0, "ȡ��ԤԼʧ�ܣ����������鲻��ԤԼ״̬");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RbResult.build(-1, "ȡ��ԤԼʧ��");
		}
	}
	/**
	 * Ԥ���黹�鼮
	 * @param reservationId
	 * @param userId
	 * @param deadline
	 * @param request
	 * @return
	 */
	@RequestMapping("/reserveReturnBook")
	@ResponseBody
	public RbResult reserveReturnBook(String reservationId,String userId,
			String deadline,String soltTime,HttpServletRequest request){
		boolean result1 = CheckLoginUtil.checkLogin(request,redisService);
		if(result1==false){
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
		//�鿴��ԤԼ���Ƿ���3|���黹״̬
		Map<String,Object> map=new HashMap<String, Object>();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date deadlineDate=null;
		try {
			deadlineDate = format.parse(deadline);
			//����ԤԼid��ȡ�ֻ���
			RbReservation result = reservationService.getReservationById(reservationId);
			String phone=result.getPhone();
			result.setDeadline(deadlineDate);
			reservationService.updateReservation(result);
			String mes = "�𾴵��û����ã����Ѿ��ɹ�ԤԼ���飬����"+deadline+"��"+soltTime+"ʱ���ǰ��ѧ��"+LOCATION+"���顾������ݡ�"; 
			SendMsgUtil.sendMsg(phone, mes);
			return RbResult.ok();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "����ʧ�ܣ�������");
	}
	@RequestMapping("/getLocation")
	@ResponseBody
	public RbResult getLocation(HttpServletRequest request){
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if (result == false) {
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
		return RbResult.ok(LOCATION);
	}
	
}
