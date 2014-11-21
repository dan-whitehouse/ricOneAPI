package api.dao;

import api.model.R1StaffAssignment;
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

public class R1StaffAssignmentDAO extends BaseDAO
{
	protected final Logger logger = Logger.getLogger(getClass());
	
	//Return Single R1StaffAssignment Object
    @SuppressWarnings("unchecked")
    public R1StaffAssignment getStaffAssignment(BasicTransaction tx, String staffAssignmentRefId, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	 try
         {
             Criteria criteria = tx.getSession().createCriteria(R1StaffAssignment.class)
                .add(Restrictions.eq("staffAssignmentRefId", staffAssignmentRefId)); //the actual sql type query
               
             
             List<R1StaffAssignment> staffAssignments = criteria.list();
             
             // There can only be a maximum of one
             if (staffAssignments.isEmpty()) 
             {
            	 logger.debug("No StaffAssignment with staffAssignmentRefID = "+ staffAssignmentRefId);
                 return null;
             }
             else // already exists
             {
             	return staffAssignments.get(0); //always 1 if looking for a specific record, so index 0 is the first record
             }
         }
         catch (HibernateException e)
         {
             throw new PersistenceException("Unable to retrieve R1StaffAssignment with staffAssignmentRefId = "+ staffAssignmentRefId, e);
         }	
    }
    
    //Return Multiple R1StaffAssignment Objects
    @SuppressWarnings("unchecked")
	public List<R1StaffAssignment> getStaffAssignments(BasicTransaction tx, SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {        
    	try
        {
            Criteria criteria = tx.getSession().createCriteria(R1StaffAssignment.class);
               //.add(Restrictions.eq("environmentID", environmentID))
               //.add(Restrictions.eq("adapterType", adapterType.name()));
            
            return criteria.list();  
        }
        catch (HibernateException e)
        {
            throw new PersistenceException("Unable to retrieve List of R1StaffAssignments from R1StaffAssignmentDAO");
        }	
    }

}
