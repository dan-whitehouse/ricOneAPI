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


public class R1StudentContactIdentifier implements Serializable
{
	private static final long serialVersionUID = 4255194616261324178L;
    
	private String studentContactIdentifierRefId;
	private String studentContactRefId;
	private String identificationSystemCode;
	private String studentContactId;
	
	
	public R1StudentContactIdentifier() {}


	public String getStudentContactIdentifierRefId() {
		return studentContactIdentifierRefId;
	}


	public void setStudentContactIdentifierRefId(
			String studentContactIdentifierRefId) {
		this.studentContactIdentifierRefId = studentContactIdentifierRefId;
	}


	public String getStudentContactRefId() {
		return studentContactRefId;
	}


	public void setStudentContactRefId(String studentContactRefId) {
		this.studentContactRefId = studentContactRefId;
	}


	public String getIdentificationSystemCode() {
		return identificationSystemCode;
	}


	public void setIdentificationSystemCode(String identificationSystemCode) {
		this.identificationSystemCode = identificationSystemCode;
	}


	public String getStudentContactId() {
		return studentContactId;
	}


	public void setStudentContactId(String studentContactId) {
		this.studentContactId = studentContactId;
	}


	@Override
	public String toString() {
		return "R1StudentContactIdentifier [studentContactIdentifierRefId="
				+ studentContactIdentifierRefId + ", studentContactRefId="
				+ studentContactRefId + ", identificationSystemCode="
				+ identificationSystemCode + ", studentContactId="
				+ studentContactId + "]";
	}




	
}
