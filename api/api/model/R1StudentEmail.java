package api.model;

import java.io.Serializable;

public class R1StudentEmail implements Serializable
{
	private static final long serialVersionUID = 4255199616263324176L;
    
	private String studentEmailRefId;
	private String studentRefId;
	private String emailAddress;
	private String emailTypeCode;
	private boolean primaryEmailAddressIdicator;
		
	public R1StudentEmail() {}

	public String getStudentEmailRefId()
	{
		return studentEmailRefId;
	}

	public void setStudentEmailRefId(String studentEmailRefId)
	{
		this.studentEmailRefId = studentEmailRefId;
	}

	public String getStudentRefId()
	{
		return studentRefId;
	}

	public void setStudentRefId(String studentRefId)
	{
		this.studentRefId = studentRefId;
	}

	public String getEmailAddress()
	{
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress = emailAddress;
	}

	public String getEmailTypeCode()
	{
		return emailTypeCode;
	}

	public void setEmailTypeCode(String emailTypeCode)
	{
		this.emailTypeCode = emailTypeCode;
	}

	public boolean isPrimaryEmailAddressIdicator()
	{
		return primaryEmailAddressIdicator;
	}

	public void setPrimaryEmailAddressIdicator(boolean primaryEmailAddressIdicator)
	{
		this.primaryEmailAddressIdicator = primaryEmailAddressIdicator;
	}

	


}
