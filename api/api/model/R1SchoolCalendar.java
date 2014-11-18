package api.model;

import java.io.Serializable;

public class R1SchoolCalendar implements Serializable
{
	private static final long serialVersionUID = 4255199616263324176L;
    
	private String schoolCalendarRefId;
	private String schoolRefId;
	private String calendarCode;
	private String calendarDescription;
	private String calendarYear;
	
	public R1SchoolCalendar() {}

	public String getSchoolCalendarRefId() {
		return schoolCalendarRefId;
	}

	public void setSchoolCalendarRefId(String schoolCalendarRefId) {
		this.schoolCalendarRefId = schoolCalendarRefId;
	}

	public String getSchoolRefId() {
		return schoolRefId;
	}

	public void setSchoolRefId(String schoolRefId) {
		this.schoolRefId = schoolRefId;
	}

	public String getCalendarCode() {
		return calendarCode;
	}

	public void setCalendarCode(String calendarCode) {
		this.calendarCode = calendarCode;
	}

	public String getCalendarDescription() {
		return calendarDescription;
	}

	public void setCalendarDescription(String calendarDescription) {
		this.calendarDescription = calendarDescription;
	}

	public String getCalendarYear() {
		return calendarYear;
	}

	public void setCalendarYear(String calendarYear) {
		this.calendarYear = calendarYear;
	}

	@Override
	public String toString() {
		return "R1SchoolCalendar [schoolCalendarRefId=" + schoolCalendarRefId
				+ ", schoolRefId=" + schoolRefId + ", calendarCode="
				+ calendarCode + ", calendarDescription=" + calendarDescription
				+ ", calendarYear=" + calendarYear + "]";
	}
	
}
