package api.model;

import java.io.Serializable;
import java.util.Date;

public class R1StudentEnrollment implements Serializable
{
	private static final long serialVersionUID = 4255199616263324174L;
    
	private String studentEnrollmentRefId;
	private String studentRefId;
	private String schoolRefId;
	private String entryGradeLevelCode;
	private String enrollmentStatusCode;
	private String entryTypeCode;
	private String exitGradeLevelCode;
	private String exitOrWithdrawalStatusCode;
	private String exitOrWithdrawalTypeCode;
	private String displacedStudentStatus;
	private String endOfTermStatusCode;
	private String promotionReasonCode;		   
	private String foodServiceEligibilityCode;
	private Date firstEntryDateIntoUSSchool;
	private String homeRoomIdentifier;
	private String responsibleSchoolTypeCode;
	private String counselorRefId;
	private R1Student r1Student;
	private R1School r1School;
		

	public R1StudentEnrollment() {}
		
	//-----------------------
	public String getStudentEnrollmentRefId() 
	{
		return studentEnrollmentRefId;
	}

	public void setStudentEnrollmentRefId(String studentEnrollmentRefId) 
	{
		this.studentEnrollmentRefId = studentEnrollmentRefId;
	}
	
	public String getStudentRefId() 
	{
		return studentRefId;
	}

	public void setStudentRefId(String studentRefId) 
	{
		this.studentRefId = studentRefId;
	}

	public String getSchoolRefId() 
	{
		return schoolRefId;
	}

	public void setSchoolRefId(String schoolRefId) 
	{
		this.schoolRefId = schoolRefId;
	}

	public String getEntryGradeLevelCode() 
	{
		return entryGradeLevelCode;
	}

	public void setEntryGradeLevelCode(String entryGradeLevelCode) 
	{
		this.entryGradeLevelCode = entryGradeLevelCode;
	}

	public String getEnrollmentStatusCode() 
	{
		return enrollmentStatusCode;
	}

	public void setEnrollmentStatusCode(String enrollmentStatusCode) 
	{
		this.enrollmentStatusCode = enrollmentStatusCode;
	}

	public String getEntryTypeCode() 
	{
		return entryTypeCode;
	}

	public void setEntryTypeCode(String entryTypeCode) {
		this.entryTypeCode = entryTypeCode;
	}

	public String getExitGradeLevelCode() {
		return exitGradeLevelCode;
	}

	public void setExitGradeLevelCode(String exitGradeLevelCode) 
	{
		this.exitGradeLevelCode = exitGradeLevelCode;
	}

	public String getExitOrWithdrawalStatusCode() 
	{
		return exitOrWithdrawalStatusCode;
	}

	public void setExitOrWithdrawalStatusCode(String exitOrWithdrawalStatusCode) 
	{
		this.exitOrWithdrawalStatusCode = exitOrWithdrawalStatusCode;
	}

	public String getExitOrWithdrawalTypeCode() {
		return exitOrWithdrawalTypeCode;
	}

	public void setExitOrWithdrawalTypeCode(String exitOrWithdrawalTypeCode) 
	{
		this.exitOrWithdrawalTypeCode = exitOrWithdrawalTypeCode;
	}

	public String getDisplacedStudentStatus() 
	{
		return displacedStudentStatus;
	}

	public void setDisplacedStudentStatus(String displacedStudentStatus) 
	{
		this.displacedStudentStatus = displacedStudentStatus;
	}

	public String getEndOfTermStatusCode() {
		return endOfTermStatusCode;
	}

	public void setEndOfTermStatusCode(String endOfTermStatusCode) 
	{
		this.endOfTermStatusCode = endOfTermStatusCode;
	}

	public String getPromotionReasonCode() 
	{
		return promotionReasonCode;
	}

	public void setPromotionReasonCode(String promotionReasonCode) 
	{
		this.promotionReasonCode = promotionReasonCode;
	}

	public String getFoodServiceEligibilityCode() 
	{
		return foodServiceEligibilityCode;
	}

	public void setFoodServiceEligibilityCode(String foodServiceEligibilityCode) 
	{
		this.foodServiceEligibilityCode = foodServiceEligibilityCode;
	}

	public Date getFirstEntryDateIntoUSSchool() 
	{
		return firstEntryDateIntoUSSchool;
	}

	public void setFirstEntryDateIntoUSSchool(Date firstEntryDateIntoUSSchool) 
	{
		this.firstEntryDateIntoUSSchool = firstEntryDateIntoUSSchool;
	}

	public String getHomeRoomIdentifier() 
	{
		return homeRoomIdentifier;
	}

	public void setHomeRoomIdentifier(String homeRoomIdentifier) 
	{
		this.homeRoomIdentifier = homeRoomIdentifier;
	}	
	
	
	//---------------------------------------------------
	
	public String getResponsibleSchoolTypeCode()
	{
		return responsibleSchoolTypeCode;
	}

	public void setResponsibleSchoolTypeCode(String responsibleSchoolTypeCode)
	{
		this.responsibleSchoolTypeCode = responsibleSchoolTypeCode;
	}

	public String getCounselorRefId()
	{
		return counselorRefId;
	}

	public void setCounselorRefId(String counselorRefId)
	{
		this.counselorRefId = counselorRefId;
	}

	@Override
	public String toString() 
	{
		return "R1StudentEnrollment [studentEnrollmentRefId="
				+ studentEnrollmentRefId + ", studentRefId=" + studentRefId
				+ ", schoolRefId=" + schoolRefId + ", entryGradeLevelCode="
				+ entryGradeLevelCode + ", enrollmentStatusCode="
				+ enrollmentStatusCode + ", entryTypeCode=" + entryTypeCode
				+ ", exitGradeLevelCode=" + exitGradeLevelCode
				+ ", exitOrWithdrawalStatusCode=" + exitOrWithdrawalStatusCode
				+ ", exitOrWithdrawalTypeCode=" + exitOrWithdrawalTypeCode
				+ ", displacedStudentStatus=" + displacedStudentStatus
				+ ", endOfTermStatusCode=" + endOfTermStatusCode
				+ ", promotionReasonCode=" + promotionReasonCode
				+ ", foodServiceEligibilityCode=" + foodServiceEligibilityCode
				+ ", firstEntryDateIntoUSSchool=" + firstEntryDateIntoUSSchool
				+ ", homeRoomIdentifier=" + homeRoomIdentifier + "]";
	}

	public R1Student getR1Student()
	{
		return r1Student;
	}

	public void setR1Student(R1Student r1Student)
	{
		this.r1Student = r1Student;
	}

	public R1School getR1School()
	{
		return r1School;
	}

	public void setR1School(R1School r1School)
	{
		this.r1School = r1School;
	}
}
