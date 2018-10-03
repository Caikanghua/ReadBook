package com.readbook.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.readbook.pojo.CommentMessage;
import com.readbook.pojo.RbMessage;
import com.readbook.pojo.RbPost;
import com.readbook.pojo.RbUserStar;
import com.readbook.service.AttentionService;
import com.readbook.service.PostService;
import com.readbook.service.RbMessageService;
import com.readbook.service.RbReportService;
import com.readbook.service.RedisService;
import com.readbook.service.UserService;
import com.readbook.utils.CheckLoginUtil;
import com.readbook.utils.IDUtils;
import com.readbook.utils.RbResult;
/**
 * 发表书评控制类
 * @author ckh
 * @date 2018-4-21 上午10:50:30
 */
@Controller
public class PostController {
	@Autowired
	private PostService postService;
	@Autowired
	private RedisService redisService;
	@Autowired
	private RbReportService reportService;
	@Autowired
	private RbMessageService messageService;
	@Autowired
	private UserService userService;
	@Autowired
	private AttentionService attentionService;
	private int i = 0;
	@RequestMapping("/pubPost")
	@ResponseBody
	public RbResult pubPost(RbPost rbPost,@RequestParam MultipartFile image,HttpServletRequest
			request) throws Exception{
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "您还没登录，请登录!");
		}
		//处理图片
		//获取用户id
		String userId = rbPost.getUserId();
		String fileName="";
		boolean empty = image.isEmpty();
		//判断用户是否上传照片
		if(!empty){
			String path = request.getSession().getServletContext().getRealPath("/upload/image")+"/"+userId;  
			fileName= image.getOriginalFilename();   
	        fileName=IDUtils.genImageName()+fileName.substring(fileName.lastIndexOf('.'));
	        File dir = new File(path,fileName);  
	      //如果存储图片路径不存在，就创建一个
	        if(!dir.exists()){  
	            dir.mkdirs();  
	        }
	        try {
				image.transferTo(dir);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
        //MultipartFile自带的解析方法  
		//上传成功，将图片路径插入到数据库中
    	if(!"".equals(fileName)){
    		rbPost.setPictures("/upload/image/"+userId+"/"+fileName);
    	}
    	//设置发布日期
    	rbPost.setPubDate(new Date());
    	//设置该书评的id
    	String postId = IDUtils.getId();
    	rbPost.setCommentId(postId);
    	postService.addUserPost(rbPost);
    	// 把该用户发表书评的消息通知到关注其的用户们
    	String beAttentionUser = rbPost.getUserId();
    	String nickName = userService.getUserNickNameById(beAttentionUser);
    	// 获取所有关注该用户的用户id
    	List<String> list = attentionService.getAllUserId(beAttentionUser);
    	if (list != null && list.size() > 0) {
    		for (String attentionId : list) {
        		RbMessage message = new RbMessage();
        		message.setMessageId(IDUtils.getId());
        		message.setDate(new Date());
        		message.setMessageType("5");
        		message.setSendId(postId);
        		message.setSendName(nickName);
        		message.setUserId(attentionId);
        		message.setContent("您关注的用户:"+nickName+"发表了一条书评，点击这里可直接查看书评内容");
        		messageService.sendAttentionPost(message);
    		}
    	}
		return RbResult.build(102, "发布成功");
	}
	/**
	 * 根据书评id获取书评
	 * @param commentId
	 * @param request
	 * @return
	 */
	@RequestMapping("/getPostById")
	@ResponseBody
	public RbResult getPostById(String commentId,HttpServletRequest request) {
		boolean result = CheckLoginUtil.checkLogin(request,redisService);
		if (result == false) {
			return RbResult.build(-200, "您还没有登录，请登录");
		}
		RbPost post = postService.getPostById(commentId);
		return RbResult.ok(post);
	}
	/**
	 * 用户点赞书评
	 * @param userId
	 * @param commentId
	 * @return
	 */
	@RequestMapping("/star")
	@ResponseBody
	public RbResult starToPost(String userId,String commentId,
			HttpServletRequest request){
		boolean result = CheckLoginUtil.checkLogin(request,redisService);
		if (result == false) {
			return RbResult.build(-200, "您还没有登录，请登录");
		}
		//查询用户是否重复点赞
		boolean againStar = postService.checkAgainStar(userId,commentId);
		if (againStar) {
			return RbResult.build(0, "请勿重复点赞");
		}
		try {
			postService.starToPost(commentId);
			postService.addUserStar(userId,commentId);
			return RbResult.build(102, "发布成功");
		} catch (Exception e) {
			e.printStackTrace();
			return RbResult.build(-1, "发布失败");
		}
	}
	/**
	 * http://localhost:8080/comment.do?userId=123&content=呵呵呵&type=1&commentId=152095283466689
	 * @param userId
	 * @param content 评论的内容
	 * @param postId 评论所属的书评
	 * @param type 0|对书评的评论 1|对评论的评论
	 * @param commentId 
	 * @return http://localhost:8080/comment.do?userId=888&content=哈哈哈哈&commentId=123&type=0
	 */
	@RequestMapping("/comment")
	@ResponseBody
	public RbResult comment(String userId,String content,String commentId,
			String type,String uCommentId,HttpServletRequest request){
		boolean result = CheckLoginUtil.checkLogin(request,redisService);
		if (result == false) {
			return RbResult.build(-200, "您还没有登录,请登录");
		}
		//对书评的评论
		try {
			if ("0".equals(type)) {
				postService.comment(userId,content,commentId);
			}else if("1".equals(type)) {
				//对评论的评论
				postService.commentToComment(userId,content,commentId,uCommentId);
			}
			return RbResult.build(102, "评论成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "评论失败，请重试");
	}
	/**
	 * 删除评论
	 * @param uCommentId
	 * @return
	 */
	@RequestMapping("/deleteCommentByType")
	@ResponseBody
	public RbResult deleteCommentById(@RequestParam(defaultValue="0")Integer reportId,String uCommentId,String userId,String type,String commentId,
			HttpServletRequest request,HttpServletResponse resp)throws Exception{
		resp.setHeader("Access-Control-Allow-Origin", "*");
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "您还没有登陆，请登录!");
		}
		//根据type类型删除评论
		postService.deleteCommentsById(uCommentId,commentId,type);
		//通知用户投诉已经处理
		messageService.sendReportMessage(userId);
		//处理举报记录
		reportService.ignore(reportId);
		return RbResult.ok();
	}
	/**
	 * 根据用户id获取评论消息
	 * @param userId
	 * @param request
	 * @return
	 */
	@RequestMapping("/getCommentMessage")
	@ResponseBody
	public RbResult getCommentMessage(String userId,@RequestParam(defaultValue="0")int start_num,int page_size,HttpServletRequest request){
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "您还没有登陆，请登录!");
		}
		List<CommentMessage> list=postService.getCommentMessage(userId,start_num,page_size);
		return RbResult.ok(list);
	}
	/**
	 * 根据书id获取书评列表
	 * @param isbn
	 * @param request
	 * @return
	 */
	@RequestMapping("/getPostByBookId")
	@ResponseBody
	public RbResult getPostByBookId(String isbn,HttpServletRequest request){
//		boolean result = CheckLoginUtil.checkLogin(request,redisService);
//		if (result == false) {
//			return RbResult.build(-200, "您还没有登陆，请登录!");
//		}
		List<RbPost> list = postService.getPostListByBookId(isbn);
		return RbResult.ok(list);
	}
	
}
