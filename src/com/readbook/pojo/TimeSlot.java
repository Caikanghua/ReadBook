package com.readbook.pojo;

public class TimeSlot {
    private Integer slotId;

    private String slotTime;

    public Integer getSlotId() {
        return slotId;
    }

    public void setSlotId(Integer slotId) {
        this.slotId = slotId;
    }

    public String getSlotTime() {
        return slotTime;
    }

    public void setSlotTime(String slotTime) {
        this.slotTime = slotTime == null ? null : slotTime.trim();
    }
}