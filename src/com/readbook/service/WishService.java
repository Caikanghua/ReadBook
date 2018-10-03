package com.readbook.service;

import com.readbook.pagehelper.PageBean;
import com.readbook.pojo.RbWish;

public interface WishService {

	void addWishBook(RbWish wish);

	void getWishList(PageBean<RbWish> pageBean, int type);

	void storage(int wishId);

	String getWishBookName(int wishId);

	void ignore(int wishId);

}
