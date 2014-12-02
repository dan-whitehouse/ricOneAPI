package api.service;

import java.util.List;
import api.dao.BaseDAO;
import api.dao.R1CourseDAO;
import api.model.R1Course;
import api.common.BasicTransaction;
import sif3.common.exception.PersistenceException;
import sif3.common.model.PagingInfo;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;

public class R1CourseService extends DBService
{
    private R1CourseDAO r1CourseDAO = new R1CourseDAO();
    
    @Override
    public BaseDAO getDAO()
    {
	    return r1CourseDAO;
    }

    //getCourses
    public R1Course getCourse(String courseRefID, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	R1Course row = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	row = r1CourseDAO.getCourse(tx, courseRefID, zone, context);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		System.out.println("DW-Exception: " + ex.getMessage());
    		exceptionMapper(ex, "(Error: R1CourseService) Failed to retrieve course for courseRefID = "+ courseRefID, true, false);
    	}
		return row;
    }
    
    public List<R1Course> getCourses(SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {
    	List<R1Course> list = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	list = r1CourseDAO.getCourses(tx, zone, context, pagingInfo);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		System.out.println("DW-Exception: " + ex.getMessage());
    		exceptionMapper(ex, "Failed to retrieve all courses...(R1CourseService)" , true, false);
    		
    	}
		return list;
    }
    

    

}
