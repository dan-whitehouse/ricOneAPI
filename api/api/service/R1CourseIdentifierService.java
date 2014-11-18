package api.service;

import java.util.List;
import api.dao.BaseDAO;
import api.dao.R1CourseIdentifierDAO;
import api.model.R1CourseIdentifier;
import api.common.BasicTransaction;
import sif3.common.exception.PersistenceException;
import sif3.common.model.PagingInfo;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;

public class R1CourseIdentifierService extends DBService
{
    private R1CourseIdentifierDAO r1CourseIdentifierDAO = new R1CourseIdentifierDAO();
    
    @Override
    public BaseDAO getDAO()
    {
	    return r1CourseIdentifierDAO;
    }

    //getCourseIdentifiers
    public R1CourseIdentifier getCourseIdentifier(String courseIdentifierRefID, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	R1CourseIdentifier row = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	row = r1CourseIdentifierDAO.getCourseIdentifier(tx, courseIdentifierRefID, zone, context);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "(Error: R1CourseIdentifierService) Failed to retrieve courseIdentifier for courseIdentifierRefID = "+ courseIdentifierRefID, true, false);
    	}
		return row;
    }
    
    public List<R1CourseIdentifier> getCourseIdentifiers(SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {
    	List<R1CourseIdentifier> list = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	list = r1CourseIdentifierDAO.getCourseIdentifiers(tx, zone, context, pagingInfo);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "Failed to retrieve all courseIdentifiers...(R1CourseIdentifierService)" , true, false);
    	}
		return list;
    }
    

    

}
