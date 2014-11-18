package api.model;

import java.io.Serializable;

public class R1StudentContactEmail implements Serializable
{
	private static final long serialVersionUID = 4255199616263324176L;
    
	private String studentContactEmailRefId;
	private String studentContactRefId;
	private String emailAddress;
	private boolean emailTypeCode;
		
	public R1StudentContactEmail() {}

	public String getStudentContactEmailRefId() 
	{
		return studentContactEmailRefId;
	}

	public void setStudentContactEmailRefId(String studentContactEmailRefId) 
	{
		this.studentContactEmailRefId = studentContactEmailRefId;
	}

	public String getStudentContactRefId() 
	{
		return studentContactRefId;
	}

	public void setStudentContactRefId(String studentContactRefId) 
	{
		this.studentContactRefId = studentContactRefId;
	}

	public String getEmailAddress() 
	{
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) 
	{
		this.emailAddress = emailAddress;
	}

	public boolean isEmailTypeCode() 
	{
		return emailTypeCode;
	}

	public void setEmailTypeCode(boolean emailTypeCode) 
	{
		this.emailTypeCode = emailTypeCode;
	}

	@Override
	public String toString() 
	{
		return "R1StudentContactEmail [studentContactEmailRefId="
				+ studentContactEmailRefId + ", studentContactRefId="
				+ studentContactRefId + ", emailAddress=" + emailAddress
				+ ", emailTypeCode=" + emailTypeCode + "]";
	}
}
