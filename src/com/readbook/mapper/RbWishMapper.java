package com.readbook.mapper;

import com.readbook.pojo.RbWish;
import com.readbook.pojo.RbWishExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbWishMapper {
    int countByExample(RbWishExample example);

    int deleteByExample(RbWishExample example);

    int deleteByPrimaryKey(Integer wishId);

    int insert(RbWish record);

    int insertSelective(RbWish record);

    List<RbWish> selectByExample(RbWishExample example);

    RbWish selectByPrimaryKey(Integer wishId);

    int updateByExampleSelective(@Param("record") RbWish record, @Param("example") RbWishExample example);

    int updateByExample(@Param("record") RbWish record, @Param("example") RbWishExample example);

    int updateByPrimaryKeySelective(RbWish record);

    int updateByPrimaryKey(RbWish record);

	int getTotalCount(@Param("type")int type);

	List<RbWish> getWishList(int type, int index, int count);

	String getWishBookName(@Param("wishId")int wishId);
}