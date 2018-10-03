package com.readbook.controller.admin;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.readbook.pagehelper.PageBean;
import com.readbook.pojo.Admin;
import com.readbook.pojo.RbBook;
import com.readbook.pojo.RbCarousel;
import com.readbook.pojo.RbFeedback;
import com.readbook.pojo.RbGoodbook;
import com.readbook.pojo.RbPost;
import com.readbook.pojo.RbPush;
import com.readbook.pojo.RbQanda;
import com.readbook.pojo.RbReport;
import com.readbook.pojo.RbReservation;
import com.readbook.pojo.RbShare;
import com.readbook.pojo.RbUserprotocol;
import com.readbook.service.AdminService;
import com.readbook.service.FeedbackService;
import com.readbook.service.PostService;
import com.readbook.service.QAndHelpSerivce;
import com.readbook.service.RbBookService;
import com.readbook.service.RbCarouselService;
import com.readbook.service.RbGoodbookService;
import com.readbook.service.RbMessageService;
import com.readbook.service.RbPushService;
import com.readbook.service.RbReportService;
import com.readbook.service.RbReservationService;
import com.readbook.service.RbShareService;
import com.readbook.service.RbUserProtocolService;
import com.readbook.service.RedisService;
import com.readbook.service.UserService;
import com.readbook.utils.CheckLoginUtil;
import com.readbook.utils.IDUtils;
import com.readbook.utils.RbResult;
import com.readbook.utils.SendMsgUtil;
import com.readbook.utils.StringUtils;
/**
 * ����Ա������
 * @author ckh
 * @date 2018-4-21 ����10:47:41
 */
@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private RbCarouselService rbCarouselService;
	@Autowired
	private RbPushService rbPushService;
	@Autowired
	private RbReservationService rbServationService;
	@Autowired
	private RbShareService rbShareService;
	@Autowired
	private QAndHelpSerivce helpService;
	@Autowired
	private FeedbackService feedbackService;
	@Autowired
	private RbGoodbookService goodBookService;
	@Autowired
	private RbReportService reportService;
	@Autowired
	private PostService postService;
	@Autowired
	private RedisService redisService;
	@Autowired
	private RbBookService rbBookService;
	@Autowired
	private UserService userService;
	@Autowired
	private RbMessageService messageService;
	@Autowired
	private RbReservationService reservationService;
	@Autowired
	private RbUserProtocolService userProtocolService;
	@Value("${LOCATION}")
	private String LOCATION;
	/**
	 * ����Ա��½
	 * @param username
	 * @param password
	 * @param request
	 * @return
	 */
	@RequestMapping("/admin/login")
	@ResponseBody
	public Map<String,Object> adminLogin(String username,String password,
			HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		System.out.println(password);
		password = DigestUtils.md5DigestAsHex(password.getBytes());
		System.out.println(password);
		Map<String, Object> map = adminService.adminLogin(username,password);
		if(map.get("statusCode")=="102"){
			Map<String,Object> user =  (Map<String, Object>) map.get("result");
			String userId = (String) user.get("adminId");
			redisService.addLoginToken("token:"+userId,(String)user.get("token"));
			//��½�ɹ�
			return map;
		}else{
			return map;
		}
	}
	/**
	 * 
	 * �˳���¼
	 * @param request
	 * @return
	 */
	@RequestMapping("/logout")
	@ResponseBody
	public RbResult adminLogout(HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		String keyUser = request.getHeader("x-key");
		String tokenUser = request.getHeader("x-token");
		if(keyUser==null||"".equals(keyUser)){
			return RbResult.ok();
		}else if(tokenUser==null||"".equals(tokenUser)){
			return RbResult.ok();
		}else{
			redisService.deleteLoginToken("token:"+keyUser);
			return RbResult.ok();
		}
	}
	/**
	 * ������ֲ�ͼͼƬ
	 * @param image
	 * @param description
	 * @param request
	 * @return
	 */
	@RequestMapping("/addCarousel")
	@ResponseBody
	public RbResult addCarousel(@RequestParam MultipartFile image,
			String description,String pushUrl,HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
		String path = request.getSession().getServletContext().getRealPath("/upload/image/admin");  
		if(image.isEmpty()){
			return RbResult.build(-1, "��Ϊ�ֲ�ͼ���ͼƬ");
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
        	RbCarousel rbCarousel=new RbCarousel();
        	rbCarousel.setDescription(description);
        	rbCarousel.setPushUrl(pushUrl);
        	rbCarousel.setUrl("/upload/image/admin"+"/"+fileName);
        	rbCarouselService.addRbCarousel(rbCarousel);
			return RbResult.build(102, "����¼");
		} catch (Exception e) {
			e.printStackTrace();
		}
        return RbResult.build(-1, "fail");
	}
	/**
	 * ѡ���ֲ�ͼ
	 * @param carouselsList
	 * @return
	 */
	@RequestMapping("/selectCarousels")
	@ResponseBody
	public RbResult selectCarousels(String[] carouselsList,HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
		try {
			for(int i=0;i<carouselsList.length;i++){
				//���ı�ѡ����ֲ�ͼΪ��ʾ
				rbCarouselService.changeToShow(Integer.parseInt(carouselsList[i]));
			}
			return RbResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "fail");
	}
	/**
	 * ɾ���ֲ�ͼ
	 * @param carouselId
	 * @return
	 */
	@RequestMapping("/deleteCarousel")
	@ResponseBody
	public RbResult deleteCarousel(int carouselId,HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
		try {
			rbCarouselService.deleteCarousel(carouselId);
			return RbResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "����ʧ�ܣ�������");
	}
	/**
	 * ��������
	 * @param title
	 * @param url
	 * @param image
	 * @param request
	 * @return
	 */
	@RequestMapping("/addPush")
	@ResponseBody
	public RbResult addPush(String title,String url,@RequestParam MultipartFile image,
			HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����¼");
		}
		String path = request.getSession().getServletContext().getRealPath("/upload/image/admin");  
		if(image.isEmpty()){
			return RbResult.build(-1, "��Ϊ�������ͼƬ");
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
        	RbPush rbPush=new RbPush();
        	rbPush.setTitle(title);
        	rbPush.setUrl(url);
        	rbPush.setImg("/upload/image/admin"+"/"+fileName);
        	rbPushService.addRbPush(rbPush);
			return RbResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return RbResult.build(-1, "����ʧ�ܣ�������!");
	}
	/**
	 * ɾ��ĳһ������
	 * @param pushId
	 * @return
	 */
	@RequestMapping("/deletePush")
	@ResponseBody
	public RbResult deletePush(int pushId,HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����¼");
		}
		try {
			rbPushService.deletePushById(pushId);
			return RbResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "����û�е�½�����¼");
	}

	/**
	 * ��ҳ��ȡreservation
	 * @param currentPage
	 * @param randby
	 * @param resp
	 * @return
	 */
	@RequestMapping("/getReservationList")
	@ResponseBody
	public RbResult getReservationList(@RequestParam(value="currentPage",defaultValue="1") int currentPage,int randby,HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*");
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
		//���÷�ҳbean
		PageBean<RbReservation> pageBean=new PageBean<RbReservation>();
		pageBean.setCurrentPage(currentPage);
		//����Service
		reservationService.getAllReservation(pageBean,randby);
		return RbResult.ok(pageBean);
	}
	/**
	 * ����û�����
	 * @return
	 */
	@RequestMapping("/check")
	@ResponseBody
	public RbResult checkReservation(String reservationId,String result,
			String reason,HttpServletRequest request,HttpServletResponse resp) throws Exception{
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean isLogin=CheckLoginUtil.checkLogin(request,redisService);
		if(isLogin==false){
			return RbResult.build(-200, "����û�е�½�����¼");
		}
		RbReservation rb = null;
		//���ͨ��������ԤԼ״̬������Ԥ����Ľ�������������֪ͨ�û�
		//��ȡreservation����
		rb=reservationService.getReservationById(reservationId);
		if("0".equals(result)){
			//����״̬Ϊ����ȡ
			rb.setState(1);
			rbServationService.updateSuccessCheckState(rb);
			//��ȡredis�е�slotTimeƬ��
			String slotTime = redisService.getSlotTimeByRId(reservationId);
			// ������֪ͨ�û�
			// ��������:�𾴵��û���ã����ѳɹ�ԤԼxxx��������������ԤԼʱ��xx��xx��xxʱxx�֡�xxʱxx��ǰ��ѧ��xx��ȡ
			SendMsgUtil.sendRvSuccess(rbBookService,LOCATION,rb.getBookId(),rb.getTakenDate(),rb.getPhone(),slotTime);
			redisService.deleteByKey("timeSlot:"+reservationId);
			String userId = rb.getUserId();
			String name = rbBookService.getBookNameById(rb.getBookId());
			// ƽ̨֪ͨ�û�
			messageService.sendCheckSuccessMessage(userId,name);
			return RbResult.ok();
		}else if("1".equals(result)){
			// ���ʧ�ܣ���дԭ��,������֪ͨ�û�
			SendMsgUtil.sendRvFail(reason,rb.getPhone());
			// �������һ
			rbBookService.updateStock(rb.getBookId());
			redisService.deleteByKey("timeSlot:"+reservationId);
			String userId = rb.getUserId();
			String name = rbBookService.getBookNameById(rb.getBookId());
			messageService.sendCheckFailMessage(userId,name);
			rbServationService.updateFailCheckState(rb);
			return RbResult.build(102, "�����ɹ�");
		}
		return RbResult.build(-1, "����ʧ��,������");
	}
	/**
	 * ����û�������
	 * @param shareId
	 * @param result
	 * @param reason
	 * @return
	 */
	@RequestMapping("/checkShares")
	@ResponseBody
	public RbResult checkShares(String shareId,String result,String reason,
			HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result1=CheckLoginUtil.checkLogin(request,redisService);
		if(result1==false){
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
		RbShare share=rbShareService.getShareById(shareId);
		if("0".equals(result)){
			//���ͨ����������֪ͨ
			Integer way = share.getDelieverWay();
			if(way==1){
				//���û�����ȡ����,����Ա��绰���û�Լʱ��ص�����
				String str = "�𾴵��û�,������ġ�"+share.getBookName()+"����˳ɹ�,���ǹ�����Ա��������ϵ��ȡ�顾������ݡ�";
				SendMsgUtil.sendMsg(share.getPhone(),str);
			}else if(way==0){
				//�û����鵽ѧ��
				//��ȡ����ʱ���
				String slotTime=redisService.getSlotTimeBySId(shareId);
				//����ʱ��
				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
				String str = format.format(share.getProposedDate());
//				System.out.println(slotTime +"  location:"+LOCATION);
				String mes = "�𾴵��û������ã���������鼮��"+share.getBookName()+"����˳ɹ�," +
						"����"+str+"�� "+slotTime+"ʱ���ǰ��ѧ��"+LOCATION+"���ڽ��飬лл����ƽ̨��֧��!��������ݡ�";
				//�����Ÿ��û�
				SendMsgUtil.sendMsg(share.getPhone(), mes);
				//ɾ����ԤԼ�������ʱ���
				redisService.deleteByKey("share:"+shareId);
			}
			//�����鱾״̬Ϊ������state=3
			rbShareService.updateStateToGetBook(shareId);
		}else if("1".equals(result)){
			//ԤԼ������ʧ��,���Ͷ���֪ͨ�û�ԭ��
			String str = "���û����ã��ܱ�Ǹ����������ġ�"+share.getBookName()+"���鼮������ƽ̨����¼Ҫ���������д���鼮��Ϣ�������������ʧ�ܡ�������ݡ�";
			SendMsgUtil.sendMsg(share.getPhone(), str);
			//����״̬Ϊ��ȡ��
			rbShareService.updateStateToCancle(shareId);
		}
		return RbResult.ok();
	}
	/**
	 * ���û���ȡ��ԤԼ���飬���¸��û�ԤԼ���״̬Ϊ����ȡ
	 * @param reservationId
	 * @param userId
	 * @param request
	 * @return
	 */
	@RequestMapping("/reservationBookReceive")
	@ResponseBody
	public RbResult reservationBookReceive(String reservationId,String bookId,String userId,
			HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
		try {
			//�����û�ȡ��ʱ��,����״̬Ϊ���黹
			RbReservation rbReservation=new RbReservation();
			rbReservation.setReservationId(reservationId);
			rbReservation.setTakenDate(new Date());
			rbReservation.setState(3);
			rbServationService.updateTDateAndState(rbReservation);
			//���¸���Ľ�����
			rbBookService.updateReadCnt(bookId);
			//�����û������ƽ̨���Ķ�������
			userService.updateReadCnt(userId);
			//ɾ��Ԥ�����ʱ��λ���
			redisService.deleteByKey("timeSlot:"+reservationId);
			return RbResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "����ʧ��");
	}
	/**
	 * �û���ѧ��黹��
	 * @param reservationId
	 * @param bookId
	 * @param userId
	 * @param request
	 * @return
	 */
	@RequestMapping("/reservationBookReturn")
	@ResponseBody
	public RbResult reservationBookReturn(String reservationId,String bookId,String userId,
			HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
		try {
			RbReservation rbReservation=new RbReservation();
			rbReservation.setReservationId(reservationId);
			rbReservation.setReturnDate(new Date());
			rbReservation.setState(5);
			//������״̬����Ϊ�ѹ黹
			rbServationService.updateRDateAndState(rbReservation);
			//���������1
			rbBookService.updateStock(bookId);
			return RbResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "����ʧ�ܣ�������");
	}

	/**
	 * ��ȡ�����飬�����̨ҳ�����
	 * @param currentPage
	 * @param rankby
	 * @param resp
	 * @return
	 */
	@RequestMapping("/getShareList")
	@ResponseBody
	public RbResult getShareList(@RequestParam(defaultValue="1")int currentPage,int rankby,
			HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
		//���÷�ҳbean
		PageBean<RbShare> pageBean=new PageBean<RbShare>();
		pageBean.setCurrentPage(currentPage);
		//����Service
		rbShareService.getShareList(pageBean,rankby);
		return RbResult.ok(pageBean);
	}
	/**
	 * ��ȡ��������������ʴ����ʽ��
	 * @return
	 */
	@RequestMapping("/getHelps")
	@ResponseBody
	public Map<String,Object> getHelps(HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		Map<String,Object> map=new HashMap<String, Object>();
		try {
			List<RbQanda> list=helpService.getHelps();
			map.put("statusCode", 102);
			map.put("message", "success");
			map.put("helps", list);
		} catch (Exception e) {
			map.put("statusCode", -1);
			map.put("message", "fail");
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * ����������
	 * @param question
	 * @param answerhttp://localhost:8080/addHelp.do?question="woshishui"&answer="nishixx"
	 * @return
	 */
	@RequestMapping("/addHelp")
	@ResponseBody
	public RbResult addHelp(String question,String answer,HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
		RbQanda rbQanda=new RbQanda();
		rbQanda.setQuestion(question);
		rbQanda.setAnswer(answer);
		try {
			helpService.addQanda(rbQanda);
			return RbResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "fail");
	}
	/**
	 * ����idɾ��help
	 * @param helpId
	 * @return
	 */
	@RequestMapping("/deleteHelp")
	@ResponseBody
	public RbResult deleteHelp(String helpId,HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
		try {
			helpService.deleteHelpById(helpId);
			return RbResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "ɾ��ʧ��!");
	}
	/**
	 * ��ȡ�����û�����
	 * @return
	 */
	@RequestMapping("/getFeedbacks")
	@ResponseBody
	public Map<String,Object> getFeedbacks(HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		Map<String,Object> map=new HashMap<String, Object>();
		try {
			List<RbFeedback> list=feedbackService.getFeedbacks();
			map.put("statusCode", 102);
			map.put("message", "success");
			map.put("helps", list);
		} catch (Exception e) {
			map.put("statusCode", -1);
			map.put("message", "fail");
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * ��ȡ�����鵥
	 * @return
	 */
	@RequestMapping("/getGoodBooks")
	@ResponseBody
	public Map<String,Object> getGoodBooks(HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		Map<String,Object> map=new HashMap<String, Object>();
		try {
			List<RbGoodbook> list=goodBookService.getGoodBooks();
			map.put("statusCode", 102);
			map.put("message", "success");
			map.put("books", list);
		} catch (Exception e) {
			map.put("statusCode", -1);
			map.put("message", "fail");
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * ���Ӻ���
	 * @param rbGoodbook
	 * @param image
	 * @param request
	 * @return
	 */
	@RequestMapping("/addGoodBook")
	@ResponseBody
	public RbResult addGoodBooks(RbGoodbook rbGoodbook,@RequestParam MultipartFile image,
			HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
		String path = request.getSession().getServletContext().getRealPath("/upload/image/admin");  
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
        	rbGoodbook.setPicture("/upload/image/admin"+"/"+fileName);
        	//�����������
        	rbGoodbook.setDate(new Date());
        	goodBookService.addGoodbook(rbGoodbook);
			return RbResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return RbResult.build(-1, "����ʧ�ܣ�������!");
	}
	/**
	 * ɾ������
	 * @param goodBookId
	 * @return
	 */
	@RequestMapping("/deleteGoodBook")
	@ResponseBody
	public RbResult deleteGoodBook(String goodBookId,HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
		try {
			goodBookService.deleteGoodBookById(goodBookId);
			return RbResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "fail");
	}
	@RequestMapping("/getReports")
	@ResponseBody
	public Map<String,Object> getReports(HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		Map<String,Object> map=new HashMap<String, Object>();
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			map.put("statusCode", -200);
			map.put("message", "����û�е�½�����¼!");
			return map;
		}
		try {
			List<RbReport> list = reportService.getReports();
			map.put("statusCode", 102);
			map.put("message", "success");
			map.put("reports", list);
			return map;
		} catch (Exception e) {
			map.put("statusCode", -1);
			map.put("message", "success");
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * ��ȡ���е�����,С����˵���
	 * @return
	 */
	@RequestMapping("/getAllPosts")
	@ResponseBody
	public Map<String,Object> getAllPosts(int start_num,
			int page_size,String commentId,HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		Map<String,Object> map=new HashMap<String, Object>();
//		boolean result=CheckLoginUtil.checkLogin(request,redisService);
//		if(result==false){
//			map.put("statusCode", -200);
//			map.put("message", "����û�е�½�����¼!");
//			return map;
//		}
		List<RbPost> list=postService.getAllPost(start_num,page_size);
		map.put("statusCode", 102);
		map.put("message", "success");
		map.put("posts", list);
		if(list!=null&&list.size()>0){
			map.put("result_count", list.size());
		}else{
			map.put("result_count", 0);
		}
		return map;
	}
	/**
	 * ��ȡ����������Ա�˵���
	 * @param currentPage
	 * @param resp
	 * @return
	 */
	@RequestMapping("/getPostList")
	@ResponseBody
	public RbResult getPostList(@RequestParam(defaultValue="1")int currentPage,HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*");
//		boolean result=CheckLoginUtil.checkLogin(request,redisService);
//		if(result==false){
//			return RbResult.build(-200, "����û�е�½�����¼!");
//		}
		//���÷�ҳbean
		PageBean<RbPost> pageBean=new PageBean<RbPost>();
		pageBean.setCurrentPage(currentPage);
		//����Service
		postService.getPostList(pageBean);
		return RbResult.ok(pageBean);
	}
	/**
	 * ����commetId��ȡ����
	 * @param commentId
	 * @param request
	 * @return
	 */
	@RequestMapping("/getComments")
	@ResponseBody
	public Map<String,Object> getComments(String commentId,HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		Map<String,Object> map=new HashMap<String, Object>();
//		boolean result=CheckLoginUtil.checkLogin(request,redisService);
//		if(result == false){
//			map.put("statusCode", -200);
//			map.put("message", "����û�е�½�����¼!");
//			return map;
//		}
		RbPost rbPost=postService.getDetailPost(commentId);
		map.put("statusCode", 102);
		map.put("message", "success");
		map.put("post", rbPost);
		return map;
	}
	
	/**
	 * ���ͼ��
	 * @param rbBook
	 * @return
	 */
	@RequestMapping("/addBook")
	@ResponseBody
	public RbResult addBook(RbBook rbBook,@RequestParam MultipartFile image,
			HttpServletRequest request,HttpServletResponse resp)throws Exception{
		resp.setHeader("Access-Control-Allow-Origin","*"); 
		boolean result = CheckLoginUtil.checkLogin(request,redisService);
		if (result == false) {
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
		String isbn = rbBook.getIsbn();
		if(isbn!=null&&!"".equals(isbn)){
			boolean bookExist = rbBookService.checkExistBook(isbn);
			if(bookExist){
				rbBookService.addBookById(isbn);
				return RbResult.ok();
			}
		}
		String path = request.getSession().getServletContext().getRealPath("/upload/image/admin");  
		if(image.isEmpty()){
			return RbResult.build(-1, "�����ͼ��ͼƬ");
		}
        String fileName = image.getOriginalFilename();   
        fileName=IDUtils.genImageName()+fileName.substring(fileName.indexOf('.'));
        File dir = new File(path,fileName);  
        if(!dir.exists()){  
            dir.mkdirs();  
        }
        //MultipartFile�Դ��Ľ�������  
    	image.transferTo(dir);
		//�ϴ��ɹ�����ͼƬ·�����뵽���ݿ���
    	rbBook.setPubDate(new Date());
    	rbBook.setBookImg("/upload/image/admin"+"/"+fileName);
    	rbBookService.addBook(rbBook);
    	return RbResult.ok();
	}
	
	@RequestMapping("/uploadPicutre")
	@ResponseBody
	public RbResult uploadPicture(@RequestParam MultipartFile image,
			HttpServletRequest request,HttpServletResponse resp)throws Exception{
//		resp.setHeader("Access-Control-Allow-Origin","*"); 
//		boolean result = CheckLoginUtil.checkLogin(request,redisService);
//		if (result == false) {
//			return RbResult.build(-200, "����û�е�½�����¼!");
//		}
		String path = "/data";
		if(image.isEmpty()){
			return RbResult.build(-1, "�����ͼ��ͼƬ");
		}
        String fileName = image.getOriginalFilename();   
        fileName=IDUtils.genImageName()+fileName.substring(fileName.indexOf('.'));
        File dir = new File(path,fileName);  
        if(!dir.exists()){  
            dir.mkdirs();  
        }
        //MultipartFile�Դ��Ľ�������  
    	image.transferTo(dir);
		//�ϴ��ɹ�����ͼƬ·�����뵽���ݿ���
//    	rbBook.setPubDate(new Date());
//    	rbBook.setBookImg("/upload/image/admin"+"/"+fileName);
//    	rbBookService.addBook(rbBook);
    	return RbResult.ok();
	}
	/**
	 * �ڲ�ѯ�û���������棬����û�������鵽���
	 * @param rbBook
	 * @param shareId
	 * @param image
	 * @param request
	 * @return
	 */
	@RequestMapping("/addShareBook")
	@ResponseBody
	public RbResult addShareBook(RbBook rbBook,String shareId,@RequestParam MultipartFile image,
			HttpServletRequest request,HttpServletResponse resp)throws Exception{
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
		String path = request.getSession().getServletContext().getRealPath("/upload/image/admin");  
		if (image.isEmpty()) {
			return RbResult.build(0, "�����ͼ��ͼƬ");
		}
        String fileName = image.getOriginalFilename();   
        fileName = IDUtils.genImageName()+fileName.substring(fileName.indexOf('.'));
        File dir = new File(path,fileName);  
        if (!dir.exists()) {  
            dir.mkdirs();  
        }
        //MultipartFile�Դ��Ľ�������  
        try {
        	image.transferTo(dir);
			//�ϴ��ɹ�����ͼƬ·�����뵽���ݿ���
        	rbBook.setPubDate(new Date());
        	rbBook.setBookImg("/upload/image/admin"+"/"+fileName);
        	//���ͼ�鵽�����
    		rbBookService.addShareBook(rbBook);
    		//�����id����������
    		rbShareService.addBookId(rbBook.getIsbn(),shareId);
    		//����shareId��ѯ���û�id
    		String userId=rbShareService.getUserIdByShareId(shareId);
    		//���ķ�����״̬Ϊ�����
    		rbShareService.updateStateToPut(shareId);
    		//���ӷ����û��ڸ�ƽ̨�ķ����鼮����
    		userService.updateShareCntInc(userId);
    		//������Ϣ
			return RbResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "����ͼ��ʧ��");
	}
	
	
	/**
	 * 
	 * @param isbn
	 * @return
	 */
	@RequestMapping("/deleteBook")
	@ResponseBody
	public RbResult deleteBook(String isbn,HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
		//��ѯ����Ŀ�棬���Ϊ0����ʾ����ʧ��
		String stock=rbBookService.selectStockById(isbn);
		if("0".equals(stock)){
			return RbResult.build(0, "ɾ��ͼ��ʧ�ܣ�������Ϊ0");
		}
		try {
			rbBookService.deleteBookById(isbn);
			return RbResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "ɾ��ͼ��ʧ��");
	}
	/**
	 * ����id���ͼ��
	 * @param isbn
	 * @return
	 */
	@RequestMapping("/addBookById")
	@ResponseBody
	public RbResult addBookById(String isbn,HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
		//���������Ƿ������ͬ��ͼ��
		boolean exist=rbBookService.checkExistBook(isbn);
		//��������ڣ����ؽ��
		if(exist==false){
			return RbResult.build(0, "��ͼ����û�У�������������Ϣ���ͼ��");
		}
		try {
			rbBookService.addBookById(isbn);
			return RbResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "����ʧ�ܣ�������");
	}
	/**
	 * �����ֻ��������û�����Ĵ��ڴ�����״̬���鼮
	 * @param stuNum
	 * @return
	 */
	@RequestMapping("/searhShareBookByPhone")
	@ResponseBody
	public RbResult getShareBookByStuNum(String phone,HttpServletRequest request,@RequestParam(defaultValue="0")int start_num,int page_size,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
		try {
			List<RbShare> list=rbShareService.getShareByPhone(phone,start_num,page_size);
			return RbResult.build(102, "success", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RbResult.build(102, "success");
	}
	
	
	/**
	 * �����û�������鼮
	 * @param stuNum
	 * @param state
	 * @return
	 */
	@RequestMapping("/searhUserShareBook")
	@ResponseBody
	public RbResult searhUserShareBook(String state,HttpServletRequest request,int page_size,@RequestParam(defaultValue="0")int start_num,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
		List<RbShare> list=rbShareService.searhUserShareBook(state,start_num,page_size);
		return RbResult.ok(list);
	}
	
	/**
	 * ����/����ĳ���û�
	 * @param userId
	 * @param type 0|����ĳ���û� 1|����ĳ���û�
	 * @return
	 */
	@RequestMapping("/lock")
	@ResponseBody
	public RbResult lock(String userId,String type,HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
		try {
			userService.lock(userId,type);
			return RbResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "fail");
	}
	/**
	 * �����û�Э��
	 */
	@RequestMapping("/addUserProtocol")
	@ResponseBody
	public RbResult addProtocol(String userProtocol,HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
		//ֻ�������һ���û�Э��
		boolean result1 = userProtocolService.checkProtocol();
		if(result1==true){
			//����
			return RbResult.build(-1, "ֻ�����һ���û�Э�飬����Ķ����ݣ����ڸ���ҳ���޸�");
		}
		userProtocolService.addUserProtocol(userProtocol);
		return RbResult.ok();
	}
	/**
	 * �鿴�û�Э��
	 */
	@RequestMapping("/getUserProtocol")
	@ResponseBody
	public RbResult getUserProtocol(HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
		RbUserprotocol protocol=userProtocolService.getProtocol();
		return RbResult.ok(protocol);
	}
	/**
	 * �����û�Э��
	 * @param userProtocol
	 * @return
	 */
	@RequestMapping("/updateUserProtocol")
	@ResponseBody
	public RbResult updateUserProtocol(String userProtocol,HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
		try {
			userProtocolService.updateUserProtocol(userProtocol);
			return RbResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "�����û�Э��ʧ��");
	}
	/**
	 * 
	 * @param admin
	 * @param request
	 * @return
	 */
	@RequestMapping("/addAdmin")
	@ResponseBody
	public RbResult addAdmin(Admin admin,HttpServletRequest request,HttpServletResponse resp) {
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result = CheckLoginUtil.checkLogin(request,redisService);
		if (result == false) {
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
		String password = admin.getPassword();
		// �鿴�ù���Ա�˺��Ƿ��Ѿ���ע��
		admin.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
		boolean exisit = adminService.checkAdmin(admin);
		if (exisit) {
			return RbResult.build(-102,"���˺��Ѿ���ע��");
		}
		admin.setAdminId(IDUtils.getId());
		adminService.addAdmin(admin);
		return RbResult.ok();
	}
	/**
	 * ���¹���Ա����
	 * @param adminId
	 * @param password
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateAdminPassword")
	@ResponseBody
	public RbResult updateAdminPassword(String adminId,String password,HttpServletRequest request,HttpServletResponse resp) {
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result = CheckLoginUtil.checkLogin(request,redisService);
		if (result == false) {
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
		adminService.updateAdminPassword(adminId,DigestUtils.md5DigestAsHex(password.getBytes()));
		return RbResult.ok();
	}
}
