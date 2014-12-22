package api.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="StudentEnrollment")
public class R1StudentEnrollment implements Serializable
{
	private static final long serialVersionUID = 4255199616263324174L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="StudentEnrollmentRefId", unique=true, nullable=false)
	private String studentEnrollmentRefId;
	
	//@Column(name="StudentRefId")
	private String studentRefId;
	
	//@Column(name="SchoolRefId")
	private String schoolRefId;
	
	@Column(name="EntryGradeLevelCode")
	private String entryGradeLevelCode;
	
	@Column(name="EnrollmentStatusCode")
	private String enrollmentStatusCode;
	
	@Column(name="EntryTypeCode")
	private String entryTypeCode;
	
	@Column(name="ExitGradeLevelCode")
	private String exitGradeLevelCode;
	
	@Column(name="ExitOrWithdrawalStatusCode")
	private String exitOrWithdrawalStatusCode;
	
	@Column(name="ExitOrWithdrawalTypeCode")
	private String exitOrWithdrawalTypeCode;
	
	@Column(name="DisplacedStudentStatus")
	private String displacedStudentStatus;
	
	@Column(name="EndOfTermStatusCode")
	private String endOfTermStatusCode;
	
	@Column(name="PromotionReasonCode")
	private String promotionReasonCode;		  
	
	@Column(name="FoodServiceEligibilityCode")
	private String foodServiceEligibilityCode;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "FirstEntryDateIntoUSSchool", length = 10)
	private Date firstEntryDateIntoUSSchool;
	
	@Column(name="HomeRoomIdentifier")
	private String homeRoomIdentifier;
	
	@Column(name="ResponsibleSchoolTypeCode")
	private String responsibleSchoolTypeCode;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="StudentRefId", nullable=false)
	private R1Student r1Student;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="SchoolRefId", nullable=false)
	private R1School r1School;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CounselorRefId")
	private R1Staff r1Staff;
	
			
	//--
	public R1StudentEnrollment() {}
		
	
	public R1StudentEnrollment(String studentEnrollmentRefId,
			String studentRefId, String schoolRefId,
			String entryGradeLevelCode, String enrollmentStatusCode,
			String entryTypeCode, String exitGradeLevelCode,
			String exitOrWithdrawalStatusCode, String exitOrWithdrawalTypeCode,
			String displacedStudentStatus, String endOfTermStatusCode,
			String promotionReasonCode, String foodServiceEligibilityCode,
			Date firstEntryDateIntoUSSchool, String homeRoomIdentifier,
			String responsibleSchoolTypeCode, String counselorRefId,
			R1Student r1Student, R1School r1School) 
	{
		this.studentEnrollmentRefId = studentEnrollmentRefId;
		this.studentRefId = studentRefId;
		this.schoolRefId = schoolRefId;
		this.entryGradeLevelCode = entryGradeLevelCode;
		this.enrollmentStatusCode = enrollmentStatusCode;
		this.entryTypeCode = entryTypeCode;
		this.exitGradeLevelCode = exitGradeLevelCode;
		this.exitOrWithdrawalStatusCode = exitOrWithdrawalStatusCode;
		this.exitOrWithdrawalTypeCode = exitOrWithdrawalTypeCode;
		this.displacedStudentStatus = displacedStudentStatus;
		this.endOfTermStatusCode = endOfTermStatusCode;
		this.promotionReasonCode = promotionReasonCode;
		this.foodServiceEligibilityCode = foodServiceEligibilityCode;
		this.firstEntryDateIntoUSSchool = firstEntryDateIntoUSSchool;
		this.homeRoomIdentifier = homeRoomIdentifier;
		this.responsibleSchoolTypeCode = responsibleSchoolTypeCode;
		this.r1Student = r1Student;
		this.r1School = r1School;
	}
	
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

	public void setEntryTypeCode(String entryTypeCode) 
	{
		this.entryTypeCode = entryTypeCode;
	}
	
	public String getExitGradeLevelCode() 
	{
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
	
	public String getResponsibleSchoolTypeCode()
	{
		return responsibleSchoolTypeCode;
	}

	public void setResponsibleSchoolTypeCode(String responsibleSchoolTypeCode)
	{
		this.responsibleSchoolTypeCode = responsibleSchoolTypeCode;
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

	public R1Staff getR1Staff() 
	{
		return r1Staff;
	}


	public void setR1Staff(R1Staff r1Staff) 
	{
		this.r1Staff = r1Staff;
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

}
