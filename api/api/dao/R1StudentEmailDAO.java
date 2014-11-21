package api.dao;

import api.model.R1StudentEmail;
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

public class R1StudentEmailDAO extends BaseDAO
{
	protected final Logger logger = Logger.getLogger(getClass());
	
	//Return Single R1StudentEmail Object
    @SuppressWarnings("unchecked")
    public R1StudentEmail getStudentEmail(BasicTransaction tx, String studentEmailRefId, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	 try
         {
             Criteria criteria = tx.getSession().createCriteria(R1StudentEmail.class)
                .add(Restrictions.eq("studentEmailRefId", studentEmailRefId)); //the actual sql type query
               
             
             List<R1StudentEmail> studentEmails = criteria.list();
             
             // There can only be a maximum of one
             if (studentEmails.isEmpty()) 
             {
            	 logger.debug("No StudentEmail with studentEmailRefID = '"+ studentEmailRefId);
                 return null;
             }
             else // already exists
             {
             	return studentEmails.get(0); //always 1 if looking for a specific record, so index 0 is the first record
             }
         }
         catch (HibernateException e)
         {
             throw new PersistenceException("Unable to retrieve R1StudentEmail with studentEmailRefId = '"+ studentEmailRefId + "'.", e);
         }	
    }
    
    //Return Multiple R1StudentEmail Objects
    @SuppressWarnings("unchecked")
	public List<R1StudentEmail> getStudentEmails(BasicTransaction tx, SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {        
    	try
        {
            Criteria criteria = tx.getSession().createCriteria(R1StudentEmail.class);           
            return criteria.list();  
        }
        catch (HibernateException e)
        {
            throw new PersistenceException("Unable to retrieve List of R1StudentEmails from R1StudentEmailDAO");
        }	
    }

}
