package com.readbook.mapper;

import com.readbook.pojo.RbReport;
import com.readbook.pojo.RbReportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbReportMapper {
    int countByExample(RbReportExample example);

    int deleteByExample(RbReportExample example);

    int deleteByPrimaryKey(Integer reportId);

    int insert(RbReport record);

    int insertSelective(RbReport record);

    List<RbReport> selectByExampleWithBLOBs(RbReportExample example);

    List<RbReport> selectByExample(RbReportExample example);

    RbReport selectByPrimaryKey(Integer reportId);

    int updateByExampleSelective(@Param("record") RbReport record, @Param("example") RbReportExample example);

    int updateByExampleWithBLOBs(@Param("record") RbReport record, @Param("example") RbReportExample example);

    int updateByExample(@Param("record") RbReport record, @Param("example") RbReportExample example);

    int updateByPrimaryKeySelective(RbReport record);

    int updateByPrimaryKeyWithBLOBs(RbReport record);

    int updateByPrimaryKey(RbReport record);

	List<RbReport> getReportsByCondition(int isdone, int index, int count);

	int getTotalCount(@Param("isdone")int isdone);
}