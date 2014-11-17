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
import java.util.List;
import sif3.common.header.HeaderValues.ServiceType;
import sif3.common.model.EnvironmentKey;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;
import sif3.common.model.ServiceInfo;
import sif3.common.model.ServiceRights.AccessRight;
import sif3.common.model.ServiceRights.AccessType;

public class R1LEA implements Serializable
{
	private static final long serialVersionUID = 4255199616263324177L;
    
	private String leaRefId;
	private String leaId;
	private String leaSEAId;
	private String leaNCESId;
	private String leaName;
		
	public R1LEA() {}
	
	//-----------------------
	public String getLeaRefId()
    {
    	return this.leaRefId;
    }
	
	public void setLeaRefId(String leaRefId)
    {
    	this.leaRefId = leaRefId;
    }
	
	//-----------------------
	public String getLeaId()
    {
    	return this.leaId;
    }
	
	public void setLeaId(String leaId)
    {
    	this.leaId = leaId;
    }
	
	//-----------------------
	public String getLeaSEAId()
    {
    	return this.leaSEAId;
    }
	
	public void setLeaSEAId(String leaSEAId)
    {
    	this.leaSEAId = leaSEAId;
    }
	
	//-----------------------
	public String getLeaNCESId()
    {
    	return this.leaNCESId;
    }
	
	public void setLeaNCESId(String leaNCESId)
    {
    	this.leaNCESId = leaNCESId;
    }
	
	//-----------------------
	public String getLeaName()
    {
    	return this.leaName;
    }
	
	public void setLeaName(String leaName)
    {
    	this.leaName = leaName;
    }
	
	
	
	//---------------------------------------------------
	
	@Override
    public String toString()
    {
		String output = String.format("LEA Output [refID: %1$s], [FN: %2$s], [MN: %3$s], [LN: %4$s]", leaRefId, leaId, leaName, leaSEAId);
	    return output;
    }	
}
