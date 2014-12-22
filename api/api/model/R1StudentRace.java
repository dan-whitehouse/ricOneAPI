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
@Table(name="StudentRace")
public class R1StudentRace implements Serializable
{
	private static final long serialVersionUID = 4255199616263324174L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="StudentRaceRefId", unique=true, nullable=false)
	private String studentRaceRefId;
	
	//@Column(name="StudentRefId")
	private String studentRefId;
	
	@Column(name="RaceCode", length = 36)
	private String raceCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="StudentRefId", nullable=false)
	private R1Student r1Student;
		
	//--
	public R1StudentRace() {}

	public R1StudentRace(String studentRaceRefId, String studentRefId,
			String raceCode, R1Student r1Student) 
	{
		this.studentRaceRefId = studentRaceRefId;
		this.studentRefId = studentRefId;
		this.raceCode = raceCode;
		this.r1Student = r1Student;
	}

	public String getStudentRaceRefId() 
	{
		return studentRaceRefId;
	}

	public void setStudentRaceRefId(String studentRaceRefId) 
	{
		this.studentRaceRefId = studentRaceRefId;
	}
	
	public String getStudentRefId() 
	{
		return studentRefId;
	}

	public void setStudentRefId(String studentRefId) 
	{
		this.studentRefId = studentRefId;
	}
	
	public String getRaceCode() 
	{
		return raceCode;
	}

	public void setRaceCode(String raceCode) 
	{
		this.raceCode = raceCode;
	}

	public R1Student getR1Student()
	{
		return r1Student;
	}
	
	public void setR1Student(R1Student r1Student)
	{
		this.r1Student = r1Student;
	}

	//--
	@Override
	public String toString() {
		return "R1StudentRace [studentRaceRefId=" + studentRaceRefId
				+ ", studentRefId=" + studentRefId + ", raceCode=" + raceCode
				+ "]";
	}
	
}
