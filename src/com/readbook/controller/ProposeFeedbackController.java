package com.readbook.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.readbook.mapper.RbFeedbackMapper;
import com.readbook.pagehelper.PageBean;
import com.readbook.pojo.RbBook;
import com.readbook.pojo.RbFeedback;
import com.readbook.service.FeedbackService;
import com.readbook.service.RbMessageService;
import com.readbook.service.RedisService;
import com.readbook.utils.CheckLoginUtil;
import com.readbook.utils.IDUtils;
import com.readbook.utils.RbResult;
/**
 * 提出反馈controller
 * @author caikanghua
 *
 */
@Controller
public class ProposeFeedbackController {
	@Autowired
	private FeedbackService feedBackService;
	@Autowired
	private RbMessageService messageService;
	@Autowired
	private RedisService redisService;
	/**
	 * 用户反馈问题
	 * @param rbFeedback
	 * @param file
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/proposeFeedback",method=RequestMethod.POST)
	@ResponseBody
	public RbResult proposeFeedback(RbFeedback rbFeedback,@RequestParam MultipartFile image,HttpServletRequest request) throws Exception{
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "您还没有登录，请登录");
		}
		//设置反馈日期
		rbFeedback.setProposedDate(new Date());
		//获取用户id
		String userId = rbFeedback.getUserId();
	    String path = request.getSession().getServletContext().getRealPath("/upload/image")+"/"+userId;  
        String fileName ="";
        boolean empty = image.isEmpty();
        if(!empty){
        	  fileName=image.getOriginalFilename();   
              fileName=IDUtils.genImageName()+fileName.substring(fileName.lastIndexOf('.'));
              File dir = new File(path,fileName);  
              if(!dir.exists()){  
                  dir.mkdirs();  
              }
              try {
				image.transferTo(dir);
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
        //MultipartFile自带的解析方法  
		//上传成功，将图片路径插入到数据库中
        if(!"".equals(fileName)){
        	rbFeedback.setPrintscreen("/upload/image/"+userId+"/"+fileName);
        }
		feedBackService.addUserFeedback(rbFeedback);
		return RbResult.build(102, "已收录");
	}
	/**
	 * 管理员处理用户反馈问题
	 * @param feedbackId
	 * @param userId
	 * @param feedbackResult
	 * @return
	 */
	@RequestMapping("/dealFeedback")
	@ResponseBody
	public RbResult dealFeedback(int feedbackId,String userId,String feedbackResult,
			HttpServletRequest request,HttpServletResponse resp)throws Exception{
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "您还没有登陆，请登录!");
		}
		feedBackService.dealFeedback(feedbackId,userId,feedbackResult);
		messageService.sendFeedbackMessage(userId,feedbackResult);
		return RbResult.ok();
	}
	/**
	 * 获取反馈列表
	 * @param currentPage
	 * @param resp
	 * @return
	 */
	@RequestMapping("/getFeedbackList")
	@ResponseBody
	public RbResult getFeedbackList(@RequestParam(defaultValue="1")int currentPage,HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "您还没有登陆，请登录!");
		}
		//设置分页bean
		PageBean<RbFeedback> pageBean=new PageBean<RbFeedback>();
		pageBean.setCurrentPage(currentPage);
		//调用Service
		feedBackService.getFeedbackList(pageBean);
		return RbResult.ok(pageBean);
	}
	
}
