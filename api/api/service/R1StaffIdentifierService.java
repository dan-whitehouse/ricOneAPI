package api.service;

import java.util.List;
import api.dao.BaseDAO;
import api.dao.R1StaffIdentifierDAO;
import api.model.R1StaffIdentifier;
import api.common.BasicTransaction;
import sif3.common.exception.PersistenceException;
import sif3.common.model.PagingInfo;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;

public class R1StaffIdentifierService extends DBService
{
    private R1StaffIdentifierDAO r1StaffIdentifierDAO = new R1StaffIdentifierDAO();
    
    @Override
    public BaseDAO getDAO()
    {
	    return r1StaffIdentifierDAO;
    }

    //getStaffIdentifiers
    public R1StaffIdentifier getStaffIdentifier(String staffIdentifierRefID, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	R1StaffIdentifier row = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	row = r1StaffIdentifierDAO.getStaffIdentifier(tx, staffIdentifierRefID, zone, context);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "(Error: R1StaffIdentifierService) Failed to retrieve staffIdentifier for staffIdentifierRefID ="+ staffIdentifierRefID, true, false);
    	}
		return row;
    }
    
    public List<R1StaffIdentifier> getStaffIdentifiers(SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {
    	List<R1StaffIdentifier> list = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	list = r1StaffIdentifierDAO.getStaffIdentifiers(tx, zone, context, pagingInfo); //returning null
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		System.out.println("~~~~DW" + ex.getMessage());
    		rollback(tx);
    		exceptionMapper(ex, "Failed to retrieve all staffIdentifiers...(R1StaffIdentifierService)" , true, false);
    	}
		return list;
    }
    

    

}
