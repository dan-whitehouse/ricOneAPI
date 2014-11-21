package api.service;

import java.util.List;
import api.dao.BaseDAO;
import api.dao.R1StudentEmailDAO;
import api.model.R1StudentEmail;
import api.common.BasicTransaction;
import sif3.common.exception.PersistenceException;
import sif3.common.model.PagingInfo;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;

public class R1StudentEmailService extends DBService
{
    private R1StudentEmailDAO r1StudentEmailDAO = new R1StudentEmailDAO();
    
    @Override
    public BaseDAO getDAO()
    {
	    return r1StudentEmailDAO;
    }

    //getStudentEmails
    public R1StudentEmail getStudentEmail(String studentEmailRefID, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	R1StudentEmail row = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	row = r1StudentEmailDAO.getStudentEmail(tx, studentEmailRefID, zone, context);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "(Error: R1StudentEmailService) Failed to retrieve studentEmail for studentEmailRefID = "+ studentEmailRefID, true, false);
    	}
		return row;
    }
    
    public List<R1StudentEmail> getStudentEmails(SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {
    	List<R1StudentEmail> list = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	list = r1StudentEmailDAO.getStudentEmails(tx, zone, context, pagingInfo);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "Failed to retrieve all studentEmails...(R1StudentEmailService)" , true, false);
    	}
		return list;
    }
    

    

}
