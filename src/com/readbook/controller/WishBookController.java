package com.readbook.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.readbook.pagehelper.PageBean;
import com.readbook.pojo.RbFeedback;
import com.readbook.pojo.RbWish;
import com.readbook.service.RbMessageService;
import com.readbook.service.RedisService;
import com.readbook.service.WishService;
import com.readbook.utils.CheckLoginUtil;
import com.readbook.utils.RbResult;

@Controller
public class WishBookController {
	@Autowired
	private RedisService redisService;
	@Autowired
	private WishService wishService;
	@Autowired
	private RbMessageService messageService;
	/**
	 * 增加愿望书单
	 * @param wish
	 * @param request
	 * @return
	 */
	@RequestMapping("/addWishBook")
	@ResponseBody
	public RbResult addWishBook(RbWish wish,HttpServletRequest request){
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "您还没有登陆，请登录!");
		}
		wish.setWishDate(new Date());
		wishService.addWishBook(wish);
		return RbResult.ok();
	}
	/**
	 * 获取愿望书单列表
	 * @param currentPage
	 * @param type 0|没处理 1|已经处理
	 * @param resp
	 * @return
	 */
	@RequestMapping("/getWishBookList")
	@ResponseBody
	public RbResult getWishBookList(HttpServletRequest request,@RequestParam(defaultValue="1")int currentPage,int type,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "您还没有登陆，请登陆");
		}
		//设置分页bean
		PageBean<RbWish> pageBean=new PageBean<RbWish>();
		pageBean.setCurrentPage(currentPage);
		//调用Service
		wishService.getWishList(pageBean,type);
		return RbResult.ok(pageBean);
	}
	/**
	 * 管理员入库愿望书单的书
	 * @param wishId
	 * @param userId
	 * @param resp
	 * @return
	 */
	@RequestMapping("/storageWishBook")
	@ResponseBody
	public RbResult storage(HttpServletRequest request,int wishId,String userId,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "您还没有登陆，请登陆");
		}
		//处理愿望书
		wishService.storage(wishId);
		//根据wishId获取bookName
		String bookName = wishService.getWishBookName(wishId);
		//通知用户愿望书单的书已经到库
		messageService.sendWishStorageMessage(userId,bookName);
		return RbResult.ok();
	}
	/**
	 * 忽略愿望书申请
	 * @param wishId
	 * @param userId
	 * @param resp
	 * @return
	 */
	@RequestMapping("/ignoreWishBook")
	@ResponseBody
	public RbResult ignore(HttpServletRequest request,int wishId,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "您还没有登陆，请登陆");
		}
		//处理愿望书
		wishService.ignore(wishId);
		return RbResult.ok();
	}
	
}
