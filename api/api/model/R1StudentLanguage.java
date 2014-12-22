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
@Table(name="StudentLanguage")
public class R1StudentLanguage implements Serializable
{
	private static final long serialVersionUID = 4255194616261324178L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="StudentLanguageRefId", unique=true, nullable=false)
	private String studentLanguageRefId;
	
	//@Column(name="StudentRefId")
	private String studentRefId;
	
	@Column(name="LanguageCode")
	private String languageCode;
	
	@Column(name="LanguageUseTypeCode")
	private String languageUseTypeCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="StudentRefId", nullable=false)
	private R1Student r1Student;
	
	//--
	public R1StudentLanguage() {}
	
	public R1StudentLanguage(String studentLanguageRefId, String studentRefId,
			String languageCode, String languageUseTypeCode, R1Student r1Student) 
	{
		this.studentLanguageRefId = studentLanguageRefId;
		this.studentRefId = studentRefId;
		this.languageCode = languageCode;
		this.languageUseTypeCode = languageUseTypeCode;
		this.r1Student = r1Student;
	}

	public String getStudentLanguageRefId() 
	{
		return studentLanguageRefId;
	}

	public void setStudentLanguageRefId(String studentLanguageRefId) 
	{
		this.studentLanguageRefId = studentLanguageRefId;
	}

	public String getStudentRefId() 
	{
		return studentRefId;
	}

	public void setStudentRefId(String studentRefId) 
	{
		this.studentRefId = studentRefId;
	}
	
	public String getLanguageCode() 
	{
		return languageCode;
	}

	public void setLanguageCode(String languageCode) 
	{
		this.languageCode = languageCode;
	}
	
	public String getLanguageUseTypeCode() 
	{
		return languageUseTypeCode;
	}
	
	public void setLanguageUseTypeCode(String languageUseTypeCode) 
	{
		this.languageUseTypeCode = languageUseTypeCode;
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
	public String toString() 
	{
		return "R1StudentLanguage [studentLanguageRefId="
				+ studentLanguageRefId + ", studentRefId=" + studentRefId
				+ ", languageCode=" + languageCode + ", languageUseTypeCode="
				+ languageUseTypeCode + "]";
	}
}
