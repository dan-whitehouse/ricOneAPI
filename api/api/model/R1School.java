package api.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import sif3.common.header.HeaderValues.ServiceType;
import sif3.common.model.EnvironmentKey;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;
import sif3.common.model.ServiceInfo;
import sif3.common.model.ServiceRights.AccessRight;
import sif3.common.model.ServiceRights.AccessType;

@Entity
@Table(name="School")
public class R1School implements Serializable
{
	private static final long serialVersionUID = 4255199616263324176L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SchoolRefId", unique=true, nullable=false)
	private String schoolRefId;
	
	//@Column(name="LEARefId", nullable=false)
	private String leaRefId;
	
	@Column(name="LEAName", nullable=true, length=60)
	private String leaName;
	
	@Column(name="StreetNumberAndName", nullable=true, length=40)
	private String streetNumberAndName;
	
	@Column(name="City", nullable=true, length=30)
	private String city;
	
	@Column(name="StateCode", nullable=true, length=50)
	private String stateCode; 
	
	@Column(name="PostalCode", nullable=true, length=50)
	private String postalCode;
	
	@Column(name="AddressCountyName", nullable=true, length=30)
	private String addressCountyName;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="r1School")
	private Set<R1StudentEnrollment> r1StudentEnrollments = new HashSet<R1StudentEnrollment>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="r1School")
	private Set<R1Course> r1Courses = new HashSet<R1Course>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="r1School")
	private Set<R1SchoolIdentifier> r1SchoolIdentifiers = new HashSet<R1SchoolIdentifier>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="r1School")
	private Set<R1SchoolCalendar> r1SchoolCalendars = new HashSet<R1SchoolCalendar>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="r1School")
	private Set<R1StaffAssignment> r1StaffAssignments = new HashSet<R1StaffAssignment>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="r1School")
	private Set<R1SchoolTelephone> r1SchoolTelephones = new HashSet<R1SchoolTelephone>(0);
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="LEARefId", nullable=false)
	private R1LEA r1Lea;
	
	//--
	public R1School() {}

	public R1School(String schoolRefId, String leaRefId, String leaName,
			String streetNumberAndName, String city, String stateCode,
			String postalCode, String addressCountyName,
			Set<R1StudentEnrollment> r1StudentEnrollments,
			Set<R1Course> r1Courses,
			Set<R1SchoolIdentifier> r1SchoolIdentifiers,
			Set<R1SchoolCalendar> r1SchoolCalendars,
			Set<R1StaffAssignment> r1StaffAssignments,
			Set<R1SchoolTelephone> r1SchoolTelephones, R1LEA r1Lea) 
	{
		this.schoolRefId = schoolRefId;
		this.leaRefId = leaRefId;
		this.leaName = leaName;
		this.streetNumberAndName = streetNumberAndName;
		this.city = city;
		this.stateCode = stateCode;
		this.postalCode = postalCode;
		this.addressCountyName = addressCountyName;
		this.r1StudentEnrollments = r1StudentEnrollments;
		this.r1Courses = r1Courses;
		this.r1SchoolIdentifiers = r1SchoolIdentifiers;
		this.r1SchoolCalendars = r1SchoolCalendars;
		this.r1StaffAssignments = r1StaffAssignments;
		this.r1SchoolTelephones = r1SchoolTelephones;
		this.r1Lea = r1Lea;
	}




	
	public String getSchoolRefId()
    {
    	return this.schoolRefId;
    }
	
	public void setSchoolRefId(String schoolRefId)
    {
    	this.schoolRefId = schoolRefId;
    }
	
	
	public String getLeaRefId()
    {
    	return this.leaRefId;
    }
	
	public void setLeaRefId(String leaRefId)
    {
    	this.leaRefId = leaRefId;
    }
	
	
	public String getLeaName()
    {
    	return this.leaName;
    }
	
	public void setLeaName(String leaName)
    {
    	this.leaName = leaName;
    }
	
	
	public String getStreetNumberAndName()
    {
    	return this.streetNumberAndName;
    }
	
	public void setStreetNumberAndName(String streetNumberAndName)
    {
    	this.streetNumberAndName = streetNumberAndName;
    }
	
	
	public String getCity()
    {
    	return this.city;
    }
	
	public void setCity(String city)
    {
    	this.city = city;
    }
	
	
	public String getStateCode()
    {
    	return this.stateCode;
    }
	
	public void setStateCode(String stateCode)
    {
    	this.stateCode = stateCode;
    }
	
	
	public String getPostalCode()
    {
    	return this.postalCode;
    }
	
	public void setPostalCode(String postalCode)
    {
    	this.postalCode = postalCode;
    }
	
	
	
	public String getAddressCountyName()
    {
    	return this.addressCountyName;
    }
	
	public void setAddressCountyName(String addressCountyName)
    {
    	this.addressCountyName = addressCountyName;
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

	public Set<R1SchoolTelephone> getR1SchoolTelephones() 
	{
		return r1SchoolTelephones;
	}

	public void setR1SchoolTelephones(Set<R1SchoolTelephone> r1SchoolTelephones) 
	{
		this.r1SchoolTelephones = r1SchoolTelephones;
	}	
	
	
	public R1LEA getR1Lea()
	{
		return r1Lea;
	}

	public void setR1Lea(R1LEA r1Lea)
	{
		this.r1Lea = r1Lea;
	}
	//-----
	@Override
    public String toString()
    {
		String output = String.format("School Output [refID: %1$s], [FN: %2$s], [MN: %3$s], [LN: %4$s]", schoolRefId, leaRefId, leaName, streetNumberAndName);
	    return output;
    }
}
