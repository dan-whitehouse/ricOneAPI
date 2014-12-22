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
@Table(name="StudentContactTelephone")
public class R1StudentContactTelephone implements Serializable
{
	private static final long serialVersionUID = 4255199616263324176L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="StudentContactAddressRefId", unique=true, nullable=false)
	private String studentContactPhoneRefId;
	
	//@Column(name="StudentContactRefId")
	private String studentContactRefId;
	
	@Column(name="TelephoneNumber")
	private String telephoneNumber;
	
	@Column(name="PrimaryTelephoneNumberIndicator")
	private boolean primaryTelephoneNumberIndicator;
	
	@Column(name="TelephoneNumberTypeCode")
	private String telephoneNumberTypeCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="StudentContactRefId", nullable=false)
	private R1StudentContact r1StudentContact;
	
	//--
	public R1StudentContactTelephone() {}
	
	public R1StudentContactTelephone(String studentContactPhoneRefId,
			String studentContactRefId, String telephoneNumber,
			boolean primaryTelephoneNumberIndicator,
			String telephoneNumberTypeCode, R1StudentContact r1StudentContact) 
	{
		this.studentContactPhoneRefId = studentContactPhoneRefId;
		this.studentContactRefId = studentContactRefId;
		this.telephoneNumber = telephoneNumber;
		this.primaryTelephoneNumberIndicator = primaryTelephoneNumberIndicator;
		this.telephoneNumberTypeCode = telephoneNumberTypeCode;
		this.r1StudentContact = r1StudentContact;
	}

	public String getStudentContactPhoneRefId() 
	{
		return studentContactPhoneRefId;
	}

	public void setStudentContactPhoneRefId(String studentContactPhoneRefId) 
	{
		this.studentContactPhoneRefId = studentContactPhoneRefId;
	}
	
	public String getStudentContactRefId() 
	{
		return studentContactRefId;
	}

	public void setStudentContactRefId(String studentContactRefId) 
	{
		this.studentContactRefId = studentContactRefId;
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

	public void setPrimaryTelephoneNumberIndicator(boolean primaryTelephoneNumberIndicator) 
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
		return "R1StudentContactTelephone [studentContactPhoneRefId="
				+ studentContactPhoneRefId + ", studentContactRefId="
				+ studentContactRefId + ", telephoneNumber=" + telephoneNumber
				+ ", primaryTelephoneNumberIndicator="
				+ primaryTelephoneNumberIndicator
				+ ", telephoneNumberTypeCode=" + telephoneNumberTypeCode + "]";
	}
}
