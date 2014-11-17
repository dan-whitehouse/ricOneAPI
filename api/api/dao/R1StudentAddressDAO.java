package api.dao;

import api.model.R1StudentAddress;
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

public class R1StudentAddressDAO extends BaseDAO
{
	protected final Logger logger = Logger.getLogger(getClass());
	
	//Return Single R1StudentAddress Object
    @SuppressWarnings("unchecked")
    public R1StudentAddress getStudentAddress(BasicTransaction tx, String studentAddressRefId, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	 try
         {
             Criteria criteria = tx.getSession().createCriteria(R1StudentAddress.class)
                .add(Restrictions.eq("studentAddressRefId", studentAddressRefId)); //the actual sql type query
               
             
             List<R1StudentAddress> studentAddresss = criteria.list();
             
             // There can only be a maximum of one
             if (studentAddresss.isEmpty()) 
             {
            	 logger.debug("No StudentAddress with studentAddressRefID = '"+ studentAddressRefId);
                 return null;
             }
             else // already exists
             {
             	return studentAddresss.get(0); //always 1 if looking for a specific record, so index 0 is the first record
             }
         }
         catch (HibernateException e)
         {
             throw new PersistenceException("Unable to retrieve R1StudentAddress with studentAddressRefId = '"+ studentAddressRefId + "'.", e);
         }	
    }
    
    //Return Multiple R1StudentAddress Objects
    @SuppressWarnings("unchecked")
	public List<R1StudentAddress> getStudentAddresses(BasicTransaction tx, SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {        
    	try
        {
            Criteria criteria = tx.getSession().createCriteria(R1StudentAddress.class);           
            return criteria.list();  
        }
        catch (HibernateException e)
        {
            throw new PersistenceException("Unable to retrieve List of R1StudentAddresss from R1StudentAddressDAO");
        }	
    }

}
