package api.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import sif3.common.header.HeaderValues.ServiceType;
import sif3.common.model.EnvironmentKey;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;
import sif3.common.model.ServiceInfo;
import sif3.common.model.ServiceRights.AccessRight;
import sif3.common.model.ServiceRights.AccessType;

@Entity
@Table(name="StudentContactAddress")
public class R1StudentContactAddress implements Serializable
{
	private static final long serialVersionUID = 4255199616263324176L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="StudentContactAddressRefId", unique=true, nullable=false)
	private String studentContactAddressRefId;
	
	//@Column(name="StudentContactRefId")
	private String studentContactRefId;
	
	@Column(name="AddressTypeCode")
	private String addressTypeCode;
	
	@Column(name="StreetNumberAndName")
	private String streetNumberAndName;
	
	@Column(name="ApartmentRoomOrSuiteNumber")
	private String apartmentRoomOrSuiteNumber;
	
	@Column(name="City")
	private String city;
	
	@Column(name="StateCode")
	private String stateCode; 
	
	@Column(name="PostalCode")
	private String postalCode;
	
	@Column(name="AddressCountyName")
	private String addressCountyName;
	
	@Column(name="CountryCode")
	private String countryCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="StudentContactRefId", nullable=false)
	private R1StudentContact r1StudentContact;

	//--
	public R1StudentContactAddress() {}

	public R1StudentContactAddress(String studentContactAddressRefId,
			String studentContactRefId, String addressTypeCode,
			String streetNumberAndName, String apartmentRoomOrSuiteNumber,
			String city, String stateCode, String postalCode,
			String addressCountyName, String countryCode,
			R1StudentContact r1StudentContact) 
	{
		this.studentContactAddressRefId = studentContactAddressRefId;
		this.studentContactRefId = studentContactRefId;
		this.addressTypeCode = addressTypeCode;
		this.streetNumberAndName = streetNumberAndName;
		this.apartmentRoomOrSuiteNumber = apartmentRoomOrSuiteNumber;
		this.city = city;
		this.stateCode = stateCode;
		this.postalCode = postalCode;
		this.addressCountyName = addressCountyName;
		this.countryCode = countryCode;
		this.r1StudentContact = r1StudentContact;
	}

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

	public R1StudentContact getR1StudentContact()
	{
		return r1StudentContact;
	}

	public void setR1StudentContact(R1StudentContact r1StudentContact)
	{
		this.r1StudentContact = r1StudentContact;
	}
	
	//----
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
