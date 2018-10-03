package com.readbook.service;

import java.util.List;

import com.readbook.pojo.RbGoodbook;

public interface RbGoodbookService {

	List<RbGoodbook> getGoodBooks();

	void addGoodbook(RbGoodbook rbGoodbook);

	void deleteGoodBookById(String goodBookId);

}
