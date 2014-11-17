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
import java.util.List;
import sif3.common.header.HeaderValues.ServiceType;
import sif3.common.model.EnvironmentKey;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;
import sif3.common.model.ServiceInfo;
import sif3.common.model.ServiceRights.AccessRight;
import sif3.common.model.ServiceRights.AccessType;


public class R1Course implements Serializable
{
	private static final long serialVersionUID = 4255194616261324178L;
    
	private String courseRefId;
	private String schoolRefId;
	private String leaCourseId;
	private String title;
	private String description;
	private String subjectCode;
	private String courseApplicableEducationLevelCode;
	private String scedCourseLevelCode;
	private String scedCourseSubjectAreaCode;
	
	
	public R1Course() {}
	
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


	public String getLeaCourseId()
	{
		return leaCourseId;
	}


	public void setLeaCourseId(String leaCourseId)
	{
		this.leaCourseId = leaCourseId;
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

}
