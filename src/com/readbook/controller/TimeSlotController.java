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
	 * 增加时间段
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
			return RbResult.build(-200, "您还没有登陆，请登陆");
		}
		slotService.addTimeSlot(slotTime);
		return RbResult.ok();
	}
	/**
	 * 根据id获取时间段
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
			return RbResult.build(-200, "您还没有登陆，请登陆");
		}
		TimeSlot timeSlot = slotService.getTimeSlot(slotId);
		return RbResult.ok(timeSlot);
	}
	/**
	 * 获取所有时间段列表
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
//			return RbResult.build(-200, "您还没有登陆，请登陆");
//		}
		List<TimeSlot> list=slotService.getTimeSlotList();
		return RbResult.ok(list);
	}
	
	
	/**
	 * 更新时间段
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
			return RbResult.build(-200, "您还没有登陆，请登陆");
		}
		slotService.updateTimeSlot(timeSlot);
		return RbResult.ok();
	}
	/**
	 * 删除时间段
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
			return RbResult.build(-200, "您还没有登陆，请登陆");
		}
		try {
			slotService.deleteTimeSlotById(slotId);
			return RbResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "删除失败，请重试");
	}
}
