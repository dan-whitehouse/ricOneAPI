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
    public R1StudentHealth getStudentHealth(String StudentHealthRefID, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	R1StudentHealth row = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	row = r1StudentHealthDAO.getStudentHealth(tx, StudentHealthRefID, zone, context);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "(Error: R1StudentHealthService) Failed to retrieve StudentHealth for StudentHealthRefID = "+ StudentHealthRefID, true, false);
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
    		exceptionMapper(ex, "Failed to retrieve all StudentHealths...(R1StudentHealthService)" , true, false);
    	}
		return list;
    }
    
    public boolean deleteStudentHealth(String studentHealthRefId, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	BasicTransaction tx = null;
    	try
    	{
    		tx = startTransaction();
    		if(r1StudentHealthDAO.deleteStudentHealth(tx, studentHealthRefId, zone, context))
    		{
    			tx.commit();
    			return true;
    		}
    		else
    		{
    			rollback(tx);
    			return false;
    		}  		
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "(Error: R1StudentHealthService) Failed to retrieve student for studentRefID = "+ studentHealthRefId, true, false);
    		return false;
    	}		
    }
    
}
