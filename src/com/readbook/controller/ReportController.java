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
	 * �û���ĳ����/����Ͷ��
	 * @param rbReport
	 * @param request
	 * @return
	 */
	@RequestMapping("/report")
	@ResponseBody
	public RbResult report(RbReport rbReport,HttpServletRequest request){
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
		rbReport.setProposedDate(new Date());
		reportService.addReport(rbReport);
		return RbResult.ok();
	}
	/**
	 * ��ȡ�ٱ��б�
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
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
		//���÷�ҳbean
		PageBean<RbReport> pageBean=new PageBean<RbReport>();
		pageBean.setCurrentPage(currentPage);
		//����Service
		reportService.getAllReport(pageBean,isdone);
		return RbResult.ok(pageBean);
	}
	/**
	 * ���Ծٱ�
	 * @param reportId
	 * @param resp
	 * @return
	 */
	@RequestMapping("/ignoreReport")
	@ResponseBody
	public RbResult ignoreReport(int reportId,HttpServletRequest request,HttpServletResponse resp){
		boolean result=CheckLoginUtil.checkLogin(request,redisService);
		if(result==false){
			return RbResult.build(-200, "����û�е�½�����¼!");
		}
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		reportService.ignore(reportId);
		return RbResult.ok();
	}
	
}
