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
	 * ����Ը���鵥
	 * @param wish
	 * @param request
	 * @return
	 */
	@RequestMapping("/addWishBook")
	@ResponseBody
	public RbResult addWishBook(RbWish wish,HttpServletRequest request){
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
		wish.setWishDate(new Date());
		wishService.addWishBook(wish);
		return RbResult.ok();
	}
	/**
	 * ��ȡԸ���鵥�б�
	 * @param currentPage
	 * @param type 0|û���� 1|�Ѿ�����
	 * @param resp
	 * @return
	 */
	@RequestMapping("/getWishBookList")
	@ResponseBody
	public RbResult getWishBookList(HttpServletRequest request,@RequestParam(defaultValue="1")int currentPage,int type,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����½");
		}
		//���÷�ҳbean
		PageBean<RbWish> pageBean=new PageBean<RbWish>();
		pageBean.setCurrentPage(currentPage);
		//����Service
		wishService.getWishList(pageBean,type);
		return RbResult.ok(pageBean);
	}
	/**
	 * ����Ա���Ը���鵥����
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
			return RbResult.build(-200, "����û�е�½�����½");
		}
		//����Ը����
		wishService.storage(wishId);
		//����wishId��ȡbookName
		String bookName = wishService.getWishBookName(wishId);
		//֪ͨ�û�Ը���鵥�����Ѿ�����
		messageService.sendWishStorageMessage(userId,bookName);
		return RbResult.ok();
	}
	/**
	 * ����Ը��������
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
			return RbResult.build(-200, "����û�е�½�����½");
		}
		//����Ը����
		wishService.ignore(wishId);
		return RbResult.ok();
	}
	
}
