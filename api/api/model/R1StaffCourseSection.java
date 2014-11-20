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


public class R1StaffCourseSection implements Serializable
{
	private static final long serialVersionUID = 4255194616261324178L;
    
	private String staffCourseSectionRefId;
	private String staffRefId;
	private String courseSectionRefId;
	private boolean teacherOfRecord;
	private BigDecimal contributionPercentage;
	
	
	public R1StaffCourseSection() {}


	public String getStaffCourseSectionRefId() {
		return staffCourseSectionRefId;
	}


	public void setStaffCourseSectionRefId(String staffCourseSectionRefId) {
		this.staffCourseSectionRefId = staffCourseSectionRefId;
	}


	public String getStaffRefId() {
		return staffRefId;
	}


	public void setStaffRefId(String staffRefId) {
		this.staffRefId = staffRefId;
	}


	public String getCourseSectionRefId() {
		return courseSectionRefId;
	}


	public void setCourseSectionRefId(String courseSectionRefId) {
		this.courseSectionRefId = courseSectionRefId;
	}


	public boolean getTeacherOfRecord() {
		return teacherOfRecord;
	}


	public void setTeacherOfRecord(boolean teacherOfRecord) {
		this.teacherOfRecord = teacherOfRecord;
	}


	public BigDecimal getContributionPercentage() {
		return contributionPercentage;
	}


	public void setContributionPercentage(BigDecimal contributionPercentage) {
		this.contributionPercentage = contributionPercentage;
	}


	@Override
	public String toString() {
		return "R1StaffCourseSection [staffCourseSectionRefId="
				+ staffCourseSectionRefId + ", staffRefId=" + staffRefId
				+ ", courseSectionRefId=" + courseSectionRefId
				+ ", teacherOfRecord=" + teacherOfRecord
				+ ", contributionPercentage=" + contributionPercentage + "]";
	}




}
