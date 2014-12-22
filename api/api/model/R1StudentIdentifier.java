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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="StudentIdentifier")
public class R1StudentIdentifier implements Serializable
{
	private static final long serialVersionUID = 4255194616261324178L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="StudentIdentifierRefId", unique=true, nullable=false)
	private String studentIdentifierRefId;
	
	//@Column(name="StudentRefId")
	private String studentRefId;
	
	@Column(name="IdentificationSystemCode")
	private String identificationSystemCode;
	
	@Column(name="StudentId")
	private String studentId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="StudentRefId", nullable=false)
	private R1Student r1Student;
	
	//--
	public R1StudentIdentifier() {}

	public R1StudentIdentifier(String studentIdentifierRefId,
			String studentRefId, String identificationSystemCode,
			String studentId, R1Student r1Student) 
	{
		this.studentIdentifierRefId = studentIdentifierRefId;
		this.studentRefId = studentRefId;
		this.identificationSystemCode = identificationSystemCode;
		this.studentId = studentId;
		this.r1Student = r1Student;
	}

	public String getStudentIdentifierRefId() 
	{
		return studentIdentifierRefId;
	}

	public void setStudentIdentifierRefId(String studentIdentifierRefId) {
		this.studentIdentifierRefId = studentIdentifierRefId;
	}
	
	public String getStudentRefId() 
	{
		return studentRefId;
	}

	public void setStudentRefId(String studentRefId) 
	{
		this.studentRefId = studentRefId;
	}

	public String getIdentificationSystemCode() 
	{
		return identificationSystemCode;
	}

	public void setIdentificationSystemCode(String identificationSystemCode) 
	{
		this.identificationSystemCode = identificationSystemCode;
	}

	public String getStudentId() 
	{
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public R1Student getR1Student()
	{
		return r1Student;
	}

	public void setR1Student(R1Student r1Student)
	{
		this.r1Student = r1Student;
	}
	
	@Override
	public String toString() {
		return "R1StudentIdentifier [studentIdentifierRefId="
				+ studentIdentifierRefId + ", studentRefId=" + studentRefId
				+ ", identificationSystemCode=" + identificationSystemCode
				+ ", studentId=" + studentId + "]";
	}
}
