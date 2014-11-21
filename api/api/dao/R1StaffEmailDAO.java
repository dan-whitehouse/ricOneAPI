package api.dao;

import api.model.R1StaffEmail;
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

public class R1StaffEmailDAO extends BaseDAO
{
	protected final Logger logger = Logger.getLogger(getClass());
	
	//Return Single R1StaffEmail Object
    @SuppressWarnings("unchecked")
    public R1StaffEmail getStaffEmail(BasicTransaction tx, String staffEmailRefId, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	 try
         {
             Criteria criteria = tx.getSession().createCriteria(R1StaffEmail.class)
                .add(Restrictions.eq("staffEmailRefId", staffEmailRefId)); //the actual sql type query
               
             
             List<R1StaffEmail> staffEmails = criteria.list();
             
             // There can only be a maximum of one
             if (staffEmails.isEmpty()) 
             {
            	 logger.debug("No StaffEmail with staffEmailRefID = "+ staffEmailRefId);
                 return null;
             }
             else // already exists
             {
             	return staffEmails.get(0); //always 1 if looking for a specific record, so index 0 is the first record
             }
         }
         catch (HibernateException e)
         {
             throw new PersistenceException("Unable to retrieve R1StaffEmail with staffEmailRefId = "+ staffEmailRefId, e);
         }	
    }
    
    //Return Multiple R1StaffEmail Objects
    @SuppressWarnings("unchecked")
	public List<R1StaffEmail> getStaffEmails(BasicTransaction tx, SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {        
    	try
        {
            Criteria criteria = tx.getSession().createCriteria(R1StaffEmail.class);
               //.add(Restrictions.eq("environmentID", environmentID))
               //.add(Restrictions.eq("adapterType", adapterType.name()));
            
            return criteria.list();  
        }
        catch (HibernateException e)
        {
            throw new PersistenceException("Unable to retrieve List of R1StaffEmails from R1StaffEmailDAO");
        }	
    }

}
