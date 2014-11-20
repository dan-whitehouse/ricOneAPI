package api.mapping;

//SIF Common


import sif.dd.us32.model.ObjectFactory;

//SIF School
import sif.dd.us32.model.K12SchoolType;
import sif.dd.us32.model.K12SchoolType.Identification;
import api.model.R1SchoolIdentifier;


public class R1SchoolIdentifierMapper
{
	private ObjectFactory oFac = new ObjectFactory();

		
	//--School---------------------------------------------------------------//
	public K12SchoolType modelToSIF(R1SchoolIdentifier r1School)
	{
		K12SchoolType sifSchool = oFac.createK12SchoolType();
		Identification sifIdentification = oFac.createK12SchoolTypeIdentification();
				
		//Identification Data
		sifIdentification.setSchoolId(r1School.getSchoolId());	
		sifSchool.setRefId(r1School.getSchoolRefId());
		
		sifSchool.setIdentification(sifIdentification);
			
		return sifSchool;
	}
	
	public R1SchoolIdentifier sifToModel(K12SchoolType sifSchool)
	{
		R1SchoolIdentifier r1School = new R1SchoolIdentifier();
		
		//Identification Data
		r1School.setSchoolRefId(sifSchool.getRefId());
		r1School.setSchoolId(sifSchool.getIdentification().getSchoolId());
		r1School.setIdentificationSystemCode(sifSchool.getIdentification().getOrganizationType()); //Idk if this is correct
				
		return r1School;
		
	}
	
	
	
}
