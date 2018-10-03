package com.readbook.mapper;

import com.readbook.pojo.Attention;
import com.readbook.pojo.AttentionExample;
import com.readbook.pojo.RbUser;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttentionMapper {
    int countByExample(AttentionExample example);

    int deleteByExample(AttentionExample example);

    int deleteByPrimaryKey(Integer aId);

    int insert(Attention record);

    int insertSelective(Attention record);

    List<Attention> selectByExample(AttentionExample example);

    Attention selectByPrimaryKey(Integer aId);

    int updateByExampleSelective(@Param("record") Attention record, @Param("example") AttentionExample example);

    int updateByExample(@Param("record") Attention record, @Param("example") AttentionExample example);

    int updateByPrimaryKeySelective(Attention record);

    int updateByPrimaryKey(Attention record);

	List<RbUser> selectAllAttention(@Param("userId")String userId);

	List<String> getAllUserId(@Param("beAttentionUser")String beAttentionUser);
}