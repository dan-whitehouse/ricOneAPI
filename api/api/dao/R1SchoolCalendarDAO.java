package api.dao;

import api.model.R1SchoolCalendar;
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

public class R1SchoolCalendarDAO extends BaseDAO
{
	protected final Logger logger = Logger.getLogger(getClass());
	
	//Return Single R1SchoolCalendar Object
    @SuppressWarnings("unchecked")
    public R1SchoolCalendar getSchoolCalendar(BasicTransaction tx, String schoolCalendarRefId, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	 try
         {
             Criteria criteria = tx.getSession().createCriteria(R1SchoolCalendar.class)
                .add(Restrictions.eq("schoolCalendarRefId", schoolCalendarRefId)); //the actual sql type query
               
             
             List<R1SchoolCalendar> schoolCalendars = criteria.list();
             
             // There can only be a maximum of one
             if (schoolCalendars.isEmpty()) 
             {
            	 logger.debug("No SchoolCalendar with schoolCalendarRefID = '"+ schoolCalendarRefId);
                 return null;
             }
             else // already exists
             {
             	return schoolCalendars.get(0); //always 1 if looking for a specific record, so index 0 is the first record
             }
         }
         catch (HibernateException e)
         {
        	 System.out.println("DW-Exception-DAO: " + e.getMessage());
             throw new PersistenceException("Unable to retrieve R1SchoolCalendar with schoolCalendarRefId = '"+ schoolCalendarRefId + "'.", e);
         }	
    }
    
    //Return Multiple R1SchoolCalendar Objects
    @SuppressWarnings("unchecked")
	public List<R1SchoolCalendar> getSchoolCalendars(BasicTransaction tx, SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {        
    	try
        {
            Criteria criteria = tx.getSession().createCriteria(R1SchoolCalendar.class);
               //.add(Restrictions.eq("environmentID", environmentID))
               //.add(Restrictions.eq("adapterType", adapterType.name()));
            
            return criteria.list();  
        }
        catch (HibernateException e)
        {
        	System.out.println("DW-Exception-DAO: " + e.getMessage());
            throw new PersistenceException("Unable to retrieve List of R1SchoolCalendars from R1SchoolCalendarDAO");
        }	
    }

}
