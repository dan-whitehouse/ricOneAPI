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
@Table(name="SchoolIdentifier")
public class R1SchoolIdentifier implements Serializable
{
	private static final long serialVersionUID = 4255199616263324176L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SchoolIdentifierRefId", unique=true, nullable=false)
	private String schoolIdentifierRefId;
	
	//@Column(name="SchoolRefId")
	private String schoolRefId;
	
	@Column(name="IdentificationSystemCode")
	private String identificationSystemCode;
	
	@Column(name="SchoolId")
	private String schoolId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="SchoolRefId", nullable=false)
	private R1School r1School;
	
	//--
	public R1SchoolIdentifier() {}
	
	
	
	public R1SchoolIdentifier(String schoolIdentifierRefId, String schoolRefId,
			String identificationSystemCode, String schoolId, R1School r1School) 
	{
		this.schoolIdentifierRefId = schoolIdentifierRefId;
		this.schoolRefId = schoolRefId;
		this.identificationSystemCode = identificationSystemCode;
		this.schoolId = schoolId;
		this.r1School = r1School;
	}



	
	public String getSchoolIdentifierRefId() 
	{
		return schoolIdentifierRefId;
	}
	
	public void setSchoolIdentifierRefId(String schoolIdentifierRefId) 
	{
		this.schoolIdentifierRefId = schoolIdentifierRefId;
	}
	
	
	public String getSchoolRefId() 
	{
		return schoolRefId;
	}
	
	public void setSchoolRefId(String schoolRefId) 
	{
		this.schoolRefId = schoolRefId;
	}
	
	
	public String getIdentificationSystemCode() 
	{
		return identificationSystemCode;
	}
	
	public void setIdentificationSystemCode(String identificationSystemCode) 
	{
		this.identificationSystemCode = identificationSystemCode;
	}
	
	
	public String getSchoolId() 
	{
		return schoolId;
	}
	
	public void setSchoolId(String schoolId) 
	{
		this.schoolId = schoolId;
	}
	
	public R1School getR1School()
	{
		return r1School;
	}

	public void setR1School(R1School r1School)
	{
		this.r1School = r1School;
	}
	
	//--
	@Override
	public String toString() 
	{
		return "R1SchoolIdentifier [schoolIdentifierRefId="
				+ schoolIdentifierRefId + ", schoolRefId=" + schoolRefId
				+ ", identificationSystemCode=" + identificationSystemCode
				+ ", schoolId=" + schoolId + "]";
	}

}
