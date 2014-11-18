package api.service;

import java.util.List;
import api.dao.BaseDAO;
import api.dao.R1StudentContactAddressDAO;
import api.model.R1StudentContactAddress;
import api.common.BasicTransaction;
import sif3.common.exception.PersistenceException;
import sif3.common.model.PagingInfo;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;

public class R1StudentContactAddressService extends DBService
{
    private R1StudentContactAddressDAO r1StudentContactAddressDAO = new R1StudentContactAddressDAO();
    
    @Override
    public BaseDAO getDAO()
    {
	    return r1StudentContactAddressDAO;
    }

    //getStudentContactAddresss
    public R1StudentContactAddress getStudentContactAddress(String studentContactAddressRefID, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	R1StudentContactAddress row = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	row = r1StudentContactAddressDAO.getStudentContactAddress(tx, studentContactAddressRefID, zone, context);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "(Error: R1StudentContactAddressService) Failed to retrieve studentContactAddress for studentContactAddressRefID = "+ studentContactAddressRefID, true, false);
    	}
		return row;
    }
    
    public List<R1StudentContactAddress> getStudentContactAddresss(SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {
    	List<R1StudentContactAddress> list = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	list = r1StudentContactAddressDAO.getStudentContactAddresss(tx, zone, context, pagingInfo);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "Failed to retrieve all studentContactAddresss...(R1StudentContactAddressService)" , true, false);
    	}
		return list;
    }
    

    

}
