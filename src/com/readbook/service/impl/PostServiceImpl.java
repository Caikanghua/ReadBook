package com.readbook.service.impl;
import java.util.Date;
import java.util.List;

import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.readbook.mapper.RbPostMapper;
import com.readbook.mapper.RbUserMapper;
import com.readbook.mapper.RbUsercommentMapper;
import com.readbook.pagehelper.PageBean;
import com.readbook.pojo.CommentMessage;
import com.readbook.pojo.RbBook;
import com.readbook.pojo.RbPost;
import com.readbook.pojo.RbPostExample;
import com.readbook.pojo.RbUser;
import com.readbook.pojo.RbUserStar;
import com.readbook.pojo.RbUsercomment;
import com.readbook.pojo.RbUsercommentExample;
import com.readbook.pojo.RbUsercommentExample.Criteria;
import com.readbook.service.PostService;
import com.readbook.utils.IDUtils;
@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private RbPostMapper rbPostMapper;
	@Autowired
	private RbUserMapper rbUserMapper;
	@Autowired
	private RbUsercommentMapper rbUserCommentMapper;
	@Override
	public void addUserPost(RbPost rbPost) {
//		rbPost.setStars(0);
		rbPostMapper.insertSelective(rbPost);
	}
	@Override
	public void starToPost(String commentId) {
		rbPostMapper.insertStarToPost(commentId);
	}
	@Override
	public void comment(String userId, String content, String commentId) {
		RbUsercomment userComment=new RbUsercomment();
		userComment.setTime(new Date());
		List<RbUser> list=rbUserMapper.getIdAndName(userId);
		String  atUserId=rbPostMapper.getPostUserId(commentId);
		RbUser user=list.get(0);
		userComment.setCommentType(0);
		userComment.setFromId(user.getUserId());
		userComment.setAtId(atUserId);
		userComment.setFromName(user.getNickName());
		userComment.setToCommentId(commentId);
		//����������id
		userComment.setCommentId(commentId);
		userComment.setUcontent(content);
		String mCommentId = IDUtils.getId();
		userComment.setuCommentId(mCommentId);
	    rbUserCommentMapper.insert(userComment);
//		//������id�Ͷ�����������id���뵽�м��
//	    PostMiddleCommentKey key=new PostMiddleCommentKey();
//	    key.setmCommentId(mCommentId);
//	    key.setmPostId(commentId);
//	    postMiddleCommentMapper.insert(key);
	    //������������
	    rbPostMapper.incCommentCnt(commentId);
	}
	@Override
	public void commentToComment(String userId, String content,
			String commentId, String uCommentId) {
		RbUsercomment userComment=new RbUsercomment();
		userComment.setTime(new Date());
		List<RbUser> list=rbUserMapper.getIdAndName(userId);
		RbUser user=list.get(0);
		userComment.setFromId(user.getUserId());
		//���ø�����������������
		userComment.setCommentId(commentId);
		userComment.setCommentType(1);
		userComment.setFromName(user.getNickName());
		userComment.setUcontent(content);
		userComment.setuCommentId(IDUtils.getId());
		userComment.setToCommentId(uCommentId);
		List<RbUsercomment> cList=rbUserCommentMapper.getBeCommenterIdAndName(uCommentId);
		userComment.setAtId(cList.get(0).getFromId());
		userComment.setAtName(cList.get(0).getFromName());
		rbUserCommentMapper.insert(userComment);
	}
	@Override
	public List<RbPost> getAllPost(int start_num, int page_size) {
		List<RbPost> list=rbPostMapper.getAllPost(start_num,page_size);
		return list;
	}
	@Override
	public RbPost getDetailPost(String commentId) {
		RbPost post=rbPostMapper.getDetailPost(commentId);
//		post=getAllCommentsByPost(post);
		return post;
	}
	/**
	 * ��ȡ������������������
	 * @param post
	 * @return
	 */
	@Override
	public void deleteCommentsById(String uCommentId, String commentId,String type) {
		if("0".equals(type)){
			RbUsercommentExample example=new RbUsercommentExample();
			Criteria criteria = example.createCriteria();
			criteria.andCommentIdEqualTo(commentId);
			rbUserCommentMapper.deleteByExample(example);
			rbPostMapper.deleteByPrimaryKey(commentId);
		}else if("1".equals(type)) {
			RbUsercomment comment = rbUserCommentMapper.selectByPrimaryKey(uCommentId);
			if (comment == null) {
				return;
			}
			RbUsercommentExample example=new RbUsercommentExample();
			Criteria criteria = example.createCriteria();
			criteria.andToCommentIdEqualTo(uCommentId);
			rbUserCommentMapper.deleteByExample(example);
			String comment_id = comment.getCommentId();
			String to_comment_id = comment.getToCommentId();
			if (comment_id.equals(to_comment_id)) {
				// Ϊ���ۣ��������ۼ�һ
				rbPostMapper.decCommentCnt(comment_id);
			}
			rbUserCommentMapper.deleteByPrimaryKey(uCommentId);
		}
		
	}
	@Override
	public List<CommentMessage> getCommentMessage(String userId,int start_num,int page_size) {
		List<CommentMessage> list=rbPostMapper.getCommentMessage(userId,start_num,page_size);
		return list;
	}
	@Override
	public boolean checkAgainStar(String userId,String commentId) {
		List<RbUserStar> list = rbUserMapper.checkAgainStar(userId,commentId);
		if(list!=null&&list.size()>0){
			return true;
		}
		return false;
	}
	@Override
	public void addUserStar(String userId, String commentId) {
		rbUserMapper.addUserStar(userId,commentId);
	}
	@Override
	public void getPostList(PageBean<RbPost> pageBean) {
		//2. ��ѯ�ܼ�¼��;  ���õ�pb������
		int totalCount = this.getTotalCount();
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
		List<RbPost> allPost = rbPostMapper.getAllPost(index, count);
		pageBean.setPageData(allPost);	
	}
	private int getTotalCount() {
		int count=rbPostMapper.getTotalCount();
		return count;
	}
	@Override
	public List<RbPost> getPostListByBookId(String isbn) {
//		RbPostExample example = new RbPostExample();
//		com.readbook.pojo.RbPostExample.Criteria criteria = example.createCriteria();
//		criteria.andBookIdEqualTo(isbn);
		List<RbPost> postList = rbPostMapper.getAllPostByBookId(isbn);
		return postList;
	}
	@Override
	public RbPost getPostById(String commentId) {
		RbPost post = rbPostMapper.getPostById(commentId);
		return post;
	}
}
