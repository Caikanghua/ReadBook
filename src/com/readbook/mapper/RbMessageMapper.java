package com.readbook.mapper;

import com.readbook.pojo.RbMessage;
import com.readbook.pojo.RbMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbMessageMapper {
    int countByExample(RbMessageExample example);

    int deleteByExample(RbMessageExample example);

    int deleteByPrimaryKey(String messageId);

    int insert(RbMessage record);

    int insertSelective(RbMessage record);

    List<RbMessage> selectByExample(RbMessageExample example);

    RbMessage selectByPrimaryKey(String messageId);

    int updateByExampleSelective(@Param("record") RbMessage record, @Param("example") RbMessageExample example);

    int updateByExample(@Param("record") RbMessage record, @Param("example") RbMessageExample example);

    int updateByPrimaryKeySelective(RbMessage record);

    int updateByPrimaryKey(RbMessage record);

	List<RbMessage> getUserAllMessage(@Param("userId")String userId, @Param("isRead")String isRead,
			@Param("start_num")int start_num, @Param("page_size")int page_size);
}