package api.model;

import java.io.Serializable;

public class R1StudentRace implements Serializable
{
	private static final long serialVersionUID = 4255199616263324174L;
    
	private String studentRaceRefId;
	private String studentRefId;
	private String raceCode;
		

	public R1StudentRace() {}


	public String getStudentRaceRefId() {
		return studentRaceRefId;
	}


	public void setStudentRaceRefId(String studentRaceRefId) {
		this.studentRaceRefId = studentRaceRefId;
	}


	public String getStudentRefId() {
		return studentRefId;
	}


	public void setStudentRefId(String studentRefId) {
		this.studentRefId = studentRefId;
	}


	public String getRaceCode() {
		return raceCode;
	}


	public void setRaceCode(String raceCode) {
		this.raceCode = raceCode;
	}


	@Override
	public String toString() {
		return "R1StudentRace [studentRaceRefId=" + studentRaceRefId
				+ ", studentRefId=" + studentRefId + ", raceCode=" + raceCode
				+ "]";
	}


	
}
