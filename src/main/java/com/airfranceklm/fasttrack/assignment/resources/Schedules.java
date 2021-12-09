package com.airfranceklm.fasttrack.assignment.resources;

public class Schedules {
	
	private  String holidayId;
	public String getHolidayId() {
		return holidayId;
	}
	public void setHolidayId(String holidayId) {
		this.holidayId = holidayId;
	}
	public Holiday getHoliday() {
		return holiday;
	}
	public void setHoliday(Holiday holiday) {
		this.holiday = holiday;
	}
	private  Holiday holiday;
}
