package api.model;

import java.io.Serializable;

public class R1StaffEmail implements Serializable
{
	private static final long serialVersionUID = 4255199616263324176L;
    
	private String staffEmailRefId;
	private String staffRefId;
	private String emailAddress;
	private String emailTypeCode;
	private boolean primaryEmailAddressIndicator;
		
	public R1StaffEmail() {}

	public String getStaffEmailRefId()
	{
		return staffEmailRefId;
	}

	public void setStaffEmailRefId(String staffEmailRefId)
	{
		this.staffEmailRefId = staffEmailRefId;
	}

	public String getStaffRefId()
	{
		return staffRefId;
	}

	public void setStaffRefId(String staffRefId)
	{
		this.staffRefId = staffRefId;
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

	@Override
	public String toString() {
		return "R1StaffEmail [staffEmailRefId=" + staffEmailRefId
				+ ", staffRefId=" + staffRefId + ", emailAddress="
				+ emailAddress + ", emailTypeCode=" + emailTypeCode
				+ ", primaryEmailAddressIndicator="
				+ primaryEmailAddressIndicator + "]";
	}

	


}
