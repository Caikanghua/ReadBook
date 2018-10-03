package com.readbook.mapper;

import com.readbook.pojo.VoteBook;
import com.readbook.pojo.VoteBookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VoteBookMapper {
    int countByExample(VoteBookExample example);

    int deleteByExample(VoteBookExample example);

    int deleteByPrimaryKey(Integer voteBookId);

    int insert(VoteBook record);

    int insertSelective(VoteBook record);

    List<VoteBook> selectByExampleWithBLOBs(VoteBookExample example);

    List<VoteBook> selectByExample(VoteBookExample example);

    VoteBook selectByPrimaryKey(Integer voteBookId);

    int updateByExampleSelective(@Param("record") VoteBook record, @Param("example") VoteBookExample example);

    int updateByExampleWithBLOBs(@Param("record") VoteBook record, @Param("example") VoteBookExample example);

    int updateByExample(@Param("record") VoteBook record, @Param("example") VoteBookExample example);

    int updateByPrimaryKeySelective(VoteBook record);

    int updateByPrimaryKeyWithBLOBs(VoteBook record);

    int updateByPrimaryKey(VoteBook record);
}