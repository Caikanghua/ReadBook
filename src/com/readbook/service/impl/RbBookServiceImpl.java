package com.readbook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.readbook.mapper.RbBookMapper;
import com.readbook.pagehelper.PageBean;
import com.readbook.pojo.RbBook;
import com.readbook.service.RbBookService;
@Service
public class RbBookServiceImpl implements RbBookService {
	@Autowired
	private RbBookMapper rbBookMapper;
	@Override
	public void minusBook(String bookId) {
		rbBookMapper.minusBookById(bookId);
	}
	@Override
	public boolean checkIsStock(String bookId) {
		String stock=rbBookMapper.checkIsStock(bookId);
		if(stock!=null&&"0".equals(stock)){
			return false;
		}
		return true;
	}
	@Override
	public void updateReadCnt(String bookId) {
		rbBookMapper.updateReadCntInc(bookId);
	}
	@Override
	public String getBookNameById(String bookId) {
		String bookName=rbBookMapper.getBookNameById(bookId);
		return bookName;
	}
	@Override
	public void updateStock(String bookId) {
		rbBookMapper.updteStockInc(bookId);
	}
	@Override
	public void addBook(RbBook rbBook) {
		rbBookMapper.insertSelective(rbBook);
	}
	@Override
	public String selectStockById(String isbn) {
		String stock=rbBookMapper.selectStockById(isbn);
		return stock;
	}
	@Override
	public void deleteBookById(String isbn) {
		rbBookMapper.deleteBookById(isbn);
	}
	@Override
	public boolean checkExistBook(String isbn) {
		RbBook book = rbBookMapper.selectByPrimaryKey(isbn);
		if(book!=null){
			return true;
		}
		return false;
	}
	@Override
	public void addBookById(String isbn) {
		rbBookMapper.addBookById(isbn);
	}
	@Override
	public void addShareBook(RbBook rbBook) {
		//查找该书是否在书库中存在
		RbBook check = rbBookMapper.selectByPrimaryKey(rbBook.getIsbn());
		if(check!=null){
			//存在，库存直接自加1
			rbBookMapper.updteStockInc(rbBook.getIsbn());
		}else{
			//不存在，添加完整信息到书库中
			rbBookMapper.insertSelective(rbBook);
		}
	}
	@Override
	public RbBook getBookById(String bookId) {
		RbBook rbBook = rbBookMapper.selectByPrimaryKey(bookId);
		return rbBook;
	}

}
