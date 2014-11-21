package api.dao;

import api.model.R1StudentIdentifier;
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

public class R1StudentIdentifierDAO extends BaseDAO
{
	protected final Logger logger = Logger.getLogger(getClass());
	
	//Return Single R1StudentIdentifier Object
    @SuppressWarnings("unchecked")
    public R1StudentIdentifier getStudentIdentifier(BasicTransaction tx, String studentIdentifierRefId, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	 try
         {
             Criteria criteria = tx.getSession().createCriteria(R1StudentIdentifier.class)
                .add(Restrictions.eq("studentIdentifierRefId", studentIdentifierRefId)); //the actual sql type query
               
             
             List<R1StudentIdentifier> studentIdentifiers = criteria.list();
             
             // There can only be a maximum of one
             if (studentIdentifiers.isEmpty()) 
             {
            	 logger.debug("No StudentIdentifier with studentIdentifierRefID = '"+ studentIdentifierRefId);
                 return null;
             }
             else // already exists
             {
             	return studentIdentifiers.get(0); //always 1 if looking for a specific record, so index 0 is the first record
             }
         }
         catch (HibernateException e)
         {
             throw new PersistenceException("Unable to retrieve R1StudentIdentifier with studentIdentifierRefId = '"+ studentIdentifierRefId + "'.", e);
         }	
    }
    
    //Return Multiple R1StudentIdentifier Objects
    @SuppressWarnings("unchecked")
	public List<R1StudentIdentifier> getStudentIdentifiers(BasicTransaction tx, SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {        
    	try
        {
            Criteria criteria = tx.getSession().createCriteria(R1StudentIdentifier.class);           
            return criteria.list();  
        }
        catch (HibernateException e)
        {
            throw new PersistenceException("Unable to retrieve List of R1StudentIdentifiers from R1StudentIdentifierDAO");
        }	
    }

}
