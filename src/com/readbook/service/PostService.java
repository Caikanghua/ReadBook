package com.readbook.service;

import java.util.List;

import com.readbook.pagehelper.PageBean;
import com.readbook.pojo.CommentMessage;
import com.readbook.pojo.RbBook;
import com.readbook.pojo.RbPost;

public interface PostService {

	void addUserPost(RbPost rbPost);

	void starToPost(String commentId);

	void comment(String userId, String content, String commentId);

	void commentToComment(String userId, String content, String commentId,
			String uCommentId);
	List<RbPost> getAllPost(int start_num, int page_size);

	RbPost getDetailPost(String commentId);

	void deleteCommentsById(String uCommentId, String commentId, String type);

	List<CommentMessage> getCommentMessage(String userId, int start_num, int page_size);

	boolean checkAgainStar(String userId, String commentId);

	void addUserStar(String userId, String commentId);

	void getPostList(PageBean<RbPost> pageBean);

	List<RbPost> getPostListByBookId(String isbn);

	RbPost getPostById(String commentId);
}
