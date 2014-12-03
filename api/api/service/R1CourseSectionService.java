package api.service;

import java.util.List;

import api.dao.BaseDAO;
import api.dao.R1CourseSectionDAO;
import api.model.R1Course;
import api.model.R1CourseSection;
import api.common.BasicTransaction;
import sif3.common.exception.PersistenceException;
import sif3.common.model.PagingInfo;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;

public class R1CourseSectionService extends DBService
{
    private R1CourseSectionDAO r1CourseSectionDAO = new R1CourseSectionDAO();
    
    @Override
    public BaseDAO getDAO()
    {
	    return r1CourseSectionDAO;
    }

    //getCourseSections
    public R1CourseSection getCourseSection(String courseSectionRefID, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	R1CourseSection row = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	row = r1CourseSectionDAO.getCourseSection(tx, courseSectionRefID, zone, context);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "(Error: R1CourseSectionService) Failed to retrieve courseSection for courseSectionRefID = "+ courseSectionRefID, true, false);
    	}
		return row;
    }
    
    public List<R1CourseSection> getCourseSections(SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {
    	List<R1CourseSection> list = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	list = r1CourseSectionDAO.getCourseSections(tx, zone, context, pagingInfo);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "Failed to retrieve all courseSections...(R1CourseSectionService)" , true, false);
    	}
		return list;
    }
    
    public boolean deleteCourseSection(String courseSectionRefID, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	R1CourseSection row = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	row = r1CourseSectionDAO.getCourseSection(tx, courseSectionRefID, zone, context);
    		tx.getSession().delete(row);
    		tx.commit();
    		return true;
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "(Error: R1CourseSectionService) Failed to retrieve Course Section for courseSectionRefID = "+ courseSectionRefID, true, false);
    		return false;
    	}		
    }

    

}
