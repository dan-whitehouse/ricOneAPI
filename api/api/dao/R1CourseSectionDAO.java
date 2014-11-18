package api.dao;

import api.model.R1CourseSection;
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

public class R1CourseSectionDAO extends BaseDAO
{
	protected final Logger logger = Logger.getLogger(getClass());
	
	//Return Single R1CourseSection Object
    @SuppressWarnings("unchecked")
    public R1CourseSection getCourseSection(BasicTransaction tx, String courseSectionRefId, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	 try
         {
             Criteria criteria = tx.getSession().createCriteria(R1CourseSection.class)
                .add(Restrictions.eq("courseSectionRefId", courseSectionRefId)); //the actual sql type query
               
             
             List<R1CourseSection> courseSections = criteria.list();
             
             // There can only be a maximum of one
             if (courseSections.isEmpty()) 
             {
            	 logger.debug("No CourseSection with staffRefID = "+ courseSectionRefId);
                 return null;
             }
             else // already exists
             {
             	return courseSections.get(0); //always 1 if looking for a specific record, so index 0 is the first record
             }
         }
         catch (HibernateException e)
         {
             throw new PersistenceException("Unable to retrieve R1CourseSection with courseSectionRefId = "+ courseSectionRefId, e);
         }	
    }
    
    //Return Multiple R1CourseSection Objects
    @SuppressWarnings("unchecked")
	public List<R1CourseSection> getCourseSections(BasicTransaction tx, SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {        
    	try
        {
            Criteria criteria = tx.getSession().createCriteria(R1CourseSection.class);            
            return criteria.list();  
        }
        catch (HibernateException e)
        {
            throw new PersistenceException("Unable to retrieve List of R1CourseSections from R1CourseSectionDAO");
        }	
    }

}
