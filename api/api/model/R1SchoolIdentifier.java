package api.model;

import java.io.Serializable;

public class R1SchoolIdentifier implements Serializable
{
	private static final long serialVersionUID = 4255199616263324176L;
    
	private String schoolIdentifierRefId;
	private String schoolRefId;
	private String identificationSystemCode;
	private String schoolId;
	
	public R1SchoolIdentifier() {}
	
	public String getSchoolIdentifierRefId() {
		return schoolIdentifierRefId;
	}
	public void setSchoolIdentifierRefId(String schoolIdentifierRefId) {
		this.schoolIdentifierRefId = schoolIdentifierRefId;
	}
	public String getSchoolRefId() {
		return schoolRefId;
	}
	public void setSchoolRefId(String schoolRefId) {
		this.schoolRefId = schoolRefId;
	}
	public String getIdentificationSystemCode() {
		return identificationSystemCode;
	}
	public void setIdentificationSystemCode(String identificationSystemCode) {
		this.identificationSystemCode = identificationSystemCode;
	}
	public String getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	
	@Override
	public String toString() {
		return "R1SchoolIdentifier [schoolIdentifierRefId="
				+ schoolIdentifierRefId + ", schoolRefId=" + schoolRefId
				+ ", identificationSystemCode=" + identificationSystemCode
				+ ", schoolId=" + schoolId + "]";
	}
}
