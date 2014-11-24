package api.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class R1Staff implements Serializable
{
	private static final long serialVersionUID = 4255199616263324179L;
    
	private String staffRefId;	
	private String firstName;
	private String middleName;
	private String lastName;
	private String generationCode;
	private String prefix; 
	private Date birthdate;
	private String sexCode;
	private boolean hispanicLatinoEthnicity;
	private String usCitizenshipStatusCode;	
	private Set<R1StaffCourseSection> r1StaffCourseSections = new HashSet<R1StaffCourseSection>(0);
	private Set<R1StaffEmail> r1StaffEmails = new HashSet<R1StaffEmail>(0);
	private Set<R1StaffIdentifier> r1StaffIdentifiers = new HashSet<R1StaffIdentifier>(0);
	private Set<R1StaffAssignment> r1StaffAssignments = new HashSet<R1StaffAssignment>(0);
		

	public R1Staff() {}
		
	//-----------------------
	public String getStaffRefId()
    {
    	return this.staffRefId;
    }
	
	public void setStaffRefId(String staffRefId)
    {
    	this.staffRefId = staffRefId;
    }
	
	//-----------------------
	public String getFirstName()
    {
    	return this.firstName;
    }
	
	public void setFirstName(String firstName)
    {
    	this.firstName = firstName;
    }
	
	//-----------------------
	public String getMiddleName()
    {
    	return this.middleName;
    }
	
	public void setMiddleName(String middleName)
    {
    	this.middleName = middleName;
    }
	
	//-----------------------	
	public String getLastName()
    {
    	return this.lastName;
    }	
	
	public void setLastName(String lastName)
    {
    	this.lastName = lastName;
    }
	
	//-----------------------
	public String getGenerationCode()
    {
    	return this.generationCode;
    }
	
	public void setGenerationCode(String generationCode)
    {
    	this.generationCode = generationCode;
    }
	
	//-----------------------
	public String getPrefix()
    {
    	return this.prefix;
    }
	
	public void setPrefix(String prefix)
    {
    	this.prefix = prefix;
    }
	
	//-----------------------
	public Date getBirthdate()
    {
    	return this.birthdate;
    }
	
	public void setBirthdate(Date birthdate)
    {
    	this.birthdate = birthdate;
    }
	
	//-----------------------
	public String getSexCode()
    {
    	return this.sexCode;
    }
	
	public void setSexCode(String sexCode)
    {
    	this.sexCode = sexCode;
    }
	
	//-----------------------
	public boolean getHispanicLatinoEthnicity()
    {
    	return this.hispanicLatinoEthnicity;
    }
	
	public void setHispanicLatinoEthnicity(boolean hispanicLatinoEthnicity)
    {
    	this.hispanicLatinoEthnicity = hispanicLatinoEthnicity;
    }
	
	//-----------------------
	public String getUsCitizenshipStatusCode()
    {
    	return this.usCitizenshipStatusCode;
    }
	
	public void setUsCitizenshipStatusCode(String usCitizenshipStatusCode)
    {
    	this.usCitizenshipStatusCode = usCitizenshipStatusCode;
    }
	
	@Override
	public String toString() {
		return "R1Staff [staffRefId=" + staffRefId + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName
				+ ", generationCode=" + generationCode + ", prefix=" + prefix
				+ ", birthdate=" + birthdate + ", sexCode=" + sexCode
				+ ", hispanicLatinoEthnicity=" + hispanicLatinoEthnicity
				+ ", usCitizenshipStatusCode=" + usCitizenshipStatusCode + "]";
	}

	public Set<R1StaffCourseSection> getR1StaffCourseSections()
	{
		return r1StaffCourseSections;
	}

	public void setR1StaffCourseSections(Set<R1StaffCourseSection> r1StaffCourseSections)
	{
		this.r1StaffCourseSections = r1StaffCourseSections;
	}

	public Set<R1StaffEmail> getR1StaffEmails()
	{
		return r1StaffEmails;
	}

	public void setR1StaffEmails(Set<R1StaffEmail> r1StaffEmails)
	{
		this.r1StaffEmails = r1StaffEmails;
	}

	public Set<R1StaffIdentifier> getR1StaffIdentifiers()
	{
		return r1StaffIdentifiers;
	}

	public void setR1StaffIdentifiers(Set<R1StaffIdentifier> r1StaffIdentifiers)
	{
		this.r1StaffIdentifiers = r1StaffIdentifiers;
	}

	public Set<R1StaffAssignment> getR1StaffAssignments()
	{
		return r1StaffAssignments;
	}

	public void setR1StaffAssignments(Set<R1StaffAssignment> r1StaffAssignments)
	{
		this.r1StaffAssignments = r1StaffAssignments;
	}


	
   

	
}
