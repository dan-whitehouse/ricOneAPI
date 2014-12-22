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
@Table(name="StudentOtherName")
public class R1StudentOtherName implements Serializable
{
	private static final long serialVersionUID = 4255199616263324174L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="StudentOtherNameRefId", unique=true, nullable=false)
	private String studentOtherNameRefId;
	
	//@Column(name="StudentRefId")
	private String studentRefId;
	
	@Column(name="FirstName")
	private String firstName;
	
	@Column(name="MiddleName")
	private String middleName;
	
	@Column(name="LastName")
	private String lastName;
	
	@Column(name="GenerationCode")
	private String generationCode;
	
	@Column(name="Prefix")
	private String prefix; 
	
	@Column(name="Type")
	private String type;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="StudentRefId", nullable=false)
	private R1Student r1Student;
		
	//--
	public R1StudentOtherName() {}

	public R1StudentOtherName(String studentOtherNameRefId,
			String studentRefId, String firstName, String middleName,
			String lastName, String generationCode, String prefix, String type,
			R1Student r1Student) 
	{
		this.studentOtherNameRefId = studentOtherNameRefId;
		this.studentRefId = studentRefId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.generationCode = generationCode;
		this.prefix = prefix;
		this.type = type;
		this.r1Student = r1Student;
	}

	public String getStudentOtherNameRefId() 
	{
		return studentOtherNameRefId;
	}

	public void setStudentOtherNameRefId(String studentOtherNameRefId) {
		this.studentOtherNameRefId = studentOtherNameRefId;
	}

	public String getStudentRefId() 
	{
		return studentRefId;
	}

	public void setStudentRefId(String studentRefId) 
	{
		this.studentRefId = studentRefId;
	}

	public String getFirstName() 
	{
		return firstName;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	public String getMiddleName() 
	{
		return middleName;
	}

	public void setMiddleName(String middleName) 
	{
		this.middleName = middleName;
	}

	public String getLastName() 
	{
		return lastName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	public String getGenerationCode() 
	{
		return generationCode;
	}

	public void setGenerationCode(String generationCode) 
	{
		this.generationCode = generationCode;
	}

	public String getPrefix() 
	{
		return prefix;
	}

	public void setPrefix(String prefix) 
	{
		this.prefix = prefix;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
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
		return "R1StudentOtherName [studentOtherNameRefId="
				+ studentOtherNameRefId + ", studentRefId=" + studentRefId
				+ ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", generationCode="
				+ generationCode + ", prefix=" + prefix + "]";
	}
}
