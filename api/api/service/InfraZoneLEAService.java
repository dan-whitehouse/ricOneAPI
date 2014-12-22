package api.service;

import java.util.List;

import sif3.common.persist.dao.BaseDAO;
import api.dao.InfraZoneLEADAO;
import api.model.InfraZoneLEA;
import sif3.common.persist.common.BasicTransaction;
import sif3.common.exception.PersistenceException;
import sif3.common.model.PagingInfo;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;

public class InfraZoneLEAService extends sif3.common.persist.service.DBService
{
    private InfraZoneLEADAO infraZoneLEADAO = new InfraZoneLEADAO();
    
    @Override
    public BaseDAO getDAO()
    {
	    return infraZoneLEADAO;
    }

    public List<InfraZoneLEA> getZoneLEAs(SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	List<InfraZoneLEA> list = null;
    	BasicTransaction tx = null;

    	try
    	{
    		tx = startTransaction();
        	list = infraZoneLEADAO.getZoneLEAs(tx, zone, context);
    		tx.commit();
    	}
    	catch (Exception ex)
    	{
    		rollback(tx);
    		exceptionMapper(ex, "Failed to retrieve all zones...(infraZoneLEA Service)" , true, false);
    	}
		return list;
    }

}
