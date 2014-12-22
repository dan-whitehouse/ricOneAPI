package api.mapping.sif32;

//SIF Common


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import sif.dd.us32.model.K12StudentType.Contact.EmailList;
import sif.dd.us32.model.K12StudentType.Contact.EmailList.Email;
import sif.dd.us32.model.K12StudentType.Contact.PhoneNumberList;
import sif.dd.us32.model.K12StudentType.Contact.PhoneNumberList.PhoneNumber;
import sif.dd.us32.model.K12StudentType.Identity.Identification;
import sif.dd.us32.model.K12StudentType.Identity.OtherNameList;
import sif.dd.us32.model.K12StudentType.Identity.OtherNameList.OtherName;
import sif.dd.us32.model.K12StudentType.LanguageList;
import sif.dd.us32.model.K12StudentType.LanguageList.Language;
//SIF Student
import sif.dd.us32.model.ObjectFactory;
import sif.dd.us32.model.K12StudentType;
import sif.dd.us32.model.K12StudentType.Contact;
import sif.dd.us32.model.K12StudentType.Demographic;
import sif.dd.us32.model.K12StudentType.Identity;
import sif.dd.us32.model.K12StudentType.Identity.Name;
import sif.dd.us32.model.K12StudentType.EnrollmentList;
import sif.dd.us32.model.K12StudentType.Contact.AddressList;
import sif.dd.us32.model.K12StudentType.Contact.AddressList.Address;
import sif.dd.us32.model.K12StudentType.Contact.AddressList.Address.Street;
import sif.dd.us32.model.K12StudentType.EnrollmentList.Enrollment;
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

		
	//--Student---------------------------------------------------------------//
	public K12StudentType modelToSIF32(R1Student r1Student)
	{
		K12StudentType sifStudent = oFac.createK12StudentType();
		Identity sifIdentity = oFac.createK12StudentTypeIdentity();
		Demographic sifDemographic = oFac.createK12StudentTypeDemographic();
		Contact sifContact = oFac.createK12StudentTypeContact();
		EnrollmentList sifEnrollmentList = oFac.createK12StudentTypeEnrollmentList();
		AddressList sifAddressList = oFac.createK12StudentTypeContactAddressList();
		LanguageList sifLanaguageList = oFac.createK12StudentTypeLanguageList();
		OtherNameList sifOtherNameList = oFac.createK12StudentTypeIdentityOtherNameList();
		EmailList sifEmailList = oFac.createK12StudentTypeContactEmailList();
		PhoneNumberList sifPhoneNumberList = oFac.createK12StudentTypeContactPhoneNumberList();
		

		/********** Identity **********/
		Name sifName = new Name();
		sifName.setFirstName(r1Student.getFirstName());
		sifName.setMiddleName(r1Student.getMiddleName());
		sifName.setLastName(r1Student.getLastName());
		sifName.setPrefix(r1Student.getPrefix());
		sifName.setSuffix(r1Student.getGenerationCode());
		
		//OtherNames
		for(R1StudentOtherName otherName : r1Student.getR1StudentOtherNames())
		{
			OtherName sifOtherName = oFac.createK12StudentTypeIdentityOtherNameListOtherName();
			sifOtherName.setOtherFirstName(otherName.getFirstName());
			sifOtherName.setOtherMiddleName(otherName.getMiddleName());
			sifOtherName.setOtherLastName(otherName.getLastName());
			sifOtherName.setOtherNameType(otherName.getType());
			sifOtherNameList.getOtherName().add(sifOtherName);
			
		}
		
		//StudentIdentifier
		for(R1StudentIdentifier identifier : r1Student.getR1StudentIdentifiers())
		{
			Identification sifIdentification = oFac.createK12StudentTypeIdentityIdentification();
			sifIdentification.setIdVerification(identifier.getIdentificationSystemCode());
			sifIdentification.setStudentId(identifier.getStudentId());			
			sifIdentity.setIdentification(sifIdentification);
		}
		
		
		//Set Identity
		sifIdentity.setName(sifName);
		sifIdentity.setOtherNameList(sifOtherNameList);
		
	
		/********** Demographics **********/
		sifDemographic.setSex(r1Student.getSexCode());
		sifDemographic.setBirthdate(r1Student.getBirthdate().toString());
		sifDemographic.setResidenceStatus(r1Student.getUsCitizenshipStatusCode()); //Not sure if Residence is correct
		
		if(r1Student.isHispanicLatinoEthnicity() == true)
		{
			sifDemographic.setHispanicOrLatinoEthnicity("True");
		}
		else
		{
			sifDemographic.setHispanicOrLatinoEthnicity("False");
		}
		
		
		if(r1Student.getR1StudentRaces() != null)
		{
			for(R1StudentRace race : r1Student.getR1StudentRaces())
			{
				if(race.getRaceCode().equalsIgnoreCase("AmericanIndianOrAlaskaNative"))
				{
					sifDemographic.setAmericanIndianOrAlaskaNative("True");
				}
				else if(race.getRaceCode().equalsIgnoreCase("Asian"))
				{
					sifDemographic.setAsian("True");
				}
				else if(race.getRaceCode().equalsIgnoreCase("BlackOrAfricanAmerican"))
				{
					sifDemographic.setBlackOrAfricanAmerican("True");
				}
				else if(race.getRaceCode().equalsIgnoreCase("NativeHawaiianOrOtherPacificIslander"))
				{
					sifDemographic.setNativeHawaiianOrOtherPacificIslander("True");
				}
				else if(race.getRaceCode().equalsIgnoreCase("White"))
				{
					sifDemographic.setWhite("True");
				}
				else if(race.getRaceCode().equalsIgnoreCase("DemographicRaceTwoOrMoreRaces"))
				{
					sifDemographic.setTwoOrMoreRaces("True");
				}
				
			}	
		}
						
		/********** Enrollments **********/
		for(R1StudentEnrollment enrollment : r1Student.getR1StudentEnrollments())
		{		
			Enrollment sifEnrollment = new Enrollment();
			sifEnrollment.setCohortGraduationYear(r1Student.getCohortGraduationYear());
			//sifEnrollment.setSchoolId(enrollment.getSchoolRefId());
			sifEnrollment.setEntryGradeLevel(enrollment.getEntryGradeLevelCode());			
			sifEnrollment.setEnrollmentStatus(enrollment.getEnrollmentStatusCode());
			sifEnrollment.setEntryType(enrollment.getEntryTypeCode());
			sifEnrollment.setExitGradeLevel(enrollment.getExitGradeLevelCode());
			sifEnrollment.setExitStatus(enrollment.getExitOrWithdrawalStatusCode());
			sifEnrollment.setExitType(enrollment.getExitOrWithdrawalTypeCode());
			sifEnrollment.setDisplacedStudent(enrollment.getDisplacedStudentStatus());

			sifEnrollmentList.getEnrollment().add(sifEnrollment);
		}
		
			
		/********** Languages **********/
		for(R1StudentLanguage language : r1Student.getR1StudentLanguages())
		{
			Language sifLanguage = oFac.createK12StudentTypeLanguageListLanguage();			
			sifLanguage.setCode(language.getLanguageCode());
			sifLanguage.setType(language.getLanguageUseTypeCode());
			
			sifLanaguageList.getLanguage().add(sifLanguage);		
		}
		
		
		/********** Addresses **********/
		for(R1StudentAddress address : r1Student.getR1StudentAddresses())
		{
			Address sifAddress = oFac.createK12StudentTypeContactAddressListAddress();
			Street sifStreet = oFac.createK12StudentTypeContactAddressListAddressStreet();
			
			sifStreet.setLine1(address.getStreetNumberAndName());
			sifStreet.setApartmentNumber(address.getApartmentRoomOrSuiteNumber());
			
			//Set Address
			sifAddress.setAddressType(address.getAddressTypeCode());
			sifAddress.setCity(address.getCity());
			sifAddress.setCounty(address.getAddressCountyName());
			sifAddress.setPostalCode(address.getPostalCode());
			sifAddress.setStateProvince(address.getStateCode());
			sifAddress.setCountry(address.getCountryCode());				
			sifAddress.setStreet(sifStreet);
			
			sifAddressList.getAddress().add(sifAddress);	
		}
		
		/********** Email **********/
		for(R1StudentEmail email : r1Student.getR1StudentEmails())
		{
			Email sifEmail = oFac.createK12StudentTypeContactEmailListEmail();		
			sifEmail.setEmailType(email.getEmailTypeCode());

			sifEmailList.getEmail().add(sifEmail);
		}
		
		
		/********** PhoneNumber**********/
		for(R1StudentTelephone phone : r1Student.getR1StudentTelephones())
		{
			PhoneNumber sifPhoneNumber = oFac.createK12StudentTypeContactPhoneNumberListPhoneNumber();
			sifPhoneNumber.setNumber(phone.getTelephoneNumber());
			sifPhoneNumber.setPhoneNumberType(phone.getTelephoneNumberTypeCode());
			
			if(phone.getPrimaryTelephoneNumberIndicator() == true)
			{
				sifPhoneNumber.setPhoneNumberIndicator("True");
			}
			else if(phone.getPrimaryTelephoneNumberIndicator() == false)
			{
				sifPhoneNumber.setPhoneNumberIndicator("False");
			}
			else
			{
				sifPhoneNumber.setPhoneNumberIndicator("Null");
			}						
			sifPhoneNumberList.getPhoneNumber().add(sifPhoneNumber);
		}
		
		

		/********** Set K12StudentCore **********/
		sifStudent.setRefId(r1Student.getStudentRefId());
		sifStudent.setIdentity(sifIdentity);
		sifStudent.setDemographic(sifDemographic);
		sifContact.setAddressList(sifAddressList);	
		sifContact.setEmailList(sifEmailList);
		sifContact.setPhoneNumberList(sifPhoneNumberList);
		sifStudent.setContact(sifContact);		
		sifStudent.setEnrollmentList(sifEnrollmentList);
		sifStudent.setLanguageList(sifLanaguageList);
		

		return sifStudent;
	}
	

	public R1Student sif32ToModel(K12StudentType sifStudent)
	{
		R1Student r1Student = new R1Student();
		r1Student.setStudentRefId(sifStudent.getRefId());		
		
		//Name
		r1Student.setFirstName(sifStudent.getIdentity().getName().getFirstName());
		r1Student.setMiddleName(sifStudent.getIdentity().getName().getMiddleName());
		r1Student.setLastName(sifStudent.getIdentity().getName().getLastName());
		r1Student.setPrefix(sifStudent.getIdentity().getName().getPrefix());
				
		
		/********** Demographics **********/
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
