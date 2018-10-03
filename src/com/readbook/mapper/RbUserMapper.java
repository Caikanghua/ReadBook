package com.readbook.mapper;

import com.readbook.pojo.RbUser;
import com.readbook.pojo.RbUserExample;
import com.readbook.pojo.RbUserStar;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbUserMapper {
    int countByExample(RbUserExample example);

    int deleteByExample(RbUserExample example);

    int deleteByPrimaryKey(String userId);

    int insert(RbUser record);

    int insertSelective(RbUser record);

    List<RbUser> selectByExample(RbUserExample example);

    RbUser selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") RbUser record, @Param("example") RbUserExample example);

    int updateByExample(@Param("record") RbUser record, @Param("example") RbUserExample example);

    int updateByPrimaryKeySelective(RbUser record);

    int updateByPrimaryKey(RbUser record);
    //新添加方法
	List<RbUser> getIdAndName(String userId);

	void updateReadCnt(@Param("userId")String userId);

	void updateShareCntInc(@Param("userId")String userId);

	void lock(String userId, String type);

	String getUserNickName(@Param("userId")String userId);

	List<RbUserStar> checkAgainStar(@Param("userId")String userId, @Param("commentId")String commentId);

	void addUserStar(@Param("userId")String userId, @Param("commentId")String commentId);

	RbUser getUserPartDetailByUserId(@Param("userId")String userId);
}