package api.model;

import java.io.Serializable;

public class R1LEATelephone implements Serializable
{
	private static final long serialVersionUID = 4255199616263324176L;
    
	private String schoolPhoneRefId;
	private String leaRefId;
	private String telephoneNumber;
	private boolean primaryTelephoneNumberIndicator;
	private String telephoneNumberTypeCode;
		
	public R1LEATelephone() {}

	public String getSchoolPhoneRefId() {
		return schoolPhoneRefId;
	}

	public void setSchoolPhoneRefId(String schoolPhoneRefId) {
		this.schoolPhoneRefId = schoolPhoneRefId;
	}

	public String getLeaRefId() {
		return leaRefId;
	}

	public void setLeaRefId(String leaRefId) {
		this.leaRefId = leaRefId;
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
		return "R1LEATelephone [schoolPhoneRefId=" + schoolPhoneRefId
				+ ", leaRefId=" + leaRefId + ", telephoneNumber="
				+ telephoneNumber + ", primaryTelephoneNumberIndicator="
				+ primaryTelephoneNumberIndicator
				+ ", telephoneNumberTypeCode=" + telephoneNumberTypeCode + "]";
	}

	
}
