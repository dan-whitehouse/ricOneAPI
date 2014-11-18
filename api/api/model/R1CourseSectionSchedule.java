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


public class R1CourseSectionSchedule implements Serializable
{
	private static final long serialVersionUID = 4255194616261324178L;
    
	private String courseSectionScheduleRefId;
	private String courseSectionRefId;
	private String classMeetingDays;
	private Date classBeginningTime;
	private Date classEndingTime;
	private String classPeriod;
	private String timeDayIdentifier;
	private String classroomIdentifier;
	
	
	public R1CourseSectionSchedule() {}


	public String getCourseSectionScheduleRefId() {
		return courseSectionScheduleRefId;
	}


	public void setCourseSectionScheduleRefId(String courseSectionScheduleRefId) {
		this.courseSectionScheduleRefId = courseSectionScheduleRefId;
	}


	public String getCourseSectionRefId() {
		return courseSectionRefId;
	}


	public void setCourseSectionRefId(String courseSectionRefId) {
		this.courseSectionRefId = courseSectionRefId;
	}


	public String getClassMeetingDays() {
		return classMeetingDays;
	}


	public void setClassMeetingDays(String classMeetingDays) {
		this.classMeetingDays = classMeetingDays;
	}


	public Date getClassBeginningTime() {
		return classBeginningTime;
	}


	public void setClassBeginningTime(Date classBeginningTime) {
		this.classBeginningTime = classBeginningTime;
	}


	public Date getClassEndingTime() {
		return classEndingTime;
	}


	public void setClassEndingTime(Date classEndingTime) {
		this.classEndingTime = classEndingTime;
	}


	public String getClassPeriod() {
		return classPeriod;
	}


	public void setClassPeriod(String classPeriod) {
		this.classPeriod = classPeriod;
	}


	public String getTimeDayIdentifier() {
		return timeDayIdentifier;
	}


	public void setTimeDayIdentifier(String timeDayIdentifier) {
		this.timeDayIdentifier = timeDayIdentifier;
	}


	public String getClassroomIdentifier() {
		return classroomIdentifier;
	}


	public void setClassroomIdentifier(String classroomIdentifier) {
		this.classroomIdentifier = classroomIdentifier;
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
