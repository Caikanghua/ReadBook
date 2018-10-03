package com.readbook.service;

import com.readbook.pagehelper.PageBean;
import com.readbook.pojo.RbBook;

public interface RbBookService {

	void minusBook(String bookId);

	boolean checkIsStock(String bookId);

	void updateReadCnt(String bookId);

	String getBookNameById(String bookId);

	void updateStock(String bookId);

	void addBook(RbBook rbBook);

	String selectStockById(String isbn);

	void deleteBookById(String isbn);

	boolean checkExistBook(String isbn);

	void addBookById(String isbn);

	void addShareBook(RbBook rbBook);

	RbBook getBookById(String bookId);


}
