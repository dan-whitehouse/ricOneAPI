package api.dao;

import api.model.R1SchoolCalendarSession;
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

public class R1SchoolCalendarSessionDAO extends BaseDAO
{
	protected final Logger logger = Logger.getLogger(getClass());
	
	//Return Single R1SchoolCalendarSession Object
    @SuppressWarnings("unchecked")
    public R1SchoolCalendarSession getSchoolCalendarSession(BasicTransaction tx, String schoolCalendarSessionRefId, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	 try
         {
             Criteria criteria = tx.getSession().createCriteria(R1SchoolCalendarSession.class)
                .add(Restrictions.eq("schoolCalendarSessionRefId", schoolCalendarSessionRefId)); //the actual sql type query
               
             
             List<R1SchoolCalendarSession> schoolCalendarSessions = criteria.list();
             
             // There can only be a maximum of one
             if (schoolCalendarSessions.isEmpty()) 
             {
            	 logger.debug("No SchoolCalendarSession with schoolCalendarSessionRefID = '"+ schoolCalendarSessionRefId);
                 return null;
             }
             else // already exists
             {
             	return schoolCalendarSessions.get(0); //always 1 if looking for a specific record, so index 0 is the first record
             }
         }
         catch (HibernateException e)
         {
        	 
             throw new PersistenceException("Unable to retrieve R1SchoolCalendarSession with schoolCalendarSessionRefId = '"+ schoolCalendarSessionRefId + "'.", e);
         }	
    }
    
    //Return Multiple R1SchoolCalendarSession Objects
    @SuppressWarnings("unchecked")
	public List<R1SchoolCalendarSession> getSchoolCalendarSessions(BasicTransaction tx, SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {        
    	try
        {
            Criteria criteria = tx.getSession().createCriteria(R1SchoolCalendarSession.class);
               //.add(Restrictions.eq("environmentID", environmentID))
               //.add(Restrictions.eq("adapterType", adapterType.name()));
            
            return criteria.list();  
        }
        catch (HibernateException e)
        {
            throw new PersistenceException("Unable to retrieve List of R1SchoolCalendarSessions from R1SchoolCalendarSessionDAO");
        }	
    }

}
