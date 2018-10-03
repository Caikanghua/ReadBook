package com.readbook.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.readbook.mapper.RbUserMapper;
import com.readbook.pojo.RbBook;
import com.readbook.pojo.RbCarousel;
import com.readbook.pojo.RbMessage;
import com.readbook.pojo.RbPost;
import com.readbook.pojo.RbReservation;
import com.readbook.pojo.RbShare;
import com.readbook.pojo.RbUser;
import com.readbook.service.RbBookService;
import com.readbook.service.RbCarouselService;
import com.readbook.service.RbMessageService;
import com.readbook.service.RbShareService;
import com.readbook.service.RedisService;
import com.readbook.service.UserService;
import com.readbook.utils.CheckLoginUtil;
import com.readbook.utils.IDUtils;
import com.readbook.utils.RbResult;
import com.readbook.utils.SendMsgUtil;
import com.readbook.utils.StringUtils;
import com.readbook.utils.StuVerifyUtils;
import com.readbook.utils.BookAPI.APIBookUtils;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private RedisService redisService;
	@Autowired
	private RbShareService shareService;
	@Autowired
	private RbCarouselService carouselService;
	@Autowired
	private RbBookService rbBookService;
	@Autowired
	private RbMessageService messageService;
	/**
	 * 
	 * @param phone
	 * @param type 0 注册 | 1 修改密码
	 * @param stuNum 学号(type=0时需要填写)
	 * @param isValid 是否通过验证的key(type=0时需要填写)
	 * @return
	 */
	@RequestMapping("/getVerifycode")
	@ResponseBody
	public RbResult getVerifycode(String phone,String type,
	   			HttpServletRequest request){
    	boolean phoneRegister = userService.checkPhoneRegister(phone);
		if (phoneRegister) {
			return RbResult.build(0, "该手机号已经注册过了!");
		}
		//用户注册
		if ("0".equals(type)) {
			//发送验证码给手机
			String random = SendMsgUtil.sendMsg(phone);
			//将验证码添加到缓存
			redisService.addVerifyCode("verifycode:"+phone,random);
			return RbResult.build(100, "success");
		}else if ("1".equals(type)) {
			boolean resultCheck = CheckLoginUtil.checkLogin(request,redisService);
			if (resultCheck == false) {
				return RbResult.build(-200, "您还没有登陆，请登录!");
			}
			//修改密码，先验证用户是否在登陆状态
			String userId = request.getHeader("x-key");
			//验证手机是否已经注册过了
			//发送验证码给手机
			String random = SendMsgUtil.sendMsg(phone);
			//将验证码添加到缓存
			redisService.addVerifyCode("verifycode:"+userId,random);
			return RbResult.build(100, "success");
		}
		return RbResult.build(-1, "出现错误，请重试");
	}
	/**
	 * 注册实现
	 * @param rbUser
	 * @param verifycode
	 * @param isValid
	 * @param request
	 * @return
	 */
	@RequestMapping("/signup")
	@ResponseBody
	public Map<String,Object> signup(RbUser rbUser,String verifycode,
			HttpServletRequest request){
		Map<String,Object> map = new HashMap<String,Object>();
		// 从缓存中获取验证码，验证用户
		String vfiCode = redisService.getVerifyCode("verifycode:"+rbUser.getPhone());
		if (StringUtils.isBlank(verifycode) || StringUtils.isBlank(vfiCode)) {
			map.put("statusCode",-1);
			map.put("message", "请输入验证码");
			return map;
		}
		if (verifycode.equals(vfiCode)) {
			// 密码Md5加密
			String password = DigestUtils.md5DigestAsHex(rbUser.getPassword().getBytes());
			rbUser.setPassword(password);
			String userId = IDUtils.getId();
			rbUser.setUserId(userId);
			rbUser.setRegisterTime(new Date());
			userService.register(rbUser);
			redisService.deleteByKey("verifycode:"+rbUser.getPhone());
			map.put("statusCode",101);
			map.put("message", "success");
			return map;
		} else {
			map.put("statusCode",-3);
			map.put("message", "手机验证码输入错误");
			return map;
		}
	}
	
	/**
	 * 用户登陆
	 * @param phone
	 * @param password
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public Map<String,Object> userLogin(String phone,String password,
			HttpServletRequest request)throws Exception{
		Map<String, Object> map = userService.userLogin(phone,password);
		if(map.get("statusCode") == "102"){
			//登陆成功
			Map<String,Object> user =  (Map<String, Object>) map.get("result");
			String userId = (String) user.get("userId");
			redisService.addLoginToken("token:"+userId,(String)user.get("token"));
			//登陆成功
			return map;
		}else{
			return map;
		}
	}
	/**
	 * 获取用户信息http://localhost:8080/getUserInfo.do?userId=152116416588874
	 * @param userId
	 * @param type
	 * @return
	 */
	@RequestMapping("/getUserInfo")
	@ResponseBody
	public RbResult getUserInfo(String userId,String type,HttpServletRequest
			request){
		//验证用户是否登陆
		boolean result = CheckLoginUtil.checkLogin(request,redisService);
		if (result == false) {
			return RbResult.build(-200, "您还没有登陆，请登录!");
		}
		RbUser rbUser = userService.getUserInfo(userId);
		if (rbUser == null) {
			return RbResult.build(-1, "fail");
		} else {
			return RbResult.build(100, "success", rbUser);
		}
	}
	/**
	 * 修改个人信息
	 * @param user
	 * @return
	 */
	@RequestMapping("/updateMyInfo")
	@ResponseBody
	public RbResult updateMyInfo(RbUser user,HttpServletRequest request){
		//验证登陆态
		boolean result = CheckLoginUtil.checkLogin(request,redisService);
		if (result == false) {
			return RbResult.build(-200, "您还没有登陆，请登录!");
		}
		if (user.getPassword() != null) {
			// 密码进行md5加密
			user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		}
		try {
			userService.updateUserInfo(user);
			return RbResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "更新信息失败，请重试");
	}
	/**
	 * 更新手机号
	 * @param userId
	 * @param phone
	 * @param verifycode
	 * @param request
	 * @return
	 */
	@RequestMapping("/updatePhone")
	@ResponseBody
	public RbResult updatePhone(String userId,String phone,String verifycode,
			HttpServletRequest request){
		String verifyStr = null;
		boolean result = CheckLoginUtil.checkLogin(request,redisService);
		if (result == false) {
			return RbResult.build(-200, "您还没有登陆，请登录!");
		}
//		String stuNum=userService.getStuNumById(userId);
		verifyStr = redisService.getVerifyCode("verifycode:"+userId);
		if (verifyStr != null) {
			if (verifyStr.equals(verifycode)) {	
				RbUser rbUser = userService.selectUserById(userId);
				rbUser.setPhone(phone);
				// 验证成功,更改手机号码
				try {
					userService.updateUserInfo(rbUser);
				} catch (Exception e) {
					e.printStackTrace();
				}
				// 返回更改后的用户
				RbUser user = userService.selectUserById(userId);
				return RbResult.build(100, "success", user);
			} else {
				return RbResult.build(0, "验证码出错");
			}
		} else {
			return RbResult.build(-1, "操作失败,请重试");
		}
	}
	/**
	 * 查看用户预约
	 * @param userId
	 * @param status 0 审核中 | 1 待领取 | 2 未通过| 3 超期|4 已归还
	 * @param stu_num 开始记录数
	 * @param page_size 每页帖子数
	 * @return
	 */
	@RequestMapping("/getMyReservations")
	@ResponseBody
	public Map<String,Object> getUserReservations(String userId,int[] status,
			@RequestParam(defaultValue="0")int stu_num,int page_size,
			HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean result = CheckLoginUtil.checkLogin(request,redisService);
		if (result == false) {
			map.put("statusCode", -200);
			map.put("message", "您还没有登陆，请登录!");
			return map;
		}
		List<RbReservation> list = new ArrayList<RbReservation>();
		for(int i=0;i<status.length;i++){
			List<RbReservation> reserationList=userService.getUserReservations(userId,status[i],stu_num,page_size);
			if (reserationList != null) {
				list.addAll(reserationList);
			}
		}
	   for (RbReservation rbReservation : list) {
			String bookId = rbReservation.getBookId();
			RbBook book = rbBookService.getBookById(bookId);
			rbReservation.setRbBook(book);
		}
		return getResultMap(list);
	}
	/**
	 * 获取用户所有的预约
	 * @param userId
	 * @param stu_num
	 * @param page_size
	 * @param request
	 * @return
	 */
	@RequestMapping("/getMyAllReservations")
	@ResponseBody
	public Map<String,Object> getMyAllReservations(String userId,@RequestParam(defaultValue="0")int stu_num,@RequestParam(defaultValue="10")int page_size,
			HttpServletRequest request){
		Map<String, Object> map=new HashMap<String, Object>();
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if (result == false) {
			map.put("statusCode", -200);
			map.put("message", "您还没有登陆，请登录!");
			return map;
		}
		List<RbReservation> reserationList = userService.getUserAllReservations(userId,stu_num,page_size);
	    for (RbReservation rbReservation : reserationList) {
			String bookId = rbReservation.getBookId();
			RbBook book = rbBookService.getBookById(bookId);
			rbReservation.setRbBook(book);
		}
		return getResultMap(reserationList);
	}
	
	/**
	 * 查看用户分享的书
	 * @param userId
	 * @param status
	 * @param stu_num
	 * @param page_size
	 * @return
	 */
	@RequestMapping("/getMyShares")
	@ResponseBody
	public Map<String,Object> getUserShares(String userId,int[] status,
			@RequestParam(defaultValue="0")int stu_num,int page_size,
			HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean result = CheckLoginUtil.checkLogin(request,redisService);
		if (result == false) {
			map.put("statusCode", -200);
			map.put("message", "您还没有登陆，请登录!");
			return map;
		}
		List<RbShare> list = new ArrayList<RbShare>();
		for(int i=0;i<status.length;i++){
			List<RbShare> shareList=userService.getUserShares(userId,status[i],stu_num,page_size);
			if (shareList != null) {
				list.addAll(shareList);
			}
		}
		return getResultMap(list);
	}
	/**
	 * 获取用户发过的书评
	 * @param userId
	 * @param rankby
	 * @param stu_num
	 * @param page_size
	 * @return
	 */
	@RequestMapping("/getMyPosts")
	@ResponseBody
	public Map<String,Object> getUserPosts(String userId,@RequestParam(defaultValue="0")String rankby,
			 @RequestParam(defaultValue="0")int stu_num,int page_size,
			 HttpServletRequest request)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		boolean result = CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			map.put("statusCode", -200);
			map.put("message", "您还没有登陆，请登录!");
			return map;
		}
		List<RbPost> list = new ArrayList<RbPost>();
		list = userService.getUserPostsByCondition(userId,rankby,stu_num,page_size);
		return getResultMap(list);
	}
	/**
	 * 用户预约送书
	 * @param share
	 * @param send_time
	 * @param request
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("/addMyShares")
	@ResponseBody
	public RbResult addMyShares(RbShare share,String send_time,String slotTime,
			HttpServletRequest request) throws ParseException{
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "您还没有登陆，请登录!");
		}
		String phone = share.getPhone();
		if (phone == null || "".equals(phone)) {
			return RbResult.build(-1, "请填写手机号");
		}
		// 获取用户选择的送书方式 0|分享人自己拿书上来 1|我们上门拿书
		Integer way = share.getDelieverWay();
		if (way == 0) {
			share.setState(0);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date parse = format.parse(send_time);
			share.setProposedDate(parse);
			int addShare = shareService.addShare(share);
			// 添加share 的send_Time到redis缓存中
			redisService.addShareSendTime("share:"+addShare,slotTime);
			// 分享人自己拿书到学活
			// SendMsgUtil.sendMsg(share.getPhone(),"sBook"+location);
			return RbResult.ok();
		}else if (way==1) {
			//我们上门领书
			share.setState(0);
			share.setProposedDate(new Date());
			try {
				shareService.addShare(share);
				//SendMsgUtil.sendMsg(share.getPhone(),"wnas");
				return RbResult.ok();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return RbResult.build(-1, "操作失败，请重试");
	}
	/**
	 * 取消分享书籍
	 * @param shareId
	 * @return
	 */
	@RequestMapping("/cancleMyShares")
	@ResponseBody
	public RbResult cancleMyShares(String shareId,HttpServletRequest request){
		String userId = request.getHeader("x-key");
		boolean result = CheckLoginUtil.checkLogin(request,redisService);
		if (result == false) {
			return RbResult.build(-200, "您还没有登陆，请登录!");
		}
		try {
			shareService.cancleMyShares(shareId);
			redisService.deleteByKey("timeSlot:"+userId);
			return RbResult.build(102, "您已经取消分享");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "操作失败，请重试");
	}
	@RequestMapping("/getMyAllShares")
	@ResponseBody
	public Map<String,Object> getMyAllShares(String userId,@RequestParam(defaultValue="0")int stu_num,@RequestParam(defaultValue="10")int page_size,HttpServletRequest request){
		List<RbShare> reserationList = userService.getUserAllShares(userId,stu_num,page_size);
	    for (RbShare rbReservation : reserationList) {
			String bookId = rbReservation.getBookId();
			if (bookId != null && !"".equals(bookId)) {
				RbBook book = rbBookService.getBookById(bookId);
				rbReservation.setRbBook(book);
			}
		}
		return getResultMap(reserationList);
	}
	@RequestMapping("/getCarousels")
	@ResponseBody
	public RbResult getCarousel(String number,HttpServletRequest request){
		boolean result = CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "您还没有登陆，请登录!");
		}
		List<RbCarousel> list = carouselService.getCarousel(number);
		return RbResult.ok(list);
	}
	
	/**
	 * 分页返回结果
	 * @param map
	 * @param list
	 * @return
	 */
	private Map<String, Object> getResultMap(
			List  list) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("statusCode", 100);
		map.put("message", "success");
		if (list != null) {
			map.put("result_count", list.size());
		} else {
			map.put("result_count", 0);
		}
		map.put("result", list);
		return map;
	}
	/**
	 * 更新昵称和头像
	 * @param rbUser
	 * @param image
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateNickNameOrImage")
	@ResponseBody
	public RbResult updateNickNameOrImage(RbUser rbUser,@RequestParam MultipartFile image,HttpServletRequest request){
		String userId = rbUser.getUserId();
		String path = request.getSession().getServletContext().getRealPath("/upload/image")+"/"+userId;  
        String fileName = "";
        boolean empty = image.isEmpty();
        if(!empty){
        	  fileName = image.getOriginalFilename();   
              fileName = IDUtils.genImageName()+fileName.substring(fileName.lastIndexOf('.'));
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
        if(!"".equals(fileName)){
        	rbUser.setPictureUrl("/upload/image/"+userId+"/"+fileName);
        }
		userService.updateUserInfo(rbUser);
		return RbResult.build(102, "success");
	}
	/**
	 * 重置密码
	 * @param password
	 * @param request
	 * @return
	 */
	@RequestMapping("/resetPassword")
	@ResponseBody
	public RbResult resetPassword(String password,String phone,String verifycode,HttpServletRequest request)throws Exception{
		RbUser rbUser = userService.getUserByPhone(phone);
		if (rbUser != null){
			String passwordMd = DigestUtils.md5DigestAsHex(password.getBytes());
			rbUser.setPassword(passwordMd);
		} else {
			return RbResult.build(-1, "fail");
		}
		String verifyC = redisService.getVerifyCode("passwordVerifycode:"+phone);
		if (verifyC ==null || !verifyC.equals(verifycode)) {
			return RbResult.build(0, "验证码错误");
		} else if (verifyC.equals(verifycode)) {
			userService.updateUserInfo(rbUser);
			redisService.deleteByKey("passwordVerifycode:"+phone);
			return RbResult.ok();
		}
		return RbResult.build(0, "验证码错误");
	}
	/**
	 * 获取重置密码验证码
	 * @param phone
	 * @return
	 */
	@RequestMapping("/getResetPassVerifycode")
	@ResponseBody
	public RbResult getResetPassVerifycode(String phone)throws Exception{
		boolean register = userService.checkPhoneRegister(phone);
		if(!register){
			return RbResult.build(0, "该手机号还没有注册");
		}
		//发送验证码给手机
		String random = SendMsgUtil.sendResetPasswordMsg(phone);
		//将验证码添加到缓存
		redisService.addVerifyCode("passwordVerifycode:"+phone,random);
		return RbResult.ok();
	}
	/**
	 *根据id获取消息详细
	 * @param messageId
	 * @return
	 */
	@RequestMapping("/getMessageDetailById")
	@ResponseBody
	public RbResult getMessageDetailById(String messageId,HttpServletRequest request){
		boolean result = CheckLoginUtil.checkLogin(request,redisService);
		if (result == false) {
			return RbResult.build(-200, "您还没有登陆，请登录!");
		}
		RbMessage message = messageService.getMessageDetailById(messageId);
		//更新消息为已读
		messageService.updateHasRead(messageId);
		return RbResult.ok(message);
	}
	/**
	 * 获取用户消息
	 * @param userId
	 * @param isRead
	 * @param start_num
	 * @param page_size
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getUserAllMessage")
	@ResponseBody
	public Map<String,Object> getUserAllMessage(String userId,@RequestParam(defaultValue="0")String isRead,
			 @RequestParam(defaultValue="0")int start_num,int page_size,
			 HttpServletRequest request)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		boolean result = CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			map.put("statusCode", -200);
			map.put("message", "您还没有登陆，请登录!");
			return map;
		}
		List<RbMessage> list = new ArrayList<RbMessage>();
		list = messageService.getUserAllMessage(userId,isRead,start_num,page_size);
		return getResultMap(list);
	}
	// 新增方法
	
	/**
	 * 根据isbn获取图书详情
	 * @param isbn
	 * @param request
	 * @return
	 */
	@RequestMapping("/getDetailBookById")
	@ResponseBody
	public RbResult getDetailBookById(String isbn,HttpServletRequest request){
//		boolean result = CheckLoginUtil.checkLogin(request,redisService);
//		if (result == false) {
//			return RbResult.build(-200, "您还没有登陆，请登录!");
//		}
		RbBook rbBook = rbBookService.getBookById(isbn);
		return RbResult.ok(rbBook);
	}
	/**
	 * 根据根据用户id获取用户部分基本信息
	 * @param userId
	 * @param request
	 * @return
	 */
	@RequestMapping("/getUserPartDetailByUserId")
	@ResponseBody
	public RbResult getUserPartDetailByUserId(String userId,HttpServletRequest request) {
//		boolean result = CheckLoginUtil.checkLogin(request,redisService);
//		if (result == false) {
//			return RbResult.build(-200, "您还没有登陆，请登录!");
//		}
		RbUser user = userService.getUserPartDetail(userId);
		return RbResult.ok(user);
	}
	/**
	 * 根据isbn获取分享书信息
	 */
	@RequestMapping("/getBookInfById")
	@ResponseBody
	public RbResult getBookInfById(String isbn) {
		RbShare share = APIBookUtils.getBookByIsbn(isbn);
		return RbResult.ok(share);
	}
}