package com.readbook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.readbook.mapper.TimeSlotMapper;
import com.readbook.pojo.TimeSlot;
import com.readbook.pojo.TimeSlotExample;
import com.readbook.service.TimeSlotService;
@Service
public class TimeSlotServiceImpl implements TimeSlotService {
	@Autowired
	private TimeSlotMapper mapper;
	@Override
	public void addTimeSlot(String timeSlot) {
		TimeSlot slot=new TimeSlot();
		slot.setSlotTime(timeSlot);
		mapper.insertSelective(slot);
	}
	@Override
	public TimeSlot getTimeSlot(String timeSlotId) {
		TimeSlot slot = mapper.selectByPrimaryKey(Integer.parseInt(timeSlotId));
		return slot;
	}
	@Override
	public void updateTimeSlot(TimeSlot timeSlot) {
		mapper.updateByPrimaryKey(timeSlot);
	}
	@Override
	public void deleteTimeSlotById(String timeSlotId) {
		mapper.deleteByPrimaryKey(Integer.parseInt(timeSlotId));
	}
	@Override
	public List<TimeSlot> getTimeSlotList() {
		TimeSlotExample example=new TimeSlotExample();
		List<TimeSlot> list = mapper.selectByExample(example);
		return list;
	}

}
