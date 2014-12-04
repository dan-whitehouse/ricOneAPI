package api.model;

import java.io.Serializable;

public class R1LEATelephone implements Serializable
{
	private static final long serialVersionUID = 4255199616263324176L;
    
	private String leaTelephoneRefId;
	private String leaRefId;
	private String telephoneNumber;
	private boolean primaryTelephoneNumberIndicator;
	private String telephoneNumberTypeCode;
	private R1LEA r1Lea;
		
	public R1LEATelephone() {}

	

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
		return "R1LEATelephone [schoolPhoneRefId=" + leaTelephoneRefId
				+ ", leaRefId=" + leaRefId + ", telephoneNumber="
				+ telephoneNumber + ", primaryTelephoneNumberIndicator="
				+ primaryTelephoneNumberIndicator
				+ ", telephoneNumberTypeCode=" + telephoneNumberTypeCode + "]";
	}

	public R1LEA getR1Lea()
	{
		return r1Lea;
	}

	public void setR1Lea(R1LEA r1Lea)
	{
		this.r1Lea = r1Lea;
	}



	public String getLeaTelephoneRefId()
	{
		return leaTelephoneRefId;
	}



	public void setLeaTelephoneRefId(String leaTelephoneRefId)
	{
		this.leaTelephoneRefId = leaTelephoneRefId;
	}

	
}
