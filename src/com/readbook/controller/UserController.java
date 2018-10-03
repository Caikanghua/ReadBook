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
	 * @param type 0 ע�� | 1 �޸�����
	 * @param stuNum ѧ��(type=0ʱ��Ҫ��д)
	 * @param isValid �Ƿ�ͨ����֤��key(type=0ʱ��Ҫ��д)
	 * @return
	 */
	@RequestMapping("/getVerifycode")
	@ResponseBody
	public RbResult getVerifycode(String phone,String type,
	   			HttpServletRequest request){
    	boolean phoneRegister = userService.checkPhoneRegister(phone);
		if (phoneRegister) {
			return RbResult.build(0, "���ֻ����Ѿ�ע�����!");
		}
		//�û�ע��
		if ("0".equals(type)) {
			//������֤����ֻ�
			String random = SendMsgUtil.sendMsg(phone);
			//����֤����ӵ�����
			redisService.addVerifyCode("verifycode:"+phone,random);
			return RbResult.build(100, "success");
		}else if ("1".equals(type)) {
			boolean resultCheck = CheckLoginUtil.checkLogin(request,redisService);
			if (resultCheck == false) {
				return RbResult.build(-200, "����û�е�½�����¼!");
			}
			//�޸����룬����֤�û��Ƿ��ڵ�½״̬
			String userId = request.getHeader("x-key");
			//��֤�ֻ��Ƿ��Ѿ�ע�����
			//������֤����ֻ�
			String random = SendMsgUtil.sendMsg(phone);
			//����֤����ӵ�����
			redisService.addVerifyCode("verifycode:"+userId,random);
			return RbResult.build(100, "success");
		}
		return RbResult.build(-1, "���ִ���������");
	}
	/**
	 * ע��ʵ��
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
		// �ӻ����л�ȡ��֤�룬��֤�û�
		String vfiCode = redisService.getVerifyCode("verifycode:"+rbUser.getPhone());
		if (StringUtils.isBlank(verifycode) || StringUtils.isBlank(vfiCode)) {
			map.put("statusCode",-1);
			map.put("message", "��������֤��");
			return map;
		}
		if (verifycode.equals(vfiCode)) {
			// ����Md5����
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
			map.put("message", "�ֻ���֤���������");
			return map;
		}
	}
	
	/**
	 * �û���½
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
			//��½�ɹ�
			Map<String,Object> user =  (Map<String, Object>) map.get("result");
			String userId = (String) user.get("userId");
			redisService.addLoginToken("token:"+userId,(String)user.get("token"));
			//��½�ɹ�
			return map;
		}else{
			return map;
		}
	}
	/**
	 * ��ȡ�û���Ϣhttp://localhost:8080/getUserInfo.do?userId=152116416588874
	 * @param userId
	 * @param type
	 * @return
	 */
	@RequestMapping("/getUserInfo")
	@ResponseBody
	public RbResult getUserInfo(String userId,String type,HttpServletRequest
			request){
		//��֤�û��Ƿ��½
		boolean result = CheckLoginUtil.checkLogin(request,redisService);
		if (result == false) {
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
		RbUser rbUser = userService.getUserInfo(userId);
		if (rbUser == null) {
			return RbResult.build(-1, "fail");
		} else {
			return RbResult.build(100, "success", rbUser);
		}
	}
	/**
	 * �޸ĸ�����Ϣ
	 * @param user
	 * @return
	 */
	@RequestMapping("/updateMyInfo")
	@ResponseBody
	public RbResult updateMyInfo(RbUser user,HttpServletRequest request){
		//��֤��½̬
		boolean result = CheckLoginUtil.checkLogin(request,redisService);
		if (result == false) {
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
		if (user.getPassword() != null) {
			// �������md5����
			user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		}
		try {
			userService.updateUserInfo(user);
			return RbResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "������Ϣʧ�ܣ�������");
	}
	/**
	 * �����ֻ���
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
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
//		String stuNum=userService.getStuNumById(userId);
		verifyStr = redisService.getVerifyCode("verifycode:"+userId);
		if (verifyStr != null) {
			if (verifyStr.equals(verifycode)) {	
				RbUser rbUser = userService.selectUserById(userId);
				rbUser.setPhone(phone);
				// ��֤�ɹ�,�����ֻ�����
				try {
					userService.updateUserInfo(rbUser);
				} catch (Exception e) {
					e.printStackTrace();
				}
				// ���ظ��ĺ���û�
				RbUser user = userService.selectUserById(userId);
				return RbResult.build(100, "success", user);
			} else {
				return RbResult.build(0, "��֤�����");
			}
		} else {
			return RbResult.build(-1, "����ʧ��,������");
		}
	}
	/**
	 * �鿴�û�ԤԼ
	 * @param userId
	 * @param status 0 ����� | 1 ����ȡ | 2 δͨ��| 3 ����|4 �ѹ黹
	 * @param stu_num ��ʼ��¼��
	 * @param page_size ÿҳ������
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
			map.put("message", "����û�е�½�����¼!");
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
	 * ��ȡ�û����е�ԤԼ
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
			map.put("message", "����û�е�½�����¼!");
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
	 * �鿴�û��������
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
			map.put("message", "����û�е�½�����¼!");
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
	 * ��ȡ�û�����������
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
			map.put("message", "����û�е�½�����¼!");
			return map;
		}
		List<RbPost> list = new ArrayList<RbPost>();
		list = userService.getUserPostsByCondition(userId,rankby,stu_num,page_size);
		return getResultMap(list);
	}
	/**
	 * �û�ԤԼ����
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
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
		String phone = share.getPhone();
		if (phone == null || "".equals(phone)) {
			return RbResult.build(-1, "����д�ֻ���");
		}
		// ��ȡ�û�ѡ������鷽ʽ 0|�������Լ��������� 1|������������
		Integer way = share.getDelieverWay();
		if (way == 0) {
			share.setState(0);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date parse = format.parse(send_time);
			share.setProposedDate(parse);
			int addShare = shareService.addShare(share);
			// ���share ��send_Time��redis������
			redisService.addShareSendTime("share:"+addShare,slotTime);
			// �������Լ����鵽ѧ��
			// SendMsgUtil.sendMsg(share.getPhone(),"sBook"+location);
			return RbResult.ok();
		}else if (way==1) {
			//������������
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
		return RbResult.build(-1, "����ʧ�ܣ�������");
	}
	/**
	 * ȡ�������鼮
	 * @param shareId
	 * @return
	 */
	@RequestMapping("/cancleMyShares")
	@ResponseBody
	public RbResult cancleMyShares(String shareId,HttpServletRequest request){
		String userId = request.getHeader("x-key");
		boolean result = CheckLoginUtil.checkLogin(request,redisService);
		if (result == false) {
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
		try {
			shareService.cancleMyShares(shareId);
			redisService.deleteByKey("timeSlot:"+userId);
			return RbResult.build(102, "���Ѿ�ȡ������");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "����ʧ�ܣ�������");
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
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
		List<RbCarousel> list = carouselService.getCarousel(number);
		return RbResult.ok(list);
	}
	
	/**
	 * ��ҳ���ؽ��
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
	 * �����ǳƺ�ͷ��
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
	 * ��������
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
			return RbResult.build(0, "��֤�����");
		} else if (verifyC.equals(verifycode)) {
			userService.updateUserInfo(rbUser);
			redisService.deleteByKey("passwordVerifycode:"+phone);
			return RbResult.ok();
		}
		return RbResult.build(0, "��֤�����");
	}
	/**
	 * ��ȡ����������֤��
	 * @param phone
	 * @return
	 */
	@RequestMapping("/getResetPassVerifycode")
	@ResponseBody
	public RbResult getResetPassVerifycode(String phone)throws Exception{
		boolean register = userService.checkPhoneRegister(phone);
		if(!register){
			return RbResult.build(0, "���ֻ��Ż�û��ע��");
		}
		//������֤����ֻ�
		String random = SendMsgUtil.sendResetPasswordMsg(phone);
		//����֤����ӵ�����
		redisService.addVerifyCode("passwordVerifycode:"+phone,random);
		return RbResult.ok();
	}
	/**
	 *����id��ȡ��Ϣ��ϸ
	 * @param messageId
	 * @return
	 */
	@RequestMapping("/getMessageDetailById")
	@ResponseBody
	public RbResult getMessageDetailById(String messageId,HttpServletRequest request){
		boolean result = CheckLoginUtil.checkLogin(request,redisService);
		if (result == false) {
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
		RbMessage message = messageService.getMessageDetailById(messageId);
		//������ϢΪ�Ѷ�
		messageService.updateHasRead(messageId);
		return RbResult.ok(message);
	}
	/**
	 * ��ȡ�û���Ϣ
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
			map.put("message", "����û�е�½�����¼!");
			return map;
		}
		List<RbMessage> list = new ArrayList<RbMessage>();
		list = messageService.getUserAllMessage(userId,isRead,start_num,page_size);
		return getResultMap(list);
	}
	// ��������
	
	/**
	 * ����isbn��ȡͼ������
	 * @param isbn
	 * @param request
	 * @return
	 */
	@RequestMapping("/getDetailBookById")
	@ResponseBody
	public RbResult getDetailBookById(String isbn,HttpServletRequest request){
//		boolean result = CheckLoginUtil.checkLogin(request,redisService);
//		if (result == false) {
//			return RbResult.build(-200, "����û�е�½�����¼!");
//		}
		RbBook rbBook = rbBookService.getBookById(isbn);
		return RbResult.ok(rbBook);
	}
	/**
	 * ���ݸ����û�id��ȡ�û����ֻ�����Ϣ
	 * @param userId
	 * @param request
	 * @return
	 */
	@RequestMapping("/getUserPartDetailByUserId")
	@ResponseBody
	public RbResult getUserPartDetailByUserId(String userId,HttpServletRequest request) {
//		boolean result = CheckLoginUtil.checkLogin(request,redisService);
//		if (result == false) {
//			return RbResult.build(-200, "����û�е�½�����¼!");
//		}
		RbUser user = userService.getUserPartDetail(userId);
		return RbResult.ok(user);
	}
	/**
	 * ����isbn��ȡ��������Ϣ
	 */
	@RequestMapping("/getBookInfById")
	@ResponseBody
	public RbResult getBookInfById(String isbn) {
		RbShare share = APIBookUtils.getBookByIsbn(isbn);
		return RbResult.ok(share);
	}
}