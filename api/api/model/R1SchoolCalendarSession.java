/*
 * SIF3Session.java
 * Created: 30/01/2014
 *
 * Copyright 2014 Systemic Pty Ltd
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License 
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */

package api.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.math.BigDecimal;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="SchoolCalendarSession")
public class R1SchoolCalendarSession implements Serializable
{
	private static final long serialVersionUID = 4255194616261324178L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SchoolCalendarSessionRefId", unique=true, nullable=false)
	private String schoolCalendarSessionRefId;
	
	//@Column(name="SchoolCalendarRefId", nullable=false)
	private String schoolCalendarRefId;
	
	@Column(name="Designator", nullable=true, length=7)
	private String designator;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "BeginDate", length = 10)
	private Date beginDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "EndDate", length = 10)
	private Date endDate;
	
	@Column(name="SessionTypeCode", nullable=true, length=50)
	private String sessionTypeCode;
	
	@Column(name="InstructionalMinutes", nullable=true)
	private BigDecimal instructionalMinutes;
	
	@Column(name="Code", nullable=true, length=30)
	private String code;
	
	@Column(name="Description", nullable=true, length=254)
	private String description;
	
	@Column(name="MarkingTermIndicator", nullable=true)
	private boolean markingTermIndicator;
	
	@Column(name="SchedulingTermIndicator", nullable=true)
	private boolean schedulingTermIndicator;
	
	@Column(name="AttendanceTermIndicator", nullable=true)
	private boolean attendanceTermIndicator;
	
	@Column(name="DaysInSession", nullable=true)
	private Integer daysInSession;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "FirstInstructionDate", length = 10)
	private Date firstInstructionDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "LastInstructionDate", length = 10)
	private Date lastInstructionDate;
	
	@Column(name="MinutesPerDay", nullable=true)
	private Integer minutesPerDay;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "SessionStartTime", length = 16)
	private Date sessionStartTime;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "SessionEndTime", length = 16)
	private Date sessionEndTime;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="r1SchoolCalendarSession")
	private Set<R1CourseSection> r1CourseSections = new HashSet<R1CourseSection>(0);
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="SchoolCalendarRefId", nullable=false)
	private R1SchoolCalendar r1SchoolCalendar;
	
	//--
	public R1SchoolCalendarSession() {}

	public R1SchoolCalendarSession(String schoolCalendarSessionRefId,
			String schoolCalendarRefId, String designator, Date beginDate,
			Date endDate, String sessionTypeCode,
			BigDecimal instructionalMinutes, String code, String description,
			boolean markingTermIndicator, boolean schedulingTermIndicator,
			boolean attendanceTermIndicator, Integer daysInSession,
			Date firstInstructionDate, Date lastInstructionDate,
			Integer minutesPerDay, Date sessionStartTime, Date sessionEndTime,
			Set<R1CourseSection> r1CourseSections,
			R1SchoolCalendar r1SchoolCalendar) 
	{

		this.schoolCalendarSessionRefId = schoolCalendarSessionRefId;
		this.schoolCalendarRefId = schoolCalendarRefId;
		this.designator = designator;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.sessionTypeCode = sessionTypeCode;
		this.instructionalMinutes = instructionalMinutes;
		this.code = code;
		this.description = description;
		this.markingTermIndicator = markingTermIndicator;
		this.schedulingTermIndicator = schedulingTermIndicator;
		this.attendanceTermIndicator = attendanceTermIndicator;
		this.daysInSession = daysInSession;
		this.firstInstructionDate = firstInstructionDate;
		this.lastInstructionDate = lastInstructionDate;
		this.minutesPerDay = minutesPerDay;
		this.sessionStartTime = sessionStartTime;
		this.sessionEndTime = sessionEndTime;
		this.r1CourseSections = r1CourseSections;
		this.r1SchoolCalendar = r1SchoolCalendar;
	}

	public String getSchoolCalendarSessionRefId() 
	{
		return schoolCalendarSessionRefId;
	}


	public void setSchoolCalendarSessionRefId(String schoolCalendarSessionRefId) 
	{
		this.schoolCalendarSessionRefId = schoolCalendarSessionRefId;
	}


	
	public String getSchoolCalendarRefId() 
	{
		return schoolCalendarRefId;
	}


	public void setSchoolCalendarRefId(String schoolCalendarRefId) 
	{
		this.schoolCalendarRefId = schoolCalendarRefId;
	}

	
	public String getDesignator() 
	{
		return designator;
	}


	public void setDesignator(String designator) 
	{
		this.designator = designator;
	}

	
	public Date getBeginDate() 
	{
		return beginDate;
	}


	public void setBeginDate(Date beginDate)
	{
		this.beginDate = beginDate;
	}

	
	public Date getEndDate() 
	{
		return endDate;
	}


	public void setEndDate(Date endDate) 
	{
		this.endDate = endDate;
	}

	
	public String getSessionTypeCode()
	{
		return sessionTypeCode;
	}


	public void setSessionTypeCode(String sessionTypeCode)
	{
		this.sessionTypeCode = sessionTypeCode;
	}

	
	public BigDecimal getInstructionalMinutes() 
	{
		return instructionalMinutes;
	}


	public void setInstructionalMinutes(BigDecimal instructionalMinutes) 
	{
		if(instructionalMinutes != null)
		{
			this.instructionalMinutes = instructionalMinutes;
		}
		else
		{
			this.instructionalMinutes = this.instructionalMinutes.ZERO;
		}
		
	}

	
	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}

	
	public String getDescription() 
	{
		return description;
	}


	public void setDescription(String description) 
	{
		this.description = description;
	}

	
	public boolean isMarkingTermIndicator() 
	{
		return markingTermIndicator;
	}


	public void setMarkingTermIndicator(boolean markingTermIndicator) 
	{
		this.markingTermIndicator = markingTermIndicator;
	}

	
	public boolean isSchedulingTermIndicator() 
	{
		return schedulingTermIndicator;
	}


	public void setSchedulingTermIndicator(boolean schedulingTermIndicator) 
	{
		this.schedulingTermIndicator = schedulingTermIndicator;
	}


	public boolean isAttendanceTermIndicator() 
	{
		return attendanceTermIndicator;
	}


	public void setAttendanceTermIndicator(boolean attendanceTermIndicator) 
	{
		this.attendanceTermIndicator = attendanceTermIndicator;
	}

	
	public Integer getDaysInSession() 
	{
		return daysInSession;
	}


	public void setDaysInSession(Integer daysInSession) 
	{
		this.daysInSession = daysInSession;
	}

	
	public Date getFirstInstructionDate() 
	{
		return firstInstructionDate;
	}


	public void setFirstInstructionDate(Date firstInstructionDate) 
	{
		this.firstInstructionDate = firstInstructionDate;
	}

	
	public Date getLastInstructionDate() 
	{
		return lastInstructionDate;
	}


	public void setLastInstructionDate(Date lastInstructionDate) 
	{
		this.lastInstructionDate = lastInstructionDate;
	}

	
	public Integer getMinutesPerDay() 
	{
		return minutesPerDay;
	}


	public void setMinutesPerDay(Integer minutesPerDay) {
		this.minutesPerDay = minutesPerDay;
	}

	
	public Date getSessionStartTime() {
		return sessionStartTime;
	}


	public void setSessionStartTime(Date sessionStartTime) {
		this.sessionStartTime = sessionStartTime;
	}

	public Date getSessionEndTime() {
		return sessionEndTime;
	}


	public void setSessionEndTime(Date sessionEndTime) 
	{
		this.sessionEndTime = sessionEndTime;
	}


	
	public Set<R1CourseSection> getR1CourseSections()
	{
		return r1CourseSections;
	}

	public void setR1CourseSections(Set<R1CourseSection> r1CourseSections)
	{
		this.r1CourseSections = r1CourseSections;
	}

	public R1SchoolCalendar getR1SchoolCalendar()
	{
		return r1SchoolCalendar;
	}


	public void setR1SchoolCalendar(R1SchoolCalendar r1SchoolCalendar)
	{
		this.r1SchoolCalendar = r1SchoolCalendar;
	}
	
	//--
	@Override
	public String toString() {
		return "R1SchoolCalendarSession [schoolCalendarSessionRefId="
				+ schoolCalendarSessionRefId + ", schoolCalendarRefId="
				+ schoolCalendarRefId + ", designator=" + designator
				+ ", beginDate=" + beginDate + ", endDate=" + endDate
				+ ", sessionTypeCode=" + sessionTypeCode
				+ ", instructionalMinutes=" + instructionalMinutes + ", code="
				+ code + ", description=" + description
				+ ", markingTermIndicator=" + markingTermIndicator
				+ ", schedulingTermIndicator=" + schedulingTermIndicator
				+ ", attendanceTermIndicator=" + attendanceTermIndicator
				+ ", daysInSession=" + daysInSession
				+ ", firstInstructionDate=" + firstInstructionDate
				+ ", lastInstructionDate=" + lastInstructionDate
				+ ", minutesPerDay=" + minutesPerDay + ", sessionStartTime="
				+ sessionStartTime + ", sessionEndTime=" + sessionEndTime + "]";
	}


}
