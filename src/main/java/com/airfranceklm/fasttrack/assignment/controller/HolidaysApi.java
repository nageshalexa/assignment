package com.airfranceklm.fasttrack.assignment.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.airfranceklm.fasttrack.assignment.resources.Schedules;
import com.airfranceklm.fasttrack.assignment.service.HolidayService;

/**
 * @author Nagesh
 *
 */

@RestController
public class HolidaysApi {
	@Autowired
	HolidayService holidayService;

	@GetMapping("/schedulelist")
	private List<Schedules> getAllSchedules() {
		return holidayService.getAllSchedules();
	}

	@PostMapping("/schedulelist")
	private List<Schedules> saveSchedule(@RequestBody Schedules schedules) {
		return holidayService.saveSchedule(schedules);

	}

	@PutMapping("/schedulelist/{holidayId}")
	private List<Schedules> updateSchedule(@PathVariable("holidayId") String holidayId, @RequestBody Schedules schedules) {
		return holidayService.updateSchedule(holidayId, schedules);

	}

	@DeleteMapping("/schedulelist/{holidayId}")
	private List<Schedules> deleteSchedule(@PathVariable("holidayId") String holidayId, @RequestBody Schedules schedules) {
		return holidayService.deleteSchedule(holidayId,schedules);
	}
}