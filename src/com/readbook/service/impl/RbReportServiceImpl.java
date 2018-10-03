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
		//2. ��ѯ�ܼ�¼��;  ���õ�pb������
		int totalCount = this.getTotalCount(isdone);
		pageBean.setTotalCount(totalCount);
		/*
		 * ���⣺ jspҳ�棬�����ǰҳΪ��ҳ���ٵ����һҳ����
		 *              �����ǰҳΪĩҳ���ٵ���һҳ��ʾ�����⣡
		 * �����
		 * 	   1. �����ǰҳ <= 0;       ��ǰҳ���õ�ǰҳΪ1;
		 * 	   2. �����ǰҳ > ���ҳ����  ��ǰҳ����Ϊ���ҳ��
		 */
		// �ж�
		if (pageBean.getCurrentPage() <=0) {
			pageBean.setCurrentPage(1);					    // �ѵ�ǰҳ����Ϊ1
		} else if (pageBean.getCurrentPage() > pageBean.getTotalPage()){
			pageBean.setCurrentPage(pageBean.getTotalPage());		// �ѵ�ǰҳ����Ϊ���ҳ��
		}
		
		//1. ��ȡ��ǰҳ�� �����ѯ����ʼ�С����ص�����
		int currentPage = pageBean.getCurrentPage();
		int index = (currentPage -1 ) * pageBean.getPageCount();// ��ѯ����ʼ��
		int count = pageBean.getPageCount();// ��ѯ���ص�����
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
