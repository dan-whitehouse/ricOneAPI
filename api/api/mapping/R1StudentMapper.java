package api.mapping;

//SIF Common


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/*import sif.dd.us32.model.K12StudentType.AcademicRecord;
import sif.dd.us32.model.K12StudentType.Contact;
import sif.dd.us32.model.K12StudentType.Immigrant;
import sif.dd.us32.model.K12StudentType.IndividualizedProgramList;
import sif.dd.us32.model.K12StudentType.IndividualizedProgramList.IndividualizedProgram;
import sif.dd.us32.model.K12StudentType.Lep;*/

//SIF Student
import sif.dd.us32.model.ObjectFactory;
import sif.dd.us32.model.K12StudentType;
import sif.dd.us32.model.K12StudentType.Demographic;
import sif.dd.us32.model.K12StudentType.Identity;
import sif.dd.us32.model.K12StudentType.Identity.Name;
import sif.dd.us32.model.K12StudentType.EnrollmentList;
import sif.dd.us32.model.K12StudentType.EnrollmentList.Enrollment;
import api.model.R1Student;



public class R1StudentMapper
{
	private ObjectFactory oFac = new ObjectFactory();
	
	//--Student---------------------------------------------------------------//
	public K12StudentType modelToSIF(R1Student r1Student)
	{
		K12StudentType sifStudent = oFac.createK12StudentType();
		Identity sifIdentity = oFac.createK12StudentTypeIdentity();
		Demographic sifDemographic = oFac.createK12StudentTypeDemographic();	
		EnrollmentList sifEnrollmentList = oFac.createK12StudentTypeEnrollmentList();
		Enrollment sifEnrollment = oFac.createK12StudentTypeEnrollmentListEnrollment();

		//Identity
		Name name = new Name();
		name.setFirstName(r1Student.getFirstName());
		name.setMiddleName(r1Student.getMiddleName());
		name.setLastName(r1Student.getLastName());
		name.setPrefix(r1Student.getPrefix());
		sifIdentity.setName(name);
		

		//Demographics
		sifDemographic.setSex(r1Student.getSexCode());
		sifDemographic.setBirthdate(r1Student.getBirthdate().toString());
		
		if(r1Student.isHispanicLatinoEthnicity())
		{
			sifDemographic.setHispanicOrLatinoEthnicity("Yes");
		}
		else
		{
			sifDemographic.setHispanicOrLatinoEthnicity("No");
		}
								
		//Enrollment	
		sifEnrollment.setCohortGraduationYear(r1Student.getCohortGraduationYear());
		sifEnrollmentList.getEnrollment().add(sifEnrollment);
		

		//Set K12Student
		sifStudent.setRefId(r1Student.getStudentRefId());
		sifStudent.setIdentity(sifIdentity);
		sifStudent.setDemographic(sifDemographic);
		sifStudent.setEnrollmentList(sifEnrollmentList);
		return sifStudent;
	}
	
	public R1Student sifToModel(K12StudentType sifStudent)
	{
		R1Student r1Student = new R1Student();
		r1Student.setStudentRefId(sifStudent.getRefId());		
		
		//Name
		r1Student.setFirstName(sifStudent.getIdentity().getName().getFirstName());
		r1Student.setMiddleName(sifStudent.getIdentity().getName().getMiddleName());
		r1Student.setLastName(sifStudent.getIdentity().getName().getLastName());
		r1Student.setPrefix(sifStudent.getIdentity().getName().getPrefix());
				
		//Demographics
		r1Student.setSexCode(sifStudent.getDemographic().getSex());
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try
		{
			r1Student.setBirthdate(format.parse(sifStudent.getDemographic().getBirthdate()));
		} 
		catch (ParseException e)
		{
			System.out.println("R1StudentMapper: failed to format date of: birthdate");
			e.printStackTrace();
		}
		
		if(sifStudent.getDemographic().getHispanicOrLatinoEthnicity().equalsIgnoreCase("Yes"))
		{
			r1Student.setHispanicLatinoEthnicity(true);
		}
		else
		{
			r1Student.setHispanicLatinoEthnicity(false);
		}

		//r1Student.setUsCitizenshipStatusCode(sifStudent.getDemographic().???);	
					
		for(Enrollment enrollment : sifStudent.getEnrollmentList().getEnrollment())
		{
			r1Student.setCohortGraduationYear(enrollment.getCohortGraduationYear());
		}
		
		//r1Student.setCounselor(sifStudent.getAcademicRecord().get);
		//r1Student.setGenerationCode(sifStudent.getDemographic().);	
		
		return r1Student;
	}
	

	
	
	
}
