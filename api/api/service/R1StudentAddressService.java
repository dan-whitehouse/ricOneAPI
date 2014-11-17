package api.service;

import java.util.List;
import api.dao.BaseDAO;
import api.dao.R1StudentAddressDAO;
import api.model.R1StudentAddress;
import api.common.BasicTransaction;
import sif3.common.exception.PersistenceException;
import sif3.common.model.PagingInfo;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;

public class R1StudentAddressService extends DBService
{
    private R1StudentAddressDAO r1StudentAddressDAO = new R1StudentAddressDAO();
    
    @Override
    public BaseDAO getDAO()
    {
	    return r1StudentAddressDAO;
    }

    //getStudentAddresss
    public R1StudentAddress getStudentAddress(String studentAddressRefID, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	R1StudentAddress row = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	row = r1StudentAddressDAO.getStudentAddress(tx, studentAddressRefID, zone, context);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "(Error: R1StudentAddressService) Failed to retrieve studentAddress for studentAddressRefID = "+ studentAddressRefID, true, false);
    	}
		return row;
    }
    
    public List<R1StudentAddress> getStudentAddresses(SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {
    	List<R1StudentAddress> list = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	list = r1StudentAddressDAO.getStudentAddresses(tx, zone, context, pagingInfo);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "Failed to retrieve studentAddresses...some error here = '" , true, false);
    	}
		return list;
    }
    

    

}
