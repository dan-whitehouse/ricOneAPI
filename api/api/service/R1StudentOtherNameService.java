package api.service;

import java.util.List;
import api.dao.BaseDAO;
import api.dao.R1StudentOtherNameDAO;
import api.model.R1StudentOtherName;
import api.common.BasicTransaction;
import sif3.common.exception.PersistenceException;
import sif3.common.model.PagingInfo;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;

public class R1StudentOtherNameService extends DBService
{
    private R1StudentOtherNameDAO r1StudentOtherNameDAO = new R1StudentOtherNameDAO();
    
    @Override
    public BaseDAO getDAO()
    {
	    return r1StudentOtherNameDAO;
    }

    //getStudentOtherNames
    public R1StudentOtherName getStudentOtherName(String studentOtherNameRefID, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	R1StudentOtherName row = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	row = r1StudentOtherNameDAO.getStudentOtherName(tx, studentOtherNameRefID, zone, context);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "(Error: R1StudentOtherNameService) Failed to retrieve studentOtherName for studentOtherNameRefID = "+ studentOtherNameRefID, true, false);
    	}
		return row;
    }
    
    public List<R1StudentOtherName> getStudentOtherNames(SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {
    	List<R1StudentOtherName> list = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	list = r1StudentOtherNameDAO.getStudentOtherNames(tx, zone, context, pagingInfo);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "Failed to retrieve all studentOtherNames...(R1StudentOtherNameService)" , true, false);
    	}
		return list;
    }
    

    

}
