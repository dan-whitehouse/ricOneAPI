package api.model;

import java.io.Serializable;
import java.util.Date;

public class R1Student implements Serializable
{
	private static final long serialVersionUID = 4255199616263324174L;
    
	private String studentRefId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String generationCode;
	private String prefix; 
	private Date birthdate;
	private String sexCode;
	private boolean hispanicLatinoEthnicity;
	private String usCitizenshipStatusCode;		   
	private String counselor;
	private String cohortGraduationYear;
	private String gradeLevelCode;
		

	public R1Student() {}


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


	public Date getBirthdate()
	{
		return birthdate;
	}


	public void setBirthdate(Date birthdate)
	{
		this.birthdate = birthdate;
	}


	public String getSexCode()
	{
		return sexCode;
	}


	public void setSexCode(String sexCode)
	{
		this.sexCode = sexCode;
	}


	public boolean isHispanicLatinoEthnicity()
	{
		return hispanicLatinoEthnicity;
	}


	public void setHispanicLatinoEthnicity(boolean hispanicLatinoEthnicity)
	{
		this.hispanicLatinoEthnicity = hispanicLatinoEthnicity;
	}


	public String getUsCitizenshipStatusCode()
	{
		return usCitizenshipStatusCode;
	}


	public void setUsCitizenshipStatusCode(String usCitizenshipStatusCode)
	{
		this.usCitizenshipStatusCode = usCitizenshipStatusCode;
	}


	public String getCounselor()
	{
		return counselor;
	}


	public void setCounselor(String counselor)
	{
		this.counselor = counselor;
	}


	public String getCohortGraduationYear()
	{
		return cohortGraduationYear;
	}


	public void setCohortGraduationYear(String cohortGraduationYear)
	{
		this.cohortGraduationYear = cohortGraduationYear;
	}


	public String getGradeLevelCode()
	{
		return gradeLevelCode;
	}


	public void setGradeLevelCode(String gradeLevelCode)
	{
		this.gradeLevelCode = gradeLevelCode;
	}
		
	
}
