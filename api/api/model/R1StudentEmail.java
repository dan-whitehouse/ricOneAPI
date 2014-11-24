package api.model;

import java.io.Serializable;

public class R1StudentEmail implements Serializable
{
	private static final long serialVersionUID = 4255199616263324176L;
    
	private String studentEmailRefId;
	private String studentRefId;
	private String emailAddress;
	private String emailTypeCode;
	private boolean primaryEmailAddressIndicator;
	private R1Student r1Student;
		
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

	public boolean isPrimaryEmailAddressIndicator()
	{
		return primaryEmailAddressIndicator;
	}

	public void setPrimaryEmailAddressIndicator(boolean primaryEmailAddressIndicator)
	{
		this.primaryEmailAddressIndicator = primaryEmailAddressIndicator;
	}

	public R1Student getR1Student()
	{
		return r1Student;
	}

	public void setR1Student(R1Student r1Student)
	{
		this.r1Student = r1Student;
	}

	


}
