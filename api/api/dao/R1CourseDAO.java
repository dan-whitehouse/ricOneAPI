package api.dao;

import api.model.R1Course;
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

public class R1CourseDAO extends BaseDAO
{
	protected final Logger logger = Logger.getLogger(getClass());
	
	//Return Single R1Course Object
    @SuppressWarnings("unchecked")
    public R1Course getCourse(BasicTransaction tx, String courseRefId, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	 try
         {
             Criteria criteria = tx.getSession().createCriteria(R1Course.class)
                .add(Restrictions.eq("courseRefId", courseRefId)); //the actual sql type query
               
             
             List<R1Course> courses = criteria.list();
             
             // There can only be a maximum of one
             if (courses.isEmpty()) 
             {
            	 logger.debug("No Course with staffRefID = "+ courseRefId);
                 return null;
             }
             else // already exists
             {
             	return courses.get(0); //always 1 if looking for a specific record, so index 0 is the first record
             }
         }
         catch (HibernateException e)
         {
             throw new PersistenceException("Unable to retrieve R1Course with courseRefId = "+ courseRefId, e);
         }	
    }
    
    //Return Multiple R1Course Objects
    @SuppressWarnings("unchecked")
	public List<R1Course> getCourses(BasicTransaction tx, SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {        
    	try
        {
            Criteria criteria = tx.getSession().createCriteria(R1Course.class);            
            return criteria.list();  
        }
        catch (HibernateException e)
        {
            throw new PersistenceException("Unable to retrieve List of R1Courses from R1CourseDAO");
        }	
    }

}
