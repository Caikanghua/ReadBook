package com.readbook.service;

import java.util.List;

import com.readbook.pagehelper.PageBean;
import com.readbook.pojo.RbBook;

public interface SeachBookService {
	
	public List<RbBook> searchBookByKey(String key, int start_num, int page_size);

	public List<RbBook> getBooks(int randby, int start_num, int page_size);

	public void getAllBook(PageBean<RbBook> pageBean, int randby);
}
