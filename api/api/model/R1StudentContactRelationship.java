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
@Table(name="StudentContactRelationship")
public class R1StudentContactRelationship implements Serializable
{
	private static final long serialVersionUID = 4255199616263324174L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="StudentContactRelationshipRefId", unique=true, nullable=false)
	private String studentContactRelationshipRefId;
	
	//@Column(name="StudentRefId")
	private String studentRefId;
	
	//@Column(name="StudentContactRefId")
	private String studentContactRefId;
	
	@Column(name="RelationshipCode")
	private String relationshipCode;
	
	@Column(name="CustodialRelationshipIndicator")
	private boolean custodialRelationshipIndicator;
	
	@Column(name="EmergencyContactIndicator")
	private boolean emergencyContactIndicator;
	
	@Column(name="ContactPriorityNumber")
	private Integer contactPriorityNumber; 
	
	@Column(name="ContactRestrictions")
	private String contactRestrictions;
	
	@Column(name="LivesWithIndicator")
	private boolean livesWithIndicator;
	
	@Column(name="PrimaryContactIndicator")
	private boolean primaryContactIndicator;	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="StudentRefId", nullable=false)
	private R1Student r1Student;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="StudentContactRefId", nullable=false)
	private R1StudentContact r1StudentContact;
	
	//--
	public R1StudentContactRelationship() {}
	
	public R1StudentContactRelationship(String studentContactRelationshipRefId,
			String studentRefId, String studentContactRefId,
			String relationshipCode, boolean custodialRelationshipIndicator,
			boolean emergencyContactIndicator, Integer contactPriorityNumber,
			String contactRestrictions, boolean livesWithIndicator,
			boolean primaryContactIndicator, R1Student r1Student,
			R1StudentContact r1StudentContact) 
	{
		this.studentContactRelationshipRefId = studentContactRelationshipRefId;
		this.studentRefId = studentRefId;
		this.studentContactRefId = studentContactRefId;
		this.relationshipCode = relationshipCode;
		this.custodialRelationshipIndicator = custodialRelationshipIndicator;
		this.emergencyContactIndicator = emergencyContactIndicator;
		this.contactPriorityNumber = contactPriorityNumber;
		this.contactRestrictions = contactRestrictions;
		this.livesWithIndicator = livesWithIndicator;
		this.primaryContactIndicator = primaryContactIndicator;
		this.r1Student = r1Student;
		this.r1StudentContact = r1StudentContact;
	}

	public String getStudentContactRelationshipRefId() 
	{
		return studentContactRelationshipRefId;
	}

	public void setStudentContactRelationshipRefId(String studentContactRelationshipRefId) 
	{
		this.studentContactRelationshipRefId = studentContactRelationshipRefId;
	}
	
	public String getStudentRefId() 
	{
		return studentRefId;
	}

	public void setStudentRefId(String studentRefId) 
	{
		this.studentRefId = studentRefId;
	}

	public String getStudentContactRefId() 
	{
		return studentContactRefId;
	}

	public void setStudentContactRefId(String studentContactRefId) 
	{
		this.studentContactRefId = studentContactRefId;
	}

	public String getRelationshipCode() 
	{
		return relationshipCode;
	}

	public void setRelationshipCode(String relationshipCode) 
	{
		this.relationshipCode = relationshipCode;
	}
	
	public boolean isCustodialRelationshipIndicator() 
	{
		return custodialRelationshipIndicator;
	}

	public void setCustodialRelationshipIndicator(boolean custodialRelationshipIndicator) 
	{
		this.custodialRelationshipIndicator = custodialRelationshipIndicator;
	}

	public boolean isEmergencyContactIndicator() 
	{
		return emergencyContactIndicator;
	}

	public void setEmergencyContactIndicator(boolean emergencyContactIndicator) 
	{
		this.emergencyContactIndicator = emergencyContactIndicator;
	}

	public Integer getContactPriorityNumber() 
	{
		return contactPriorityNumber;
	}

	public void setContactPriorityNumber(int contactPriorityNumber) 
	{
		this.contactPriorityNumber = contactPriorityNumber;
	}
	
	public String getContactRestrictions() 
	{
		return contactRestrictions;
	}
	
	public void setContactRestrictions(String contactRestrictions) 
	{
		this.contactRestrictions = contactRestrictions;
	}

	public boolean isLivesWithIndicator() 
	{
		return livesWithIndicator;
	}

	public void setLivesWithIndicator(boolean livesWithIndicator) 
	{
		this.livesWithIndicator = livesWithIndicator;
	}
	
	public boolean isPrimaryContactIndicator() 
	{
		return primaryContactIndicator;
	}

	public void setPrimaryContactIndicator(boolean primaryContactIndicator) 
	{
		this.primaryContactIndicator = primaryContactIndicator;
	}
	
	public R1Student getR1Student()
	{
		return r1Student;
	}

	public void setR1Student(R1Student r1Student)
	{
		this.r1Student = r1Student;
	}
	
	public R1StudentContact getR1StudentContact()
	{
		return r1StudentContact;
	}

	public void setR1StudentContact(R1StudentContact r1StudentContact)
	{
		this.r1StudentContact = r1StudentContact;
	}
	
	@Override
	public String toString() 
	{
		return "R1StudentContactRelationship [studentContactRelationshipRefId="
				+ studentContactRelationshipRefId + ", studentRefId="
				+ studentRefId + ", studentContactRefId=" + studentContactRefId
				+ ", relationshipCode=" + relationshipCode
				+ ", custodialRelationshipIndicator="
				+ custodialRelationshipIndicator
				+ ", emergencyContactIndicator=" + emergencyContactIndicator
				+ ", contactPriorityNumber=" + contactPriorityNumber
				+ ", contactRestrictions=" + contactRestrictions
				+ ", livesWithIndicator=" + livesWithIndicator
				+ ", primaryContactIndicator=" + primaryContactIndicator + "]";
	}
}
