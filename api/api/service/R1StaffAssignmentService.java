package api.service;

import java.util.List;
import api.dao.BaseDAO;
import api.dao.R1StaffAssignmentDAO;
import api.model.R1StaffAssignment;
import api.common.BasicTransaction;
import sif3.common.exception.PersistenceException;
import sif3.common.model.PagingInfo;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;

public class R1StaffAssignmentService extends DBService
{
    private R1StaffAssignmentDAO r1StaffAssignmentDAO = new R1StaffAssignmentDAO();
    
    @Override
    public BaseDAO getDAO()
    {
	    return r1StaffAssignmentDAO;
    }

    //getStaffAssignments
    public R1StaffAssignment getStaffAssignment(String staffAssignmentRefID, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	R1StaffAssignment row = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	row = r1StaffAssignmentDAO.getStaffAssignment(tx, staffAssignmentRefID, zone, context);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "(Error: R1StaffAssignmentService) Failed to retrieve staffAssignment for staffAssignmentRefID ="+ staffAssignmentRefID, true, false);
    	}
		return row;
    }
    
    public List<R1StaffAssignment> getStaffAssignments(SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {
    	List<R1StaffAssignment> list = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	list = r1StaffAssignmentDAO.getStaffAssignments(tx, zone, context, pagingInfo); //returning null
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		System.out.println("~~~~DW" + ex.getMessage());
    		rollback(tx);
    		exceptionMapper(ex, "Failed to retrieve all staffAssignments...(R1StaffAssignmentService)" , true, false);
    	}
		return list;
    }
    

    

}
