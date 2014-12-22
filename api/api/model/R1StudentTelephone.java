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
@Table(name="StudentTelephone")
public class R1StudentTelephone implements Serializable
{
	private static final long serialVersionUID = 4255199616263324176L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="StudentPhoneRefId", unique=true, nullable=false)
	private String studentPhoneRefId;
	
	//@Column(name="StudentRefId")
	private String studentRefId;
	
	@Column(name="TelephoneNumber")
	private String telephoneNumber;
	
	@Column(name="PrimaryTelephoneNumberIndicator")
	private boolean primaryTelephoneNumberIndicator;
	
	@Column(name="TelephoneNumberTypeCode")
	private String telephoneNumberTypeCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="StudentRefId", nullable=false)
	private R1Student r1Student;
		
	//--
	public R1StudentTelephone() {}

	
	
	public R1StudentTelephone(String studentPhoneRefId, String studentRefId,
			String telephoneNumber, boolean primaryTelephoneNumberIndicator,
			String telephoneNumberTypeCode, R1Student r1Student) 
	{
		this.studentPhoneRefId = studentPhoneRefId;
		this.studentRefId = studentRefId;
		this.telephoneNumber = telephoneNumber;
		this.primaryTelephoneNumberIndicator = primaryTelephoneNumberIndicator;
		this.telephoneNumberTypeCode = telephoneNumberTypeCode;
		this.r1Student = r1Student;
	}

	public String getStudentPhoneRefId() 
	{
		return studentPhoneRefId;
	}

	public void setStudentPhoneRefId(String studentPhoneRefId) {
		this.studentPhoneRefId = studentPhoneRefId;
	}

	
	public String getStudentRefId() 
	{
		return studentRefId;
	}

	public void setStudentRefId(String studentRefId) 
	{
		this.studentRefId = studentRefId;
	}

	
	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) 
	{
		this.telephoneNumber = telephoneNumber;
	}

	
	public boolean getPrimaryTelephoneNumberIndicator() 
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

	
	public R1Student getR1Student()
	{
		return r1Student;
	}

	public void setR1Student(R1Student r1Student)
	{
		this.r1Student = r1Student;
	}

	@Override
	public String toString() {
		return "R1StudentTelephone [studentPhoneRefId=" + studentPhoneRefId
				+ ", studentRefId=" + studentRefId + ", telephoneNumber="
				+ telephoneNumber + ", primaryTelephoneNumberIndicator="
				+ primaryTelephoneNumberIndicator
				+ ", telephoneNumberTypeCode=" + telephoneNumberTypeCode + "]";
	}
}
