package api.model;

import java.io.Serializable;

public class R1SchoolTelephone implements Serializable
{
	private static final long serialVersionUID = 4255199616263324176L;
    
	private String schoolPhoneRefId;
	private String schoolRefId;
	private String telephoneNumber;
	private boolean primaryTelephoneNumberIndicator;
	private String telephoneNumberTypeCode;
		
	public R1SchoolTelephone() {}

	public String getSchoolPhoneRefId() {
		return schoolPhoneRefId;
	}

	public void setSchoolPhoneRefId(String schoolPhoneRefId) {
		this.schoolPhoneRefId = schoolPhoneRefId;
	}

	public String getSchoolRefId() {
		return schoolRefId;
	}

	public void setSchoolRefId(String schoolRefId) {
		this.schoolRefId = schoolRefId;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public boolean isPrimaryTelephoneNumberIndicator() {
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
		return "R1SchoolTelephone [schoolPhoneRefId=" + schoolPhoneRefId
				+ ", schoolRefId=" + schoolRefId + ", telephoneNumber="
				+ telephoneNumber + ", primaryTelephoneNumberIndicator="
				+ primaryTelephoneNumberIndicator
				+ ", telephoneNumberTypeCode=" + telephoneNumberTypeCode + "]";
	}

	
}
