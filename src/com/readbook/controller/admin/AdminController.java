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
 * 管理员控制类
 * @author ckh
 * @date 2018-4-21 上午10:47:41
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
	 * 管理员登陆
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
			//登陆成功
			return map;
		}else{
			return map;
		}
	}
	/**
	 * 
	 * 退出登录
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
	 * 添加新轮播图图片
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
			return RbResult.build(-200, "您还没有登陆，请登录!");
		}
		String path = request.getSession().getServletContext().getRealPath("/upload/image/admin");  
		if(image.isEmpty()){
			return RbResult.build(-1, "请为轮播图添加图片");
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
        	RbCarousel rbCarousel=new RbCarousel();
        	rbCarousel.setDescription(description);
        	rbCarousel.setPushUrl(pushUrl);
        	rbCarousel.setUrl("/upload/image/admin"+"/"+fileName);
        	rbCarouselService.addRbCarousel(rbCarousel);
			return RbResult.build(102, "已收录");
		} catch (Exception e) {
			e.printStackTrace();
		}
        return RbResult.build(-1, "fail");
	}
	/**
	 * 选择轮播图
	 * @param carouselsList
	 * @return
	 */
	@RequestMapping("/selectCarousels")
	@ResponseBody
	public RbResult selectCarousels(String[] carouselsList,HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "您还没有登陆，请登录!");
		}
		try {
			for(int i=0;i<carouselsList.length;i++){
				//更改被选择的轮播图为显示
				rbCarouselService.changeToShow(Integer.parseInt(carouselsList[i]));
			}
			return RbResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "fail");
	}
	/**
	 * 删除轮播图
	 * @param carouselId
	 * @return
	 */
	@RequestMapping("/deleteCarousel")
	@ResponseBody
	public RbResult deleteCarousel(int carouselId,HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "您还没有登陆，请登录!");
		}
		try {
			rbCarouselService.deleteCarousel(carouselId);
			return RbResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "操作失败，请重试");
	}
	/**
	 * 增加推送
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
			return RbResult.build(-200, "您还没有登陆，请登录");
		}
		String path = request.getSession().getServletContext().getRealPath("/upload/image/admin");  
		if(image.isEmpty()){
			return RbResult.build(-1, "请为推送添加图片");
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
        	RbPush rbPush=new RbPush();
        	rbPush.setTitle(title);
        	rbPush.setUrl(url);
        	rbPush.setImg("/upload/image/admin"+"/"+fileName);
        	rbPushService.addRbPush(rbPush);
			return RbResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return RbResult.build(-1, "操作失败，请重试!");
	}
	/**
	 * 删除某一条推送
	 * @param pushId
	 * @return
	 */
	@RequestMapping("/deletePush")
	@ResponseBody
	public RbResult deletePush(int pushId,HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "您还没有登陆，请登录");
		}
		try {
			rbPushService.deletePushById(pushId);
			return RbResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "您还没有登陆，请登录");
	}

	/**
	 * 分页获取reservation
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
			return RbResult.build(-200, "您还没有登陆，请登录!");
		}
		//设置分页bean
		PageBean<RbReservation> pageBean=new PageBean<RbReservation>();
		pageBean.setCurrentPage(currentPage);
		//调用Service
		reservationService.getAllReservation(pageBean,randby);
		return RbResult.ok(pageBean);
	}
	/**
	 * 审核用户借书
	 * @return
	 */
	@RequestMapping("/check")
	@ResponseBody
	public RbResult checkReservation(String reservationId,String result,
			String reason,HttpServletRequest request,HttpServletResponse resp) throws Exception{
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean isLogin=CheckLoginUtil.checkLogin(request,redisService);
		if(isLogin==false){
			return RbResult.build(-200, "您还没有登陆，请登录");
		}
		RbReservation rb = null;
		//审核通过，更新预约状态，更新预定书的借阅量，发短信通知用户
		//获取reservation对象
		rb=reservationService.getReservationById(reservationId);
		if("0".equals(result)){
			//更新状态为待领取
			rb.setState(1);
			rbServationService.updateSuccessCheckState(rb);
			//获取redis中的slotTime片段
			String slotTime = redisService.getSlotTimeByRId(reservationId);
			// 发短信通知用户
			// 短信内容:尊敬的用户你好，你已成功预约xxx（书名），请于预约时间xx月xx日xx时xx分—xx时xx分前往学活xx领取
			SendMsgUtil.sendRvSuccess(rbBookService,LOCATION,rb.getBookId(),rb.getTakenDate(),rb.getPhone(),slotTime);
			redisService.deleteByKey("timeSlot:"+reservationId);
			String userId = rb.getUserId();
			String name = rbBookService.getBookNameById(rb.getBookId());
			// 平台通知用户
			messageService.sendCheckSuccessMessage(userId,name);
			return RbResult.ok();
		}else if("1".equals(result)){
			// 审核失败，填写原因,发短信通知用户
			SendMsgUtil.sendRvFail(reason,rb.getPhone());
			// 该书库存加一
			rbBookService.updateStock(rb.getBookId());
			redisService.deleteByKey("timeSlot:"+reservationId);
			String userId = rb.getUserId();
			String name = rbBookService.getBookNameById(rb.getBookId());
			messageService.sendCheckFailMessage(userId,name);
			rbServationService.updateFailCheckState(rb);
			return RbResult.build(102, "操作成功");
		}
		return RbResult.build(-1, "操作失败,请重试");
	}
	/**
	 * 审核用户分享书
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
			return RbResult.build(-200, "您还没有登陆，请登录!");
		}
		RbShare share=rbShareService.getShareById(shareId);
		if("0".equals(result)){
			//审核通过，发短信通知
			Integer way = share.getDelieverWay();
			if(way==1){
				//上用户门领取方法,管理员打电话与用户约时间地点拿书
				String str = "尊敬的用户,您分享的《"+share.getBookName()+"》审核成功,我们工作人员将尽快联系您取书【深大书屋】";
				SendMsgUtil.sendMsg(share.getPhone(),str);
			}else if(way==0){
				//用户拿书到学活
				//获取交书时间段
				String slotTime=redisService.getSlotTimeBySId(shareId);
				//解析时间
				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
				String str = format.format(share.getProposedDate());
//				System.out.println(slotTime +"  location:"+LOCATION);
				String mes = "尊敬的用户，您好，您分享的书籍《"+share.getBookName()+"》审核成功," +
						"请在"+str+"日 "+slotTime+"时间段前往学活"+LOCATION+"窗口交书，谢谢您对平台的支持!【深大书屋】";
				//发短信给用户
				SendMsgUtil.sendMsg(share.getPhone(), mes);
				//删除掉预约分享书的时间段
				redisService.deleteByKey("share:"+shareId);
			}
			//更新书本状态为待交书state=3
			rbShareService.updateStateToGetBook(shareId);
		}else if("1".equals(result)){
			//预约分享书失败,发送短信通知用户原因
			String str = "尊敬用户您好，很抱歉，您所分享的《"+share.getBookName()+"》书籍不符合平台的收录要求或者您填写的书籍信息不完整导致审核失败【深大书屋】";
			SendMsgUtil.sendMsg(share.getPhone(), str);
			//更新状态为已取消
			rbShareService.updateStateToCancle(shareId);
		}
		return RbResult.ok();
	}
	/**
	 * 当用户领取到预约的书，更新该用户预约书的状态为已领取
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
			return RbResult.build(-200, "您还没有登陆，请登录!");
		}
		try {
			//更新用户取书时间,更新状态为待归还
			RbReservation rbReservation=new RbReservation();
			rbReservation.setReservationId(reservationId);
			rbReservation.setTakenDate(new Date());
			rbReservation.setState(3);
			rbServationService.updateTDateAndState(rbReservation);
			//更新该书的借阅量
			rbBookService.updateReadCnt(bookId);
			//更新用户在这个平台的阅读书数量
			userService.updateReadCnt(userId);
			//删除预定书的时间段缓存
			redisService.deleteByKey("timeSlot:"+reservationId);
			return RbResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "操作失败");
	}
	/**
	 * 用户到学活归还书
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
			return RbResult.build(-200, "您还没有登陆，请登录!");
		}
		try {
			RbReservation rbReservation=new RbReservation();
			rbReservation.setReservationId(reservationId);
			rbReservation.setReturnDate(new Date());
			rbReservation.setState(5);
			//将该书状态更改为已归还
			rbServationService.updateRDateAndState(rbReservation);
			//将该书库存加1
			rbBookService.updateStock(bookId);
			return RbResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "操作失败，请重试");
	}

	/**
	 * 获取分享书，管理后台页面调用
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
			return RbResult.build(-200, "您还没有登陆，请登录!");
		}
		//设置分页bean
		PageBean<RbShare> pageBean=new PageBean<RbShare>();
		pageBean.setCurrentPage(currentPage);
		//调用Service
		rbShareService.getShareList(pageBean,rankby);
		return RbResult.ok(pageBean);
	}
	/**
	 * 获取帮助项（帮助项是问答的形式）
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
	 * 新增帮助项
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
			return RbResult.build(-200, "您还没有登陆，请登录!");
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
	 * 根据id删除help
	 * @param helpId
	 * @return
	 */
	@RequestMapping("/deleteHelp")
	@ResponseBody
	public RbResult deleteHelp(String helpId,HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "您还没有登陆，请登录!");
		}
		try {
			helpService.deleteHelpById(helpId);
			return RbResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "删除失败!");
	}
	/**
	 * 获取所有用户反馈
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
	 * 获取好书书单
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
	 * 增加好书
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
			return RbResult.build(-200, "您还没有登陆，请登录!");
		}
		String path = request.getSession().getServletContext().getRealPath("/upload/image/admin");  
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
        	rbGoodbook.setPicture("/upload/image/admin"+"/"+fileName);
        	//增加添加日期
        	rbGoodbook.setDate(new Date());
        	goodBookService.addGoodbook(rbGoodbook);
			return RbResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return RbResult.build(-1, "操作失败，请重试!");
	}
	/**
	 * 删除好书
	 * @param goodBookId
	 * @return
	 */
	@RequestMapping("/deleteGoodBook")
	@ResponseBody
	public RbResult deleteGoodBook(String goodBookId,HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "您还没有登陆，请登录!");
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
			map.put("message", "您还没有登陆，请登录!");
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
	 * 获取所有的书评,小程序端调用
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
//			map.put("message", "您还没有登陆，请登录!");
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
	 * 获取书评，管理员端调用
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
//			return RbResult.build(-200, "您还没有登陆，请登录!");
//		}
		//设置分页bean
		PageBean<RbPost> pageBean=new PageBean<RbPost>();
		pageBean.setCurrentPage(currentPage);
		//调用Service
		postService.getPostList(pageBean);
		return RbResult.ok(pageBean);
	}
	/**
	 * 根据commetId获取评论
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
//			map.put("message", "您还没有登陆，请登录!");
//			return map;
//		}
		RbPost rbPost=postService.getDetailPost(commentId);
		map.put("statusCode", 102);
		map.put("message", "success");
		map.put("post", rbPost);
		return map;
	}
	
	/**
	 * 添加图书
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
			return RbResult.build(-200, "您还没有登陆，请登录!");
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
			return RbResult.build(-1, "请添加图书图片");
		}
        String fileName = image.getOriginalFilename();   
        fileName=IDUtils.genImageName()+fileName.substring(fileName.indexOf('.'));
        File dir = new File(path,fileName);  
        if(!dir.exists()){  
            dir.mkdirs();  
        }
        //MultipartFile自带的解析方法  
    	image.transferTo(dir);
		//上传成功，将图片路径插入到数据库中
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
//			return RbResult.build(-200, "您还没有登陆，请登录!");
//		}
		String path = "/data";
		if(image.isEmpty()){
			return RbResult.build(-1, "请添加图书图片");
		}
        String fileName = image.getOriginalFilename();   
        fileName=IDUtils.genImageName()+fileName.substring(fileName.indexOf('.'));
        File dir = new File(path,fileName);  
        if(!dir.exists()){  
            dir.mkdirs();  
        }
        //MultipartFile自带的解析方法  
    	image.transferTo(dir);
		//上传成功，将图片路径插入到数据库中
//    	rbBook.setPubDate(new Date());
//    	rbBook.setBookImg("/upload/image/admin"+"/"+fileName);
//    	rbBookService.addBook(rbBook);
    	return RbResult.ok();
	}
	/**
	 * 在查询用户分享书界面，添加用户分享的书到书库
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
			return RbResult.build(-200, "您还没有登陆，请登录!");
		}
		String path = request.getSession().getServletContext().getRealPath("/upload/image/admin");  
		if (image.isEmpty()) {
			return RbResult.build(0, "请添加图书图片");
		}
        String fileName = image.getOriginalFilename();   
        fileName = IDUtils.genImageName()+fileName.substring(fileName.indexOf('.'));
        File dir = new File(path,fileName);  
        if (!dir.exists()) {  
            dir.mkdirs();  
        }
        //MultipartFile自带的解析方法  
        try {
        	image.transferTo(dir);
			//上传成功，将图片路径插入到数据库中
        	rbBook.setPubDate(new Date());
        	rbBook.setBookImg("/upload/image/admin"+"/"+fileName);
        	//添加图书到库存中
    		rbBookService.addShareBook(rbBook);
    		//添加书id到分享书中
    		rbShareService.addBookId(rbBook.getIsbn(),shareId);
    		//根据shareId查询出用户id
    		String userId=rbShareService.getUserIdByShareId(shareId);
    		//更改分享书状态为已入库
    		rbShareService.updateStateToPut(shareId);
    		//增加分享用户在该平台的分享书籍数量
    		userService.updateShareCntInc(userId);
    		//返回信息
			return RbResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "增加图书失败");
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
			return RbResult.build(-200, "您还没有登陆，请登录!");
		}
		//查询该书的库存，如果为0，提示操作失败
		String stock=rbBookService.selectStockById(isbn);
		if("0".equals(stock)){
			return RbResult.build(0, "删除图书失败，该书库存为0");
		}
		try {
			rbBookService.deleteBookById(isbn);
			return RbResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "删除图书失败");
	}
	/**
	 * 根据id添加图书
	 * @param isbn
	 * @return
	 */
	@RequestMapping("/addBookById")
	@ResponseBody
	public RbResult addBookById(String isbn,HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "您还没有登陆，请登录!");
		}
		//检测书库中是否存在相同的图书
		boolean exist=rbBookService.checkExistBook(isbn);
		//如果不存在，返回结果
		if(exist==false){
			return RbResult.build(0, "该图书库存没有，请输入完整信息添加图书");
		}
		try {
			rbBookService.addBookById(isbn);
			return RbResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "操作失败，请重试");
	}
	/**
	 * 根据手机号搜素用户分享的处在待交书状态的书籍
	 * @param stuNum
	 * @return
	 */
	@RequestMapping("/searhShareBookByPhone")
	@ResponseBody
	public RbResult getShareBookByStuNum(String phone,HttpServletRequest request,@RequestParam(defaultValue="0")int start_num,int page_size,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "您还没有登陆，请登录!");
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
	 * 搜索用户分享的书籍
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
			return RbResult.build(-200, "您还没有登陆，请登录!");
		}
		List<RbShare> list=rbShareService.searhUserShareBook(state,start_num,page_size);
		return RbResult.ok(list);
	}
	
	/**
	 * 锁定/解锁某个用户
	 * @param userId
	 * @param type 0|锁定某个用户 1|解锁某个用户
	 * @return
	 */
	@RequestMapping("/lock")
	@ResponseBody
	public RbResult lock(String userId,String type,HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "您还没有登陆，请登录!");
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
	 * 增加用户协议
	 */
	@RequestMapping("/addUserProtocol")
	@ResponseBody
	public RbResult addProtocol(String userProtocol,HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "您还没有登陆，请登录!");
		}
		//只允许添加一个用户协议
		boolean result1 = userProtocolService.checkProtocol();
		if(result1==true){
			//存在
			return RbResult.build(-1, "只能添加一个用户协议，如需改动内容，请在更新页面修改");
		}
		userProtocolService.addUserProtocol(userProtocol);
		return RbResult.ok();
	}
	/**
	 * 查看用户协议
	 */
	@RequestMapping("/getUserProtocol")
	@ResponseBody
	public RbResult getUserProtocol(HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "您还没有登陆，请登录!");
		}
		RbUserprotocol protocol=userProtocolService.getProtocol();
		return RbResult.ok(protocol);
	}
	/**
	 * 更新用户协议
	 * @param userProtocol
	 * @return
	 */
	@RequestMapping("/updateUserProtocol")
	@ResponseBody
	public RbResult updateUserProtocol(String userProtocol,HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "您还没有登陆，请登录!");
		}
		try {
			userProtocolService.updateUserProtocol(userProtocol);
			return RbResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RbResult.build(-1, "更新用户协议失败");
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
			return RbResult.build(-200, "您还没有登陆，请登录!");
		}
		String password = admin.getPassword();
		// 查看该管理员账号是否已经被注册
		admin.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
		boolean exisit = adminService.checkAdmin(admin);
		if (exisit) {
			return RbResult.build(-102,"该账号已经被注册");
		}
		admin.setAdminId(IDUtils.getId());
		adminService.addAdmin(admin);
		return RbResult.ok();
	}
	/**
	 * 更新管理员密码
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
			return RbResult.build(-200, "您还没有登陆，请登录!");
		}
		adminService.updateAdminPassword(adminId,DigestUtils.md5DigestAsHex(password.getBytes()));
		return RbResult.ok();
	}
}
