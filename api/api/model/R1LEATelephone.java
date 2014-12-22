package api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="LEATelephone")
public class R1LEATelephone implements Serializable
{
	private static final long serialVersionUID = 4255199616263324176L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="LEATelephoneRefId", unique=true, nullable=false)
	private String leaTelephoneRefId;
	
	//@Column(name="LEARefId", nullable=false)
	private String leaRefId;
	
	@Column(name="TelephoneNumber", nullable=true, length=24)
	private String telephoneNumber;
	
	@Column(name="PrimaryTelephoneNumberIndicator", nullable=true)
	private boolean primaryTelephoneNumberIndicator;
	
	@Column(name="TelephoneNumberTypeCode", nullable=true, length=50)
	private String telephoneNumberTypeCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="LEARefId", nullable=false)
	private R1LEA r1Lea;
		
	//--
	public R1LEATelephone() {}

	
	public R1LEATelephone(String leaTelephoneRefId, String leaRefId,
			String telephoneNumber, boolean primaryTelephoneNumberIndicator,
			String telephoneNumberTypeCode, R1LEA r1Lea) 
	{
		this.leaTelephoneRefId = leaTelephoneRefId;
		this.leaRefId = leaRefId;
		this.telephoneNumber = telephoneNumber;
		this.primaryTelephoneNumberIndicator = primaryTelephoneNumberIndicator;
		this.telephoneNumberTypeCode = telephoneNumberTypeCode;
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

	
	public String getLeaRefId()
	{
		return leaRefId;
	}

	public void setLeaRefId(String leaRefId) 
	{
		this.leaRefId = leaRefId;
	}

	
	public String getTelephoneNumber() 
	{
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) 
	{
		this.telephoneNumber = telephoneNumber;
	}

	
	public boolean isPrimaryTelephoneNumberIndicator() 
	{
		return primaryTelephoneNumberIndicator;
	}

	public void setPrimaryTelephoneNumberIndicator(boolean primaryTelephoneNumberIndicator) 
	{
		this.primaryTelephoneNumberIndicator = primaryTelephoneNumberIndicator;
	}

	
	public String getTelephoneNumberTypeCode() 
	{
		return telephoneNumberTypeCode;
	}

	public void setTelephoneNumberTypeCode(String telephoneNumberTypeCode) 
	{
		this.telephoneNumberTypeCode = telephoneNumberTypeCode;
	}

	
	public R1LEA getR1Lea()
	{
		return r1Lea;
	}

	public void setR1Lea(R1LEA r1Lea)
	{
		this.r1Lea = r1Lea;
	}

	//--
	@Override
	public String toString() {
		return "R1LEATelephone [schoolPhoneRefId=" + leaTelephoneRefId
				+ ", leaRefId=" + leaRefId + ", telephoneNumber="
				+ telephoneNumber + ", primaryTelephoneNumberIndicator="
				+ primaryTelephoneNumberIndicator
				+ ", telephoneNumberTypeCode=" + telephoneNumberTypeCode + "]";
	}


	
}
