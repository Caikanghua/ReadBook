package com.readbook.mapper;

import com.readbook.pojo.UserVote;
import com.readbook.pojo.UserVoteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserVoteMapper {
    int countByExample(UserVoteExample example);

    int deleteByExample(UserVoteExample example);

    int deleteByPrimaryKey(String userVoteId);

    int insert(UserVote record);

    int insertSelective(UserVote record);

    List<UserVote> selectByExample(UserVoteExample example);

    UserVote selectByPrimaryKey(String userVoteId);

    int updateByExampleSelective(@Param("record") UserVote record, @Param("example") UserVoteExample example);

    int updateByExample(@Param("record") UserVote record, @Param("example") UserVoteExample example);

    int updateByPrimaryKeySelective(UserVote record);

    int updateByPrimaryKey(UserVote record);

	void incUserVoteTimes(@Param("userVoteId")int userVoteId);
}