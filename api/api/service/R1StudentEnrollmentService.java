package api.service;

import java.util.List;
import api.dao.BaseDAO;
import api.dao.R1StudentEnrollmentDAO;
import api.model.R1StudentEnrollment;
import api.common.BasicTransaction;
import sif3.common.exception.PersistenceException;
import sif3.common.model.PagingInfo;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;

public class R1StudentEnrollmentService extends DBService
{
    private R1StudentEnrollmentDAO r1StudentEnrollmentDAO = new R1StudentEnrollmentDAO();
    
    @Override
    public BaseDAO getDAO()
    {
	    return r1StudentEnrollmentDAO;
    }

    //getStudentEnrollments
    public R1StudentEnrollment getStudentEnrollment(String studentEnrollmentRefID, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	R1StudentEnrollment row = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	row = r1StudentEnrollmentDAO.getStudentEnrollment(tx, studentEnrollmentRefID, zone, context);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "(Error: R1StudentEnrollmentService) Failed to retrieve studentEnrollment for studentEnrollmentRefID = "+ studentEnrollmentRefID, true, false);
    	}
		return row;
    }
    
    public List<R1StudentEnrollment> getStudentEnrollments(SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {
    	List<R1StudentEnrollment> list = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	list = r1StudentEnrollmentDAO.getStudentEnrollments(tx, zone, context, pagingInfo);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "Failed to retrieve all studentEnrollments...(R1StudentEnrollmentService)" , true, false);
    	}
		return list;
    }
    

    

}
