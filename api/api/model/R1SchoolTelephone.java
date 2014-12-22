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
@Table(name="SchoolTelephone")
public class R1SchoolTelephone implements Serializable
{
	private static final long serialVersionUID = 4255199616263324176L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SchoolPhoneRefId", unique=true, nullable=false)
	private String schoolPhoneRefId;
	
	//@Column(name="SchoolRefId")
	private String schoolRefId;
	
	@Column(name="TelephoneNumber")
	private String telephoneNumber;
	
	@Column(name="PrimaryTelephoneNumberIndicator")
	private boolean primaryTelephoneNumberIndicator;
	
	@Column(name="TelephoneNumberTypeCode")
	private String telephoneNumberTypeCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="SchoolRefId", nullable=false)
	private R1School r1School;
		
	//--
	public R1SchoolTelephone() {}
	
	

	public R1SchoolTelephone(String schoolPhoneRefId, String schoolRefId,
			String telephoneNumber, boolean primaryTelephoneNumberIndicator,
			String telephoneNumberTypeCode, R1School r1School) 
	{

		this.schoolPhoneRefId = schoolPhoneRefId;
		this.schoolRefId = schoolRefId;
		this.telephoneNumber = telephoneNumber;
		this.primaryTelephoneNumberIndicator = primaryTelephoneNumberIndicator;
		this.telephoneNumberTypeCode = telephoneNumberTypeCode;
		this.r1School = r1School;
	}


	public String getSchoolPhoneRefId() 
	{
		return schoolPhoneRefId;
	}

	public void setSchoolPhoneRefId(String schoolPhoneRefId) 
	{
		this.schoolPhoneRefId = schoolPhoneRefId;
	}

	
	public String getSchoolRefId()
	{
		return schoolRefId;
	}

	public void setSchoolRefId(String schoolRefId)
	{
		this.schoolRefId = schoolRefId;
	}


	public String getTelephoneNumber() 
	{
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) 
	{
		this.telephoneNumber = telephoneNumber;
	}

	
	public boolean isPrimaryTelephoneNumberIndicator() 
	{
		return primaryTelephoneNumberIndicator;
	}

	public void setPrimaryTelephoneNumberIndicator(
			boolean primaryTelephoneNumberIndicator) 
	{
		this.primaryTelephoneNumberIndicator = primaryTelephoneNumberIndicator;
	}

	
	public String getTelephoneNumberTypeCode()
	{
		return telephoneNumberTypeCode;
	}

	public void setTelephoneNumberTypeCode(String telephoneNumberTypeCode)
	{
		this.telephoneNumberTypeCode = telephoneNumberTypeCode;
	}

	
	public R1School getR1School()
	{
		return r1School;
	}

	public void setR1School(R1School r1School)
	{
		this.r1School = r1School;
	}
	
	@Override
	public String toString() {
		return "R1SchoolTelephone [schoolPhoneRefId=" + schoolPhoneRefId
				+ ", schoolRefId=" + schoolRefId + ", telephoneNumber="
				+ telephoneNumber + ", primaryTelephoneNumberIndicator="
				+ primaryTelephoneNumberIndicator
				+ ", telephoneNumberTypeCode=" + telephoneNumberTypeCode + "]";
	}
}
