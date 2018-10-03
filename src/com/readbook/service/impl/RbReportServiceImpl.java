package com.readbook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.readbook.mapper.RbReportMapper;
import com.readbook.pagehelper.PageBean;
import com.readbook.pojo.RbBook;
import com.readbook.pojo.RbReport;
import com.readbook.pojo.RbReportExample;
import com.readbook.service.RbReportService;
@Service
public class RbReportServiceImpl implements RbReportService {
	@Autowired
	private RbReportMapper reportMapper;
	@Override
	public List<RbReport> getReports() {
		RbReportExample example=new RbReportExample();
		List<RbReport> list = reportMapper.selectByExampleWithBLOBs(example);
		return list;
	}
	@Override
	public void addReport(RbReport rbReport) {
		reportMapper.insertSelective(rbReport);
	}
	@Override
	public void getAllReport(PageBean<RbReport> pageBean, int isdone) {
		//2. 查询总记录数;  设置到pb对象中
		int totalCount = this.getTotalCount(isdone);
		pageBean.setTotalCount(totalCount);
		/*
		 * 问题： jsp页面，如果当前页为首页，再点击上一页报错！
		 *              如果当前页为末页，再点下一页显示有问题！
		 * 解决：
		 * 	   1. 如果当前页 <= 0;       当前页设置当前页为1;
		 * 	   2. 如果当前页 > 最大页数；  当前页设置为最大页数
		 */
		// 判断
		if (pageBean.getCurrentPage() <=0) {
			pageBean.setCurrentPage(1);					    // 把当前页设置为1
		} else if (pageBean.getCurrentPage() > pageBean.getTotalPage()){
			pageBean.setCurrentPage(pageBean.getTotalPage());		// 把当前页设置为最大页数
		}
		
		//1. 获取当前页： 计算查询的起始行、返回的行数
		int currentPage = pageBean.getCurrentPage();
		int index = (currentPage -1 ) * pageBean.getPageCount();// 查询的起始行
		int count = pageBean.getPageCount();// 查询返回的行数
//		System.out.println("currentPage:"+currentPage);
//		System.out.println("index:"+index);
//		System.out.println("count:"+count);
		List<RbReport> reportList=reportMapper.getReportsByCondition(isdone, index, count);
		pageBean.setPageData(reportList);	
	}
	private int getTotalCount(int isdone) {
		int result = reportMapper.getTotalCount(isdone);
		return result;
	}
	@Override
	public void ignore(int reportId) {
		RbReport report = new RbReport();
		report.setReportId(reportId);
		report.setIsdone(true);
		reportMapper.updateByPrimaryKeySelective(report);
	}

}
