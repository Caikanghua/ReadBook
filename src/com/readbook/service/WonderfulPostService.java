package com.readbook.service;

import java.util.List;

import com.readbook.pagehelper.PageBean;
import com.readbook.pojo.RbWonderfulPost;

public interface WonderfulPostService {

	void addWonderfulPost(RbWonderfulPost wonderfulPost);

	void deleteWonderfulPost(String wonderfulPostId);

	void updateWonderfulPost(RbWonderfulPost wonderfulPost);

	List<RbWonderfulPost> getWonderfulPost(int start_num, int page_size);

	void getWonderfulPostList(PageBean<RbWonderfulPost> pageBean);

}
