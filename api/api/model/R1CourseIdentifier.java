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
@Table(name="CourseIdentifier")
public class R1CourseIdentifier implements Serializable
{
	private static final long serialVersionUID = 4255194616261324178L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CourseIdentifierRefId", unique=true, nullable=false)
	private String courseIdentifierRefId;
	
	//@Column(name="CourseRefId", nullable=false)
	private String courseRefId;
	
	@Column(name="IdentificationSystemCode", nullable=true, length=50)
	private String identificationSystemCode;
	
	@Column(name="CourseId", nullable=true, length=50)
	private String courseId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CourseRefId", nullable=false)
	private R1Course r1Course;
	
	//--
	public R1CourseIdentifier() {}

	
	public R1CourseIdentifier(String courseIdentifierRefId, String courseRefId,
			String identificationSystemCode, String courseId, R1Course r1Course) 
	{

		this.courseIdentifierRefId = courseIdentifierRefId;
		this.courseRefId = courseRefId;
		this.identificationSystemCode = identificationSystemCode;
		this.courseId = courseId;
		this.r1Course = r1Course;
	}



	public String getCourseIdentifierRefId() 
	{
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

	
	public String getCourseId() 
	{
		return courseId;
	}


	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}


	
	public R1Course getR1Course()
	{
		return r1Course;
	}


	public void setR1Course(R1Course r1Course)
	{
		this.r1Course = r1Course;
	}
	
	//--
	@Override
	public String toString() {
		return "R1CourseIdentifier [courseIdentifierRefId="
				+ courseIdentifierRefId + ", courseRefId=" + courseRefId
				+ ", identificationSystemCode=" + identificationSystemCode
				+ ", courseId=" + courseId + "]";
	}
}
