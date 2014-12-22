package api.dao;

import api.model.InfraZoneLEA;
import sif3.common.persist.common.BasicTransaction;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

import sif3.common.exception.PersistenceException;
import sif3.common.model.PagingInfo;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;

public class InfraZoneLEADAO extends sif3.common.persist.dao.BaseDAO
{
	protected final Logger logger = Logger.getLogger(getClass());
	
    //Return Multiple R1Student Objects
    @SuppressWarnings("unchecked")
	public List<InfraZoneLEA> getZoneLEAs(BasicTransaction tx, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {        
    	try
        {
    		Criteria criteria = tx.getSession().createCriteria(InfraZoneLEA.class, "infraZoneLEA")
    		.add(Restrictions.eq("infraZoneLEA.zoneId", zone.getId()));

            return criteria.list();  
        }
        catch (HibernateException e)
        {
            throw new PersistenceException("Unable to retrieve List of Zones from InfraZoneLEADAO");
        }	
    }
    


}
