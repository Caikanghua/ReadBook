package com.readbook.service;

import java.util.List;

import com.readbook.pojo.TimeSlot;

public interface TimeSlotService {

	void addTimeSlot(String timeSlot);

	TimeSlot getTimeSlot(String timeSlotId);

	void updateTimeSlot(TimeSlot timeSlot);

	void deleteTimeSlotById(String timeSlotId);

	List<TimeSlot> getTimeSlotList();

}
