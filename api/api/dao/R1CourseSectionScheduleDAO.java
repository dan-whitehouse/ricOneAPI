package api.dao;

import api.model.R1CourseSectionSchedule;
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

public class R1CourseSectionScheduleDAO extends BaseDAO
{
	protected final Logger logger = Logger.getLogger(getClass());
	
	//Return Single R1CourseSectionSchedule Object
    @SuppressWarnings("unchecked")
    public R1CourseSectionSchedule getCourseSectionSchedule(BasicTransaction tx, String courseSectionScheduleRefId, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	 try
         {
             Criteria criteria = tx.getSession().createCriteria(R1CourseSectionSchedule.class)
                .add(Restrictions.eq("courseSectionScheduleRefId", courseSectionScheduleRefId)); //the actual sql type query
               
             
             List<R1CourseSectionSchedule> courseSectionSchedules = criteria.list();
             
             // There can only be a maximum of one
             if (courseSectionSchedules.isEmpty()) 
             {
            	 logger.debug("No CourseSectionSchedule with staffRefID = "+ courseSectionScheduleRefId);
                 return null;
             }
             else // already exists
             {
             	return courseSectionSchedules.get(0); //always 1 if looking for a specific record, so index 0 is the first record
             }
         }
         catch (HibernateException e)
         {
             throw new PersistenceException("Unable to retrieve R1CourseSectionSchedule with courseSectionScheduleRefId = "+ courseSectionScheduleRefId, e);
         }	
    }
    
    //Return Multiple R1CourseSectionSchedule Objects
    @SuppressWarnings("unchecked")
	public List<R1CourseSectionSchedule> getCourseSectionSchedules(BasicTransaction tx, SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {        
    	try
        {
            Criteria criteria = tx.getSession().createCriteria(R1CourseSectionSchedule.class);            
            return criteria.list();  
        }
        catch (HibernateException e)
        {
            throw new PersistenceException("Unable to retrieve List of R1CourseSectionSchedules from R1CourseSectionScheduleDAO");
        }	
    }

}
