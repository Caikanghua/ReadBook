package com.readbook.service;

import java.util.List;

import com.readbook.pagehelper.PageBean;
import com.readbook.pojo.RbReport;

public interface RbReportService {

	List<RbReport> getReports();

	void addReport(RbReport rbReport);

	void getAllReport(PageBean<RbReport> pageBean, int isdone);

	void ignore(int reportId);

}
