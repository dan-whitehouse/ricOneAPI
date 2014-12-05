package api.mapping.sif32;

//SIF Common


import sif.dd.us32.model.K12SchoolType.SessionList;
import sif.dd.us32.model.K12SchoolType.SessionList.Session;
import sif.dd.us32.model.ObjectFactory;

//SIF School
import sif.dd.us32.model.K12SchoolType;
import sif.dd.us32.model.K12SchoolType.Identification;
import api.model.R1SchoolCalendar;
import api.model.R1SchoolCalendarSession;


public class R1SchoolCalendarMapper
{
	private ObjectFactory oFac = new ObjectFactory();

		
	//--School---------------------------------------------------------------//
	public K12SchoolType modelToSIF(R1SchoolCalendar r1SchoolCalendar)
	{
		K12SchoolType sifSchool = oFac.createK12SchoolType();
		Identification sifIdentification = oFac.createK12SchoolTypeIdentification();
		SessionList sifSessionList = oFac.createK12SchoolTypeSessionList();
		
		//Identification Data	
		sifSchool.setRefId(r1SchoolCalendar.getSchoolRefId());
		
		//Session Data
		for(R1SchoolCalendarSession session : r1SchoolCalendar.getR1SchoolCalendarSessions())
		{
			Session sifSession = oFac.createK12SchoolTypeSessionListSession();
			
			if(session.getDaysInSession() != null)
			{
				sifSession.setDaysInSession(String.valueOf(session.getDaysInSession())); 
			}
			
			if(session.getInstructionalMinutes() != null)
			{
				sifSession.setInstructionalMinutes(String.valueOf(session.getInstructionalMinutes())); 
			}
			
			if(session.getMinutesPerDay() != null)
			{
				sifSession.setMinutesPerDay(String.valueOf(session.getMinutesPerDay()));
			}
			
			sifSession.setFirstInstructionDate(session.getFirstInstructionDate().toString());		
			sifSession.setLastInstructionDate(session.getLastInstructionDate().toString());
			sifSession.setSessionDescription(session.getDescription());
			
			sifSessionList.getSession().add(sifSession);
		}
		
		
		sifSchool.setSessionList(sifSessionList);
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
