package api.dao;

import api.model.R1StudentOtherName;
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

public class R1StudentOtherNameDAO extends BaseDAO
{
	protected final Logger logger = Logger.getLogger(getClass());
	
	//Return Single R1StudentOtherName Object
    @SuppressWarnings("unchecked")
    public R1StudentOtherName getStudentOtherName(BasicTransaction tx, String studentOtherNameRefId, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	 try
         {
             Criteria criteria = tx.getSession().createCriteria(R1StudentOtherName.class)
                .add(Restrictions.eq("studentOtherNameRefId", studentOtherNameRefId)); //the actual sql type query
               
             
             List<R1StudentOtherName> studentOtherNames = criteria.list();
             
             // There can only be a maximum of one
             if (studentOtherNames.isEmpty()) 
             {
            	 logger.debug("No StudentOtherName with studentOtherNameRefID = '"+ studentOtherNameRefId);
                 return null;
             }
             else // already exists
             {
             	return studentOtherNames.get(0); //always 1 if looking for a specific record, so index 0 is the first record
             }
         }
         catch (HibernateException e)
         {
             throw new PersistenceException("Unable to retrieve R1StudentOtherName with studentOtherNameRefId = '"+ studentOtherNameRefId + "'.", e);
         }	
    }
    
    //Return Multiple R1StudentOtherName Objects
    @SuppressWarnings("unchecked")
	public List<R1StudentOtherName> getStudentOtherNames(BasicTransaction tx, SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {        
    	try
        {
            Criteria criteria = tx.getSession().createCriteria(R1StudentOtherName.class);           
            return criteria.list();  
        }
        catch (HibernateException e)
        {
            throw new PersistenceException("Unable to retrieve List of R1StudentOtherNames from R1StudentOtherNameDAO");
        }	
    }

}
