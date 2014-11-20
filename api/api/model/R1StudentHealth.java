package api.model;

import java.io.Serializable;
import java.util.Date;

public class R1StudentHealth implements Serializable
{
	private static final long serialVersionUID = 4255199616263324174L;
    
	private String studentHealthRefId;
	private String studentRefId;
	private Date visionScreeningDate;
	private String visionScreeningStatusCode;
	private Date hearingScreeningDate;
	private String hearingScreeningStatusCode; 
	private Date dentalScreeningDate;
	private String dentalScreeningStatusCode;
	private String healthInsuranceCoverageCode;
	private String dentalInsuranceCoverageTypeCode;		   
	private String medicalAlertIndicatorCode;
	private String healthScreeningEquipmentUsed;
	private String healthScreeningFollowUpRecommendation;
		

	public R1StudentHealth() {}


	public String getStudentHealthRefId() {
		return studentHealthRefId;
	}


	public void setStudentHealthRefId(String studentHealthRefId) {
		this.studentHealthRefId = studentHealthRefId;
	}


	public String getStudentRefId() {
		return studentRefId;
	}


	public void setStudentRefId(String studentRefId) {
		this.studentRefId = studentRefId;
	}


	public Date getVisionScreeningDate() {
		return visionScreeningDate;
	}


	public void setVisionScreeningDate(Date visionScreeningDate) {
		this.visionScreeningDate = visionScreeningDate;
	}


	public String getVisionScreeningStatusCode() {
		return visionScreeningStatusCode;
	}


	public void setVisionScreeningStatusCode(String visionScreeningStatusCode) {
		this.visionScreeningStatusCode = visionScreeningStatusCode;
	}


	public Date getHearingScreeningDate() {
		return hearingScreeningDate;
	}


	public void setHearingScreeningDate(Date hearingScreeningDate) {
		this.hearingScreeningDate = hearingScreeningDate;
	}


	public String getHearingScreeningStatusCode() {
		return hearingScreeningStatusCode;
	}


	public void setHearingScreeningStatusCode(String hearingScreeningStatusCode) {
		this.hearingScreeningStatusCode = hearingScreeningStatusCode;
	}


	public Date getDentalScreeningDate() {
		return dentalScreeningDate;
	}


	public void setDentalScreeningDate(Date dentalScreeningDate) {
		this.dentalScreeningDate = dentalScreeningDate;
	}


	public String getDentalScreeningStatusCode() {
		return dentalScreeningStatusCode;
	}


	public void setDentalScreeningStatusCode(String dentalScreeningStatusCode) {
		this.dentalScreeningStatusCode = dentalScreeningStatusCode;
	}


	public String getHealthInsuranceCoverageCode() {
		return healthInsuranceCoverageCode;
	}


	public void setHealthInsuranceCoverageCode(String healthInsuranceCoverageCode) {
		this.healthInsuranceCoverageCode = healthInsuranceCoverageCode;
	}


	public String getDentalInsuranceCoverageTypeCode() {
		return dentalInsuranceCoverageTypeCode;
	}


	public void setDentalInsuranceCoverageTypeCode(
			String dentalInsuranceCoverageTypeCode) {
		this.dentalInsuranceCoverageTypeCode = dentalInsuranceCoverageTypeCode;
	}


	public String getMedicalAlertIndicatorCode() {
		return medicalAlertIndicatorCode;
	}


	public void setMedicalAlertIndicatorCode(String medicalAlertIndicatorCode) {
		this.medicalAlertIndicatorCode = medicalAlertIndicatorCode;
	}


	public String getHealthScreeningEquipmentUsed() {
		return healthScreeningEquipmentUsed;
	}


	public void setHealthScreeningEquipmentUsed(String healthScreeningEquipmentUsed) {
		this.healthScreeningEquipmentUsed = healthScreeningEquipmentUsed;
	}


	public String getHealthScreeningFollowUpRecommendation() {
		return healthScreeningFollowUpRecommendation;
	}


	public void setHealthScreeningFollowUpRecommendation(
			String healthScreeningFollowUpRecommendation) {
		this.healthScreeningFollowUpRecommendation = healthScreeningFollowUpRecommendation;
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
