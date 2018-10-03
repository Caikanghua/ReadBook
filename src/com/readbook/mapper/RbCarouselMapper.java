package com.readbook.mapper;

import com.readbook.pojo.RbCarousel;
import com.readbook.pojo.RbCarouselExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbCarouselMapper {
    int countByExample(RbCarouselExample example);

    int deleteByExample(RbCarouselExample example);

    int deleteByPrimaryKey(Integer carouselId);

    int insert(RbCarousel record);

    int insertSelective(RbCarousel record);

    List<RbCarousel> selectByExampleWithBLOBs(RbCarouselExample example);

    List<RbCarousel> selectByExample(RbCarouselExample example);

    RbCarousel selectByPrimaryKey(Integer carouselId);

    int updateByExampleSelective(@Param("record") RbCarousel record, @Param("example") RbCarouselExample example);

    int updateByExampleWithBLOBs(@Param("record") RbCarousel record, @Param("example") RbCarouselExample example);

    int updateByExample(@Param("record") RbCarousel record, @Param("example") RbCarouselExample example);

    int updateByPrimaryKeySelective(RbCarousel record);

    int updateByPrimaryKeyWithBLOBs(RbCarousel record);

    int updateByPrimaryKey(RbCarousel record);

	List<RbCarousel> getCarouselShow(@Param("number")Integer number);

	void changeToShow(@Param("i")int i);
}