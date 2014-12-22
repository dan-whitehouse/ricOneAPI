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
@Table(name="StudentHealth")
public class R1StudentHealth implements Serializable
{
	private static final long serialVersionUID = 4255199616263324174L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="StudentHealthRefId", unique=true, nullable=false)
	private String studentHealthRefId;
	
	//@Column(name="StudentRefId")
	private String studentRefId;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "VisionScreeningDate", length = 10)
	private Date visionScreeningDate;
	
	@Column(name="VisionScreeningStatusCode")
	private String visionScreeningStatusCode;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "HearingScreeningDate", length = 10)
	private Date hearingScreeningDate;
	
	@Column(name="HearingScreeningStatusCode")
	private String hearingScreeningStatusCode;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DentalScreeningDate", length = 10)
	private Date dentalScreeningDate;
	
	@Column(name="DentalScreeningStatusCode")
	private String dentalScreeningStatusCode;
	
	@Column(name="HealthInsuranceCoverageCode")
	private String healthInsuranceCoverageCode;
	
	@Column(name="DentalInsuranceCoverageTypeCode")
	private String dentalInsuranceCoverageTypeCode;		   
	
	@Column(name="MedicalAlertIndicatorCode")
	private String medicalAlertIndicatorCode;
	
	@Column(name="HealthScreeningEquipmentUsed")
	private String healthScreeningEquipmentUsed;
	
	@Column(name="HealthScreeningFollowUpRecommendation")
	private String healthScreeningFollowUpRecommendation;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="StudentRefId", nullable=false)
	private R1Student r1Student;
		
	//--
	public R1StudentHealth() {}

	public R1StudentHealth(String studentHealthRefId, String studentRefId,
			Date visionScreeningDate, String visionScreeningStatusCode,
			Date hearingScreeningDate, String hearingScreeningStatusCode,
			Date dentalScreeningDate, String dentalScreeningStatusCode,
			String healthInsuranceCoverageCode,
			String dentalInsuranceCoverageTypeCode,
			String medicalAlertIndicatorCode,
			String healthScreeningEquipmentUsed,
			String healthScreeningFollowUpRecommendation, R1Student r1Student) 
	{
		this.studentHealthRefId = studentHealthRefId;
		this.studentRefId = studentRefId;
		this.visionScreeningDate = visionScreeningDate;
		this.visionScreeningStatusCode = visionScreeningStatusCode;
		this.hearingScreeningDate = hearingScreeningDate;
		this.hearingScreeningStatusCode = hearingScreeningStatusCode;
		this.dentalScreeningDate = dentalScreeningDate;
		this.dentalScreeningStatusCode = dentalScreeningStatusCode;
		this.healthInsuranceCoverageCode = healthInsuranceCoverageCode;
		this.dentalInsuranceCoverageTypeCode = dentalInsuranceCoverageTypeCode;
		this.medicalAlertIndicatorCode = medicalAlertIndicatorCode;
		this.healthScreeningEquipmentUsed = healthScreeningEquipmentUsed;
		this.healthScreeningFollowUpRecommendation = healthScreeningFollowUpRecommendation;
		this.r1Student = r1Student;
	}

	public String getStudentHealthRefId() 
	{
		return studentHealthRefId;
	}

	public void setStudentHealthRefId(String studentHealthRefId) 
	{
		this.studentHealthRefId = studentHealthRefId;
	}

	public String getStudentRefId() 
	{
		return studentRefId;
	}

	public void setStudentRefId(String studentRefId) 
	{
		this.studentRefId = studentRefId;
	}
	
	public Date getVisionScreeningDate() 
	{
		return visionScreeningDate;
	}

	public void setVisionScreeningDate(Date visionScreeningDate) 
	{
		this.visionScreeningDate = visionScreeningDate;
	}

	public String getVisionScreeningStatusCode() 
	{
		return visionScreeningStatusCode;
	}

	public void setVisionScreeningStatusCode(String visionScreeningStatusCode) 
	{
		this.visionScreeningStatusCode = visionScreeningStatusCode;
	}

	public Date getHearingScreeningDate() 
	{
		return hearingScreeningDate;
	}

	public void setHearingScreeningDate(Date hearingScreeningDate) 
	{
		this.hearingScreeningDate = hearingScreeningDate;
	}
	
	public String getHearingScreeningStatusCode() 
	{
		return hearingScreeningStatusCode;
	}

	public void setHearingScreeningStatusCode(String hearingScreeningStatusCode) 
	{
		this.hearingScreeningStatusCode = hearingScreeningStatusCode;
	}

	public Date getDentalScreeningDate() 
	{
		return dentalScreeningDate;
	}

	public void setDentalScreeningDate(Date dentalScreeningDate) 
	{
		this.dentalScreeningDate = dentalScreeningDate;
	}
	
	public String getDentalScreeningStatusCode() 
	{
		return dentalScreeningStatusCode;
	}

	public void setDentalScreeningStatusCode(String dentalScreeningStatusCode) 
	{
		this.dentalScreeningStatusCode = dentalScreeningStatusCode;
	}

	public String getHealthInsuranceCoverageCode() 
	{
		return healthInsuranceCoverageCode;
	}

	public void setHealthInsuranceCoverageCode(String healthInsuranceCoverageCode) 
	{
		this.healthInsuranceCoverageCode = healthInsuranceCoverageCode;
	}
	
	public String getDentalInsuranceCoverageTypeCode() 
	{
		return dentalInsuranceCoverageTypeCode;
	}

	public void setDentalInsuranceCoverageTypeCode(String dentalInsuranceCoverageTypeCode) 
	{
		this.dentalInsuranceCoverageTypeCode = dentalInsuranceCoverageTypeCode;
	}

	public String getMedicalAlertIndicatorCode() 
	{
		return medicalAlertIndicatorCode;
	}

	public void setMedicalAlertIndicatorCode(String medicalAlertIndicatorCode) 
	{
		this.medicalAlertIndicatorCode = medicalAlertIndicatorCode;
	}

	public String getHealthScreeningEquipmentUsed() 
	{
		return healthScreeningEquipmentUsed;
	}

	public void setHealthScreeningEquipmentUsed(String healthScreeningEquipmentUsed) 
	{
		this.healthScreeningEquipmentUsed = healthScreeningEquipmentUsed;
	}

	public String getHealthScreeningFollowUpRecommendation() 
	{
		return healthScreeningFollowUpRecommendation;
	}

	public void setHealthScreeningFollowUpRecommendation(String healthScreeningFollowUpRecommendation) 
	{
		this.healthScreeningFollowUpRecommendation = healthScreeningFollowUpRecommendation;
	}

	public R1Student getR1Student()
	{
		return r1Student;
	}

	public void setR1Student(R1Student r1Student)
	{
		this.r1Student = r1Student;
	}
		
	@Override
	public String toString() {
		return "R1StudentHealth [studentHealthRefId=" + studentHealthRefId
				+ ", studentRefId=" + studentRefId + ", visionScreeningDate="
				+ visionScreeningDate + ", visionScreeningStatusCode="
				+ visionScreeningStatusCode + ", hearingScreeningDate="
				+ hearingScreeningDate + ", hearingScreeningStatusCode="
				+ hearingScreeningStatusCode + ", dentalScreeningDate="
				+ dentalScreeningDate + ", dentalScreeningStatusCode="
				+ dentalScreeningStatusCode + ", healthInsuranceCoverageCode="
				+ healthInsuranceCoverageCode
				+ ", dentalInsuranceCoverageTypeCode="
				+ dentalInsuranceCoverageTypeCode
				+ ", medicalAlertIndicatorCode=" + medicalAlertIndicatorCode
				+ ", healthScreeningEquipmentUsed="
				+ healthScreeningEquipmentUsed
				+ ", healthScreeningFollowUpRecommendation="
				+ healthScreeningFollowUpRecommendation + "]";
	}
}
