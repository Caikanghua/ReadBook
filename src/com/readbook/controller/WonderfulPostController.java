package com.readbook.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.readbook.pagehelper.PageBean;
import com.readbook.pojo.RbBook;
import com.readbook.pojo.RbReservation;
import com.readbook.pojo.RbWonderfulPost;
import com.readbook.service.RedisService;
import com.readbook.service.WonderfulPostService;
import com.readbook.utils.CheckLoginUtil;
import com.readbook.utils.RbResult;

@Controller
public class WonderfulPostController {
	@Autowired
	private WonderfulPostService wonderfulPostService;
	@Autowired
	private RedisService redisService;
	@RequestMapping("/addWonderfulPost")
	@ResponseBody
	public RbResult addWonderfulPost(RbWonderfulPost wonderfulPost,HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����½");
		}
		//�����������ʱ��
		wonderfulPost.setPostTime(new Date());
		try {
			wonderfulPostService.addWonderfulPost(wonderfulPost);
			return RbResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "fail");
	}
	/**
	 * ����idɾ����������
	 * @param wonderfulPostId
	 * @param request
	 * @return
	 */
	@RequestMapping("/deleteWonderfulPost")
	@ResponseBody
	public RbResult deleteWonderfulPost(String wonderfulPostId,
			HttpServletResponse resp,HttpServletRequest request){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����½");
		}
		try {
			wonderfulPostService.deleteWonderfulPost(wonderfulPostId);
			return RbResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "����ʧ�ܣ�������");
	}
	
	@RequestMapping("/updateWonderfulPost")
	@ResponseBody
	public RbResult updateWonderfulPost(RbWonderfulPost wonderfulPost,HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����½");
		}
		//�����������ʱ��
		wonderfulPost.setPostTime(new Date());
		try {
			wonderfulPostService.updateWonderfulPost(wonderfulPost);
			return RbResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "����ʧ�ܣ�������");
	}
	/**
	 * �鿴
	 * @param start_num
	 * @param page_size
	 * @return
	 */
	@RequestMapping("/getWonderfulPost")
	@ResponseBody
	public Map<String,Object> getWonderfulPost(@RequestParam(defaultValue="0")int start_num,int page_size,
			 HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		Map<String,Object> map=new HashMap<String, Object>();
//		boolean result=CheckLoginUtil.checkLogin(request,redisService);
//		if(result==false){
//			map.put("statusCode", -200);
//			map.put("message", "����û�е�½�����½");
//			return map;
//		}
		List<RbWonderfulPost> list;
		try {
			list = wonderfulPostService.getWonderfulPost(start_num,page_size);
			if(list!=null&&list.size()>0){
				map.put("result_count", list.size());
				map.put("statusCode", 102);
				map.put("result", list);
				map.put("message", "success");
				return map;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("statusCode", 102);
	    map.put("message", "success");
	    map.put("result_count", 0);
	    map.put("result", null);
		return map;
	}
	/**
	 * ��ȡ��������
	 * @param request
	 * @param currentPage
	 * @param resp
	 * @return
	 */
	@RequestMapping("/getWonderfulPostList")
	@ResponseBody
	public RbResult getWonderfulPostList(HttpServletRequest request,@RequestParam(defaultValue="1")int currentPage,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
//		boolean result=CheckLoginUtil.checkLogin(request,redisService);
//		if(result==false){
//			return RbResult.build(-200, "����û�е�½�����½");
//		}
		//���÷�ҳbean
		PageBean<RbWonderfulPost> pageBean=new PageBean<RbWonderfulPost>();
		pageBean.setCurrentPage(currentPage);
		//����Service
		wonderfulPostService.getWonderfulPostList(pageBean);
		return RbResult.ok(pageBean);
	}
}
