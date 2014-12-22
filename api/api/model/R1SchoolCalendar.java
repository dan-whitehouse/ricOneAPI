package api.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SchoolCalendar")
public class R1SchoolCalendar implements Serializable
{
	private static final long serialVersionUID = 4255199616263324176L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SchoolCalendarRefId", unique=true, nullable=false)
	private String schoolCalendarRefId;
	
	//@Column(name="SchoolRefId", nullable=false)
	private String schoolRefId;
	
	@Column(name="CalendarCode", nullable=true, length=30)
	private String calendarCode;
	
	@Column(name="CalendarDescription", nullable=true, length=60)
	private String calendarDescription;
	
	@Column(name="CalendarYear", nullable=true, length=4)
	private String calendarYear;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="SchoolRefId", nullable=false)
	private R1School r1School;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="r1SchoolCalendar")
	private Set<R1SchoolCalendarSession> r1SchoolCalendarSessions = new HashSet<R1SchoolCalendarSession>(0);
	
	//--
	public R1SchoolCalendar() {}

	
	
	public R1SchoolCalendar(String schoolCalendarRefId, String schoolRefId,
			String calendarCode, String calendarDescription,
			String calendarYear, R1School r1School,
			Set<R1SchoolCalendarSession> r1SchoolCalendarSessions) 
	{
		this.schoolCalendarRefId = schoolCalendarRefId;
		this.schoolRefId = schoolRefId;
		this.calendarCode = calendarCode;
		this.calendarDescription = calendarDescription;
		this.calendarYear = calendarYear;
		this.r1School = r1School;
		this.r1SchoolCalendarSessions = r1SchoolCalendarSessions;
	}



	
	public String getSchoolCalendarRefId() 
	{
		return schoolCalendarRefId;
	}

	public void setSchoolCalendarRefId(String schoolCalendarRefId) 
	{
		this.schoolCalendarRefId = schoolCalendarRefId;
	}

	
	public String getSchoolRefId() 
	{
		return schoolRefId;
	}

	public void setSchoolRefId(String schoolRefId) 
	{
		this.schoolRefId = schoolRefId;
	}

	
	public String getCalendarCode() 
	{
		return calendarCode;
	}

	public void setCalendarCode(String calendarCode) 
	{
		this.calendarCode = calendarCode;
	}

	
	public String getCalendarDescription() 
	{
		return calendarDescription;
	}

	public void setCalendarDescription(String calendarDescription) 
	{
		this.calendarDescription = calendarDescription;
	}

	
	public String getCalendarYear() 
	{
		return calendarYear;
	}
	
	public void setCalendarYear(String calendarYear) 
	{
		this.calendarYear = calendarYear;
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
	
	//--

	@Override
	public String toString() {
		return "R1SchoolCalendar [schoolCalendarRefId=" + schoolCalendarRefId
				+ ", schoolRefId=" + schoolRefId + ", calendarCode="
				+ calendarCode + ", calendarDescription=" + calendarDescription
				+ ", calendarYear=" + calendarYear + "]";
	}
	
}
