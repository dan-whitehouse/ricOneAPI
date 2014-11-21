package api.service;

import java.util.List;
import api.dao.BaseDAO;
import api.dao.R1StaffEmailDAO;
import api.model.R1StaffEmail;
import api.common.BasicTransaction;
import sif3.common.exception.PersistenceException;
import sif3.common.model.PagingInfo;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;

public class R1StaffEmailService extends DBService
{
    private R1StaffEmailDAO r1StaffEmailDAO = new R1StaffEmailDAO();
    
    @Override
    public BaseDAO getDAO()
    {
	    return r1StaffEmailDAO;
    }

    //getStaffEmails
    public R1StaffEmail getStaffEmail(String staffEmailRefID, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	R1StaffEmail row = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	row = r1StaffEmailDAO.getStaffEmail(tx, staffEmailRefID, zone, context);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "(Error: R1StaffEmailService) Failed to retrieve staffEmail for staffEmailRefID ="+ staffEmailRefID, true, false);
    	}
		return row;
    }
    
    public List<R1StaffEmail> getStaffEmails(SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {
    	List<R1StaffEmail> list = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	list = r1StaffEmailDAO.getStaffEmails(tx, zone, context, pagingInfo); //returning null
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		System.out.println("~~~~DW" + ex.getMessage());
    		rollback(tx);
    		exceptionMapper(ex, "Failed to retrieve all staffEmails...(R1StaffEmailService)" , true, false);
    	}
		return list;
    }
    

    

}
