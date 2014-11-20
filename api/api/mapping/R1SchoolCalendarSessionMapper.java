package api.mapping;

//SIF Common


import sif.dd.us32.model.CalendarCEDSType;
import sif.dd.us32.model.CalendarCEDSType.EventList;
import sif.dd.us32.model.CalendarCEDSType.EventList.Event;
import sif.dd.us32.model.ObjectFactory;

//SIF School
import sif.dd.us32.model.K12SchoolType;
import sif.dd.us32.model.K12SchoolType.Identification;
import sif.dd.us32.model.SchoolCalendarCollectionType;
import sif.dd.us32.model.SchoolCalendarType;
import api.model.R1SchoolCalendarSession;


public class R1SchoolCalendarSessionMapper
{
	private ObjectFactory oFac = new ObjectFactory();

		
	//--School---------------------------------------------------------------//
	public K12SchoolType modelToSIF(R1SchoolCalendarSession r1SchoolCalendarSession)
	{
		K12SchoolType sifSchool = oFac.createK12SchoolType();
		

		SchoolCalendarType  sifCalendar = oFac.createSchoolCalendarType();
		sifCalendar.setSchoolRefId(r1SchoolCalendarSession.getSchoolCalendarRefId());		
		return sifSchool;
	}
	
	public R1SchoolCalendarSession sifToModel(K12SchoolType sifSchool)
	{
		R1SchoolCalendarSession r1School = new R1SchoolCalendarSession();

		return r1School;
		
	}
	
	
	
}
