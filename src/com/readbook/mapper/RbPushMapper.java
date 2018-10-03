package com.readbook.mapper;

import com.readbook.pojo.RbPush;
import com.readbook.pojo.RbPushExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbPushMapper {
    int countByExample(RbPushExample example);

    int deleteByExample(RbPushExample example);

    int deleteByPrimaryKey(Integer pushId);

    int insert(RbPush record);

    int insertSelective(RbPush record);

    List<RbPush> selectByExample(RbPushExample example);

    RbPush selectByPrimaryKey(Integer pushId);

    int updateByExampleSelective(@Param("record") RbPush record, @Param("example") RbPushExample example);

    int updateByExample(@Param("record") RbPush record, @Param("example") RbPushExample example);

    int updateByPrimaryKeySelective(RbPush record);

    int updateByPrimaryKey(RbPush record);
}