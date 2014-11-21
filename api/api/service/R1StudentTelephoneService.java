package api.service;

import java.util.List;
import api.dao.BaseDAO;
import api.dao.R1StudentTelephoneDAO;
import api.model.R1StudentTelephone;
import api.common.BasicTransaction;
import sif3.common.exception.PersistenceException;
import sif3.common.model.PagingInfo;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;

public class R1StudentTelephoneService extends DBService
{
    private R1StudentTelephoneDAO r1StudentTelephoneDAO = new R1StudentTelephoneDAO();
    
    @Override
    public BaseDAO getDAO()
    {
	    return r1StudentTelephoneDAO;
    }

    //getStudentTelephones
    public R1StudentTelephone getStudentTelephone(String studentTelephoneRefID, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	R1StudentTelephone row = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	row = r1StudentTelephoneDAO.getStudentTelephone(tx, studentTelephoneRefID, zone, context);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "(Error: R1StudentTelephoneService) Failed to retrieve studentTelephone for studentTelephoneRefID = "+ studentTelephoneRefID, true, false);
    	}
		return row;
    }
    
    public List<R1StudentTelephone> getStudentTelephones(SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {
    	List<R1StudentTelephone> list = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	list = r1StudentTelephoneDAO.getStudentTelephones(tx, zone, context, pagingInfo);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "Failed to retrieve all studentTelephones...(R1StudentTelephoneService)" , true, false);
    	}
		return list;
    }
    

    

}
