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
 * 用户预定书控制类
 * @author ckh
 * @date 2018-4-21 上午10:48:59
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
	 * 预定书
	 * @param reservation
	 * @return
	 */
	@RequestMapping("/order")
	@ResponseBody
	public RbResult orderBook(RbReservation reservation,String taken_date,String timeSlot,HttpServletRequest request){
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "您还没有登录，请登录!");
		}
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date takenDate=null;
		try {
			 takenDate = format.parse(taken_date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String bookId = reservation.getBookId();
		//检查该书是否还有库存
		boolean bookStock=rbBookService.checkIsStock(bookId);
		if(bookStock==false){
			return RbResult.build(0, "不好意思，该书暂无库存");
		}
		String phone = reservation.getPhone();
		boolean checkMobile = CheckUtils.checkMobile(phone);
		//检查用户重复预约了相同的书
		boolean ifOrdered=orderService.checkIfOrdered(reservation.getUserId(),bookId);
		boolean twoBooks=orderService.checkIsTwoBook(reservation.getUserId(), bookId);
		if(ifOrdered==true){
			return RbResult.build(1, "您已经预约了该书 ，请勿重复操作");
		}else if(twoBooks){
			return RbResult.build(2, "预约失败，每人在借书数量不能超过两本");
		}
		if(checkMobile==true){
			try {
				reservation.setReservationId(IDUtils.getId());
				//该书库存减一
				rbBookService.minusBook(bookId);
				//添加预约取书时间
				reservation.setTakenDate(takenDate);
				orderService.orderBook(reservation);
				redisService.addTimeSlot("timeSlot:"+reservation.getReservationId(),timeSlot);
				return RbResult.build(102, "预约成功，等待审核");
			} catch (Exception e) {
				e.printStackTrace();
				return RbResult.build(-1, "预约失败，请重试");
			}
		}
		return RbResult.build(3, "预约失败,不合法的手机号");
	}
	/**
	 * 用户取消了预定书
	 * @param reservationId
	 * @return
	 */
	@RequestMapping("/cancleOrder")
	@ResponseBody
	public RbResult cancleOrder(String reservationId,String bookId,HttpServletRequest request){
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "您还没有登陆，请登录!");
		}
		//查询该书是否在预约状态
		String state = orderService.getStateById(reservationId);
		try {
			if ("0".equals(state)) {
				orderService.cancleOrder(reservationId);
				rbBookService.updateStock(bookId);
				//删除时间缓存
				redisService.deleteByKey("timeSlot:"+reservationId);
				return RbResult.build(102, "取消预约成功");
			} else {
				return RbResult.build(0, "取消预约失败，您操作的书不在预约状态");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RbResult.build(-1, "取消预约失败");
		}
	}
	/**
	 * 预定归还书籍
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
			return RbResult.build(-200, "您还没有登陆，请登录!");
		}
		//查看该预约书是否在3|待归还状态
		Map<String,Object> map=new HashMap<String, Object>();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date deadlineDate=null;
		try {
			deadlineDate = format.parse(deadline);
			//根据预约id获取手机号
			RbReservation result = reservationService.getReservationById(reservationId);
			String phone=result.getPhone();
			result.setDeadline(deadlineDate);
			reservationService.updateReservation(result);
			String mes = "尊敬的用户您好，您已经成功预约还书，请于"+deadline+"日"+soltTime+"时间段前往学活"+LOCATION+"还书【深大书屋】"; 
			SendMsgUtil.sendMsg(phone, mes);
			return RbResult.ok();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "操作失败，请重试");
	}
	@RequestMapping("/getLocation")
	@ResponseBody
	public RbResult getLocation(HttpServletRequest request){
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if (result == false) {
			return RbResult.build(-200, "您还没有登陆，请登录!");
		}
		return RbResult.ok(LOCATION);
	}
	
}
