package api.service;

import java.util.List;
import api.dao.BaseDAO;
import api.dao.R1SchoolCalendarSessionDAO;
import api.model.R1SchoolCalendarSession;
import api.common.BasicTransaction;
import sif3.common.exception.PersistenceException;
import sif3.common.model.PagingInfo;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;

public class R1SchoolCalendarSessionService extends DBService
{
    private R1SchoolCalendarSessionDAO r1SchoolCalendarSessionDAO = new R1SchoolCalendarSessionDAO();
    
    @Override
    public BaseDAO getDAO()
    {
	    return r1SchoolCalendarSessionDAO;
    }

    //getSchoolCalendarSessions
    public R1SchoolCalendarSession getSchoolCalendarSession(String schoolCalendarSessionRefID, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	R1SchoolCalendarSession row = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	row = r1SchoolCalendarSessionDAO.getSchoolCalendarSession(tx, schoolCalendarSessionRefID, zone, context);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "(Error: R1SchoolCalendarSessionService) Failed to retrieve schoolCalendarSession for schoolCalendarSessionRefID = "+ schoolCalendarSessionRefID, true, false);
    	}
		return row;
    }
    
    public List<R1SchoolCalendarSession> getSchoolCalendarSessions(SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {
    	List<R1SchoolCalendarSession> list = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	list = r1SchoolCalendarSessionDAO.getSchoolCalendarSessions(tx, zone, context, pagingInfo);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "Failed to retrieve schoolCalendarSessions...some error here = '" , true, false);
    	}
		return list;
    }
    

    

}
