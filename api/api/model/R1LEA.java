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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import sif3.common.header.HeaderValues.ServiceType;
import sif3.common.model.EnvironmentKey;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;
import sif3.common.model.ServiceInfo;
import sif3.common.model.ServiceRights.AccessRight;
import sif3.common.model.ServiceRights.AccessType;

@Entity
@Table(name="LEA")
public class R1LEA implements Serializable
{
	private static final long serialVersionUID = 4255199616263324177L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="LEARefId", unique=true, nullable=false)
	private String leaRefId;
	
	@Column(name="LEAId", nullable=true, length=30)
	private String leaId;
	
	@Column(name="LEASEAId", nullable=true, length=30)
	private String leaSEAId;
	
	@Column(name="LEANCESId", nullable=true, length=30)
	private String leaNCESId;
	
	@Column(name="LEAName", nullable=true, length=60)
	private String leaName;
	
	@Column(name="StreetNumberAndName", nullable=true, length=40)
	private String streetNumberAndName;
	
	@Column(name="City", nullable=true, length=30)
	private String city;
	
	@Column(name="StateCode", nullable=true, length=50)
	private String stateCode;
	
	@Column(name="PostalCode", nullable=true, length=50)
	private String postalCode;
	
	@Column(name="AddressCountyName", nullable=true, length=30)
	private String addressCountyName;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="r1Lea")
	private Set<R1School> r1Schools = new HashSet<R1School>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="r1Lea")
	private Set<R1LEATelephone> r1LEATelephones = new HashSet<R1LEATelephone>(0);
	
	
	//--
	public R1LEA() {}
	
	

	public R1LEA(String leaRefId, String leaId, String leaSEAId,
			String leaNCESId, String leaName, String streetNumberAndName,
			String city, String stateCode, String postalCode,
			String addressCountyName, Set<R1School> r1Schools,
			Set<R1LEATelephone> r1leaTelephones) 
	{
		this.leaRefId = leaRefId;
		this.leaId = leaId;
		this.leaSEAId = leaSEAId;
		this.leaNCESId = leaNCESId;
		this.leaName = leaName;
		this.streetNumberAndName = streetNumberAndName;
		this.city = city;
		this.stateCode = stateCode;
		this.postalCode = postalCode;
		this.addressCountyName = addressCountyName;
		this.r1Schools = r1Schools;
		r1LEATelephones = r1leaTelephones;
	}



	
	public String getLeaRefId()
	{
		return leaRefId;
	}

	public void setLeaRefId(String leaRefId)
	{
		this.leaRefId = leaRefId;
	}

	
	public String getLeaId()
	{
		return leaId;
	}

	public void setLeaId(String leaId)
	{
		this.leaId = leaId;
	}

	
	public String getLeaSEAId()
	{
		return leaSEAId;
	}

	public void setLeaSEAId(String leaSEAId)
	{
		this.leaSEAId = leaSEAId;
	}
	
	
	public String getLeaNCESId()
	{
		return leaNCESId;
	}

	public void setLeaNCESId(String leaNCESId)
	{
		this.leaNCESId = leaNCESId;
	}

	
	public String getLeaName()
	{
		return leaName;
	}

	public void setLeaName(String leaName)
	{
		this.leaName = leaName;
	}

	
	public String getStreetNumberAndName()
	{
		return streetNumberAndName;
	}

	public void setStreetNumberAndName(String streetNumberAndName)
	{
		this.streetNumberAndName = streetNumberAndName;
	}

	
	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	
	public String getStateCode()
	{
		return stateCode;
	}

	public void setStateCode(String stateCode)
	{
		this.stateCode = stateCode;
	}

	
	public String getPostalCode()
	{
		return postalCode;
	}

	public void setPostalCode(String postalCode)
	{
		this.postalCode = postalCode;
	}

	
	public String getAddressCountyName()
	{
		return addressCountyName;
	}

	public void setAddressCountyName(String addressCountyName)
	{
		this.addressCountyName = addressCountyName;
	}

	
	public Set<R1School> getR1Schools()
	{
		return r1Schools;
	}

	public void setR1Schools(Set<R1School> r1Schools)
	{
		this.r1Schools = r1Schools;
	}

	public Set<R1LEATelephone> getR1LEATelephones()
	{
		return r1LEATelephones;
	}

	public void setR1LEATelephones(Set<R1LEATelephone> r1leaTelephones)
	{
		r1LEATelephones = r1leaTelephones;
	}
	
	//-----------------------
	
}
