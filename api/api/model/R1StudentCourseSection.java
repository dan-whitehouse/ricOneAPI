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
@Table(name="StudentCourseSection")
public class R1StudentCourseSection implements Serializable
{
	private static final long serialVersionUID = 4255199616263324174L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="StudentCourseSectionRefId", unique=true, nullable=false)
	private String studentCourseSectionRefId;
	
	//@Column(name="StudentRefId")
	private String studentRefId;
	
	//@Column(name="CourseSectionRefId")
	private String courseSectionRefId;
	
	@Column(name="CourseSectionEnrollmentStatusTypeCode")
	private String courseSectionEnrollmentStatusTypeCode;
	
	@Column(name="CourseSectionEntryTypeCode")
	private String courseSectionEntryTypeCode;
	
	@Column(name="CourseSectionExitTypeCode")
	private String courseSectionExitTypeCode;
	
	@Column(name="ExitOrWithdrawalStatusCode")
	private String exitOrWithdrawalStatusCode;
	
	@Column(name="GradeLevelWhenCourseTakenCode")
	private String gradeLevelWhenCourseTakenCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="StudentRefId", nullable=false)
	private R1Student r1Student;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CourseSectionRefId", nullable=false)
	private R1CourseSection r1CourseSection;

	//--
	public R1StudentCourseSection() {}
		
	public R1StudentCourseSection(String studentCourseSectionRefId,
			String studentRefId, String courseSectionRefId,
			String courseSectionEnrollmentStatusTypeCode,
			String courseSectionEntryTypeCode,
			String courseSectionExitTypeCode,
			String exitOrWithdrawalStatusCode,
			String gradeLevelWhenCourseTakenCode, R1Student r1Student,
			R1CourseSection r1CourseSection) 
	{
		this.studentCourseSectionRefId = studentCourseSectionRefId;
		this.studentRefId = studentRefId;
		this.courseSectionRefId = courseSectionRefId;
		this.courseSectionEnrollmentStatusTypeCode = courseSectionEnrollmentStatusTypeCode;
		this.courseSectionEntryTypeCode = courseSectionEntryTypeCode;
		this.courseSectionExitTypeCode = courseSectionExitTypeCode;
		this.exitOrWithdrawalStatusCode = exitOrWithdrawalStatusCode;
		this.gradeLevelWhenCourseTakenCode = gradeLevelWhenCourseTakenCode;
		this.r1Student = r1Student;
		this.r1CourseSection = r1CourseSection;
	}

	public String getStudentCourseSectionRefId() 
	{
		return studentCourseSectionRefId;
	}

	public void setStudentCourseSectionRefId(String studentCourseSectionRefId) 
	{
		this.studentCourseSectionRefId = studentCourseSectionRefId;
	}

	public String getStudentRefId() 
	{
		return studentRefId;
	}

	public void setStudentRefId(String studentRefId) 
	{
		this.studentRefId = studentRefId;
	}
	
	public String getCourseSectionRefId() 
	{
		return courseSectionRefId;
	}

	public void setCourseSectionRefId(String courseSectionRefId) 
	{
		this.courseSectionRefId = courseSectionRefId;
	}
	
	public String getCourseSectionEnrollmentStatusTypeCode() 
	{
		return courseSectionEnrollmentStatusTypeCode;
	}

	public void setCourseSectionEnrollmentStatusTypeCode(String courseSectionEnrollmentStatusTypeCode) 
	{
		this.courseSectionEnrollmentStatusTypeCode = courseSectionEnrollmentStatusTypeCode;
	}
	
	public String getCourseSectionEntryTypeCode() 
	{
		return courseSectionEntryTypeCode;
	}

	public void setCourseSectionEntryTypeCode(String courseSectionEntryTypeCode) 
	{
		this.courseSectionEntryTypeCode = courseSectionEntryTypeCode;
	}
	
	public String getCourseSectionExitTypeCode() 
	{
		return courseSectionExitTypeCode;
	}

	public void setCourseSectionExitTypeCode(String courseSectionExitTypeCode) 
	{
		this.courseSectionExitTypeCode = courseSectionExitTypeCode;
	}

	public String getExitOrWithdrawalStatusCode() 
	{
		return exitOrWithdrawalStatusCode;
	}

	public void setExitOrWithdrawalStatusCode(String exitOrWithdrawalStatusCode) 
	{
		this.exitOrWithdrawalStatusCode = exitOrWithdrawalStatusCode;
	}

	public String getGradeLevelWhenCourseTakenCode() 
	{
		return gradeLevelWhenCourseTakenCode;
	}

	public void setGradeLevelWhenCourseTakenCode(String gradeLevelWhenCourseTakenCode) 
	{
		this.gradeLevelWhenCourseTakenCode = gradeLevelWhenCourseTakenCode;
	}
	
	public R1Student getR1Student()
	{
		return r1Student;
	}

	public void setR1Student(R1Student r1Student)
	{
		this.r1Student = r1Student;
	}
	
	public R1CourseSection getR1CourseSection()
	{
		return r1CourseSection;
	}

	public void setR1CourseSection(R1CourseSection r1CourseSection)
	{
		this.r1CourseSection = r1CourseSection;
	}
	
	//---------------------------------------------------
	@Override
	public String toString() 
	{
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
