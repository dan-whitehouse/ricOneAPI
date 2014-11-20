package api.model;

import java.io.Serializable;

public class R1StudentEmail implements Serializable
{
	private static final long serialVersionUID = 4255199616263324176L;
    
	private String studentEmailRefId;
	private String studentRefId;
	private String emailAddress;
	private String emailTypeCode;
		
	public R1StudentEmail() {}

	public String getStudentEmailRefId() {
		return studentEmailRefId;
	}

	public void setStudentEmailRefId(String studentEmailRefId) {
		this.studentEmailRefId = studentEmailRefId;
	}

	public String getStudentRefId() {
		return studentRefId;
	}

	public void setStudentRefId(String studentRefId) {
		this.studentRefId = studentRefId;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getEmailTypeCode() {
		return emailTypeCode;
	}

	public void setEmailTypeCode(String emailTypeCode) {
		this.emailTypeCode = emailTypeCode;
	}

	@Override
	public String toString() {
		return "R1StudentEmail [studentEmailRefId=" + studentEmailRefId
				+ ", studentRefId=" + studentRefId + ", emailAddress="
				+ emailAddress + ", emailTypeCode=" + emailTypeCode + "]";
	}


}
