package api.dao;

import api.model.R1StaffIdentifier;
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

public class R1StaffIdentifierDAO extends BaseDAO
{
	protected final Logger logger = Logger.getLogger(getClass());
	
	//Return Single R1StaffIdentifier Object
    @SuppressWarnings("unchecked")
    public R1StaffIdentifier getStaffIdentifier(BasicTransaction tx, String staffIdentifierRefId, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	 try
         {
             Criteria criteria = tx.getSession().createCriteria(R1StaffIdentifier.class)
                .add(Restrictions.eq("staffIdentifierRefId", staffIdentifierRefId)); //the actual sql type query
               
             
             List<R1StaffIdentifier> staffIdentifiers = criteria.list();
             
             // There can only be a maximum of one
             if (staffIdentifiers.isEmpty()) 
             {
            	 logger.debug("No StaffIdentifier with staffIdentifierRefID = "+ staffIdentifierRefId);
                 return null;
             }
             else // already exists
             {
             	return staffIdentifiers.get(0); //always 1 if looking for a specific record, so index 0 is the first record
             }
         }
         catch (HibernateException e)
         {
             throw new PersistenceException("Unable to retrieve R1StaffIdentifier with staffIdentifierRefId = "+ staffIdentifierRefId, e);
         }	
    }
    
    //Return Multiple R1StaffIdentifier Objects
    @SuppressWarnings("unchecked")
	public List<R1StaffIdentifier> getStaffIdentifiers(BasicTransaction tx, SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {        
    	try
        {
            Criteria criteria = tx.getSession().createCriteria(R1StaffIdentifier.class);
               //.add(Restrictions.eq("environmentID", environmentID))
               //.add(Restrictions.eq("adapterType", adapterType.name()));
            
            return criteria.list();  
        }
        catch (HibernateException e)
        {
            throw new PersistenceException("Unable to retrieve List of R1StaffIdentifiers from R1StaffIdentifierDAO");
        }	
    }

}
