package api.service;

import java.util.List;

import api.dao.BaseDAO;
import api.dao.R1StudentContactDAO;
import api.model.R1Student;
import api.model.R1StudentContact;
import api.common.BasicTransaction;
import sif3.common.exception.PersistenceException;
import sif3.common.model.PagingInfo;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;

public class R1StudentContactService extends DBService
{
    private R1StudentContactDAO r1StudentContactDAO = new R1StudentContactDAO();
    
    @Override
    public BaseDAO getDAO()
    {
	    return r1StudentContactDAO;
    }

    //getStudentContacts
    public R1StudentContact getStudentContact(String studentContactRefID, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	R1StudentContact row = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	row = r1StudentContactDAO.getStudentContact(tx, studentContactRefID, zone, context);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "(Error: R1StudentContactService) Failed to retrieve studentContact for studentContactRefID = "+ studentContactRefID, true, false);
    	}
		return row;
    }
    
    public List<R1StudentContact> getStudentContacts(SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {
    	List<R1StudentContact> list = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	list = r1StudentContactDAO.getStudentContacts(tx, zone, context, pagingInfo);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "Failed to retrieve all studentContacts...(R1StudentContactService)" , true, false);
    	}
		return list;
    }
    

    public boolean deleteStudentContact(String studentContactRefID, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	R1StudentContact row = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	row = r1StudentContactDAO.getStudentContact(tx, studentContactRefID, zone, context);
    		tx.getSession().delete(row);
    		tx.commit();
    		return true;
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "(Error: R1StudentContactService) Failed to retrieve student Contact for studentContactRefID = "+ studentContactRefID, true, false);
    		return false;
    	}		
    }
    

}
