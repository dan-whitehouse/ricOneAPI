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
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="StaffCourseSection")
public class R1StaffCourseSection implements Serializable
{
	private static final long serialVersionUID = 4255194616261324178L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="StaffCourseSectionRefId", unique=true, nullable=false)
	private String staffCourseSectionRefId;
	
	//@Column(name="StaffRefId")
	private String staffRefId;
	
	//@Column(name="CourseSectionRefId")
	private String courseSectionRefId;
	
	@Column(name="TeacherOfRecord")
	private boolean teacherOfRecord;
	
	@Column(name="ContributionPercentage")
	private BigDecimal contributionPercentage;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CourseSectionRefId", nullable=false)
	private R1CourseSection r1CourseSection;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="StaffRefId", nullable=false)
	private R1Staff r1Staff;
	
	//--
	public R1StaffCourseSection() {}
	
	public R1StaffCourseSection(String staffCourseSectionRefId,
			String staffRefId, String courseSectionRefId,
			boolean teacherOfRecord, BigDecimal contributionPercentage,
			R1CourseSection r1CourseSection, R1Staff r1Staff) 
	{

		this.staffCourseSectionRefId = staffCourseSectionRefId;
		this.staffRefId = staffRefId;
		this.courseSectionRefId = courseSectionRefId;
		this.teacherOfRecord = teacherOfRecord;
		this.contributionPercentage = contributionPercentage;
		this.r1CourseSection = r1CourseSection;
		this.r1Staff = r1Staff;
	}


	public String getStaffCourseSectionRefId() 
	{
		return staffCourseSectionRefId;
	}


	public void setStaffCourseSectionRefId(String staffCourseSectionRefId) 
	{
		this.staffCourseSectionRefId = staffCourseSectionRefId;
	}

	
	public String getStaffRefId() 
	{
		return staffRefId;
	}

	public void setStaffRefId(String staffRefId) 
	{
		this.staffRefId = staffRefId;
	}

	public String getCourseSectionRefId() 
	{
		return courseSectionRefId;
	}

	public void setCourseSectionRefId(String courseSectionRefId) 
	{
		this.courseSectionRefId = courseSectionRefId;
	}
	
	public boolean getTeacherOfRecord() 
	{
		return teacherOfRecord;
	}

	public void setTeacherOfRecord(boolean teacherOfRecord) 
	{
		this.teacherOfRecord = teacherOfRecord;
	}
	
	public BigDecimal getContributionPercentage() 
	{
		return contributionPercentage;
	}

	public void setContributionPercentage(BigDecimal contributionPercentage) 
	{
		this.contributionPercentage = contributionPercentage;
	}

	public R1CourseSection getR1CourseSection()
	{
		return r1CourseSection;
	}

	public void setR1CourseSection(R1CourseSection r1CourseSection)
	{
		this.r1CourseSection = r1CourseSection;
	}

	public R1Staff getR1Staff()
	{
		return r1Staff;
	}

	public void setR1Staff(R1Staff r1Staff)
	{
		this.r1Staff = r1Staff;
	}

	//--

	@Override
	public String toString() {
		return "R1StaffCourseSection [staffCourseSectionRefId="
				+ staffCourseSectionRefId + ", staffRefId=" + staffRefId
				+ ", courseSectionRefId=" + courseSectionRefId
				+ ", teacherOfRecord=" + teacherOfRecord
				+ ", contributionPercentage=" + contributionPercentage + "]";
	}
}
