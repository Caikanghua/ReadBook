package com.readbook.mapper;

import com.readbook.pojo.RbUserprotocol;
import com.readbook.pojo.RbUserprotocolExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbUserprotocolMapper {
    int countByExample(RbUserprotocolExample example);

    int deleteByExample(RbUserprotocolExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RbUserprotocol record);

    int insertSelective(RbUserprotocol record);

    List<RbUserprotocol> selectByExampleWithBLOBs(RbUserprotocolExample example);

    List<RbUserprotocol> selectByExample(RbUserprotocolExample example);

    RbUserprotocol selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RbUserprotocol record, @Param("example") RbUserprotocolExample example);

    int updateByExampleWithBLOBs(@Param("record") RbUserprotocol record, @Param("example") RbUserprotocolExample example);

    int updateByExample(@Param("record") RbUserprotocol record, @Param("example") RbUserprotocolExample example);

    int updateByPrimaryKeySelective(RbUserprotocol record);

    int updateByPrimaryKeyWithBLOBs(RbUserprotocol record);
}