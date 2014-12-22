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
@Table(name="StudentContactEmail")
public class R1StudentContactEmail implements Serializable
{
	private static final long serialVersionUID = 4255199616263324176L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="StudentContactEmailRefId", unique=true, nullable=false)
	private String studentContactEmailRefId;
	
	//@Column(name="StudentContactRefId")
	private String studentContactRefId;
	
	@Column(name="EmailAddress")
	private String emailAddress;
	
	@Column(name="EmailTypeCode")
	private String emailTypeCode;
	
	@Column(name="PrimaryEmailAddressIndicator")
	private boolean primaryEmailAddressIndicator;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="StudentContactRefId", nullable=false)
	private R1StudentContact r1StudentContact;
	
	//--	
	public R1StudentContactEmail() {}
	
	public R1StudentContactEmail(String studentContactEmailRefId,
			String studentContactRefId, String emailAddress,
			String emailTypeCode, boolean primaryEmailAddressIndicator,
			R1StudentContact r1StudentContact) 
	{
		this.studentContactEmailRefId = studentContactEmailRefId;
		this.studentContactRefId = studentContactRefId;
		this.emailAddress = emailAddress;
		this.emailTypeCode = emailTypeCode;
		this.primaryEmailAddressIndicator = primaryEmailAddressIndicator;
		this.r1StudentContact = r1StudentContact;
	}

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

	public R1StudentContact getR1StudentContact()
	{
		return r1StudentContact;
	}

	public void setR1StudentContact(R1StudentContact r1StudentContact)
	{
		this.r1StudentContact = r1StudentContact;
	}
}
