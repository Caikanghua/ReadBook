package com.readbook.controller;

import java.util.Date;

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
import com.readbook.service.RbReportService;
import com.readbook.service.RedisService;
import com.readbook.utils.CheckLoginUtil;
import com.readbook.utils.RbResult;

@Controller
public class ReportController {
	@Autowired
	private RedisService redisService;
	@Autowired
	private RbReportService reportService;
	/**
	 * 用户对某书评/评论投诉
	 * @param rbReport
	 * @param request
	 * @return
	 */
	@RequestMapping("/report")
	@ResponseBody
	public RbResult report(RbReport rbReport,HttpServletRequest request){
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "您还没有登陆，请登录!");
		}
		rbReport.setProposedDate(new Date());
		reportService.addReport(rbReport);
		return RbResult.ok();
	}
	/**
	 * 获取举报列表
	 * @param currentPage
	 * @param isdone
	 * @param resp
	 * @return
	 */
	@RequestMapping("/getReportList")
	@ResponseBody
	public RbResult getReportList(@RequestParam(defaultValue="1")int currentPage,int isdone,HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "您还没有登陆，请登录!");
		}
		//设置分页bean
		PageBean<RbReport> pageBean=new PageBean<RbReport>();
		pageBean.setCurrentPage(currentPage);
		//调用Service
		reportService.getAllReport(pageBean,isdone);
		return RbResult.ok(pageBean);
	}
	/**
	 * 忽略举报
	 * @param reportId
	 * @param resp
	 * @return
	 */
	@RequestMapping("/ignoreReport")
	@ResponseBody
	public RbResult ignoreReport(int reportId,HttpServletRequest request,HttpServletResponse resp){
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "您还没有登陆，请登录!");
		}
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		reportService.ignore(reportId);
		return RbResult.ok();
	}
	
}
