package api.dao;

import api.model.R1Staff;
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

public class R1StaffDAO extends BaseDAO
{
	protected final Logger logger = Logger.getLogger(getClass());
	
	//Return Single R1Staff Object
    @SuppressWarnings("unchecked")
    public R1Staff getStaff(BasicTransaction tx, String staffRefId, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	 try
         {
             Criteria criteria = tx.getSession().createCriteria(R1Staff.class)
                .add(Restrictions.eq("staffRefId", staffRefId)); //the actual sql type query
               
             
             List<R1Staff> staffs = criteria.list();
             
             // There can only be a maximum of one
             if (staffs.isEmpty()) 
             {
            	 logger.debug("No Staff with staffRefID = "+ staffRefId);
                 return null;
             }
             else // already exists
             {
             	return staffs.get(0); //always 1 if looking for a specific record, so index 0 is the first record
             }
         }
         catch (HibernateException e)
         {
             throw new PersistenceException("Unable to retrieve R1Staff with staffRefId = "+ staffRefId, e);
         }	
    }
    
    //Return Multiple R1Staff Objects
    @SuppressWarnings("unchecked")
	public List<R1Staff> getStaffs(BasicTransaction tx, SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {        
    	try
        {
            Criteria criteria = tx.getSession().createCriteria(R1Staff.class);
               //.add(Restrictions.eq("environmentID", environmentID))
               //.add(Restrictions.eq("adapterType", adapterType.name()));
            
            return criteria.list();  
        }
        catch (HibernateException e)
        {
        	System.out.println("!!!!!!!!!!!!!STAFFDAO " + e.getMessage());
            throw new PersistenceException("Unable to retrieve List of R1Staffs from R1StaffDAO");
        }	
    }

}
