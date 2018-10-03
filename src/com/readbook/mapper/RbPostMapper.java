package com.readbook.mapper;

import com.readbook.pojo.CommentMessage;
import com.readbook.pojo.RbPost;
import com.readbook.pojo.RbPostExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbPostMapper {
	List<RbPost> getUserPostsByCondition(String userId,String rankby,
			int stu_num,int page_size);
	 int countByExample(RbPostExample example);

    int deleteByExample(RbPostExample example);

    int deleteByPrimaryKey(String commentId);

    int insert(RbPost record);

    int insertSelective(RbPost record);

    List<RbPost> selectByExampleWithBLOBs(RbPostExample example);

    List<RbPost> selectByExample(RbPostExample example);

    RbPost selectByPrimaryKey(String commentId);

    int updateByExampleSelective(@Param("record") RbPost record, @Param("example") RbPostExample example);

    int updateByExampleWithBLOBs(@Param("record") RbPost record, @Param("example") RbPostExample example);

    int updateByExample(@Param("record") RbPost record, @Param("example") RbPostExample example);

    int updateByPrimaryKeySelective(RbPost record);

    int updateByPrimaryKeyWithBLOBs(RbPost record);

    int updateByPrimaryKey(RbPost record);
    //插入对书评的点赞
	void insertStarToPost(String commentId);
	List<RbPost> getPostsByType(@Param("type")String type, @Param("commentId")String commentId,@Param("start_num")int start_num,@Param("page_size")int page_size);
	
	void incCommentCnt(@Param("commentId")String commentId);
	//获取所有post书评，不包括评论
	List<RbPost> getAllPost(int start_num, int page_size);
	//获取书评的评论
	RbPost getDetailPost(@Param("commentId")String commentId);
	//书评评论减一
	void decCommentCnt(@Param("commentId")String commentId);
	//获取书评所属用户id
	String getPostUserId(@Param("commentId")String commentId);
	List<CommentMessage> getCommentMessage(@Param("userId")String userId, @Param("start_num")int start_num, @Param("page_size")int page_size);
	int getTotalCount();
	// 根据postId获取post,不包括评论
	RbPost getPostById(@Param("commentId")String commentId);
	List<RbPost> getAllPostByBookId(@Param("isbn")String isbn);
}