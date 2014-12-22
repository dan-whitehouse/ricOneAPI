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
@Table(name="StaffIdentifier")
public class R1StaffIdentifier implements Serializable
{
	private static final long serialVersionUID = 4255194616261324178L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="StaffIdentifierRefId", unique=true, nullable=false)
	private String staffIdentifierRefId;
	
	//@Column(name="StaffRefId")
	private String staffRefId;
	
	@Column(name="IdentificationSystemCode")
	private String identificationSystemCode;
	
	@Column(name="StaffId")
	private String staffId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="StaffRefId", nullable=false)
	private R1Staff r1Staff;
	
	//--
	public R1StaffIdentifier() {}

	public R1StaffIdentifier(String staffIdentifierRefId, String staffRefId,
			String identificationSystemCode, String staffId, R1Staff r1Staff) 
	{
		this.staffIdentifierRefId = staffIdentifierRefId;
		this.staffRefId = staffRefId;
		this.identificationSystemCode = identificationSystemCode;
		this.staffId = staffId;
		this.r1Staff = r1Staff;
	}

	public String getStaffIdentifierRefId() 
	{
		return staffIdentifierRefId;
	}

	public void setStaffIdentifierRefId(String staffIdentifierRefId) 
	{
		this.staffIdentifierRefId = staffIdentifierRefId;
	}
	
	public String getStaffRefId() 
	{
		return staffRefId;
	}

	public void setStaffRefId(String staffRefId) {
		this.staffRefId = staffRefId;
	}
	
	public String getIdentificationSystemCode() 
	{
		return identificationSystemCode;
	}

	public void setIdentificationSystemCode(String identificationSystemCode) 
	{
		this.identificationSystemCode = identificationSystemCode;
	}
	
	public String getStaffId() 
	{
		return staffId;
	}

	public void setStaffId(String staffId) 
	{
		this.staffId = staffId;
	}

	public R1Staff getR1Staff()
	{
		return r1Staff;
	}

	public void setR1Staff(R1Staff r1Staff)
	{
		this.r1Staff = r1Staff;
	}

	//--
	@Override
	public String toString() {
		return "R1StaffIdentifier [staffIdentifierRefId="
				+ staffIdentifierRefId + ", staffRefId=" + staffRefId
				+ ", identificationSystemCode=" + identificationSystemCode
				+ ", staffId=" + staffId + "]";
	}


	
}
