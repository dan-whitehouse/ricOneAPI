package api.service;

import java.util.List;
import api.dao.BaseDAO;
import api.dao.R1CourseSectionScheduleDAO;
import api.model.R1CourseSectionSchedule;
import api.common.BasicTransaction;
import sif3.common.exception.PersistenceException;
import sif3.common.model.PagingInfo;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;

public class R1CourseSectionScheduleService extends DBService
{
    private R1CourseSectionScheduleDAO r1CourseSectionScheduleDAO = new R1CourseSectionScheduleDAO();
    
    @Override
    public BaseDAO getDAO()
    {
	    return r1CourseSectionScheduleDAO;
    }

    //getCourseSectionSchedules
    public R1CourseSectionSchedule getCourseSectionSchedule(String courseSectionScheduleRefID, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	R1CourseSectionSchedule row = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	row = r1CourseSectionScheduleDAO.getCourseSectionSchedule(tx, courseSectionScheduleRefID, zone, context);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "(Error: R1CourseSectionScheduleService) Failed to retrieve courseSectionSchedule for courseSectionScheduleRefID = "+ courseSectionScheduleRefID, true, false);
    	}
		return row;
    }
    
    public List<R1CourseSectionSchedule> getCourseSectionSchedules(SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {
    	List<R1CourseSectionSchedule> list = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	list = r1CourseSectionScheduleDAO.getCourseSectionSchedules(tx, zone, context, pagingInfo);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "Failed to retrieve all courseSectionSchedules...(R1CourseSectionScheduleService)" , true, false);
    	}
		return list;
    }
    

    

}
