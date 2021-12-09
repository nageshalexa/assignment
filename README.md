**assinment**

**Service details:**

Get all holiday schedules : Link: http://localhost:8080/schedulelist 

Method Type:Get
----------------------------------------------------------------------------------------------------------------------------------
**Create a holiday schedule:**

Link: http://localhost:8080/schedulelist 
Method: Post
input Json:
{ "holidayId": "3", "holiday": { "holidayLabel": "schedule4", "employeeId": "6", "startOfHoliday": "2022-08-02T08:00:00+00:00", "endOfHoliday": "2022-08-16T08:00:00+00:00", "status": "REQUESTED" } }

----------------------------------------------------------------------------------------------------------------------------------
**Update Holiday schedule:**


Link: http://localhost:8080/schedulelist/{holidayid} 

Method: PUT 

Input Json: { "holidayId": "3", "holiday": { "holidayLabel": "schedulenew", "employeeId": "6", "startOfHoliday": "2022-08-02T08:00:00+00:00", "endOfHoliday": "2022-08-16T08:00:00+00:00", "status": "REQUESTED" } }
----------------------------------------------------------------------------------------------------------------------------------

**Delete Holiday schedule:**

Link: http://localhost:8080/schedulelist{holidayid}

Method: Delete

Input Json:

{ "holidayId": "3", "holiday": { "holidayLabel": "schedulenew", "employeeId": "6", "startOfHoliday": "2022-08-02T08:00:00+00:00", "endOfHoliday": "2022-08-16T08:00:00+00:00", "status": "REQUESTED" } }
----------------------------------------------------------------------------------------------------------------------------------



**The following business rules apply:**


There should be a gap of at least 3 working days between holidays.

A holiday must be planned at least 5 working days before the start date.

A holiday must be cancelled at least 5 working days before the start date.

Holidays must not overlap (for the sake of this assignment also not between different crew members).

The abouve validations included.

