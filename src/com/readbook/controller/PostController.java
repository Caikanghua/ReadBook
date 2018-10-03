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
 * ��������������
 * @author ckh
 * @date 2018-4-21 ����10:50:30
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
			return RbResult.build(-200, "����û��¼�����¼!");
		}
		//����ͼƬ
		//��ȡ�û�id
		String userId = rbPost.getUserId();
		String fileName="";
		boolean empty = image.isEmpty();
		//�ж��û��Ƿ��ϴ���Ƭ
		if(!empty){
			String path = request.getSession().getServletContext().getRealPath("/upload/image")+"/"+userId;  
			fileName= image.getOriginalFilename();   
	        fileName=IDUtils.genImageName()+fileName.substring(fileName.lastIndexOf('.'));
	        File dir = new File(path,fileName);  
	      //����洢ͼƬ·�������ڣ��ʹ���һ��
	        if(!dir.exists()){  
	            dir.mkdirs();  
	        }
	        try {
				image.transferTo(dir);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
        //MultipartFile�Դ��Ľ�������  
		//�ϴ��ɹ�����ͼƬ·�����뵽���ݿ���
    	if(!"".equals(fileName)){
    		rbPost.setPictures("/upload/image/"+userId+"/"+fileName);
    	}
    	//���÷�������
    	rbPost.setPubDate(new Date());
    	//���ø�������id
    	String postId = IDUtils.getId();
    	rbPost.setCommentId(postId);
    	postService.addUserPost(rbPost);
    	// �Ѹ��û�������������Ϣ֪ͨ����ע����û���
    	String beAttentionUser = rbPost.getUserId();
    	String nickName = userService.getUserNickNameById(beAttentionUser);
    	// ��ȡ���й�ע���û����û�id
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
        		message.setContent("����ע���û�:"+nickName+"������һ����������������ֱ�Ӳ鿴��������");
        		messageService.sendAttentionPost(message);
    		}
    	}
		return RbResult.build(102, "�����ɹ�");
	}
	/**
	 * ��������id��ȡ����
	 * @param commentId
	 * @param request
	 * @return
	 */
	@RequestMapping("/getPostById")
	@ResponseBody
	public RbResult getPostById(String commentId,HttpServletRequest request) {
		boolean result = CheckLoginUtil.checkLogin(request,redisService);
		if (result == false) {
			return RbResult.build(-200, "����û�е�¼�����¼");
		}
		RbPost post = postService.getPostById(commentId);
		return RbResult.ok(post);
	}
	/**
	 * �û���������
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
			return RbResult.build(-200, "����û�е�¼�����¼");
		}
		//��ѯ�û��Ƿ��ظ�����
		boolean againStar = postService.checkAgainStar(userId,commentId);
		if (againStar) {
			return RbResult.build(0, "�����ظ�����");
		}
		try {
			postService.starToPost(commentId);
			postService.addUserStar(userId,commentId);
			return RbResult.build(102, "�����ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			return RbResult.build(-1, "����ʧ��");
		}
	}
	/**
	 * http://localhost:8080/comment.do?userId=123&content=�ǺǺ�&type=1&commentId=152095283466689
	 * @param userId
	 * @param content ���۵�����
	 * @param postId ��������������
	 * @param type 0|������������ 1|�����۵�����
	 * @param commentId 
	 * @return http://localhost:8080/comment.do?userId=888&content=��������&commentId=123&type=0
	 */
	@RequestMapping("/comment")
	@ResponseBody
	public RbResult comment(String userId,String content,String commentId,
			String type,String uCommentId,HttpServletRequest request){
		boolean result = CheckLoginUtil.checkLogin(request,redisService);
		if (result == false) {
			return RbResult.build(-200, "����û�е�¼,���¼");
		}
		//������������
		try {
			if ("0".equals(type)) {
				postService.comment(userId,content,commentId);
			}else if("1".equals(type)) {
				//�����۵�����
				postService.commentToComment(userId,content,commentId,uCommentId);
			}
			return RbResult.build(102, "���۳ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "����ʧ�ܣ�������");
	}
	/**
	 * ɾ������
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
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
		//����type����ɾ������
		postService.deleteCommentsById(uCommentId,commentId,type);
		//֪ͨ�û�Ͷ���Ѿ�����
		messageService.sendReportMessage(userId);
		//����ٱ���¼
		reportService.ignore(reportId);
		return RbResult.ok();
	}
	/**
	 * �����û�id��ȡ������Ϣ
	 * @param userId
	 * @param request
	 * @return
	 */
	@RequestMapping("/getCommentMessage")
	@ResponseBody
	public RbResult getCommentMessage(String userId,@RequestParam(defaultValue="0")int start_num,int page_size,HttpServletRequest request){
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
		List<CommentMessage> list=postService.getCommentMessage(userId,start_num,page_size);
		return RbResult.ok(list);
	}
	/**
	 * ������id��ȡ�����б�
	 * @param isbn
	 * @param request
	 * @return
	 */
	@RequestMapping("/getPostByBookId")
	@ResponseBody
	public RbResult getPostByBookId(String isbn,HttpServletRequest request){
//		boolean result = CheckLoginUtil.checkLogin(request,redisService);
//		if (result == false) {
//			return RbResult.build(-200, "����û�е�½�����¼!");
//		}
		List<RbPost> list = postService.getPostListByBookId(isbn);
		return RbResult.ok(list);
	}
	
}
