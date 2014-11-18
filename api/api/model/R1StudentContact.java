package api.model;

import java.io.Serializable;
import java.util.Date;

public class R1StudentContact implements Serializable
{
	private static final long serialVersionUID = 4255199616263324174L;
    
	private String studentContactRefId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String generationCode;
	private String prefix; 
	private String sexCode;   
	private String languageCode;
	private String languageUseTypeCode;
		

	public R1StudentContact() {}

	//-----------------------
	public String getStudentContactRefId() 
	{
		return studentContactRefId;
	}


	public void setStudentContactRefId(String studentContactRefId) 
	{
		this.studentContactRefId = studentContactRefId;
	}


	public String getFirstName() {
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


	public String getSexCode() 
	{
		return sexCode;
	}


	public void setSexCode(String sexCode) 
	{
		this.sexCode = sexCode;
	}


	public String getLanguageCode() 
	{
		return languageCode;
	}


	public void setLanguageCode(String languageCode) 
	{
		this.languageCode = languageCode;
	}


	public String getLanguageUseTypeCode() 
	{
		return languageUseTypeCode;
	}


	public void setLanguageUseTypeCode(String languageUseTypeCode) 
	{
		this.languageUseTypeCode = languageUseTypeCode;
	}

	
	//---------------------------------------------------
	
	@Override
	public String toString() 
	{
		return "R1StudentContact [studentContactRefId=" + studentContactRefId
				+ ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", generationCode="
				+ generationCode + ", prefix=" + prefix + ", sexCode="
				+ sexCode + ", languageCode=" + languageCode
				+ ", languageUseTypeCode=" + languageUseTypeCode + "]";
	}   
}
