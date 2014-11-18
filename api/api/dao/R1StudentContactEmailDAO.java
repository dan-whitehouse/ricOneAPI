package api.dao;

import api.model.R1StudentContactEmail;
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

public class R1StudentContactEmailDAO extends BaseDAO
{
	protected final Logger logger = Logger.getLogger(getClass());
	
	//Return Single R1StudentContactEmail Object
    @SuppressWarnings("unchecked")
    public R1StudentContactEmail getStudentContactEmail(BasicTransaction tx, String studentContactEmailRefId, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	 try
         {
             Criteria criteria = tx.getSession().createCriteria(R1StudentContactEmail.class)
                .add(Restrictions.eq("studentContactEmailRefId", studentContactEmailRefId)); //the actual sql type query
               
             
             List<R1StudentContactEmail> studentContactEmails = criteria.list();
             
             // There can only be a maximum of one
             if (studentContactEmails.isEmpty()) 
             {
            	 logger.debug("No StudentContactEmail with staffRefID = "+ studentContactEmailRefId);
                 return null;
             }
             else // already exists
             {
             	return studentContactEmails.get(0); //always 1 if looking for a specific record, so index 0 is the first record
             }
         }
         catch (HibernateException e)
         {
             throw new PersistenceException("Unable to retrieve R1StudentContactEmail with studentContactEmailRefId = "+ studentContactEmailRefId, e);
         }	
    }
    
    //Return Multiple R1StudentContactEmail Objects
    @SuppressWarnings("unchecked")
	public List<R1StudentContactEmail> getStudentContactEmails(BasicTransaction tx, SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {        
    	try
        {
            Criteria criteria = tx.getSession().createCriteria(R1StudentContactEmail.class);
               //.add(Restrictions.eq("environmentID", environmentID))
               //.add(Restrictions.eq("adapterType", adapterType.name()));
            
            return criteria.list();  
        }
        catch (HibernateException e)
        {
            throw new PersistenceException("Unable to retrieve List of R1StudentContactEmails from R1StudentContactEmailDAO");
        }	
    }

}
