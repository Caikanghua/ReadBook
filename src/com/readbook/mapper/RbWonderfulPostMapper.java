package com.readbook.mapper;

import com.readbook.pojo.RbWonderfulPost;
import com.readbook.pojo.RbWonderfulPostExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbWonderfulPostMapper {
    int countByExample(RbWonderfulPostExample example);

    int deleteByExample(RbWonderfulPostExample example);

    int deleteByPrimaryKey(Integer wonderfulPostId);

    int insert(RbWonderfulPost record);

    int insertSelective(RbWonderfulPost record);

    List<RbWonderfulPost> selectByExampleWithBLOBs(RbWonderfulPostExample example);

    List<RbWonderfulPost> selectByExample(RbWonderfulPostExample example);

    RbWonderfulPost selectByPrimaryKey(Integer wonderfulPostId);

    int updateByExampleSelective(@Param("record") RbWonderfulPost record, @Param("example") RbWonderfulPostExample example);

    int updateByExampleWithBLOBs(@Param("record") RbWonderfulPost record, @Param("example") RbWonderfulPostExample example);

    int updateByExample(@Param("record") RbWonderfulPost record, @Param("example") RbWonderfulPostExample example);

    int updateByPrimaryKeySelective(RbWonderfulPost record);

    int updateByPrimaryKeyWithBLOBs(RbWonderfulPost record);

    int updateByPrimaryKey(RbWonderfulPost record);

	List<RbWonderfulPost> getWonderfulPost(int start_num, int page_size);

	List<RbWonderfulPost> getWonderfulPostList(int index, int count);

	int getTotalCount();
}