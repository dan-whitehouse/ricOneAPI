package api.service;

import java.util.List;
import api.dao.BaseDAO;
import api.dao.R1LEADAO;
import api.model.R1LEA;
import api.common.BasicTransaction;
import sif3.common.exception.PersistenceException;
import sif3.common.model.PagingInfo;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;

public class R1LEAService extends DBService
{
    private R1LEADAO r1LEADAO = new R1LEADAO();
    
    @Override
    public BaseDAO getDAO()
    {
	    return r1LEADAO;
    }

    //getLEAs
    public R1LEA getLEA(String leaRefID, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	R1LEA row = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	row = r1LEADAO.getLEA(tx, leaRefID, zone, context);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "(Error: R1LEAService) Failed to retrieve lea for leaRefID = "+ leaRefID, true, false);
    	}
		return row;
    }
    
    public List<R1LEA> getLEAs(SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {
    	List<R1LEA> list = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	list = r1LEADAO.getLEAs(tx, zone, context, pagingInfo);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "Failed to retrieve all leas...(R1LEAService)" , true, false);
    	}
		return list;
    }
    

    

}
