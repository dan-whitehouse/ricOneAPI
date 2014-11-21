package api.service;

import java.util.List;
import api.dao.BaseDAO;
import api.dao.R1StaffCourseSectionDAO;
import api.model.R1StaffCourseSection;
import api.common.BasicTransaction;
import sif3.common.exception.PersistenceException;
import sif3.common.model.PagingInfo;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;

public class R1StaffCourseSectionService extends DBService
{
    private R1StaffCourseSectionDAO r1StaffCourseSectionDAO = new R1StaffCourseSectionDAO();
    
    @Override
    public BaseDAO getDAO()
    {
	    return r1StaffCourseSectionDAO;
    }

    //getStaffCourseSections
    public R1StaffCourseSection getStaffCourseSection(String staffCourseSectionRefID, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	R1StaffCourseSection row = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	row = r1StaffCourseSectionDAO.getStaffCourseSection(tx, staffCourseSectionRefID, zone, context);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "(Error: R1StaffCourseSectionService) Failed to retrieve staffCourseSection for staffCourseSectionRefID ="+ staffCourseSectionRefID, true, false);
    	}
		return row;
    }
    
    public List<R1StaffCourseSection> getStaffCourseSections(SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {
    	List<R1StaffCourseSection> list = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	list = r1StaffCourseSectionDAO.getStaffCourseSections(tx, zone, context, pagingInfo); //returning null
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		System.out.println("~~~~DW" + ex.getMessage());
    		rollback(tx);
    		exceptionMapper(ex, "Failed to retrieve all staffCourseSections...(R1StaffCourseSectionService)" , true, false);
    	}
		return list;
    }
    

    

}
