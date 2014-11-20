package api.model;

import java.io.Serializable;

public class R1StudentOtherName implements Serializable
{
	private static final long serialVersionUID = 4255199616263324174L;
    
	private String studentOtherNameRefId;
	private String studentRefId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String generationCode;
	private String prefix; 
		

	public R1StudentOtherName() {}


	public String getStudentOtherNameRefId() {
		return studentOtherNameRefId;
	}


	public void setStudentOtherNameRefId(String studentOtherNameRefId) {
		this.studentOtherNameRefId = studentOtherNameRefId;
	}


	public String getStudentRefId() {
		return studentRefId;
	}


	public void setStudentRefId(String studentRefId) {
		this.studentRefId = studentRefId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getGenerationCode() {
		return generationCode;
	}


	public void setGenerationCode(String generationCode) {
		this.generationCode = generationCode;
	}


	public String getPrefix() {
		return prefix;
	}


	public void setPrefix(String prefix) {
		this.prefix = prefix;
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
