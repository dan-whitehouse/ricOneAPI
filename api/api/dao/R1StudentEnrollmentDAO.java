package api.dao;

import api.model.R1StudentEnrollment;
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

public class R1StudentEnrollmentDAO extends BaseDAO
{
	protected final Logger logger = Logger.getLogger(getClass());
	
	//Return Single R1StudentEnrollment Object
    @SuppressWarnings("unchecked")
    public R1StudentEnrollment getStudentEnrollment(BasicTransaction tx, String studentEnrollmentRefId, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	 try
         {
             Criteria criteria = tx.getSession().createCriteria(R1StudentEnrollment.class)
                .add(Restrictions.eq("studentEnrollmentRefId", studentEnrollmentRefId)); //the actual sql type query
               
             
             List<R1StudentEnrollment> studentEnrollments = criteria.list();
             
             // There can only be a maximum of one
             if (studentEnrollments.isEmpty()) 
             {
            	 logger.debug("No StudentEnrollment with staffRefID = "+ studentEnrollmentRefId);
                 return null;
             }
             else // already exists
             {
             	return studentEnrollments.get(0); //always 1 if looking for a specific record, so index 0 is the first record
             }
         }
         catch (HibernateException e)
         {
             throw new PersistenceException("Unable to retrieve R1StudentEnrollment with studentEnrollmentRefId = "+ studentEnrollmentRefId, e);
         }	
    }
    
    //Return Multiple R1StudentEnrollment Objects
    @SuppressWarnings("unchecked")
	public List<R1StudentEnrollment> getStudentEnrollments(BasicTransaction tx, SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {        
    	try
        {
            Criteria criteria = tx.getSession().createCriteria(R1StudentEnrollment.class);
               //.add(Restrictions.eq("environmentID", environmentID))
               //.add(Restrictions.eq("adapterType", adapterType.name()));
            
            return criteria.list();  
        }
        catch (HibernateException e)
        {
            throw new PersistenceException("Unable to retrieve List of R1StudentEnrollments from R1StudentEnrollmentDAO");
        }	
    }

}
