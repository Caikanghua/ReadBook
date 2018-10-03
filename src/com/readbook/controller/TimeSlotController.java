package com.readbook.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.readbook.pojo.TimeSlot;
import com.readbook.service.RedisService;
import com.readbook.service.TimeSlotService;
import com.readbook.utils.CheckLoginUtil;
import com.readbook.utils.RbResult;

@Controller
public class TimeSlotController {
	@Autowired
	private TimeSlotService slotService;
	@Autowired
	private RedisService redisService;
	/**
	 * ����ʱ���
	 * @param timeSlot
	 * @param request
	 * @param resp
	 * @return
	 */
	@RequestMapping("/addTimeSlot")
	@ResponseBody
	public RbResult addTimeSlot(String slotTime,HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����½");
		}
		slotService.addTimeSlot(slotTime);
		return RbResult.ok();
	}
	/**
	 * ����id��ȡʱ���
	 * @param timeSlotId
	 * @param resp
	 * @return
	 */
	@RequestMapping("/getTimeSlotById")
	@ResponseBody
	public RbResult getTimeSlotById(String slotId,HttpServletResponse resp,HttpServletRequest request){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����½");
		}
		TimeSlot timeSlot = slotService.getTimeSlot(slotId);
		return RbResult.ok(timeSlot);
	}
	/**
	 * ��ȡ����ʱ����б�
	 * @param resp
	 * @return
	 */
	@RequestMapping("/getTimeSlots")
	@ResponseBody
	public RbResult getTimeSlots(HttpServletResponse resp,HttpServletRequest request){
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "PUT,POST,GET,OPTIONS,DELETE");
		resp.setHeader("Access-Control-Allow-Headers", "Origin,X-Requested-With,content-type");
//		boolean result=CheckLoginUtil.checkLogin(request,redisService);
//		if(result==false){
//			return RbResult.build(-200, "����û�е�½�����½");
//		}
		List<TimeSlot> list=slotService.getTimeSlotList();
		return RbResult.ok(list);
	}
	
	
	/**
	 * ����ʱ���
	 * @param timeSlot
	 * @param resp
	 * @return
	 */
	@RequestMapping("/updateTimeSlot")
	@ResponseBody
	public RbResult updateTimeSlot(TimeSlot timeSlot,HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����½");
		}
		slotService.updateTimeSlot(timeSlot);
		return RbResult.ok();
	}
	/**
	 * ɾ��ʱ���
	 * @param timeSlotId
	 * @param resp
	 * @return
	 */
	@RequestMapping("/deleteTimeSlot")
	@ResponseBody
	public RbResult deleteTimeSlot(String slotId,HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����½");
		}
		try {
			slotService.deleteTimeSlotById(slotId);
			return RbResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "ɾ��ʧ�ܣ�������");
	}
}
