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
@Table(name="StudentEmail")
public class R1StudentEmail implements Serializable
{
	private static final long serialVersionUID = 4255199616263324176L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="StudentEmailRefId", unique=true, nullable=false)
	private String studentEmailRefId;
	
	//@Column(name="StudentRefId")
	private String studentRefId;
	
	@Column(name="EmailAddress")
	private String emailAddress;
	
	@Column(name="EmailTypeCode")
	private String emailTypeCode;
	
	@Column(name="PrimaryEmailAddressIndicator")
	private boolean primaryEmailAddressIndicator;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="StudentRefId", nullable=false)
	private R1Student r1Student;
		
	//--
	public R1StudentEmail() {}
	
	public R1StudentEmail(String studentEmailRefId, String studentRefId,
			String emailAddress, String emailTypeCode,
			boolean primaryEmailAddressIndicator, R1Student r1Student) 
	{
		this.studentEmailRefId = studentEmailRefId;
		this.studentRefId = studentRefId;
		this.emailAddress = emailAddress;
		this.emailTypeCode = emailTypeCode;
		this.primaryEmailAddressIndicator = primaryEmailAddressIndicator;
		this.r1Student = r1Student;
	}

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
