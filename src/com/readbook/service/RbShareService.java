package com.readbook.service;

import java.util.List;

import com.readbook.pagehelper.PageBean;
import com.readbook.pojo.RbBook;
import com.readbook.pojo.RbShare;

public interface RbShareService {

	List<RbShare> getAllShares(String rankby);

	int addShare(RbShare share);

	void cancleMyShares(String shareId);

	RbShare getShareById(String shareId);

	void updateStateToCancle(String shareId);

	void addBookId(String isbn,String shareId);

	String getUserIdByShareId(String shareId);

	void updateStateToPut(String shareId);

//	List<RbShare> getShareByStuNum(String stuNum);

	void updateStateToGetBook(String shareId);


	List<RbShare> getShareByPhone(String phone, int start_num, int page_size);

	List<RbShare> searhUserShareBook(String state, int start_num, int page_size);

	void getShareList(PageBean<RbShare> pageBean, int randby);

}
