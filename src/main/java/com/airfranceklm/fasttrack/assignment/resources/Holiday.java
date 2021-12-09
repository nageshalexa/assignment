package com.airfranceklm.fasttrack.assignment.resources;

enum status
{
	DRAFT, REQUESTED, SCHEDULED , ARCHIVED;
}
public class Holiday {

	public String getHolidayLabel() {
		return holidayLabel;
	}
	public void setHolidayLabel(String holidayLabel) {
		this.holidayLabel = holidayLabel;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getStartOfHoliday() {
		return startOfHoliday;
	}
	public void setStartOfHoliday(String startOfHoliday) {
		this.startOfHoliday = startOfHoliday;
	}
	public String getEndOfHoliday() {
		return endOfHoliday;
	}
	public void setEndOfHoliday(String endOfHoliday) {
		this.endOfHoliday = endOfHoliday;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private String holidayLabel;
	private String employeeId;
	private String startOfHoliday;
	private String endOfHoliday;
	private String status;

}
