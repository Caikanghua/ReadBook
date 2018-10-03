package com.readbook.mapper;

import com.readbook.pojo.RbGoodbook;
import com.readbook.pojo.RbGoodbookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbGoodbookMapper {
    int countByExample(RbGoodbookExample example);

    int deleteByExample(RbGoodbookExample example);

    int deleteByPrimaryKey(Integer goodbookId);

    int insert(RbGoodbook record);

    int insertSelective(RbGoodbook record);

    List<RbGoodbook> selectByExampleWithBLOBs(RbGoodbookExample example);

    List<RbGoodbook> selectByExample(RbGoodbookExample example);

    RbGoodbook selectByPrimaryKey(Integer goodbookId);

    int updateByExampleSelective(@Param("record") RbGoodbook record, @Param("example") RbGoodbookExample example);

    int updateByExampleWithBLOBs(@Param("record") RbGoodbook record, @Param("example") RbGoodbookExample example);

    int updateByExample(@Param("record") RbGoodbook record, @Param("example") RbGoodbookExample example);

    int updateByPrimaryKeySelective(RbGoodbook record);

    int updateByPrimaryKeyWithBLOBs(RbGoodbook record);

    int updateByPrimaryKey(RbGoodbook record);
}