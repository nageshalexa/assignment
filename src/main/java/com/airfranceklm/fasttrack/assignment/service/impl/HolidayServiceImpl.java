package com.airfranceklm.fasttrack.assignment.service.impl;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.airfranceklm.fasttrack.assignment.resources.Holiday;
import com.airfranceklm.fasttrack.assignment.resources.Schedules;
import com.airfranceklm.fasttrack.assignment.service.HolidayService;

@Service
public class HolidayServiceImpl implements HolidayService {
	private static List<Schedules> schedulesList = new ArrayList<Schedules>();

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

	@Override
	public List<Schedules> saveSchedule(Schedules scheduleForSave) {

		LocalDate Startofschedule = converTolocalDate(scheduleForSave);

		if (checkanyOverlap(Startofschedule) && gapbetweenTwoholidays(Startofschedule)) {

			LocalDate Currentdate = LocalDate.now();
			if (Startofschedule.isAfter(Currentdate)) {
				long days = ChronoUnit.DAYS.between(Currentdate, Startofschedule);

				if (days >= 5) {
					schedulesList.add(scheduleForSave);
				} else {
					System.out.println("A holiday must be planned at least 5 working days before the start date");
				}

			}
		} else {
			System.out.println(
					"Holidays must not overlap Or There should be a gap of at least 3 working days between holidays");
		}

		return schedulesList;
	}

	@Override
	public List<Schedules> updateSchedule(String holidayId, Schedules schedulesUpdate) {

		Predicate<Schedules> condition = schedules -> schedules.getHolidayId().equals(holidayId);
		schedulesList.removeIf(condition);
		schedulesList.add(schedulesUpdate);

		return schedulesList;
	}

	@Override
	public List<Schedules> deleteSchedule(String holidayId, Schedules scheduledelete) {

		LocalDate Startofschedule = converTolocalDate(scheduledelete);
		LocalDate Currentdate = LocalDate.now();
		long days = ChronoUnit.DAYS.between(Currentdate, Startofschedule);

		if (days >= 5) {
			Predicate<Schedules> condition = schedules -> schedules.getHolidayId().equals(holidayId);
			schedulesList.removeIf(condition);
		} else {
			System.out.println("A holiday must be cancelled at least 5 working days before the start date");
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

	private boolean gapbetweenTwoholidays(LocalDate startofschedule) {
		for (Schedules ExistingSchedules : schedulesList) {
			System.out.println("test" + converTolocalDate(ExistingSchedules) + "" + startofschedule);
			long days = ChronoUnit.DAYS.between(converTolocalDate(ExistingSchedules), startofschedule);
			if (days >= 3) {
				return true;
			}
		}

		return false;
	}

	private LocalDate converTolocalDate(Schedules scheduleForSave) {
		ZonedDateTime result = ZonedDateTime.parse(scheduleForSave.getHoliday().getStartOfHoliday(),
				DateTimeFormatter.ISO_DATE_TIME);
		LocalDate Startofschedule = result.toLocalDate();
		return Startofschedule;
	}

}
