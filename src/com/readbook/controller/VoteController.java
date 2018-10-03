package com.readbook.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.readbook.pojo.VoteBook;
import com.readbook.service.RedisService;
import com.readbook.service.UserVoteService;
import com.readbook.service.VoteService;
import com.readbook.utils.CheckLoginUtil;
import com.readbook.utils.IDUtils;
import com.readbook.utils.RbResult;

@Controller
public class VoteController {
	// ͶƱ������
	private static Object obj = new Object();
	@Autowired
	private VoteService voteService;
	@Autowired
	private RedisService redisService;
	@Autowired
	private UserVoteService userVoteService;
	@RequestMapping("/addVoteBook")
	@ResponseBody
	public RbResult addVoteBook(VoteBook voteBook,@RequestParam MultipartFile image,HttpServletRequest request,
			HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����½");
		}
		String path = request.getSession().getServletContext().getRealPath("/upload/image/admin");  
		if(image.isEmpty()){
			return RbResult.build(0, "�����ͼ��ͼƬ");
		}
        String fileName = image.getOriginalFilename();   
        fileName=IDUtils.genImageName()+fileName.substring(fileName.indexOf('.'));
        File dir = new File(path,fileName);  
        if(!dir.exists()){  
            dir.mkdirs();  
        }
        //MultipartFile�Դ��Ľ�������  
        try {
        	image.transferTo(dir);
			//�ϴ��ɹ�����ͼƬ·�����뵽���ݿ���
        	voteBook.setBookImg("/upload/image/admin"+"/"+fileName);
        	voteService.addVoteBook(voteBook);
        	return RbResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "����ʧ�ܣ�������");
	}
	/**
	 * ����id��ȡͶƱ��
	 * @param voteId
	 * @return
	 */
	@RequestMapping("/getVoteBookById")
	@ResponseBody
	public RbResult getVoteBookById(String voteBookId,HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����½");
		}
		VoteBook book=voteService.getVoteBookById(voteBookId);
		return RbResult.ok(book);
	}
	/**
	 * ��ȡ����ͶƱ��
	 * @return
	 */
	@RequestMapping("/getVoteBooks")
	@ResponseBody
	public RbResult getVoteBooks(HttpServletResponse resp,HttpServletRequest request){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����½");
		}
		List<VoteBook> list=voteService.getVoteBooks();
		return RbResult.ok(list);
	}

	
	
	/**
	 * ����ͶƱ��
	 * @param voteBook
	 * @param image
	 * @param request
	 * @param resp
	 * @return
	 */
	@RequestMapping("/updateVoteBook")
	@ResponseBody
	public RbResult updateVoteBook(VoteBook voteBook,@RequestParam MultipartFile image,HttpServletRequest request,
			HttpServletResponse resp){
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����½");
		}
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		String path = request.getSession().getServletContext().getRealPath("/upload/image/admin");  
		 String fileName="";
		if(!image.isEmpty()){
			fileName= image.getOriginalFilename();   
	        fileName=IDUtils.genImageName()+fileName.substring(fileName.indexOf('.'));
	        File dir = new File(path,fileName);  
	        if(!dir.exists()){  
	            dir.mkdirs();  
	        }
	        //MultipartFile�Դ��Ľ�������  
	        try {
	        	image.transferTo(dir);
				//�ϴ��ɹ�����ͼƬ·�����뵽���ݿ���
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(!"".endsWith(fileName)){
			voteBook.setBookImg("/upload/image/admin"+"/"+fileName);
		}
    	voteService.updateVoteBook(voteBook);
    	return RbResult.ok();
	}
	/**
	 * ɾ��ͶƱ��
	 * @param voteBookId
	 * @param resp
	 * @return
	 */
	@RequestMapping("/deleteVoteBook")
	@ResponseBody
	public RbResult deleteVoteBook(String voteBookId,HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����½");
		}
		voteService.deleteVoteBook(voteBookId);
		return RbResult.ok();
	}
	/**
	 * �û�ͶƱ
	 * @param userId �û�id
	 * @param voteBookId ͶƱ��id
	 * @param resp
	 * @return
	 */
	@RequestMapping("/vote")
	@ResponseBody
	public RbResult vote(String userId,String voteBookId,HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result = CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����½");
		}
		try {
			synchronized (obj) {
				// ��ѯ�û���ͶƱ��
				String voteTimes = redisService.getUserVoteTimes("userVote:"+userId);
				if (voteTimes != null && !"".endsWith(voteTimes)){
					int parseInt = Integer.parseInt(voteTimes);
					if (parseInt >= 10) {
						return RbResult.build(-100, "��24Сʱ������ͶƱ");
					}
				}
				// �û�ͶƱ�鼮,��ȡͶƱ���鼮
				VoteBook voteBook = redisService.getVoteBookById(voteBookId);
				// ͶƱ���1
				voteBook.setVotes(voteBook.getVotes() + 1);
				// ����ͶƱ���redis����
				redisService.incVoteBookVotes(voteBook);
				//�û���ͶƱ����һ
				redisService.incUserVoteTimes("userVote:"+userId);
				return RbResult.ok();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "ͶƱʧ��,������");
	}
	/**
	 * ��̨��Ա��������ͶƱͨ��
	 * @param lastTime
	 * @return
	 */
	@RequestMapping("/openVote")
	@ResponseBody
	public RbResult openVoteBook(HttpServletResponse resp,HttpServletRequest request){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����½");
		}
		redisService.openVoteBook("voteState");
		//��ѯ����ͶƱ�鼮
		List<VoteBook> list = voteService.getVoteBooks();
		if (list==null || list.size() == 0) {
			return RbResult.build(-1, "�����ͶƱ��");
		}
		//��ӵ�redis����
		redisService.addVoteBookList(list);
		return RbResult.ok();
	}
	/**
	 * �ر�ͶƱ
	 * @return
	 */
	@RequestMapping("/closeVote")
	@ResponseBody
	public RbResult closeVote(HttpServletResponse resp,HttpServletRequest request){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����½");
		}
		redisService.closeVoteBook("voteState");
		return RbResult.ok();
	}
	/**
	 * �ٴο���ͶƱ
	 * @return
	 */
	@RequestMapping("/againVote")
	@ResponseBody
	public RbResult againVote(HttpServletResponse resp,HttpServletRequest request){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����½");
		}
		redisService.againVoteBook("voteState");
		// ��ѯ����ͶƱ�鼮
		List<VoteBook> list = voteService.getVoteBooks();
		// ��ӵ�redis����
		redisService.addVoteBookList(list);
		return RbResult.ok();
	}
	
	/**
	 * С����˿���ͶƱͨ��
	 * @return
	 */
	@RequestMapping("/selectVote")
	@ResponseBody
	public RbResult openVote(HttpServletResponse resp,HttpServletRequest request){
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����½");
		}
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		//�ж�ͶƱ��״̬
		String voteState=redisService.getVoteState("voteState");
		if("0".equals(voteState)){
			//û����״̬
			return RbResult.build(0, "ͶƱ��δ����");
		}else if("1".equals(voteState)){
			//����״̬
			List<VoteBook> list=redisService.getVoteBooks();
			return RbResult.build(1, "ͶƱ����",list);
		}else if("2".equals(voteState)){
			//ͶƱ����״̬
			List<VoteBook> list=redisService.getVoteBooks();
			return RbResult.build(2, "ͶƱ�Ѿ�����",list);
		}
		return RbResult.build(-1, "ϵͳ����");
	}
	
	
}
