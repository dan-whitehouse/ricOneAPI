package api.service;

import java.util.List;
import api.dao.BaseDAO;
import api.dao.R1StudentIdentifierDAO;
import api.model.R1StudentIdentifier;
import api.common.BasicTransaction;
import sif3.common.exception.PersistenceException;
import sif3.common.model.PagingInfo;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;

public class R1StudentIdentifierService extends DBService
{
    private R1StudentIdentifierDAO r1StudentIdentifierDAO = new R1StudentIdentifierDAO();
    
    @Override
    public BaseDAO getDAO()
    {
	    return r1StudentIdentifierDAO;
    }

    //getStudentIdentifiers
    public R1StudentIdentifier getStudentIdentifier(String studentIdentifierRefID, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	R1StudentIdentifier row = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	row = r1StudentIdentifierDAO.getStudentIdentifier(tx, studentIdentifierRefID, zone, context);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "(Error: R1StudentIdentifierService) Failed to retrieve studentIdentifier for studentIdentifierRefID = "+ studentIdentifierRefID, true, false);
    	}
		return row;
    }
    
    public List<R1StudentIdentifier> getStudentIdentifiers(SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {
    	List<R1StudentIdentifier> list = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	list = r1StudentIdentifierDAO.getStudentIdentifiers(tx, zone, context, pagingInfo);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "Failed to retrieve all studentIdentifiers...(R1StudentIdentifierService)" , true, false);
    	}
		return list;
    }
    

    

}
