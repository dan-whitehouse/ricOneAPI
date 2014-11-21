package api.service;

import java.util.List;
import api.dao.BaseDAO;
import api.dao.R1StudentRaceDAO;
import api.model.R1StudentRace;
import api.common.BasicTransaction;
import sif3.common.exception.PersistenceException;
import sif3.common.model.PagingInfo;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;

public class R1StudentRaceService extends DBService
{
    private R1StudentRaceDAO r1StudentRaceDAO = new R1StudentRaceDAO();
    
    @Override
    public BaseDAO getDAO()
    {
	    return r1StudentRaceDAO;
    }

    //getStudentRaces
    public R1StudentRace getStudentRace(String studentRaceRefID, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	R1StudentRace row = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	row = r1StudentRaceDAO.getStudentRace(tx, studentRaceRefID, zone, context);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "(Error: R1StudentRaceService) Failed to retrieve studentRace for studentRaceRefID = "+ studentRaceRefID, true, false);
    	}
		return row;
    }
    
    public List<R1StudentRace> getStudentRaces(SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {
    	List<R1StudentRace> list = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	list = r1StudentRaceDAO.getStudentRaces(tx, zone, context, pagingInfo);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "Failed to retrieve all studentRaces...(R1StudentRaceService)" , true, false);
    	}
		return list;
    }
    

    

}
