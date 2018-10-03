package com.readbook.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.readbook.pagehelper.PageBean;
import com.readbook.pojo.RbBook;
import com.readbook.pojo.RbReport;
import com.readbook.service.RedisService;
import com.readbook.service.SeachBookService;
import com.readbook.utils.CheckLoginUtil;
import com.readbook.utils.RbResult;
/**
 * 搜索图书类
 * @author caikanghua
 *
 */
@Controller
public class SeachBookController {
	@Autowired
	private SeachBookService seachBookService;
	@Autowired
	private RedisService redisService;
	/**
	 * 搜索书籍
	 * @param userId
	 * @param key
	 * @param start_num
	 * @param page_size
	 * @return
	 */
	@RequestMapping("/searchBook")
	@ResponseBody
	public Map<String,Object> searchBook(String userId,String key,int start_num,
			int page_size,HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		Map<String,Object> map=new HashMap<String, Object>();
//		boolean result=CheckLoginUtil.checkLogin(request,redisService);
//		if(result==false){
//			map.put("statusCode", -200);
//			map.put("message", "您还没有登陆，请登陆");
//			return map;
//		}
		List<RbBook> list=seachBookService.searchBookByKey(key,start_num,page_size);
		if(list!=null){
			map.put("result_count", list.size());
			map.put("statusCode", 100);
			map.put("message", "success");
			map.put("result", list);
		}else{
			map.put("result_count", 0);
			map.put("statusCode", -1);
			map.put("message", "fail");
		}
		return map;
	}
//	/**
//	 * 管理员搜索图书
//	 * @param key
//	 * @param request
//	 * @param resp
//	 * @return
//	 */
//	@RequestMapping("/searchRbBook")
//	@ResponseBody
//	public RbResult searchRbBook(String key,HttpServletRequest request,HttpServletResponse resp){
//		resp.setHeader("Access-Control-Allow-Origin", "*"); 
//		//设置分页bean
//		PageBean<RbReport> pageBean=new PageBean<RbReport>();
//		pageBean.setCurrentPage(currentPage);
//		//调用Service
//		reportService.getAllReport(pageBean,isdone);
//		return RbResult.ok(pageBean);
//		return null;
//	}
	/**
	 * 获取书籍列表
	 * @param userId
	 * @param randby
	 * @param start_num
	 * @param page_size
	 * @return
	 */
	@RequestMapping("/getBooks")
	@ResponseBody
	public Map<String,Object> getBooks(String userId,int randby,int start_num,
			int page_size,HttpServletResponse resp,HttpServletRequest request){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		Map<String,Object> map=new HashMap<String, Object>();
//		boolean result=CheckLoginUtil.checkLogin(request,redisService);
//		if(result==false){
//			map.put("statusCode", -200);
//			map.put("message", "您还没有登陆，请登陆");
//			return map;
//		}
		List<RbBook> list;
		try {
			list = seachBookService.getBooks(randby,start_num,page_size);
			if(list!=null&&list.size()>0){
				map.put("result_count", list.size());
				map.put("statusCode", 100);
				map.put("result", list);
				map.put("message", "success");
				return map;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("result_count", 0);
		map.put("statusCode", 100);
		map.put("result", 0);
		map.put("message", "success");
		return map;
	}
	/**
	 * 获取书列表
	 * @param currentPage
	 * @param randby
	 * @param resp
	 * @return
	 */
	@RequestMapping("/getBookList")
	@ResponseBody
	public RbResult getAllBooks(HttpServletRequest request,@RequestParam(value="currentPage",defaultValue="1") int currentPage,int randby,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*");
//		boolean result=CheckLoginUtil.checkLogin(request,redisService);
//		if(result==false){
//			return RbResult.build(-200, "您还没有登陆，请登陆");
//		}
		//设置分页bean
		PageBean<RbBook> pageBean=new PageBean<RbBook>();
		pageBean.setCurrentPage(currentPage);
		//调用Service
		seachBookService.getAllBook(pageBean,randby);
		return RbResult.ok(pageBean);
	}
	
}
