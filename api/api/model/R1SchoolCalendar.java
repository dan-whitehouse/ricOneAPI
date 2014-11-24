package api.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class R1SchoolCalendar implements Serializable
{
	private static final long serialVersionUID = 4255199616263324176L;
    
	private String schoolCalendarRefId;
	private String schoolRefId;
	private String calendarCode;
	private String calendarDescription;
	private String calendarYear;
	private R1School r1School;
	private Set<R1SchoolCalendarSession> r1SchoolCalendarSessions = new HashSet<R1SchoolCalendarSession>(0);
	
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

	public R1School getR1School()
	{
		return r1School;
	}

	public void setR1School(R1School r1School)
	{
		this.r1School = r1School;
	}

	public Set<R1SchoolCalendarSession> getR1SchoolCalendarSessions()
	{
		return r1SchoolCalendarSessions;
	}

	public void setR1SchoolCalendarSessions(Set<R1SchoolCalendarSession> r1SchoolCalendarSessions)
	{
		this.r1SchoolCalendarSessions = r1SchoolCalendarSessions;
	}
	
}
