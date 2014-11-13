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


public class R1School implements Serializable
{
	private static final long serialVersionUID = 4255199616263324176L;
    
	private String schoolRefId;
	private String leaRefId;
	private String leaName;
	private String streetNumberAndName;
	private String city;
	private String stateCode; 
	private String postalCode;
	private String addressCountyName;
		
	public R1School() {}
	
	//-----------------------
	public String getSchoolRefId()
    {
    	return this.schoolRefId;
    }
	
	public void setSchoolRefId(String schoolRefId)
    {
    	this.schoolRefId = schoolRefId;
    }
	
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
	public String getLeaName()
    {
    	return this.leaName;
    }
	
	public void setLeaName(String leaName)
    {
    	this.leaName = leaName;
    }
	
	//streetNumberAndName
	public String getStreetNumberAndName()
    {
    	return this.streetNumberAndName;
    }
	
	public void setStreetNumberAndName(String streetNumberAndName)
    {
    	this.streetNumberAndName = streetNumberAndName;
    }
	
	//city
	public String getCity()
    {
    	return this.city;
    }
	
	public void setCity(String city)
    {
    	this.city = city;
    }
	
	//stateCode
	public String getStateCode()
    {
    	return this.stateCode;
    }
	
	public void setStateCode(String stateCode)
    {
    	this.stateCode = stateCode;
    }
	
	//postalCode
	public String getPostalCode()
    {
    	return this.postalCode;
    }
	
	public void setPostalCode(String postalCode)
    {
    	this.postalCode = postalCode;
    }
	
	
	//addressCountyName
	public String getAddressCountyName()
    {
    	return this.addressCountyName;
    }
	
	public void setAddressCountyName(String addressCountyName)
    {
    	this.addressCountyName = addressCountyName;
    }
	
	
	
	@Override
    public String toString()
    {
		String output = String.format("School Output [refID: %1$s], [FN: %2$s], [MN: %3$s], [LN: %4$s]", schoolRefId, leaRefId, leaName, streetNumberAndName);
	    return output;
    }	
}
