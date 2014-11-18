package api.model;

import java.io.Serializable;

public class R1StudentContactRelationship implements Serializable
{
	private static final long serialVersionUID = 4255199616263324174L;
    
	private String studentContactRelationshipRefId;
	private String studentRefId;
	private String studentContactRefId;
	private String relationshipCode;
	private boolean custodialRelationshipIndicator;
	private boolean emergencyContactIndicator;
	private int contactPriorityNumber; 
	private String contactRestrictions;
	private boolean livesWithIndicator;
	private boolean primaryContactIndicator;		   
		

	public R1StudentContactRelationship() {}

	//-----------------------
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


	public int getContactPriorityNumber() 
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
	
	//---------------------------------------------------
	
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
