package api.mapping;

//SIF Common


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import sif.dd.us32.model.K12StudentType.Contact.EmailList;
import sif.dd.us32.model.K12StudentType.Contact.EmailList.Email;
import sif.dd.us32.model.K12StudentType.Contact.PhoneNumberList;
import sif.dd.us32.model.K12StudentType.Contact.PhoneNumberList.PhoneNumber;
import sif.dd.us32.model.K12StudentType.HealthRecordList;
import sif.dd.us32.model.K12StudentType.HealthRecordList.HealthRecord;
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
import api.model.R1StudentHealth;
import api.model.R1StudentIdentifier;
import api.model.R1StudentLanguage;
import api.model.R1StudentOtherName;
import api.model.R1StudentRace;
import api.model.R1StudentTelephone;



public class R1StudentHealthMapper
{
	private ObjectFactory oFac = new ObjectFactory();
	
	//--Student---------------------------------------------------------------//
	public K12StudentType modelToSIF(R1StudentHealth r1StudentHealth)
	{
		K12StudentType sifStudent = oFac.createK12StudentType();
		HealthRecordList sifHealthRecordList = oFac.createK12StudentTypeHealthRecordList();
		
		HealthRecord sifHealthRecord = oFac.createK12StudentTypeHealthRecordListHealthRecord();
		
		sifHealthRecord.setVisionScreeningDate(r1StudentHealth.getVisionScreeningDate().toString());
		sifHealthRecord.setVisionScreeningStatus(r1StudentHealth.getVisionScreeningStatusCode());
		
		sifHealthRecordList.getHealthRecord().add(sifHealthRecord);
		
		//for(R1StudentHealth health : r1StudentHealth.get)
		
		sifStudent.setHealthRecordList(sifHealthRecordList);

		return sifStudent;
	}
	
	public R1Student sifToModel(K12StudentType sifStudent)
	{
		R1Student r1Student = new R1Student();
		
		
		return r1Student;
	}
	

	
	
	
}
