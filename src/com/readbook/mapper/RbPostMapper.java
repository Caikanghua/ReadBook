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
    //����������ĵ���
	void insertStarToPost(String commentId);
	List<RbPost> getPostsByType(@Param("type")String type, @Param("commentId")String commentId,@Param("start_num")int start_num,@Param("page_size")int page_size);
	
	void incCommentCnt(@Param("commentId")String commentId);
	//��ȡ����post����������������
	List<RbPost> getAllPost(int start_num, int page_size);
	//��ȡ����������
	RbPost getDetailPost(@Param("commentId")String commentId);
	//�������ۼ�һ
	void decCommentCnt(@Param("commentId")String commentId);
	//��ȡ���������û�id
	String getPostUserId(@Param("commentId")String commentId);
	List<CommentMessage> getCommentMessage(@Param("userId")String userId, @Param("start_num")int start_num, @Param("page_size")int page_size);
	int getTotalCount();
	// ����postId��ȡpost,����������
	RbPost getPostById(@Param("commentId")String commentId);
	List<RbPost> getAllPostByBookId(@Param("isbn")String isbn);
}