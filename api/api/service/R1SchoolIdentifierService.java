package api.service;

import java.util.List;
import api.dao.BaseDAO;
import api.dao.R1SchoolIdentifierDAO;
import api.model.R1SchoolIdentifier;
import api.common.BasicTransaction;
import sif3.common.exception.PersistenceException;
import sif3.common.model.PagingInfo;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;

public class R1SchoolIdentifierService extends DBService
{
    private R1SchoolIdentifierDAO r1SchoolIdentifierDAO = new R1SchoolIdentifierDAO();
    
    @Override
    public BaseDAO getDAO()
    {
	    return r1SchoolIdentifierDAO;
    }

    //getSchoolIdentifiers
    public R1SchoolIdentifier getSchoolIdentifier(String schoolIdentifierRefID, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	R1SchoolIdentifier row = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	row = r1SchoolIdentifierDAO.getSchoolIdentifier(tx, schoolIdentifierRefID, zone, context);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "(Error: R1SchoolIdentifierService) Failed to retrieve schoolIdentifier for schoolIdentifierRefID = "+ schoolIdentifierRefID, true, false);
    	}
		return row;
    }
    
    public List<R1SchoolIdentifier> getSchoolIdentifiers(SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {
    	List<R1SchoolIdentifier> list = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	list = r1SchoolIdentifierDAO.getSchoolIdentifiers(tx, zone, context, pagingInfo);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "Failed to retrieve schoolIdentifiers...some error here = '" , true, false);
    	}
		return list;
    }
    

    

}
