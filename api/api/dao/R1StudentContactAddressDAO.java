package api.dao;

import api.model.R1StudentContactAddress;
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

public class R1StudentContactAddressDAO extends BaseDAO
{
	protected final Logger logger = Logger.getLogger(getClass());
	
	//Return Single R1StudentContactAddress Object
    @SuppressWarnings("unchecked")
    public R1StudentContactAddress getStudentContactAddress(BasicTransaction tx, String studentContactAddressRefId, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	 try
         {
             Criteria criteria = tx.getSession().createCriteria(R1StudentContactAddress.class)
                .add(Restrictions.eq("studentContactAddressRefId", studentContactAddressRefId)); //the actual sql type query
               
             
             List<R1StudentContactAddress> studentContactAddresses = criteria.list();
             
             // There can only be a maximum of one
             if (studentContactAddresses.isEmpty()) 
             {
            	 logger.debug("No StudentContactAddress with staffRefID = "+ studentContactAddressRefId);
                 return null;
             }
             else // already exists
             {
             	return studentContactAddresses.get(0); //always 1 if looking for a specific record, so index 0 is the first record
             }
         }
         catch (HibernateException e)
         {
             throw new PersistenceException("Unable to retrieve R1StudentContactAddress with studentContactAddressRefId = "+ studentContactAddressRefId, e);
         }	
    }
    
    //Return Multiple R1StudentContactAddress Objects
    @SuppressWarnings("unchecked")
	public List<R1StudentContactAddress> getStudentContactAddresses(BasicTransaction tx, SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {        
    	try
        {
            Criteria criteria = tx.getSession().createCriteria(R1StudentContactAddress.class);
               //.add(Restrictions.eq("environmentID", environmentID))
               //.add(Restrictions.eq("adapterType", adapterType.name()));
            
            return criteria.list();  
        }
        catch (HibernateException e)
        {
            throw new PersistenceException("Unable to retrieve List of R1StudentContactAddresss from R1StudentContactAddressDAO");
        }	
    }

}
