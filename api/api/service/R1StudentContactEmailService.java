package api.service;

import java.util.List;
import api.dao.BaseDAO;
import api.dao.R1StudentContactEmailDAO;
import api.model.R1StudentContactEmail;
import api.common.BasicTransaction;
import sif3.common.exception.PersistenceException;
import sif3.common.model.PagingInfo;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;

public class R1StudentContactEmailService extends DBService
{
    private R1StudentContactEmailDAO r1StudentContactEmailDAO = new R1StudentContactEmailDAO();
    
    @Override
    public BaseDAO getDAO()
    {
	    return r1StudentContactEmailDAO;
    }

    //getStudentContactEmails
    public R1StudentContactEmail getStudentContactEmail(String studentContactEmailRefID, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	R1StudentContactEmail row = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	row = r1StudentContactEmailDAO.getStudentContactEmail(tx, studentContactEmailRefID, zone, context);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "(Error: R1StudentContactEmailService) Failed to retrieve studentContactEmail for studentContactEmailRefID = "+ studentContactEmailRefID, true, false);
    	}
		return row;
    }
    
    public List<R1StudentContactEmail> getStudentContactEmails(SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {
    	List<R1StudentContactEmail> list = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	list = r1StudentContactEmailDAO.getStudentContactEmails(tx, zone, context, pagingInfo);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "Failed to retrieve all studentContactEmails...(R1StudentContactEmailService)" , true, false);
    	}
		return list;
    }
    

    

}
