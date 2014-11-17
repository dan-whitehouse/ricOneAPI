package api.dao;

import api.model.R1LEA;
import api.common.BasicTransaction;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

import sif3.common.exception.PersistenceException;
import sif3.common.model.PagingInfo;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;

public class R1LEADAO extends BaseDAO
{
	protected final Logger logger = Logger.getLogger(getClass());
	
	//Return Single R1LEA Object
    @SuppressWarnings("unchecked")
    public R1LEA getLEA(BasicTransaction tx, String leaRefId, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	 try
         {
             Criteria criteria = tx.getSession().createCriteria(R1LEA.class)
                .add(Restrictions.eq("leaRefId", leaRefId)); //the actual sql type query
               
             
             List<R1LEA> leas = criteria.list();
             
             // There can only be a maximum of one
             if (leas.isEmpty()) 
             {
            	 logger.debug("No Student with staffRefID = "+ leaRefId);
                 return null;
             }
             else // already exists
             {
             	return leas.get(0); //always 1 if looking for a specific record, so index 0 is the first record
             }
         }
         catch (HibernateException e)
         {
             throw new PersistenceException("Unable to retrieve R1LEA with leaRefId = "+ leaRefId, e);
         }	
    }
    
    //Return Multiple R1LEA Objects
    @SuppressWarnings("unchecked")
	public List<R1LEA> getLEAs(BasicTransaction tx, SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {        
    	try
        {
            Criteria criteria = tx.getSession().createCriteria(R1LEA.class);
               //.add(Restrictions.eq("environmentID", environmentID))
               //.add(Restrictions.eq("adapterType", adapterType.name()));
            
            return criteria.list();  
        }
        catch (HibernateException e)
        {
            throw new PersistenceException("Unable to retrieve List of R1LEAs from R1LEADAO");
        }	
    }

}
