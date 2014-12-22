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
@Table(name="CourseSection")
public class R1CourseSection implements Serializable
{
	private static final long serialVersionUID = 4255194616261324178L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CourseSectionRefId", unique=true, nullable=false)
	private String courseSectionRefId;	
	
	//@Column(name="SchoolCalendarSessionRefId", nullable=false)
	private String schoolCalendarSessionRefId;
	
	//@Column(name="CourseRefId", nullable=false)
	private String courseRefId;
	
	@Column(name="LEASectionId", nullable=true, length=50)
	private String leaSectionId;
	
	@Column(name="SystemSectionId", nullable=true, length=50)
	private String systemSectionId;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="r1CourseSection")
	private Set<R1StudentCourseSection> r1StudentCourseSections = new HashSet<R1StudentCourseSection>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="r1CourseSection")
	private Set<R1CourseSectionSchedule> r1CourseSectionSchedules = new HashSet<R1CourseSectionSchedule>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="r1CourseSection")
	private Set<R1StaffCourseSection> r1StaffCourseSections = new HashSet<R1StaffCourseSection>(0);
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CourseRefId", nullable=false)
	private R1Course r1Course;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="SchoolCalendarSessionRefId", nullable=false)
	private R1SchoolCalendarSession r1SchoolCalendarSession;
	
	
	//--
	public R1CourseSection() {}


	public R1CourseSection(String courseSectionRefId,
			String schoolCalendarSessionRefId, String courseRefId,
			String leaSectionId, String systemSectionId,
			Set<R1StudentCourseSection> r1StudentCourseSections,
			Set<R1CourseSectionSchedule> r1CourseSectionSchedules,
			Set<R1StaffCourseSection> r1StaffCourseSections, R1Course r1Course,
			R1SchoolCalendarSession r1SchoolCalendarSession) 
	{
		this.courseSectionRefId = courseSectionRefId;
		this.schoolCalendarSessionRefId = schoolCalendarSessionRefId;
		this.courseRefId = courseRefId;
		this.leaSectionId = leaSectionId;
		this.systemSectionId = systemSectionId;
		this.r1StudentCourseSections = r1StudentCourseSections;
		this.r1CourseSectionSchedules = r1CourseSectionSchedules;
		this.r1StaffCourseSections = r1StaffCourseSections;
		this.r1Course = r1Course;
		this.r1SchoolCalendarSession = r1SchoolCalendarSession;
	}





	public String getCourseSectionRefId()
	{
		return courseSectionRefId;
	}

	public void setCourseSectionRefId(String courseSectionRefId)
	{
		this.courseSectionRefId = courseSectionRefId;
	}

	
	public String getSchoolCalendarSessionRefId() 
	{
		return schoolCalendarSessionRefId;
	}


	public void setSchoolCalendarSessionRefId(String schoolCalendarSessionRefId) 
	{
		this.schoolCalendarSessionRefId = schoolCalendarSessionRefId;
	}

	
	public String getCourseRefId() {
		return courseRefId;
	}


	public void setCourseRefId(String courseRefId) 
	{
		this.courseRefId = courseRefId;
	}

	
	public String getLeaSectionId() 
	{
		return leaSectionId;
	}


	public void setLeaSectionId(String leaSectionId) 
	{
		this.leaSectionId = leaSectionId;
	}

	
	
	public String getSystemSectionId() 
	{
		return systemSectionId;
	}


	public void setSystemSectionId(String systemSectionId) 
	{
		this.systemSectionId = systemSectionId;
	}



	
	public Set<R1StudentCourseSection> getR1StudentCourseSections()
	{
		return r1StudentCourseSections;
	}


	public void setR1StudentCourseSections(Set<R1StudentCourseSection> r1StudentCourseSections)
	{
		this.r1StudentCourseSections = r1StudentCourseSections;
	}


	
	public Set<R1StaffCourseSection> getR1StaffCourseSections()
	{
		return r1StaffCourseSections;
	}


	public void setR1StaffCourseSections(Set<R1StaffCourseSection> r1StaffCourseSections)
	{
		this.r1StaffCourseSections = r1StaffCourseSections;
	}


	public Set<R1CourseSectionSchedule> getR1CourseSectionSchedules()
	{
		return r1CourseSectionSchedules;
	}

	public void setR1CourseSectionSchedules(Set<R1CourseSectionSchedule> r1CourseSectionSchedules)
	{
		this.r1CourseSectionSchedules = r1CourseSectionSchedules;
	}


	
	public R1Course getR1Course()
	{
		return r1Course;
	}

	public void setR1Course(R1Course r1Course)
	{
		this.r1Course = r1Course;
	}


	
	public R1SchoolCalendarSession getR1SchoolCalendarSession()
	{
		return r1SchoolCalendarSession;
	}



	public void setR1SchoolCalendarSession(R1SchoolCalendarSession r1SchoolCalendarSession)
	{
		this.r1SchoolCalendarSession = r1SchoolCalendarSession;
	}
	
	//--
	@Override
	public String toString() {
		return "R1CourseSection [schoolCalendarSessionRefId="
				+ schoolCalendarSessionRefId + ", courseRefId=" + courseRefId
				+ ", leaSectionId=" + leaSectionId + ", systemSectionId="
				+ systemSectionId + "]";
	}


}
