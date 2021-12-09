package com.airfranceklm.fasttrack.assignment.service.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airfranceklm.fasttrack.assignment.dao.HolidayDao;
import com.airfranceklm.fasttrack.assignment.resources.Schedules;
import com.airfranceklm.fasttrack.assignment.service.HolidayService;

@Service
public class HolidayServiceImpl implements HolidayService {

	@Autowired
    HolidayDao holidayDao;
	
	public List<Schedules> getAllSchedules() {
		return holidayDao.getAllSchedules();
	}

	@Override
	public List<Schedules> saveSchedule(Schedules scheduleforsave) {

		return holidayDao.saveSchedule(scheduleforsave);
	}

	@Override
	public List<Schedules> updateSchedule(String holidayId, Schedules schedulesUpdate) {
		return holidayDao.updateSchedule(holidayId, schedulesUpdate);
	}

	@Override
	public List<Schedules> deleteSchedule(String holidayId, Schedules scheduledelete) {

		return holidayDao.deleteSchedule(holidayId, scheduledelete);
	}

}
