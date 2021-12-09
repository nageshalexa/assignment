package com.airfranceklm.fasttrack.assignment.dao;

import java.util.List;

import com.airfranceklm.fasttrack.assignment.resources.Schedules;

public interface HolidayDao {

	List<Schedules> getAllSchedules();

	List<Schedules> saveSchedule(Schedules schedules);

	List<Schedules> updateSchedule(String holidayId, Schedules schedules);

	List<Schedules> deleteSchedule(String holidayId, Schedules schedules);
	

}
