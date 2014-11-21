package api.dao;

import api.model.R1StaffCourseSection;
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

public class R1StaffCourseSectionDAO extends BaseDAO
{
	protected final Logger logger = Logger.getLogger(getClass());
	
	//Return Single R1StaffCourseSection Object
    @SuppressWarnings("unchecked")
    public R1StaffCourseSection getStaffCourseSection(BasicTransaction tx, String staffCourseSectionRefId, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	 try
         {
             Criteria criteria = tx.getSession().createCriteria(R1StaffCourseSection.class)
                .add(Restrictions.eq("staffCourseSectionRefId", staffCourseSectionRefId)); //the actual sql type query
               
             
             List<R1StaffCourseSection> staffCourseSections = criteria.list();
             
             // There can only be a maximum of one
             if (staffCourseSections.isEmpty()) 
             {
            	 logger.debug("No StaffCourseSection with staffCourseSectionRefID = "+ staffCourseSectionRefId);
                 return null;
             }
             else // already exists
             {
             	return staffCourseSections.get(0); //always 1 if looking for a specific record, so index 0 is the first record
             }
         }
         catch (HibernateException e)
         {
             throw new PersistenceException("Unable to retrieve R1StaffCourseSection with staffCourseSectionRefId = "+ staffCourseSectionRefId, e);
         }	
    }
    
    //Return Multiple R1StaffCourseSection Objects
    @SuppressWarnings("unchecked")
	public List<R1StaffCourseSection> getStaffCourseSections(BasicTransaction tx, SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {        
    	try
        {
            Criteria criteria = tx.getSession().createCriteria(R1StaffCourseSection.class);
               //.add(Restrictions.eq("environmentID", environmentID))
               //.add(Restrictions.eq("adapterType", adapterType.name()));
            
            return criteria.list();  
        }
        catch (HibernateException e)
        {
            throw new PersistenceException("Unable to retrieve List of R1StaffCourseSections from R1StaffCourseSectionDAO");
        }	
    }

}
