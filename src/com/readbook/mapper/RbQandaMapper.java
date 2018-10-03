package com.readbook.mapper;

import com.readbook.pojo.RbQanda;
import com.readbook.pojo.RbQandaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbQandaMapper {
    int countByExample(RbQandaExample example);

    int deleteByExample(RbQandaExample example);

    int deleteByPrimaryKey(Integer qandaId);

    int insert(RbQanda record);

    int insertSelective(RbQanda record);

    List<RbQanda> selectByExample(RbQandaExample example);

    RbQanda selectByPrimaryKey(Integer qandaId);

    int updateByExampleSelective(@Param("record") RbQanda record, @Param("example") RbQandaExample example);

    int updateByExample(@Param("record") RbQanda record, @Param("example") RbQandaExample example);

    int updateByPrimaryKeySelective(RbQanda record);

    int updateByPrimaryKey(RbQanda record);
}