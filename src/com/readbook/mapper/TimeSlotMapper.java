package com.readbook.mapper;

import com.readbook.pojo.TimeSlot;
import com.readbook.pojo.TimeSlotExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TimeSlotMapper {
    int countByExample(TimeSlotExample example);

    int deleteByExample(TimeSlotExample example);

    int deleteByPrimaryKey(Integer slotId);

    int insert(TimeSlot record);

    int insertSelective(TimeSlot record);

    List<TimeSlot> selectByExample(TimeSlotExample example);

    TimeSlot selectByPrimaryKey(Integer slotId);

    int updateByExampleSelective(@Param("record") TimeSlot record, @Param("example") TimeSlotExample example);

    int updateByExample(@Param("record") TimeSlot record, @Param("example") TimeSlotExample example);

    int updateByPrimaryKeySelective(TimeSlot record);

    int updateByPrimaryKey(TimeSlot record);
}