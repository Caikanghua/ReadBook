package com.readbook.mapper;

import com.readbook.pojo.RbShare;
import com.readbook.pojo.RbShareExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

public interface RbShareMapper {
    int countByExample(RbShareExample example);

    int deleteByExample(RbShareExample example);

    int deleteByPrimaryKey(Integer shareId);

    int insert(RbShare record);

    int insertSelective(RbShare record);

    List<RbShare> selectByExample(RbShareExample example);

    RbShare selectByPrimaryKey(Integer shareId);

    int updateByExampleSelective(@Param("record") RbShare record, @Param("example") RbShareExample example);

    int updateByExample(@Param("record") RbShare record, @Param("example") RbShareExample example);

    int updateByPrimaryKeySelective(RbShare record);

    int updateByPrimaryKey(RbShare record);

	List<RbShare> findUserSharesByCondition(String userId, int state,
			int stu_num, int page_size);

	List<RbShare> getAllSharesByRankby(@Param("rankby")String rankby);

	void updateStateToCancle(@Param("shareId")String shareId);

	String getUserIdByShareId(@Param("shareId")String shareId);

	void updateStateToPut(@Param("shareId")String shareId);

	void updateStateToGetBook(@Param("shareId")String shareId);

	List<RbShare> getShareByPhone(@Param("phone")String phone, @Param("start_num")int start_num, @Param("page_size")int page_size);

	List<RbShare> searhUserShareBook(@Param("state")String state, @Param("start_num")int start_num, @Param("page_size")int page_size);

	List<RbShare> getUserAllShares(String userId, int start_num, int page_size);

	List<RbShare> getShareList(@Param("rankby")int rankby, @Param("index")int index, @Param("count")int count);

	int getTotalCount(@Param("rankby")int rankby);
}