package api.dao;

import api.model.R1StudentTelephone;
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

public class R1StudentTelephoneDAO extends BaseDAO
{
	protected final Logger logger = Logger.getLogger(getClass());
	
	//Return Single R1StudentTelephone Object
    @SuppressWarnings("unchecked")
    public R1StudentTelephone getStudentTelephone(BasicTransaction tx, String studentTelephoneRefId, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	 try
         {
             Criteria criteria = tx.getSession().createCriteria(R1StudentTelephone.class)
                .add(Restrictions.eq("studentTelephoneRefId", studentTelephoneRefId)); //the actual sql type query
               
             
             List<R1StudentTelephone> studentTelephones = criteria.list();
             
             // There can only be a maximum of one
             if (studentTelephones.isEmpty()) 
             {
            	 logger.debug("No StudentTelephone with studentTelephoneRefID = '"+ studentTelephoneRefId);
                 return null;
             }
             else // already exists
             {
             	return studentTelephones.get(0); //always 1 if looking for a specific record, so index 0 is the first record
             }
         }
         catch (HibernateException e)
         {
             throw new PersistenceException("Unable to retrieve R1StudentTelephone with studentTelephoneRefId = '"+ studentTelephoneRefId + "'.", e);
         }	
    }
    
    //Return Multiple R1StudentTelephone Objects
    @SuppressWarnings("unchecked")
	public List<R1StudentTelephone> getStudentTelephones(BasicTransaction tx, SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {        
    	try
        {
            Criteria criteria = tx.getSession().createCriteria(R1StudentTelephone.class);           
            return criteria.list();  
        }
        catch (HibernateException e)
        {
            throw new PersistenceException("Unable to retrieve List of R1StudentTelephones from R1StudentTelephoneDAO");
        }	
    }

}
