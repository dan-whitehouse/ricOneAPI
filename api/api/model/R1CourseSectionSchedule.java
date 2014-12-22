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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="CourseSectionSchedule")
public class R1CourseSectionSchedule implements Serializable
{
	private static final long serialVersionUID = 4255194616261324178L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CourseSectionScheduleRefId", unique=true, nullable=false)
	private String courseSectionScheduleRefId;
	
	//@Column(name="CourseSectionRefId", nullable=false)
	private String courseSectionRefId;
	
	@Column(name="ClassMeetingDays", nullable=true)
	private String classMeetingDays;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "ClassBeginningTime", length = 16)
	private Date classBeginningTime;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "ClassEndingTime", length = 16)
	private Date classEndingTime;
	
	@Column(name="ClassPeriod", nullable=true, length=30)
	private String classPeriod;
	
	@Column(name="TimeDayIdentifier", nullable=true, length=30)
	private String timeDayIdentifier;
	
	@Column(name="ClassroomIdentifier", nullable=true, length=30)
	private String classroomIdentifier;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CourseSectionRefId")
	private R1CourseSection r1CourseSection;
	
	//--
	public R1CourseSectionSchedule() {}

	
	
	public R1CourseSectionSchedule(String courseSectionScheduleRefId,
			String courseSectionRefId, String classMeetingDays,
			Date classBeginningTime, Date classEndingTime, String classPeriod,
			String timeDayIdentifier, String classroomIdentifier,
			R1CourseSection r1CourseSection) 
	{
		this.courseSectionScheduleRefId = courseSectionScheduleRefId;
		this.courseSectionRefId = courseSectionRefId;
		this.classMeetingDays = classMeetingDays;
		this.classBeginningTime = classBeginningTime;
		this.classEndingTime = classEndingTime;
		this.classPeriod = classPeriod;
		this.timeDayIdentifier = timeDayIdentifier;
		this.classroomIdentifier = classroomIdentifier;
		this.r1CourseSection = r1CourseSection;
	}



	
	public String getCourseSectionScheduleRefId() 
	{
		return courseSectionScheduleRefId;
	}


	public void setCourseSectionScheduleRefId(String courseSectionScheduleRefId) 
	{
		this.courseSectionScheduleRefId = courseSectionScheduleRefId;
	}

	
	public String getCourseSectionRefId() 
	{
		return courseSectionRefId;
	}


	public void setCourseSectionRefId(String courseSectionRefId) 
	{
		this.courseSectionRefId = courseSectionRefId;
	}

	
	public String getClassMeetingDays() 
	{
		return classMeetingDays;
	}


	public void setClassMeetingDays(String classMeetingDays) 
	{
		this.classMeetingDays = classMeetingDays;
	}

	
	public Date getClassBeginningTime() 
	{
		return classBeginningTime;
	}


	public void setClassBeginningTime(Date classBeginningTime) 
	{
		this.classBeginningTime = classBeginningTime;
	}

	
	public Date getClassEndingTime() 
	{
		return classEndingTime;
	}


	public void setClassEndingTime(Date classEndingTime) 
	{
		this.classEndingTime = classEndingTime;
	}
	
	
	public String getClassPeriod() 
	{
		return classPeriod;
	}


	public void setClassPeriod(String classPeriod) 
	{
		this.classPeriod = classPeriod;
	}

	
	public String getTimeDayIdentifier() 
	{
		return timeDayIdentifier;
	}


	public void setTimeDayIdentifier(String timeDayIdentifier) 
	{
		this.timeDayIdentifier = timeDayIdentifier;
	}

	
	public String getClassroomIdentifier() 
	{
		return classroomIdentifier;
	}


	public void setClassroomIdentifier(String classroomIdentifier) 
	{
		this.classroomIdentifier = classroomIdentifier;
	}

	
	public R1CourseSection getR1CourseSection()
	{
		return r1CourseSection;
	}


	public void setR1CourseSection(R1CourseSection r1CourseSection)
	{
		this.r1CourseSection = r1CourseSection;
	}
	

	@Override
	public String toString() {
		return "R1CourseSectionSchedule [courseSectionScheduleRefId="
				+ courseSectionScheduleRefId + ", courseSectionRefId="
				+ courseSectionRefId + ", classMeetingDays=" + classMeetingDays
				+ ", classBeginningTime=" + classBeginningTime
				+ ", classEndingTime=" + classEndingTime + ", classPeriod="
				+ classPeriod + ", timeDayIdentifier=" + timeDayIdentifier
				+ ", classroomIdentifier=" + classroomIdentifier + "]";
	}


}
