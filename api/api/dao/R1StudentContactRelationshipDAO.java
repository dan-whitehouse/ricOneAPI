package api.dao;

import api.model.R1StudentContactRelationship;
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

public class R1StudentContactRelationshipDAO extends BaseDAO
{
	protected final Logger logger = Logger.getLogger(getClass());
	
	//Return Single R1StudentContactRelationship Object
    @SuppressWarnings("unchecked")
    public R1StudentContactRelationship getStudentContactRelationship(BasicTransaction tx, String studentContactRelationshipRefId, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	 try
         {
             Criteria criteria = tx.getSession().createCriteria(R1StudentContactRelationship.class)
                .add(Restrictions.eq("studentContactRelationshipRefId", studentContactRelationshipRefId)); //the actual sql type query
               
             
             List<R1StudentContactRelationship> studentContactRelationships = criteria.list();
             
             // There can only be a maximum of one
             if (studentContactRelationships.isEmpty()) 
             {
            	 logger.debug("No StudentContactRelationship with staffRefID = "+ studentContactRelationshipRefId);
                 return null;
             }
             else // already exists
             {
             	return studentContactRelationships.get(0); //always 1 if looking for a specific record, so index 0 is the first record
             }
         }
         catch (HibernateException e)
         {
             throw new PersistenceException("Unable to retrieve R1StudentContactRelationship with studentContactRelationshipRefId = "+ studentContactRelationshipRefId, e);
         }	
    }
    
    //Return Multiple R1StudentContactRelationship Objects
    @SuppressWarnings("unchecked")
	public List<R1StudentContactRelationship> getStudentContactRelationships(BasicTransaction tx, SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {        
    	try
        {
            Criteria criteria = tx.getSession().createCriteria(R1StudentContactRelationship.class);
               //.add(Restrictions.eq("environmentID", environmentID))
               //.add(Restrictions.eq("adapterType", adapterType.name()));
            
            return criteria.list();  
        }
        catch (HibernateException e)
        {
            throw new PersistenceException("Unable to retrieve List of R1StudentContactRelationships from R1StudentContactRelationshipDAO");
        }	
    }

}
