package api.mapping;

//SIF Common


import sif.dd.us32.model.ObjectFactory;

//SIF Student
import sif.dd.us32.model.K12StudentType;
import sif.dd.us32.model.K12StudentType.AcademicRecord;
import sif.dd.us32.model.K12StudentType.Demographic;
import sif.dd.us32.model.K12StudentType.Identity;
import sif.dd.us32.model.K12StudentType.Identity.Name;

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
		AcademicRecord sifAcademicRecord = oFac.createK12StudentTypeAcademicRecord();
		
		//Identity
		Name name = new Name();
		name.setFirstName(r1Student.getFirstName());
		name.setMiddleName(r1Student.getMiddleName());
		name.setLastName(r1Student.getLastName());
		name.setPrefix(r1Student.getPrefix());
		sifIdentity.setName(name);
		
		//Demographics
		sifDemographic.setSex(r1Student.getSexCode());
						
		//Academics
		sifAcademicRecord.setCohortDescription(r1Student.getCohortGraduationYear());
		
		//Set K12Student
		sifStudent.setRefId(r1Student.getStudentRefId());
		sifStudent.setIdentity(sifIdentity);
		sifStudent.setDemographic(sifDemographic);
		sifStudent.setAcademicRecord(sifAcademicRecord);
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
				
		//Demographic
		r1Student.setSexCode(sifStudent.getDemographic().getSex());
		//r1Student.setBirthDate(sifStudent.getDemographic().getBirthdate());
		//r1Student.setHispanicLatinoEthnicity(sifStudent.getDemographic().getHispanicOrLatinoEthnicity()); //returns string..should it be ?
		//r1Student.setUsCitizenshipStatusCode(sifStudent.getDemographic().???);	
				
		//r1Student.setCohortGraduationYear(sifStudent.getAcademicRecord().getCohortDescription());
		//r1Student.setCounselor(sifStudent.getAcademicRecord().get);
		//r1Student.setGenerationCode(sifStudent.getDemographic().);	
		
		return r1Student;
	}
	

	
	
	
}
