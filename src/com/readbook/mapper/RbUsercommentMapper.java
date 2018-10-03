package com.readbook.mapper;

import com.readbook.pojo.RbUsercomment;
import com.readbook.pojo.RbUsercommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbUsercommentMapper {
//	List<RbUsercomment> getCommentsByComment(String u_comment_id);
    int countByExample(RbUsercommentExample example);

    int deleteByExample(RbUsercommentExample example);

    int deleteByPrimaryKey(String uCommentId);

    int insert(RbUsercomment record);

    int insertSelective(RbUsercomment record);

    List<RbUsercomment> selectByExampleWithBLOBs(RbUsercommentExample example);

    List<RbUsercomment> selectByExample(RbUsercommentExample example);

    RbUsercomment selectByPrimaryKey(String uCommentId);

    int updateByExampleSelective(@Param("record") RbUsercomment record, @Param("example") RbUsercommentExample example);

    int updateByExampleWithBLOBs(@Param("record") RbUsercomment record, @Param("example") RbUsercommentExample example);

    int updateByExample(@Param("record") RbUsercomment record, @Param("example") RbUsercommentExample example);

    int updateByPrimaryKeySelective(RbUsercomment record);

    int updateByPrimaryKeyWithBLOBs(RbUsercomment record);

    int updateByPrimaryKey(RbUsercomment record);

	List<RbUsercomment> getBeCommenterIdAndName(String uCommentId);

}