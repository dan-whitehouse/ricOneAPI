package api.mapping.sif32composite;


import sif.dd.us321api.model.GBaseNameType;
import sif.dd.us321api.model.GNameOfRecordType;
import sif.dd.us321api.model.GOtherNameListType;
import sif.dd.us321api.model.GOtherNameType;
import sif.dd.us321api.model.GYearGroupType;
import sif.dd.us321api.model.SEnrollmentList;
import sif.dd.us321api.model.GEmailTypeType;
import sif.dd.us321api.model.GLanguageType;
import sif.dd.us321api.model.GLaxCodedElementType;
import sif.dd.us321api.model.GSexusType;
import sif.dd.us321api.model.K12StudentCoreType;
import sif.dd.us321api.model.ObjectFactory;
import sif.dd.us321api.model.SDemographicsType;
import sif.dd.us321api.model.SEmailList;
import sif.dd.us321api.model.SEmailType;
import sif.dd.us321api.model.SEnrollmentType;
import sif.dd.us321api.model.SLanguageList;
import sif.dd.us321api.model.SLanguageType;
import sif.dd.us321api.model.SRaceList;
import sif.dd.us321api.model.SRaceType;
import sif.dd.us321api.model.STelephoneList;
import sif.dd.us321api.model.STelephoneType;
import api.model.R1Student;
import api.model.R1StudentAddress;
import api.model.R1StudentEmail;
import api.model.R1StudentEnrollment;
import api.model.R1StudentIdentifier;
import api.model.R1StudentLanguage;
import api.model.R1StudentOtherName;
import api.model.R1StudentRace;
import api.model.R1StudentTelephone;



public class R1StudentMapper
{
	private ObjectFactory oFac = new ObjectFactory();
	
	
	public K12StudentCoreType modelToSIF32Simple(R1Student r1Student)
	{
		K12StudentCoreType sifStudent = oFac.createK12StudentCoreType();
		SDemographicsType sifDemographic = oFac.createSDemographicsType();
		SRaceList sifRaceList = oFac.createSRaceList();
		SEmailList sifEmailList = oFac.createSEmailList();
		SLanguageList sifLanaguageList = oFac.createSLanguageList();
		STelephoneList sifPhoneNumberList = oFac.createSTelephoneList();
		SEnrollmentList sifEnrollmentList = oFac.createSEnrollmentList();
		GOtherNameListType sifOtherNameList = oFac.createGOtherNameListType();
	

		/********** Demographics **********/
		sifDemographic.setBirthDate(api.common.Helper.getDateValue(r1Student.getBirthdate().toString()));
		sifDemographic.setUsCitizenshipStatus(r1Student.getUsCitizenshipStatusCode());
		sifDemographic.setHispanicLatinoEthnicity(r1Student.isHispanicLatinoEthnicity());
		
		//Sex
		if(r1Student.getSexCode().equalsIgnoreCase("Male") || r1Student.getSexCode().equalsIgnoreCase("M"))
		{
			sifDemographic.setSex(GSexusType.M);
		}
		else if(r1Student.getSexCode().equalsIgnoreCase("Female") || r1Student.getSexCode().equalsIgnoreCase("F"))
		{
			sifDemographic.setSex(GSexusType.F);
		}
		else
		{
			sifDemographic.setSex(GSexusType.U);
		}
			
		//Race
		for(R1StudentRace race : r1Student.getR1StudentRaces())
		{
			SRaceType sifRace = oFac.createSRaceType();
			sifRace.setRace(race.getRaceCode());
			sifRaceList.getRace().add(sifRace);
		}
		sifDemographic.setRaces(sifRaceList);
		
		
		/********** Languages **********/
		for(R1StudentLanguage language : r1Student.getR1StudentLanguages())
		{
			SLanguageType sifLanguage = oFac.createSLanguageType();				
			//Type Code
			GLanguageType code = oFac.createGLanguageType();
			code.setCode(language.getLanguageUseTypeCode());
			sifLanguage.setCode(code);		
			//Type
			sifLanguage.setType(language.getLanguageCode());
			//Set List
			sifLanaguageList.getLanguage().add(sifLanguage);		
		}
		
		
		/********** Email **********/
		for(R1StudentEmail email : r1Student.getR1StudentEmails())
		{
			//Address
			SEmailType sifEmail = oFac.createSEmailType();		
			sifEmail.setEmailAddress(email.getEmailAddress());
			//Type Code
			GEmailTypeType type = oFac.createGEmailTypeType();
			type.setCode(email.getEmailTypeCode());
			sifEmail.setType(type);
			
			if(email.isPrimaryEmailAddressIndicator())
			{
				sifStudent.setEmail(sifEmail);
			}
			else
			{
				//Set List
				sifEmailList.getEmail().add(sifEmail);
			}		
		}
		
		/********** PhoneNumber**********/
		for(R1StudentTelephone phone : r1Student.getR1StudentTelephones())
		{
			STelephoneType sifPhoneNumber = oFac.createSTelephoneType();
			sifPhoneNumber.setNumber(phone.getTelephoneNumber());
			//Type Code
			GLaxCodedElementType typeCode = oFac.createGLaxCodedElementType();
			typeCode.setCode(phone.getTelephoneNumberTypeCode());
			sifPhoneNumber.setType(typeCode);
			
			//Set Indicator and Add to Student or PhoneList which is added to student below
			if(phone.getPrimaryTelephoneNumberIndicator())
			{				
				sifPhoneNumber.setPrimaryIndicator(true); //Add to Student Now		
				sifStudent.setPhoneNumber(sifPhoneNumber);
			}
			else
			{				
				sifPhoneNumber.setPrimaryIndicator(false);	
				sifPhoneNumberList.getPhoneNumber().add(sifPhoneNumber); //Add to Student Later
			}			
		}
		
		
		/********** Enrollments **********/
		for(R1StudentEnrollment enrollment : r1Student.getR1StudentEnrollments())
		{		
			SEnrollmentType sifEnrollment = oFac.createSEnrollmentType();
			GYearGroupType yearGroupType = oFac.createGYearGroupType();
			
			
			sifEnrollment.setCounselorRefId(enrollment.getCounselorRefId());
			sifEnrollment.setHomeRoomId(enrollment.getHomeRoomIdentifier());
			sifEnrollment.setK12LeaRefId(enrollment.getR1School().getLeaRefId());
			sifEnrollment.setK12SchoolRefId(enrollment.getSchoolRefId());
			//sifEnrollment.setMembershipType(); //idk
			sifEnrollment.setResponsibleSchoolType(enrollment.getResponsibleSchoolTypeCode());
			
			//Cohort Graduation Year			
			yearGroupType.setCode(r1Student.getCohortGraduationYear());
			sifEnrollment.setCohortGraduationYear(yearGroupType);

			//Current Grade
			yearGroupType.setCode(r1Student.getGradeLevelCode());
			sifEnrollment.setCurrentGradeLevel(yearGroupType);
			
			if(enrollment.getEnrollmentStatusCode().equalsIgnoreCase("01811"))
			{
				sifStudent.setEnrollment(sifEnrollment);
			}
			else
			{
				sifEnrollmentList.getEnrollment().add(sifEnrollment);
			}
		}
		
		
		/********** OTHER NAMES **********/
		for(R1StudentOtherName otherName : r1Student.getR1StudentOtherNames())
		{
			GOtherNameType sifOtherName = oFac.createGOtherNameType();
		
			sifOtherName.setNameRole(otherName.getType());
			
			GBaseNameType sifName = oFac.createGBaseNameType();		
			sifName.setGivenName(otherName.getFirstName());
			sifName.setMiddleName(otherName.getMiddleName());
			sifName.setFamilyName(otherName.getLastName());
			sifName.setPrefix(otherName.getPrefix());
			sifName.setSuffix(otherName.getGenerationCode());
					
			sifOtherName.setOtherName(sifName);
			sifOtherNameList.getOtherName().add(sifOtherName);
		}
		
		
		
		
		
		/********** LISTS **********/
		sifStudent.setRefId(r1Student.getStudentRefId());
		sifStudent.setDemographics(sifDemographic);	
		sifStudent.setLanguages(sifLanaguageList);	
		sifStudent.setOtherEmails(sifEmailList);
		sifStudent.setOtherPhoneNumbers(sifPhoneNumberList); 
		sifStudent.setOtherEnrollments(sifEnrollmentList);
		sifStudent.setOtherNames(sifOtherNameList);

		return sifStudent;
	}
	
	
	
	public R1Student sif32SimpleToModel(K12StudentCoreType sifStudent)
	{
		R1Student r1Student = new R1Student();
		return r1Student;
	}
	

	
	
	
}
