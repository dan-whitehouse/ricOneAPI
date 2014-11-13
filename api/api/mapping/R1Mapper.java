package api.mapping;

//SIF Common


import sif.dd.us32.model.ObjectFactory;

//SIF Student
import sif.dd.us32.model.K12StudentType;
import sif.dd.us32.model.K12StudentType.AcademicRecord;
import sif.dd.us32.model.K12StudentType.Demographic;
import sif.dd.us32.model.K12StudentType.Identity;
import sif.dd.us32.model.K12StudentType.Identity.Name;
//SIF Staff
import sif.dd.us32.model.K12StaffType;
//SIF School
import sif.dd.us32.model.K12SchoolType;
import sif.dd.us32.model.K12SchoolType.AddressList;
import sif.dd.us32.model.K12SchoolType.AddressList.Address;
import sif.dd.us32.model.K12SchoolType.AddressList.Address.Street;
import sif.dd.us32.model.K12SchoolType.Identification;
//-----------R1--------------------------
import api.model.R1School;
import api.model.R1Student;
import api.model.R1Staff;


public class R1Mapper
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
	
	//--Staff---------------------------------------------------------------//
		public K12StaffType modelToSIF(R1Staff r1Staff)
		{
			K12StaffType sifStaff = oFac.createK12StaffType();
			sifStaff.setRefId(r1Staff.getStaffRefId());
			
			return sifStaff;
		}
		
		public R1Staff sifToModel(K12StaffType sifStaff)
		{
			R1Staff r1Staff = new R1Staff();
			r1Staff.setStaffRefId(sifStaff.getRefId());
			return r1Staff;
		}
		
	//--School---------------------------------------------------------------//
	public K12SchoolType modelToSIF(R1School r1School)
	{
		K12SchoolType sifSchool = oFac.createK12SchoolType();
		Identification sifIdentification = oFac.createK12SchoolTypeIdentification();
		AddressList sifAddressList = oFac.createK12SchoolTypeAddressList();
		Address sifAddress = oFac.createK12SchoolTypeAddressListAddress();
		Street sifStreet = oFac.createK12SchoolTypeAddressListAddressStreet();
		
		//Identification Data
		sifIdentification.setName(r1School.getLeaName());
		
		//Address Data
		sifStreet.setLine1(r1School.getStreetNumberAndName());
		sifAddress.setStreet(sifStreet);
		sifAddress.setCity(r1School.getCity());
		sifAddress.setCounty(r1School.getAddressCountyName());
		sifAddress.setStateProvince(r1School.getStateCode());
		sifAddress.setPostalCode(r1School.getPostalCode());			
		sifAddressList.getAddress().add(sifAddress);
				
		//Fill Object
		sifSchool.setRefId(r1School.getSchoolRefId());
		sifSchool.setIdentification(sifIdentification);
		sifSchool.setAddressList(sifAddressList);
			
		return sifSchool;
	}
	
	public R1School sifToModel(K12SchoolType sifSchool)
	{
		R1School r1School = new R1School();
		
		//Identification Data
		r1School.setSchoolRefId(sifSchool.getRefId());
		
		//Address Data
		r1School.setStreetNumberAndName(sifSchool.getIdentification().getName());		
		
		for(Address address : sifSchool.getAddressList().getAddress())
		{
			r1School.setStreetNumberAndName(address.getStreet().getLine1());
			r1School.setCity(address.getCity());
			r1School.setAddressCountyName(address.getCounty());
			r1School.setStateCode(address.getStateProvince());
			r1School.setPostalCode(address.getPostalCode());
		}
		
		return r1School;
		
	}
	
	
	
}
