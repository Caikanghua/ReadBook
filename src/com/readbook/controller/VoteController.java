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
	// 投票锁对象
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
			return RbResult.build(-200, "您还没有登陆，请登陆");
		}
		String path = request.getSession().getServletContext().getRealPath("/upload/image/admin");  
		if(image.isEmpty()){
			return RbResult.build(0, "请添加图书图片");
		}
        String fileName = image.getOriginalFilename();   
        fileName=IDUtils.genImageName()+fileName.substring(fileName.indexOf('.'));
        File dir = new File(path,fileName);  
        if(!dir.exists()){  
            dir.mkdirs();  
        }
        //MultipartFile自带的解析方法  
        try {
        	image.transferTo(dir);
			//上传成功，将图片路径插入到数据库中
        	voteBook.setBookImg("/upload/image/admin"+"/"+fileName);
        	voteService.addVoteBook(voteBook);
        	return RbResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "操作失败，请重试");
	}
	/**
	 * 根据id获取投票书
	 * @param voteId
	 * @return
	 */
	@RequestMapping("/getVoteBookById")
	@ResponseBody
	public RbResult getVoteBookById(String voteBookId,HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "您还没有登陆，请登陆");
		}
		VoteBook book=voteService.getVoteBookById(voteBookId);
		return RbResult.ok(book);
	}
	/**
	 * 获取所有投票书
	 * @return
	 */
	@RequestMapping("/getVoteBooks")
	@ResponseBody
	public RbResult getVoteBooks(HttpServletResponse resp,HttpServletRequest request){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "您还没有登陆，请登陆");
		}
		List<VoteBook> list=voteService.getVoteBooks();
		return RbResult.ok(list);
	}

	
	
	/**
	 * 更新投票书
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
			return RbResult.build(-200, "您还没有登陆，请登陆");
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
	        //MultipartFile自带的解析方法  
	        try {
	        	image.transferTo(dir);
				//上传成功，将图片路径插入到数据库中
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
	 * 删除投票书
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
			return RbResult.build(-200, "您还没有登陆，请登陆");
		}
		voteService.deleteVoteBook(voteBookId);
		return RbResult.ok();
	}
	/**
	 * 用户投票
	 * @param userId 用户id
	 * @param voteBookId 投票书id
	 * @param resp
	 * @return
	 */
	@RequestMapping("/vote")
	@ResponseBody
	public RbResult vote(String userId,String voteBookId,HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result = CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "您还没有登陆，请登陆");
		}
		try {
			synchronized (obj) {
				// 查询用户总投票数
				String voteTimes = redisService.getUserVoteTimes("userVote:"+userId);
				if (voteTimes != null && !"".endsWith(voteTimes)){
					int parseInt = Integer.parseInt(voteTimes);
					if (parseInt >= 10) {
						return RbResult.build(-100, "请24小时后再来投票");
					}
				}
				// 用户投票书籍,获取投票的书籍
				VoteBook voteBook = redisService.getVoteBookById(voteBookId);
				// 投票书加1
				voteBook.setVotes(voteBook.getVotes() + 1);
				// 更新投票书的redis缓存
				redisService.incVoteBookVotes(voteBook);
				//用户的投票数加一
				redisService.incUserVoteTimes("userVote:"+userId);
				return RbResult.ok();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "投票失败,请重试");
	}
	/**
	 * 后台人员开启好书投票通道
	 * @param lastTime
	 * @return
	 */
	@RequestMapping("/openVote")
	@ResponseBody
	public RbResult openVoteBook(HttpServletResponse resp,HttpServletRequest request){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "您还没有登陆，请登陆");
		}
		redisService.openVoteBook("voteState");
		//查询所有投票书籍
		List<VoteBook> list = voteService.getVoteBooks();
		if (list==null || list.size() == 0) {
			return RbResult.build(-1, "请添加投票书");
		}
		//添加到redis缓存
		redisService.addVoteBookList(list);
		return RbResult.ok();
	}
	/**
	 * 关闭投票
	 * @return
	 */
	@RequestMapping("/closeVote")
	@ResponseBody
	public RbResult closeVote(HttpServletResponse resp,HttpServletRequest request){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "您还没有登陆，请登陆");
		}
		redisService.closeVoteBook("voteState");
		return RbResult.ok();
	}
	/**
	 * 再次开启投票
	 * @return
	 */
	@RequestMapping("/againVote")
	@ResponseBody
	public RbResult againVote(HttpServletResponse resp,HttpServletRequest request){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "您还没有登陆，请登陆");
		}
		redisService.againVoteBook("voteState");
		// 查询所有投票书籍
		List<VoteBook> list = voteService.getVoteBooks();
		// 添加到redis缓存
		redisService.addVoteBookList(list);
		return RbResult.ok();
	}
	
	/**
	 * 小程序端开启投票通道
	 * @return
	 */
	@RequestMapping("/selectVote")
	@ResponseBody
	public RbResult openVote(HttpServletResponse resp,HttpServletRequest request){
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "您还没有登陆，请登陆");
		}
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		//判断投票的状态
		String voteState=redisService.getVoteState("voteState");
		if("0".equals(voteState)){
			//没开启状态
			return RbResult.build(0, "投票暂未开启");
		}else if("1".equals(voteState)){
			//开启状态
			List<VoteBook> list=redisService.getVoteBooks();
			return RbResult.build(1, "投票开启",list);
		}else if("2".equals(voteState)){
			//投票结束状态
			List<VoteBook> list=redisService.getVoteBooks();
			return RbResult.build(2, "投票已经结束",list);
		}
		return RbResult.build(-1, "系统出错");
	}
	
	
}
