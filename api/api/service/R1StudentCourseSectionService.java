package api.service;

import java.util.List;
import api.dao.BaseDAO;
import api.dao.R1StudentCourseSectionDAO;
import api.model.R1StudentCourseSection;
import api.common.BasicTransaction;
import sif3.common.exception.PersistenceException;
import sif3.common.model.PagingInfo;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;

public class R1StudentCourseSectionService extends DBService
{
    private R1StudentCourseSectionDAO r1StudentCourseSectionDAO = new R1StudentCourseSectionDAO();
    
    @Override
    public BaseDAO getDAO()
    {
	    return r1StudentCourseSectionDAO;
    }

    //getStudentCourseSections
    public R1StudentCourseSection getStudentCourseSection(String studentCourseSectionRefID, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	R1StudentCourseSection row = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	row = r1StudentCourseSectionDAO.getStudentCourseSection(tx, studentCourseSectionRefID, zone, context);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "(Error: R1StudentCourseSectionService) Failed to retrieve studentCourseSection for studentCourseSectionRefID = "+ studentCourseSectionRefID, true, false);
    	}
		return row;
    }
    
    public List<R1StudentCourseSection> getStudentCourseSections(SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {
    	List<R1StudentCourseSection> list = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	list = r1StudentCourseSectionDAO.getStudentCourseSections(tx, zone, context, pagingInfo);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "Failed to retrieve all studentCourseSections...(R1StudentCourseSectionService)" , true, false);
    	}
		return list;
    }
    

    

}
