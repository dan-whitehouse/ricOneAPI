package api.dao;

import api.model.R1StudentHealth;
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

public class R1StudentHealthDAO extends BaseDAO
{
	protected final Logger logger = Logger.getLogger(getClass());
	
	//Return Single R1StudentHealth Object
    @SuppressWarnings("unchecked")
    public R1StudentHealth getStudentHealth(BasicTransaction tx, String StudentHealthRefId, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	 try
         {
             Criteria criteria = tx.getSession().createCriteria(R1StudentHealth.class)
                .add(Restrictions.eq("StudentHealthRefId", StudentHealthRefId)); //the actual sql type query
               
             
             List<R1StudentHealth> StudentHealths = criteria.list();
             
             // There can only be a maximum of one
             if (StudentHealths.isEmpty()) 
             {
            	 logger.debug("No StudentHealth with staffRefID = "+ StudentHealthRefId);
                 return null;
             }
             else // already exists
             {
             	return StudentHealths.get(0); //always 1 if looking for a specific record, so index 0 is the first record
             }
         }
         catch (HibernateException e)
         {
             throw new PersistenceException("Unable to retrieve R1StudentHealth with StudentHealthRefId = "+ StudentHealthRefId, e);
         }	
    }
    
    //Return Multiple R1StudentHealth Objects
    @SuppressWarnings("unchecked")
	public List<R1StudentHealth> getStudentHealths(BasicTransaction tx, SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {        
    	try
        {
            Criteria criteria = tx.getSession().createCriteria(R1StudentHealth.class);
               //.add(Restrictions.eq("environmentID", environmentID))
               //.add(Restrictions.eq("adapterType", adapterType.name()));
            
            return criteria.list();  
        }
        catch (HibernateException e)
        {
            throw new PersistenceException("Unable to retrieve List of R1StudentHealths from R1StudentHealthDAO");
        }	
    }

}
