package api.dao;

import api.model.R1StudentLanguage;
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

public class R1StudentLanguageDAO extends BaseDAO
{
	protected final Logger logger = Logger.getLogger(getClass());
	
	//Return Single R1StudentLanguage Object
    @SuppressWarnings("unchecked")
    public R1StudentLanguage getStudentLanguage(BasicTransaction tx, String studentLanguageRefId, SIFZone zone, SIFContext context) throws IllegalArgumentException, PersistenceException
    {
    	 try
         {
             Criteria criteria = tx.getSession().createCriteria(R1StudentLanguage.class)
                .add(Restrictions.eq("studentLanguageRefId", studentLanguageRefId)); //the actual sql type query
               
             
             List<R1StudentLanguage> studentLanguages = criteria.list();
             
             // There can only be a maximum of one
             if (studentLanguages.isEmpty()) 
             {
            	 logger.debug("No StudentLanguage with studentLanguageRefID = '"+ studentLanguageRefId);
                 return null;
             }
             else // already exists
             {
             	return studentLanguages.get(0); //always 1 if looking for a specific record, so index 0 is the first record
             }
         }
         catch (HibernateException e)
         {
             throw new PersistenceException("Unable to retrieve R1StudentLanguage with studentLanguageRefId = '"+ studentLanguageRefId + "'.", e);
         }	
    }
    
    //Return Multiple R1StudentLanguage Objects
    @SuppressWarnings("unchecked")
	public List<R1StudentLanguage> getStudentLanguages(BasicTransaction tx, SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws IllegalArgumentException, PersistenceException
    {        
    	try
        {
            Criteria criteria = tx.getSession().createCriteria(R1StudentLanguage.class);           
            return criteria.list();  
        }
        catch (HibernateException e)
        {
            throw new PersistenceException("Unable to retrieve List of R1StudentLanguages from R1StudentLanguageDAO");
        }	
    }

}
