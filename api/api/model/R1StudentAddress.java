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


public class R1StudentAddress implements Serializable
{
	private static final long serialVersionUID = 4255199616263324176L;
    
	private String studentAddressRefId;
	private String studentRefId;
	private String addressTypeCode;
	private String streetNumberAndName;
	private String apartmentRoomOrSuiteNumber;
	private String city;
	private String stateCode; 
	private String postalCode;
	private String addressCountyName;
	private String countryCode;

		
	public R1StudentAddress() {}

	public String getStudentAddressRefId()
	{
		return studentAddressRefId;
	}

	public void setStudentAddressRefId(String studentAddressRefId)
	{
		this.studentAddressRefId = studentAddressRefId;
	}

	public String getStudentRefId()
	{
		return studentRefId;
	}

	public void setStudentRefId(String studentRefId)
	{
		this.studentRefId = studentRefId;
	}

	public String getAddressTypeCode()
	{
		return addressTypeCode;
	}

	public void setAddressTypeCode(String addressTypeCode)
	{
		this.addressTypeCode = addressTypeCode;
	}

	public String getStreetNumberAndName()
	{
		return streetNumberAndName;
	}

	public void setStreetNumberAndName(String streetNumberAndName)
	{
		this.streetNumberAndName = streetNumberAndName;
	}
	
	
	public String getApartmentRoomOrSuiteNumber()
	{
		return apartmentRoomOrSuiteNumber;
	}

	public void setApartmentRoomOrSuiteNumber(String apartmentRoomOrSuiteNumber)
	{
		this.apartmentRoomOrSuiteNumber = apartmentRoomOrSuiteNumber;
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

	public String getCountryCode()
	{
		return countryCode;
	}

	public void setCountryCode(String countryCode)
	{
		this.countryCode = countryCode;
	}
	
	
	

}
