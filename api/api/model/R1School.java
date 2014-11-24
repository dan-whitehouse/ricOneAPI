package api.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import sif3.common.header.HeaderValues.ServiceType;
import sif3.common.model.EnvironmentKey;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;
import sif3.common.model.ServiceInfo;
import sif3.common.model.ServiceRights.AccessRight;
import sif3.common.model.ServiceRights.AccessType;


public class R1School implements Serializable
{
	private static final long serialVersionUID = 4255199616263324176L;
    
	private String schoolRefId;
	private String leaRefId;
	private String leaName;
	private String streetNumberAndName;
	private String city;
	private String stateCode; 
	private String postalCode;
	private String addressCountyName;
	private Set<R1StudentEnrollment> r1StudentEnrollments = new HashSet<R1StudentEnrollment>(0);
	private Set<R1Course> r1Courses = new HashSet<R1Course>(0);
	private Set<R1SchoolIdentifier> r1SchoolIdentifiers = new HashSet<R1SchoolIdentifier>(0);
	private Set<R1SchoolCalendar> r1SchoolCalendars = new HashSet<R1SchoolCalendar>(0);
	private Set<R1StaffAssignment> r1StaffAssignments = new HashSet<R1StaffAssignment>(0);
	private R1LEA r1Lea;
	public R1School() {}
	
	//-----------------------
	public String getSchoolRefId()
    {
    	return this.schoolRefId;
    }
	
	public void setSchoolRefId(String schoolRefId)
    {
    	this.schoolRefId = schoolRefId;
    }
	
	//-----------------------
	public String getLeaRefId()
    {
    	return this.leaRefId;
    }
	
	public void setLeaRefId(String leaRefId)
    {
    	this.leaRefId = leaRefId;
    }
	
	//-----------------------
	public String getLeaName()
    {
    	return this.leaName;
    }
	
	public void setLeaName(String leaName)
    {
    	this.leaName = leaName;
    }
	
	//streetNumberAndName
	public String getStreetNumberAndName()
    {
    	return this.streetNumberAndName;
    }
	
	public void setStreetNumberAndName(String streetNumberAndName)
    {
    	this.streetNumberAndName = streetNumberAndName;
    }
	
	//city
	public String getCity()
    {
    	return this.city;
    }
	
	public void setCity(String city)
    {
    	this.city = city;
    }
	
	//stateCode
	public String getStateCode()
    {
    	return this.stateCode;
    }
	
	public void setStateCode(String stateCode)
    {
    	this.stateCode = stateCode;
    }
	
	//postalCode
	public String getPostalCode()
    {
    	return this.postalCode;
    }
	
	public void setPostalCode(String postalCode)
    {
    	this.postalCode = postalCode;
    }
	
	
	//addressCountyName
	public String getAddressCountyName()
    {
    	return this.addressCountyName;
    }
	
	public void setAddressCountyName(String addressCountyName)
    {
    	this.addressCountyName = addressCountyName;
    }
	
	
	
	@Override
    public String toString()
    {
		String output = String.format("School Output [refID: %1$s], [FN: %2$s], [MN: %3$s], [LN: %4$s]", schoolRefId, leaRefId, leaName, streetNumberAndName);
	    return output;
    }

	public Set<R1StudentEnrollment> getR1StudentEnrollments()
	{
		return r1StudentEnrollments;
	}

	public void setR1StudentEnrollments(Set<R1StudentEnrollment> r1StudentEnrollments)
	{
		this.r1StudentEnrollments = r1StudentEnrollments;
	}

	public Set<R1Course> getR1Courses()
	{
		return r1Courses;
	}

	public void setR1Courses(Set<R1Course> r1Courses)
	{
		this.r1Courses = r1Courses;
	}

	public Set<R1SchoolIdentifier> getR1SchoolIdentifiers()
	{
		return r1SchoolIdentifiers;
	}

	public void setR1SchoolIdentifiers(Set<R1SchoolIdentifier> r1SchoolIdentifiers)
	{
		this.r1SchoolIdentifiers = r1SchoolIdentifiers;
	}

	public Set<R1SchoolCalendar> getR1SchoolCalendars()
	{
		return r1SchoolCalendars;
	}

	public void setR1SchoolCalendars(Set<R1SchoolCalendar> r1SchoolCalendars)
	{
		this.r1SchoolCalendars = r1SchoolCalendars;
	}

	public Set<R1StaffAssignment> getR1StaffAssignments()
	{
		return r1StaffAssignments;
	}

	public void setR1StaffAssignments(Set<R1StaffAssignment> r1StaffAssignments)
	{
		this.r1StaffAssignments = r1StaffAssignments;
	}

	public R1LEA getR1Lea()
	{
		return r1Lea;
	}

	public void setR1Lea(R1LEA r1Lea)
	{
		this.r1Lea = r1Lea;
	}	
}
