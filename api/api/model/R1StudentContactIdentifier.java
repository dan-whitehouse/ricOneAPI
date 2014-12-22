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
@Table(name="StudentContactIdentifier")
public class R1StudentContactIdentifier implements Serializable
{
	private static final long serialVersionUID = 4255194616261324178L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="StudentContactIdentifierRefId", unique=true, nullable=false)
	private String studentContactIdentifierRefId;
	
	//@Column(name="StudentContactRefId")
	private String studentContactRefId;
	
	@Column(name="IdentificationSystemCode")
	private String identificationSystemCode;
	
	@Column(name="StudentContactId")
	private String studentContactId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="StudentContactRefId")
	private R1StudentContact r1StudentContact;
	
	//--
	public R1StudentContactIdentifier() {}


	public R1StudentContactIdentifier(String studentContactIdentifierRefId,
			String studentContactRefId, String identificationSystemCode,
			String studentContactId, R1StudentContact r1StudentContact) 
	{
		this.studentContactIdentifierRefId = studentContactIdentifierRefId;
		this.studentContactRefId = studentContactRefId;
		this.identificationSystemCode = identificationSystemCode;
		this.studentContactId = studentContactId;
		this.r1StudentContact = r1StudentContact;
	}

	public String getStudentContactIdentifierRefId() 
	{
		return studentContactIdentifierRefId;
	}

	public void setStudentContactIdentifierRefId(String studentContactIdentifierRefId) 
	{
		this.studentContactIdentifierRefId = studentContactIdentifierRefId;
	}

	public String getStudentContactRefId() 
	{
		return studentContactRefId;
	}

	public void setStudentContactRefId(String studentContactRefId) 
	{
		this.studentContactRefId = studentContactRefId;
	}

	public String getIdentificationSystemCode() 
	{
		return identificationSystemCode;
	}

	public void setIdentificationSystemCode(String identificationSystemCode) 
	{
		this.identificationSystemCode = identificationSystemCode;
	}
	
	public String getStudentContactId() 
	{
		return studentContactId;
	}

	public void setStudentContactId(String studentContactId) 
	{
		this.studentContactId = studentContactId;
	}
	
	public R1StudentContact getR1StudentContact()
	{
		return r1StudentContact;
	}

	public void setR1StudentContact(R1StudentContact r1StudentContact)
	{
		this.r1StudentContact = r1StudentContact;
	}

	@Override
	public String toString() 
	{
		return "R1StudentContactIdentifier [studentContactIdentifierRefId="
				+ studentContactIdentifierRefId + ", studentContactRefId="
				+ studentContactRefId + ", identificationSystemCode="
				+ identificationSystemCode + ", studentContactId="
				+ studentContactId + "]";
	}
}
