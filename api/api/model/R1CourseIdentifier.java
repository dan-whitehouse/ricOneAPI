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


public class R1CourseIdentifier implements Serializable
{
	private static final long serialVersionUID = 4255194616261324178L;
    
	private String courseIdentifierRefId;
	private String courseRefId;
	private String identificationSystemCode;
	private String courseId;
	private R1Course r1Course;
	
	
	public R1CourseIdentifier() {}


	public String getCourseIdentifierRefId() {
		return courseIdentifierRefId;
	}


	public void setCourseIdentifierRefId(String courseIdentifierRefId) {
		this.courseIdentifierRefId = courseIdentifierRefId;
	}


	public String getCourseRefId() {
		return courseRefId;
	}


	public void setCourseRefId(String courseRefId) {
		this.courseRefId = courseRefId;
	}


	public String getIdentificationSystemCode() {
		return identificationSystemCode;
	}


	public void setIdentificationSystemCode(String identificationSystemCode) {
		this.identificationSystemCode = identificationSystemCode;
	}


	public String getCourseId() {
		return courseId;
	}


	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}


	@Override
	public String toString() {
		return "R1CourseIdentifier [courseIdentifierRefId="
				+ courseIdentifierRefId + ", courseRefId=" + courseRefId
				+ ", identificationSystemCode=" + identificationSystemCode
				+ ", courseId=" + courseId + "]";
	}


	public R1Course getR1Course()
	{
		return r1Course;
	}


	public void setR1Course(R1Course r1Course)
	{
		this.r1Course = r1Course;
	}
}
