package com.readbook.mapper;

import com.readbook.pojo.RbFeedback;
import com.readbook.pojo.RbFeedbackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbFeedbackMapper {
    int countByExample(RbFeedbackExample example);

    int deleteByExample(RbFeedbackExample example);

    int deleteByPrimaryKey(Integer feedbackId);

    int insert(RbFeedback record);

    int insertSelective(RbFeedback record);

    List<RbFeedback> selectByExampleWithBLOBs(RbFeedbackExample example);

    List<RbFeedback> selectByExample(RbFeedbackExample example);

    RbFeedback selectByPrimaryKey(Integer feedbackId);

    int updateByExampleSelective(@Param("record") RbFeedback record, @Param("example") RbFeedbackExample example);

    int updateByExampleWithBLOBs(@Param("record") RbFeedback record, @Param("example") RbFeedbackExample example);

    int updateByExample(@Param("record") RbFeedback record, @Param("example") RbFeedbackExample example);

    int updateByPrimaryKeySelective(RbFeedback record);

    int updateByPrimaryKeyWithBLOBs(RbFeedback record);

    int updateByPrimaryKey(RbFeedback record);

	int getTotalCount();

	List<RbFeedback> getFeedbackList(int index, int count);
}