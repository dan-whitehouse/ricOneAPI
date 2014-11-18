package api.mapping;

//SIF Common


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

//SIF Student
import sif.dd.us32.model.ObjectFactory;
import sif.dd.us32.model.K12StudentType;
import sif.dd.us32.model.K12StudentType.EnrollmentList;
import sif.dd.us32.model.K12StudentType.EnrollmentList.Enrollment;
import api.model.R1StudentEnrollment;



public class R1StudentEnrollmentMapper
{
	private ObjectFactory oFac = new ObjectFactory();
	
	//--Student---------------------------------------------------------------//
	public K12StudentType modelToSIF(R1StudentEnrollment r1StudentEnrollment)
	{
		K12StudentType sifStudent = oFac.createK12StudentType();
		EnrollmentList sifEnrollmentList = oFac.createK12StudentTypeEnrollmentList();
		Enrollment sifEnrollment = oFac.createK12StudentTypeEnrollmentListEnrollment();
							
		//Enrollment	
		sifEnrollment.setSchoolId(r1StudentEnrollment.getSchoolRefId());
		sifEnrollment.setEntryGradeLevel(r1StudentEnrollment.getEntryGradeLevelCode());
		sifEnrollment.setEnrollmentStatus(r1StudentEnrollment.getEnrollmentStatusCode());
		sifEnrollment.setEntryType(r1StudentEnrollment.getEntryTypeCode());
		sifEnrollment.setExitGradeLevel(r1StudentEnrollment.getExitGradeLevelCode());
		sifEnrollment.setExitStatus(r1StudentEnrollment.getExitOrWithdrawalStatusCode());
		sifEnrollment.setExitType(r1StudentEnrollment.getExitOrWithdrawalTypeCode());
		sifEnrollment.setDisplacedStudent(r1StudentEnrollment.getDisplacedStudentStatus());
		
		//Fill Objects
		sifEnrollmentList.getEnrollment().add(sifEnrollment);
		sifStudent.setEnrollmentList(sifEnrollmentList);
		sifStudent.setRefId(r1StudentEnrollment.getStudentRefId());
		return sifStudent;
	}
	
	public R1StudentEnrollment sifToModel(K12StudentType sifStudent)
	{
		R1StudentEnrollment r1Student = new R1StudentEnrollment();
		r1Student.setStudentRefId(sifStudent.getRefId());		
		
		return r1Student;
	}
	

	
	
	
}
