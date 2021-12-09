package com.airfranceklm.fasttrack.assignment.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.airfranceklm.fasttrack.assignment.dao.HolidayDao;
import com.airfranceklm.fasttrack.assignment.resources.Holiday;
import com.airfranceklm.fasttrack.assignment.resources.Schedules;



@SpringBootTest
class HolidayDaoTest {
	@Autowired
	HolidayDao holidayDao;

	@Test
	void testGetAllSchedules() {
		Schedules schedules = new Schedules();
		Holiday holiday = new Holiday();
		holiday.setEmployeeId("1");
		holiday.setStartOfHoliday("2022-08-02T08:00:00+00:00");
		holiday.setEndOfHoliday("2022-08-04T08:00:00+00:00");
		holiday.setHolidayLabel("Schedule1");
		holiday.setStatus("ARCHIVED");
		schedules.setHoliday(holiday);
		schedules.setHolidayId("1");
		
		List<Schedules> listodschedules=new ArrayList<Schedules>();

		assertEquals(listodschedules, holidayDao.getAllSchedules());
	}

	@Test
	void testSaveSchedule() {
		Schedules schedules = new Schedules();
		Holiday holiday = new Holiday();
		holiday.setEmployeeId("1");
		holiday.setStartOfHoliday("2022-08-08T08:00:00+00:00");
		holiday.setEndOfHoliday("2022-08-09T08:00:00+00:00");
		holiday.setHolidayLabel("Schedule2");
		holiday.setStatus("SCHEDULED");
		schedules.setHoliday(holiday);
		schedules.setHolidayId("1");
		List<Schedules> listodschedules=new ArrayList<Schedules>();

		assertEquals(listodschedules, holidayDao.saveSchedule(schedules));
	}

	@Test
	void testUpdateSchedule() {
		Schedules schedules = new Schedules();
		Holiday holiday = new Holiday();
		holiday.setEmployeeId("1");
		holiday.setStartOfHoliday("2022-08-15T08:00:00+00:00");
		holiday.setEndOfHoliday("2022-08-16T08:00:00+00:00");
		holiday.setHolidayLabel("Schedule3");
		holiday.setStatus("REQUESTED");
		schedules.setHoliday(holiday);
		schedules.setHolidayId("1");
		List<Schedules> listodschedules=new ArrayList<Schedules>();

		assertEquals(listodschedules, holidayDao.updateSchedule("6", schedules));
	}

	@Test
	void testDeleteSchedule() {
		Schedules schedules = new Schedules();
		Holiday holiday = new Holiday();
		holiday.setEmployeeId("1");
		holiday.setStartOfHoliday("2022-08-25T08:00:00+00:00");
		holiday.setEndOfHoliday("2022-08-26T08:00:00+00:00");
		holiday.setHolidayLabel("Schedule4");
		holiday.setStatus("DRAFT");
		schedules.setHoliday(holiday);
		schedules.setHolidayId("1");
		List<Schedules> listodschedules=new ArrayList<Schedules>();
		assertEquals(listodschedules, holidayDao.deleteSchedule("5", schedules));
	}

}
