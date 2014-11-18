package api.dao;

import api.model.R1StudentContact;
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

public class R1StudentContactDAO extends BaseDAO
{
	protected final Logger logger = Logger.getLogger(getClass());
	
	//Return Single R1StudentContact Object
    @SuppressWarnings("unchecked")
    public R1StudentContact getStudentContact(BasicTransaction tx, String studentContactRefId, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	 try
         {
             Criteria criteria = tx.getSession().createCriteria(R1StudentContact.class)
                .add(Restrictions.eq("studentContactRefId", studentContactRefId)); //the actual sql type query
               
             
             List<R1StudentContact> studentContacts = criteria.list();
             
             // There can only be a maximum of one
             if (studentContacts.isEmpty()) 
             {
            	 logger.debug("No StudentContact with staffRefID = "+ studentContactRefId);
                 return null;
             }
             else // already exists
             {
             	return studentContacts.get(0); //always 1 if looking for a specific record, so index 0 is the first record
             }
         }
         catch (HibernateException e)
         {
             throw new PersistenceException("Unable to retrieve R1StudentContact with studentContactRefId = "+ studentContactRefId, e);
         }	
    }
    
    //Return Multiple R1StudentContact Objects
    @SuppressWarnings("unchecked")
	public List<R1StudentContact> getStudentContacts(BasicTransaction tx, SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {        
    	try
        {
            Criteria criteria = tx.getSession().createCriteria(R1StudentContact.class);
               //.add(Restrictions.eq("environmentID", environmentID))
               //.add(Restrictions.eq("adapterType", adapterType.name()));
            
            return criteria.list();  
        }
        catch (HibernateException e)
        {
            throw new PersistenceException("Unable to retrieve List of R1StudentContacts from R1StudentContactDAO");
        }	
    }

}
