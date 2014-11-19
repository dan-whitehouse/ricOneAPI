package api.mapping;

//SIF Common


import sif.dd.us32.model.ObjectFactory;

//SIF School
import sif.dd.us32.model.K12SchoolType;
import sif.dd.us32.model.K12SchoolType.Identification;
import api.model.R1SchoolCalendar;


public class R1SchoolCalendarMapper
{
	private ObjectFactory oFac = new ObjectFactory();

		
	//--School---------------------------------------------------------------//
	public K12SchoolType modelToSIF(R1SchoolCalendar r1SchoolCalendar)
	{
		K12SchoolType sifSchool = oFac.createK12SchoolType();
		Identification sifIdentification = oFac.createK12SchoolTypeIdentification();
				
		//Identification Data	
		sifSchool.setRefId(r1SchoolCalendar.getSchoolRefId());
		

		sifSchool.setIdentification(sifIdentification);
			
		return sifSchool;
	}
	
	public R1SchoolCalendar sifToModel(K12SchoolType sifSchool)
	{
		R1SchoolCalendar r1SchoolCalendar = new R1SchoolCalendar();
		
		//Identification Data
		r1SchoolCalendar.setSchoolRefId(sifSchool.getRefId());
				
		return r1SchoolCalendar;
		
	}
	
	
	
}
