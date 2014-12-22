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

@Entity
@Table(name="StaffAssignment")
public class R1StaffAssignment implements Serializable
{
	private static final long serialVersionUID = 4255199616263324174L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="StaffAssignmentRefId", unique=true, nullable=false)
	private String staffAssignmentRefId;
	
	//@Column(name="StaffRefId")
	private String staffRefId;
	
	//@Column(name="SchoolRefId")
	private String schoolRefId;
	
	@Column(name="PrimaryAssignment")
	private boolean primaryAssignment;
	
	@Column(name="PositionTitle")
	private String positionTitle;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="StaffRefId", nullable=false)
	private R1Staff r1Staff;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="SchoolRefId", nullable=false)
	private R1School r1School;
	
	//--
	public R1StaffAssignment() {}
	
	public R1StaffAssignment(String staffAssignmentRefId, String staffRefId,
			String schoolRefId, boolean primaryAssignment,
			String positionTitle, R1Staff r1Staff, R1School r1School) 
	{
		this.staffAssignmentRefId = staffAssignmentRefId;
		this.staffRefId = staffRefId;
		this.schoolRefId = schoolRefId;
		this.primaryAssignment = primaryAssignment;
		this.positionTitle = positionTitle;
		this.r1Staff = r1Staff;
		this.r1School = r1School;
	}

	public String getStaffAssignmentRefId() 
	{
		return staffAssignmentRefId;
	}

	public void setStaffAssignmentRefId(String staffAssignmentRefId) 
	{
		this.staffAssignmentRefId = staffAssignmentRefId;
	}

	public String getStaffRefId() 
	{
		return staffRefId;
	}

	public void setStaffRefId(String staffRefId) 
	{
		this.staffRefId = staffRefId;
	}
	
	public String getSchoolRefId() 
	{
		return schoolRefId;
	}

	public void setSchoolRefId(String schoolRefId) 
	{
		this.schoolRefId = schoolRefId;
	}
	
	
	public boolean getPrimaryAssignment() 
	{
		return primaryAssignment;
	}

	public void setPrimaryAssignment(boolean primaryAssignment) {
		this.primaryAssignment = primaryAssignment;
	}
	
	public String getPositionTitle() {
		return positionTitle;
	}

	public void setPositionTitle(String positionTitle) {
		this.positionTitle = positionTitle;
	}

	public R1Staff getR1Staff()
	{
		return r1Staff;
	}

	public void setR1Staff(R1Staff r1Staff)
	{
		this.r1Staff = r1Staff;
	}
	
	public R1School getR1School()
	{
		return r1School;
	}

	public void setR1School(R1School r1School)
	{
		this.r1School = r1School;
	}
	

	@Override
	public String toString() {
		return "R1StaffAssignment [staffAssignmentRefId="
				+ staffAssignmentRefId + ", staffRefId=" + staffRefId
				+ ", schoolRefId=" + schoolRefId + ", primaryAssignment="
				+ primaryAssignment + ", positionTitle=" + positionTitle + "]";
	}
}
