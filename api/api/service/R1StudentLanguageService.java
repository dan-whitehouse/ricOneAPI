package api.service;

import java.util.List;
import api.dao.BaseDAO;
import api.dao.R1StudentLanguageDAO;
import api.model.R1StudentLanguage;
import api.common.BasicTransaction;
import sif3.common.exception.PersistenceException;
import sif3.common.model.PagingInfo;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;

public class R1StudentLanguageService extends DBService
{
    private R1StudentLanguageDAO r1StudentLanguageDAO = new R1StudentLanguageDAO();
    
    @Override
    public BaseDAO getDAO()
    {
	    return r1StudentLanguageDAO;
    }

    //getStudentLanguages
    public R1StudentLanguage getStudentLanguage(String studentLanguageRefID, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	R1StudentLanguage row = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	row = r1StudentLanguageDAO.getStudentLanguage(tx, studentLanguageRefID, zone, context);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "(Error: R1StudentLanguageService) Failed to retrieve studentLanguage for studentLanguageRefID = "+ studentLanguageRefID, true, false);
    	}
		return row;
    }
    
    public List<R1StudentLanguage> getStudentLanguages(SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {
    	List<R1StudentLanguage> list = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	list = r1StudentLanguageDAO.getStudentLanguages(tx, zone, context, pagingInfo);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "Failed to retrieve all studentLanguages...(R1StudentLanguageService)" , true, false);
    	}
		return list;
    }
    

    

}
