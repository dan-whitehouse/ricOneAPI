package api.common;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class Helper
{
	public static XMLGregorianCalendar getDateValue(String value) 
	{
		XMLGregorianCalendar result = null;
		try 
		{
			if (value != null) 
			{
				result = DatatypeFactory.newInstance().newXMLGregorianCalendar(value);
			}
		} 
		catch (Exception ex) 
		{
			
		}
		return result;
	}
}
