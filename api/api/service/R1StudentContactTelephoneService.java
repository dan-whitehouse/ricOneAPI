package api.service;

import java.util.List;
import api.dao.BaseDAO;
import api.dao.R1StudentContactTelephoneDAO;
import api.model.R1StudentContactTelephone;
import api.common.BasicTransaction;
import sif3.common.exception.PersistenceException;
import sif3.common.model.PagingInfo;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;

public class R1StudentContactTelephoneService extends DBService
{
    private R1StudentContactTelephoneDAO r1StudentContactTelephoneDAO = new R1StudentContactTelephoneDAO();
    
    @Override
    public BaseDAO getDAO()
    {
	    return r1StudentContactTelephoneDAO;
    }

    //getStudentContactTelephones
    public R1StudentContactTelephone getStudentContactTelephone(String studentContactTelephoneRefID, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	R1StudentContactTelephone row = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	row = r1StudentContactTelephoneDAO.getStudentContactTelephone(tx, studentContactTelephoneRefID, zone, context);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "(Error: R1StudentContactTelephoneService) Failed to retrieve studentContactTelephone for studentContactTelephoneRefID = "+ studentContactTelephoneRefID, true, false);
    	}
		return row;
    }
    
    public List<R1StudentContactTelephone> getStudentContactTelephones(SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {
    	List<R1StudentContactTelephone> list = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	list = r1StudentContactTelephoneDAO.getStudentContactTelephones(tx, zone, context, pagingInfo);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "Failed to retrieve all studentContactTelephones...(R1StudentContactTelephoneService)" , true, false);
    	}
		return list;
    }
    

    

}
