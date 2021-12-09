package com.airfranceklm.fasttrack.assignment.service;

import java.util.List;
import java.util.Map;

import com.airfranceklm.fasttrack.assignment.resources.Schedules;

public interface HolidayService {

	List<Schedules> getAllSchedules();

	List<Schedules> saveSchedule(Schedules schedules);

	List<Schedules> updateSchedule(String holidayId, Schedules schedules);

	List<Schedules> deleteSchedule(String holidayId, Schedules schedules);
	

}
