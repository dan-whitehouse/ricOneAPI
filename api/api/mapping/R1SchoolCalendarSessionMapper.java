package api.mapping;

//SIF Common


import sif.dd.us32.model.ObjectFactory;

//SIF School
import sif.dd.us32.model.K12SchoolType;
import sif.dd.us32.model.K12SchoolType.Identification;
import api.model.R1SchoolCalendarSession;


public class R1SchoolCalendarSessionMapper
{
	private ObjectFactory oFac = new ObjectFactory();

		
	//--School---------------------------------------------------------------//
	public K12SchoolType modelToSIF(R1SchoolCalendarSession r1SchoolCalendarSession)
	{
		K12SchoolType sifSchool = oFac.createK12SchoolType();
		Identification sifIdentification = oFac.createK12SchoolTypeIdentification();

		sifSchool.setIdentification(sifIdentification);
			
		return sifSchool;
	}
	
	public R1SchoolCalendarSession sifToModel(K12SchoolType sifSchool)
	{
		R1SchoolCalendarSession r1School = new R1SchoolCalendarSession();

		return r1School;
		
	}
	
	
	
}
