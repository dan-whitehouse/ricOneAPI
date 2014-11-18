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


public class R1StudentContactAddress implements Serializable
{
	private static final long serialVersionUID = 4255199616263324176L;
    
	private String studentContactAddressRefId;
	private String studentContactRefId;
	private String addressTypeCode;
	private String streetNumberAndName;
	private String apartmentRoomOrSuiteNumber;
	private String city;
	private String stateCode; 
	private String postalCode;
	private String addressCountyName;
	private String countryCode;

		
	public R1StudentContactAddress() {}


	public String getStudentContactAddressRefId() 
	{
		return studentContactAddressRefId;
	}


	public void setStudentContactAddressRefId(String studentContactAddressRefId) 
	{
		this.studentContactAddressRefId = studentContactAddressRefId;
	}


	public String getStudentContactRefId() 
	{
		return studentContactRefId;
	}


	public void setStudentContactRefId(String studentContactRefId) 
	{
		this.studentContactRefId = studentContactRefId;
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


	public String getPostalCode() {
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


	@Override
	public String toString() 
	{
		return "R1StudentContactAddress [studentContactAddressRefId="
				+ studentContactAddressRefId + ", studentContactRefId="
				+ studentContactRefId + ", addressTypeCode=" + addressTypeCode
				+ ", streetNumberAndName=" + streetNumberAndName
				+ ", apartmentRoomOrSuiteNumber=" + apartmentRoomOrSuiteNumber
				+ ", city=" + city + ", stateCode=" + stateCode
				+ ", postalCode=" + postalCode + ", addressCountyName="
				+ addressCountyName + ", countryCode=" + countryCode + "]";
	}
}
