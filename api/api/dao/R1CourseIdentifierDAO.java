package api.dao;

import api.model.R1CourseIdentifier;
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

public class R1CourseIdentifierDAO extends BaseDAO
{
	protected final Logger logger = Logger.getLogger(getClass());
	
	//Return Single R1CourseIdentifier Object
    @SuppressWarnings("unchecked")
    public R1CourseIdentifier getCourseIdentifier(BasicTransaction tx, String courseIdentifierRefId, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	 try
         {
             Criteria criteria = tx.getSession().createCriteria(R1CourseIdentifier.class)
                .add(Restrictions.eq("courseIdentifierRefId", courseIdentifierRefId)); //the actual sql type query
               
             
             List<R1CourseIdentifier> courseIdentifiers = criteria.list();
             
             // There can only be a maximum of one
             if (courseIdentifiers.isEmpty()) 
             {
            	 logger.debug("No CourseIdentifier with staffRefID = "+ courseIdentifierRefId);
                 return null;
             }
             else // already exists
             {
             	return courseIdentifiers.get(0); //always 1 if looking for a specific record, so index 0 is the first record
             }
         }
         catch (HibernateException e)
         {
             throw new PersistenceException("Unable to retrieve R1CourseIdentifier with courseIdentifierRefId = "+ courseIdentifierRefId, e);
         }	
    }
    
    //Return Multiple R1CourseIdentifier Objects
    @SuppressWarnings("unchecked")
	public List<R1CourseIdentifier> getCourseIdentifiers(BasicTransaction tx, SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {        
    	try
        {
            Criteria criteria = tx.getSession().createCriteria(R1CourseIdentifier.class);            
            return criteria.list();  
        }
        catch (HibernateException e)
        {
            throw new PersistenceException("Unable to retrieve List of R1CourseIdentifiers from R1CourseIdentifierDAO");
        }	
    }

}
