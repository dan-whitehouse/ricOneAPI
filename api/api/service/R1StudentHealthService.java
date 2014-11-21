package api.service;

import java.util.List;
import api.dao.BaseDAO;
import api.dao.R1StudentHealthDAO;
import api.model.R1StudentHealth;
import api.common.BasicTransaction;
import sif3.common.exception.PersistenceException;
import sif3.common.model.PagingInfo;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;

public class R1StudentHealthService extends DBService
{
    private R1StudentHealthDAO r1StudentHealthDAO = new R1StudentHealthDAO();
    
    @Override
    public BaseDAO getDAO()
    {
	    return r1StudentHealthDAO;
    }

    //getStudentHealths
    public R1StudentHealth getStudentHealth(String studentHealthRefID, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	R1StudentHealth row = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	row = r1StudentHealthDAO.getStudentHealth(tx, studentHealthRefID, zone, context);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "(Error: R1StudentHealthService) Failed to retrieve studentHealth for studentHealthRefID = "+ studentHealthRefID, true, false);
    	}
		return row;
    }
    
    public List<R1StudentHealth> getStudentHealths(SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {
    	List<R1StudentHealth> list = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	list = r1StudentHealthDAO.getStudentHealths(tx, zone, context, pagingInfo);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "Failed to retrieve all studentHealths...(R1StudentHealthService)" , true, false);
    	}
		return list;
    }
    

    

}
