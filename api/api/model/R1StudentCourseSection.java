package api.model;

import java.io.Serializable;

public class R1StudentCourseSection implements Serializable
{
	private static final long serialVersionUID = 4255199616263324174L;
    
	private String studentCourseSectionRefId;
	private String studentRefId;
	private String courseSectionRefId;
	private String courseSectionEnrollmentStatusTypeCode;
	private String courseSectionEntryTypeCode;
	private String courseSectionExitTypeCode;
	private String exitOrWithdrawalStatusCode;
	private String gradeLevelWhenCourseTakenCode;

	public R1StudentCourseSection() {}
		
	//-----------------------
	public String getStudentCourseSectionRefId() {
		return studentCourseSectionRefId;
	}

	public void setStudentCourseSectionRefId(String studentCourseSectionRefId) {
		this.studentCourseSectionRefId = studentCourseSectionRefId;
	}

	public String getStudentRefId() {
		return studentRefId;
	}

	public void setStudentRefId(String studentRefId) {
		this.studentRefId = studentRefId;
	}

	public String getCourseSectionRefId() {
		return courseSectionRefId;
	}

	public void setCourseSectionRefId(String courseSectionRefId) {
		this.courseSectionRefId = courseSectionRefId;
	}

	public String getCourseSectionEnrollmentStatusTypeCode() {
		return courseSectionEnrollmentStatusTypeCode;
	}

	public void setCourseSectionEnrollmentStatusTypeCode(
			String courseSectionEnrollmentStatusTypeCode) {
		this.courseSectionEnrollmentStatusTypeCode = courseSectionEnrollmentStatusTypeCode;
	}

	public String getCourseSectionEntryTypeCode() {
		return courseSectionEntryTypeCode;
	}

	public void setCourseSectionEntryTypeCode(String courseSectionEntryTypeCode) {
		this.courseSectionEntryTypeCode = courseSectionEntryTypeCode;
	}

	public String getCourseSectionExitTypeCode() {
		return courseSectionExitTypeCode;
	}

	public void setCourseSectionExitTypeCode(String courseSectionExitTypeCode) {
		this.courseSectionExitTypeCode = courseSectionExitTypeCode;
	}

	public String getExitOrWithdrawalStatusCode() {
		return exitOrWithdrawalStatusCode;
	}

	public void setExitOrWithdrawalStatusCode(String exitOrWithdrawalStatusCode) {
		this.exitOrWithdrawalStatusCode = exitOrWithdrawalStatusCode;
	}

	public String getGradeLevelWhenCourseTakenCode() {
		return gradeLevelWhenCourseTakenCode;
	}

	public void setGradeLevelWhenCourseTakenCode(
			String gradeLevelWhenCourseTakenCode) {
		this.gradeLevelWhenCourseTakenCode = gradeLevelWhenCourseTakenCode;
	}
	
	//---------------------------------------------------
	
	@Override
	public String toString() {
		return "R1StudentCourseSection [studentCourseSectionRefId="
				+ studentCourseSectionRefId + ", studentRefId=" + studentRefId
				+ ", courseSectionRefId=" + courseSectionRefId
				+ ", courseSectionEnrollmentStatusTypeCode="
				+ courseSectionEnrollmentStatusTypeCode
				+ ", courseSectionEntryTypeCode=" + courseSectionEntryTypeCode
				+ ", courseSectionExitTypeCode=" + courseSectionExitTypeCode
				+ ", exitOrWithdrawalStatusCode=" + exitOrWithdrawalStatusCode
				+ ", gradeLevelWhenCourseTakenCode="
				+ gradeLevelWhenCourseTakenCode + "]";
	}
}
