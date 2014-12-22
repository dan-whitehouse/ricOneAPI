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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

import sif3.common.header.HeaderValues.ServiceType;
import sif3.common.model.EnvironmentKey;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;
import sif3.common.model.ServiceInfo;
import sif3.common.model.ServiceRights.AccessRight;
import sif3.common.model.ServiceRights.AccessType;

@Entity
@Table(name="Course")
public class R1Course implements Serializable
{
	private static final long serialVersionUID = 4255194616261324178L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CourseRefId", unique=true, nullable=false)
	private String courseRefId;
	
	//@Column(name="SchoolRefId", nullable=false)
	private String schoolRefId;
	
	@Column(name="Title", nullable=true, length=60)
	private String title;
	
	@Column(name="Description", nullable=true, length=60)
	private String description;
	
	@Column(name="SubjectCode", nullable=true, length=50)
	private String subjectCode;
	
	@Column(name="CourseApplicableEducationLevelCode", nullable=true, length=50)
	private String courseApplicableEducationLevelCode;
	
	@Column(name="SCEDCourseCode", nullable=true, length=5)
	private String scedCourseCode;
	
	@Column(name="SCEDCourseLevelCode", nullable=true, length=50)
	private String scedCourseLevelCode;
	
	@Column(name="SCEDCourseSubjectAreaCode", nullable=true, length=50)
	private String scedCourseSubjectAreaCode;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="r1Course")
	private Set<R1CourseSection> r1CourseSections = new HashSet<R1CourseSection>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="r1Course")
	private Set<R1CourseIdentifier> r1CourseIdentifiers = new HashSet<R1CourseIdentifier>(0);
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="SchoolRefId", nullable=false)
	private R1School r1School;
	
	//--
	public R1Course() {}
	
	
	public R1Course(String courseRefId, String schoolRefId, String title,
					String description, String subjectCode,
					String courseApplicableEducationLevelCode, String scedCourseCode,
					String scedCourseLevelCode, String scedCourseSubjectAreaCode,
					Set<R1CourseSection> r1CourseSections,
					Set<R1CourseIdentifier> r1CourseIdentifiers, R1School r1School
				   ) 
	{
		this.courseRefId = courseRefId;
		this.schoolRefId = schoolRefId;
		this.title = title;
		this.description = description;
		this.subjectCode = subjectCode;
		this.courseApplicableEducationLevelCode = courseApplicableEducationLevelCode;
		this.scedCourseCode = scedCourseCode;
		this.scedCourseLevelCode = scedCourseLevelCode;
		this.scedCourseSubjectAreaCode = scedCourseSubjectAreaCode;
		this.r1CourseSections = r1CourseSections;
		this.r1CourseIdentifiers = r1CourseIdentifiers;
		this.r1School = r1School;
	}



	
	public String getCourseRefId()
	{
		return courseRefId;
	}


	public void setCourseRefId(String courseRefId)
	{
		this.courseRefId = courseRefId;
	}

	
	public String getSchoolRefId()
	{
		return schoolRefId;
	}


	public void setSchoolRefId(String schoolRefId)
	{
		this.schoolRefId = schoolRefId;
	}

	
	public String getTitle()
	{
		return title;
	}


	public void setTitle(String title)
	{
		this.title = title;
	}

	
	public String getDescription()
	{
		return description;
	}


	public void setDescription(String description)
	{
		this.description = description;
	}

	
	public String getSubjectCode()
	{
		return subjectCode;
	}


	public void setSubjectCode(String subjectCode)
	{
		this.subjectCode = subjectCode;
	}

	
	public String getCourseApplicableEducationLevelCode()
	{
		return courseApplicableEducationLevelCode;
	}


	public void setCourseApplicableEducationLevelCode(String courseApplicableEducationLevelCode)
	{
		this.courseApplicableEducationLevelCode = courseApplicableEducationLevelCode;
	}

	
	public String getScedCourseCode()
	{
		return scedCourseCode;
	}

	public void setScedCourseCode(String scedCourseCode)
	{
		this.scedCourseCode = scedCourseCode;
	}

	
	public String getScedCourseLevelCode()
	{
		return scedCourseLevelCode;
	}


	public void setScedCourseLevelCode(String scedCourseLevelCode)
	{
		this.scedCourseLevelCode = scedCourseLevelCode;
	}

	
	public String getScedCourseSubjectAreaCode()
	{
		return scedCourseSubjectAreaCode;
	}


	public void setScedCourseSubjectAreaCode(String scedCourseSubjectAreaCode)
	{
		this.scedCourseSubjectAreaCode = scedCourseSubjectAreaCode;
	}


	public Set<R1CourseSection> getR1CourseSections()
	{
		return r1CourseSections;
	}


	public void setR1CourseSections(Set<R1CourseSection> r1CourseSections)
	{
		this.r1CourseSections = r1CourseSections;
	}

	public Set<R1CourseIdentifier> getR1CourseIdentifiers()
	{
		return r1CourseIdentifiers;
	}


	public void setR1CourseIdentifiers(Set<R1CourseIdentifier> r1CourseIdentifiers)
	{
		this.r1CourseIdentifiers = r1CourseIdentifiers;
	}
	

	
	public R1School getR1School()
	{
		return r1School;
	}


	public void setR1School(R1School r1School)
	{
		this.r1School = r1School;
	}

	
	
}
