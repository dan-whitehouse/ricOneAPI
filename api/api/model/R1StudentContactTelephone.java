package api.model;

import java.io.Serializable;

public class R1StudentContactTelephone implements Serializable
{
	private static final long serialVersionUID = 4255199616263324176L;
    
	private String studentContactPhoneRefId;
	private String studentContactRefId;
	private String telephoneNumber;
	private boolean primaryTelephoneNumberIndicator;
	private String telephoneNumberTypeCode;
	private R1StudentContact r1StudentContact;
	
		
	public R1StudentContactTelephone() {}

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

	public R1StudentContact getR1StudentContact()
	{
		return r1StudentContact;
	}

	public void setR1StudentContact(R1StudentContact r1StudentContact)
	{
		this.r1StudentContact = r1StudentContact;
	}
}
