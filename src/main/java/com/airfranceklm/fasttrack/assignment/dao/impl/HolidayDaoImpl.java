package com.airfranceklm.fasttrack.assignment.dao.impl;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.airfranceklm.fasttrack.assignment.resources.Holiday;
import com.airfranceklm.fasttrack.assignment.resources.Schedules;
import com.airfranceklm.fasttrack.assignment.service.impl.HolidayServiceImpl;

@Repository
public class HolidayDaoImpl {
	private static final Logger logger = LogManager.getLogger(HolidayDaoImpl.class);
	private static List<Schedules> schedulesList = new ArrayList<>();

	static {
		Schedules schedules1 = new Schedules();
		Holiday holiday1 = new Holiday();
		holiday1.setEmployeeId("1");
		holiday1.setHolidayLabel("Schedule1");
		holiday1.setStartOfHoliday("2022-08-02T08:00:00+00:00");
		holiday1.setEndOfHoliday("2022-08-16T08:00:00+00:00");
		holiday1.setStatus("SCHEDULED");
		schedules1.setHolidayId("1");
		schedules1.setHoliday(holiday1);
		schedulesList.add(schedules1);

		Schedules schedules2 = new Schedules();
		Holiday holiday2 = new Holiday();
		holiday2.setEmployeeId("2");
		holiday2.setHolidayLabel("Schedule2");
		holiday2.setStartOfHoliday("2022-09-02T08:00:00+00:00");
		holiday2.setEndOfHoliday("2022-09-16T08:00:00+00:00");
		holiday2.setStatus("REQUESTED");
		schedules2.setHolidayId("2");
		schedules2.setHoliday(holiday2);
		schedulesList.add(schedules2);

	}

	public List<Schedules> getAllSchedules() {
		return schedulesList;
	}

	public List<Schedules> saveSchedule(Schedules scheduleforsave) {

		LocalDate startofschedule = converToLocalDate(scheduleforsave);

		if (checkanyOverlap(startofschedule) && gapBetweenTwoHolidays(startofschedule)) {

			LocalDate currentdate = LocalDate.now();
			if (startofschedule.isAfter(currentdate)) {
				long days = ChronoUnit.DAYS.between(currentdate, startofschedule);

				if (days >= 5) {
					schedulesList.add(scheduleforsave);
				} else {
					logger.info("A holiday must be planned at least 5 working days before the start date");
				}

			}
		} else {
			logger.info(
					"Holidays must not overlap Or There should be a gap of at least 3 working days between holidays");
		}

		return schedulesList;
	}

	public List<Schedules> updateSchedule(String holidayId, Schedules schedulesUpdate) {

		Predicate<Schedules> condition = schedules -> schedules.getHolidayId().equals(holidayId);
		schedulesList.removeIf(condition);
		schedulesList.add(schedulesUpdate);

		return schedulesList;
	}

	public List<Schedules> deleteSchedule(String holidayId, Schedules scheduledelete) {

		LocalDate startofschedule = converToLocalDate(scheduledelete);
		LocalDate currentdate = LocalDate.now();
		long days = ChronoUnit.DAYS.between(currentdate, startofschedule);

		if (days >= 5) {
			Predicate<Schedules> condition = schedules -> schedules.getHolidayId().equals(holidayId);
			schedulesList.removeIf(condition);
		} else {
			logger.info("A holiday must be cancelled at least 5 working days before the start date");
		}

		return schedulesList;
	}

	private boolean checkanyOverlap(LocalDate startofschedule) {
		for (Schedules listOfSchelules : schedulesList) {
			ZonedDateTime result = ZonedDateTime.parse(listOfSchelules.getHoliday().getStartOfHoliday(),
					DateTimeFormatter.ISO_DATE_TIME);
			LocalDate date = result.toLocalDate();
			if (date.isEqual(startofschedule)) {
				return false;
			}
		}
		return true;
	}

	private boolean gapBetweenTwoHolidays(LocalDate startofschedule) {
		for (Schedules existingschedules : schedulesList) {
			long days = ChronoUnit.DAYS.between(converToLocalDate(existingschedules), startofschedule);
			if (days >= 3) {
				return true;
			}
		}

		return false;
	}

	private LocalDate converToLocalDate(Schedules scheduleForSave) {
		ZonedDateTime result = ZonedDateTime.parse(scheduleForSave.getHoliday().getStartOfHoliday(),
				DateTimeFormatter.ISO_DATE_TIME);
		LocalDate startofschedule = result.toLocalDate();
		return startofschedule;
	}

}
