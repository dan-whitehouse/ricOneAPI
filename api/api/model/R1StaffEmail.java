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
@Table(name="StaffEmail")
public class R1StaffEmail implements Serializable
{
	private static final long serialVersionUID = 4255199616263324176L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="StaffEmailRefId", unique=true, nullable=false)
	private String staffEmailRefId;
	
	//@Column(name="StaffRefId")
	private String staffRefId;
	
	@Column(name="EmailAddress")
	private String emailAddress;
	
	@Column(name="EmailTypeCode")
	private String emailTypeCode;
	
	@Column(name="PrimaryEmailAddressIndicator")
	private boolean primaryEmailAddressIndicator;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="StaffRefId", nullable=false)
	private R1Staff r1Staff;
		
	//--
	public R1StaffEmail() {}


	public R1StaffEmail(String staffEmailRefId, String staffRefId,
			String emailAddress, String emailTypeCode,
			boolean primaryEmailAddressIndicator, R1Staff r1Staff) 
	{
		this.staffEmailRefId = staffEmailRefId;
		this.staffRefId = staffRefId;
		this.emailAddress = emailAddress;
		this.emailTypeCode = emailTypeCode;
		this.primaryEmailAddressIndicator = primaryEmailAddressIndicator;
		this.r1Staff = r1Staff;
	}

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

	public R1Staff getR1Staff()
	{
		return r1Staff;
	}

	public void setR1Staff(R1Staff r1Staff)
	{
		this.r1Staff = r1Staff;
	}

	//--
	@Override
	public String toString() {
		return "R1StaffEmail [staffEmailRefId=" + staffEmailRefId
				+ ", staffRefId=" + staffRefId + ", emailAddress="
				+ emailAddress + ", emailTypeCode=" + emailTypeCode
				+ ", primaryEmailAddressIndicator="
				+ primaryEmailAddressIndicator + "]";
	}
}
