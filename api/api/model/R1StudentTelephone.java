package api.model;

import java.io.Serializable;

public class R1StudentTelephone implements Serializable
{
	private static final long serialVersionUID = 4255199616263324176L;
    
	private String studentPhoneRefId;
	private String studentRefId;
	private String telephoneNumber;
	private boolean primaryTelephoneNumberIndicator;
	private String telephoneNumberTypeCode;
	private R1Student r1Student;
		
	public R1StudentTelephone() {}

	public String getStudentPhoneRefId() {
		return studentPhoneRefId;
	}

	public void setStudentPhoneRefId(String studentPhoneRefId) {
		this.studentPhoneRefId = studentPhoneRefId;
	}

	public String getStudentRefId() {
		return studentRefId;
	}

	public void setStudentRefId(String studentRefId) {
		this.studentRefId = studentRefId;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public boolean getPrimaryTelephoneNumberIndicator() {
		return primaryTelephoneNumberIndicator;
	}

	public void setPrimaryTelephoneNumberIndicator(
			boolean primaryTelephoneNumberIndicator) {
		this.primaryTelephoneNumberIndicator = primaryTelephoneNumberIndicator;
	}

	public String getTelephoneNumberTypeCode() {
		return telephoneNumberTypeCode;
	}

	public void setTelephoneNumberTypeCode(String telephoneNumberTypeCode) {
		this.telephoneNumberTypeCode = telephoneNumberTypeCode;
	}

	@Override
	public String toString() {
		return "R1StudentTelephone [studentPhoneRefId=" + studentPhoneRefId
				+ ", studentRefId=" + studentRefId + ", telephoneNumber="
				+ telephoneNumber + ", primaryTelephoneNumberIndicator="
				+ primaryTelephoneNumberIndicator
				+ ", telephoneNumberTypeCode=" + telephoneNumberTypeCode + "]";
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
