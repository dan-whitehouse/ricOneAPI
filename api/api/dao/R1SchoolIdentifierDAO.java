package api.dao;

import api.model.R1SchoolIdentifier;
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

public class R1SchoolIdentifierDAO extends BaseDAO
{
	protected final Logger logger = Logger.getLogger(getClass());
	
	//Return Single R1SchoolIdentifier Object
    @SuppressWarnings("unchecked")
    public R1SchoolIdentifier getSchoolIdentifier(BasicTransaction tx, String schoolIdentifierRefId, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	 try
         {
             Criteria criteria = tx.getSession().createCriteria(R1SchoolIdentifier.class)
                .add(Restrictions.eq("schoolIdentifierRefId", schoolIdentifierRefId)); //the actual sql type query
               
             
             List<R1SchoolIdentifier> schoolIdentifiers = criteria.list();
             
             // There can only be a maximum of one
             if (schoolIdentifiers.isEmpty()) 
             {
            	 logger.debug("No SchoolIdentifier with schoolIdentifierRefID = '"+ schoolIdentifierRefId);
                 return null;
             }
             else // already exists
             {
             	return schoolIdentifiers.get(0); //always 1 if looking for a specific record, so index 0 is the first record
             }
         }
         catch (HibernateException e)
         {
             throw new PersistenceException("Unable to retrieve R1SchoolIdentifier with schoolIdentifierRefId = '"+ schoolIdentifierRefId + "'.", e);
         }	
    }
    
    //Return Multiple R1SchoolIdentifier Objects
    @SuppressWarnings("unchecked")
	public List<R1SchoolIdentifier> getSchoolIdentifiers(BasicTransaction tx, SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {        
    	try
        {
            Criteria criteria = tx.getSession().createCriteria(R1SchoolIdentifier.class);
               //.add(Restrictions.eq("environmentID", environmentID))
               //.add(Restrictions.eq("adapterType", adapterType.name()));
            
            return criteria.list();  
        }
        catch (HibernateException e)
        {
            throw new PersistenceException("Unable to retrieve List of R1SchoolIdentifiers from R1SchoolIdentifierDAO");
        }	
    }

}
