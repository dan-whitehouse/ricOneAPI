package api.dao;

import api.model.R1StudentContactTelephone;
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

public class R1StudentContactTelephoneDAO extends BaseDAO
{
	protected final Logger logger = Logger.getLogger(getClass());
	
	//Return Single R1StudentContactTelephone Object
    @SuppressWarnings("unchecked")
    public R1StudentContactTelephone getStudentContactTelephone(BasicTransaction tx, String studentContactTelephoneRefId, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	 try
         {
             Criteria criteria = tx.getSession().createCriteria(R1StudentContactTelephone.class)
                .add(Restrictions.eq("studentContactTelephoneRefId", studentContactTelephoneRefId)); //the actual sql type query
               
             
             List<R1StudentContactTelephone> studentContactTelephones = criteria.list();
             
             // There can only be a maximum of one
             if (studentContactTelephones.isEmpty()) 
             {
            	 logger.debug("No StudentContactTelephone with staffRefID = "+ studentContactTelephoneRefId);
                 return null;
             }
             else // already exists
             {
             	return studentContactTelephones.get(0); //always 1 if looking for a specific record, so index 0 is the first record
             }
         }
         catch (HibernateException e)
         {
             throw new PersistenceException("Unable to retrieve R1StudentContactTelephone with studentContactTelephoneRefId = "+ studentContactTelephoneRefId, e);
         }	
    }
    
    //Return Multiple R1StudentContactTelephone Objects
    @SuppressWarnings("unchecked")
	public List<R1StudentContactTelephone> getStudentContactTelephones(BasicTransaction tx, SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {        
    	try
        {
            Criteria criteria = tx.getSession().createCriteria(R1StudentContactTelephone.class);
               //.add(Restrictions.eq("environmentID", environmentID))
               //.add(Restrictions.eq("adapterType", adapterType.name()));
            
            return criteria.list();  
        }
        catch (HibernateException e)
        {
            throw new PersistenceException("Unable to retrieve List of R1StudentContactTelephones from R1StudentContactTelephoneDAO");
        }	
    }

}
