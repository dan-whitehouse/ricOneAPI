package api.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class R1Student implements Serializable
{
	private static final long serialVersionUID = 4255199616263324174L;
    
	private String studentRefId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String generationCode;
	private String prefix; 
	private Date birthdate;
	private String sexCode;
	private boolean hispanicLatinoEthnicity;
	private String usCitizenshipStatusCode;		   
	private String counselor;
	private String cohortGraduationYear;
	private String gradeLevelCode;
	private Set<R1StudentIdentifier> r1StudentIdentifiers = new HashSet<R1StudentIdentifier>(0);
	private Set<R1StudentOtherName> r1StudentOtherNames = new HashSet<R1StudentOtherName>(0);
	private Set<R1StudentAddress> r1StudentAddresses = new HashSet<R1StudentAddress>(0);
	private Set<R1StudentEmail> r1StudentEmails = new HashSet<R1StudentEmail>(0);
	private Set<R1StudentTelephone> r1StudentTelephones = new HashSet<R1StudentTelephone>(0);
	private Set<R1StudentRace> r1StudentRaces = new HashSet<R1StudentRace>(0);
	private Set<R1StudentHealth> r1StudentHealthRecords = new HashSet<R1StudentHealth>(0);
	private Set<R1StudentLanguage> r1StudentLanguages = new HashSet<R1StudentLanguage>(0);
	private Set<R1StudentContactRelationship> r1StudentContactRelationships = new HashSet<R1StudentContactRelationship>(0);
	private Set<R1StudentCourseSection> r1StudentCourseSections = new HashSet<R1StudentCourseSection>(0);
	private Set<R1StudentEnrollment> r1StudentEnrollments = new HashSet<R1StudentEnrollment>(0);
	

	public R1Student() {}


	public String getStudentRefId()
	{
		return studentRefId;
	}


	public void setStudentRefId(String studentRefId)
	{
		this.studentRefId = studentRefId;
	}


	public String getFirstName()
	{
		return firstName;
	}


	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}


	public String getMiddleName()
	{
		return middleName;
	}


	public void setMiddleName(String middleName)
	{
		this.middleName = middleName;
	}


	public String getLastName()
	{
		return lastName;
	}


	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}


	public String getGenerationCode()
	{
		return generationCode;
	}


	public void setGenerationCode(String generationCode)
	{
		this.generationCode = generationCode;
	}


	public String getPrefix()
	{
		return prefix;
	}


	public void setPrefix(String prefix)
	{
		this.prefix = prefix;
	}


	public Date getBirthdate()
	{
		return birthdate;
	}


	public void setBirthdate(Date birthdate)
	{
		this.birthdate = birthdate;
	}


	public String getSexCode()
	{
		return sexCode;
	}


	public void setSexCode(String sexCode)
	{
		this.sexCode = sexCode;
	}


	public boolean isHispanicLatinoEthnicity()
	{
		return hispanicLatinoEthnicity;
	}


	public void setHispanicLatinoEthnicity(boolean hispanicLatinoEthnicity)
	{
		this.hispanicLatinoEthnicity = hispanicLatinoEthnicity;
	}


	public String getUsCitizenshipStatusCode()
	{
		return usCitizenshipStatusCode;
	}


	public void setUsCitizenshipStatusCode(String usCitizenshipStatusCode)
	{
		this.usCitizenshipStatusCode = usCitizenshipStatusCode;
	}


	public String getCounselor()
	{
		return counselor;
	}


	public void setCounselor(String counselor)
	{
		this.counselor = counselor;
	}


	public String getCohortGraduationYear()
	{
		return cohortGraduationYear;
	}


	public void setCohortGraduationYear(String cohortGraduationYear)
	{
		this.cohortGraduationYear = cohortGraduationYear;
	}


	public String getGradeLevelCode()
	{
		return gradeLevelCode;
	}


	public void setGradeLevelCode(String gradeLevelCode)
	{
		this.gradeLevelCode = gradeLevelCode;
	}


	public Set<R1StudentIdentifier> getR1StudentIdentifiers()
	{
		return r1StudentIdentifiers;
	}


	public void setR1StudentIdentifiers(Set<R1StudentIdentifier> r1StudentIdentifiers)
	{
		this.r1StudentIdentifiers = r1StudentIdentifiers;
	}


	public Set<R1StudentOtherName> getR1StudentOtherNames()
	{
		return r1StudentOtherNames;
	}


	public void setR1StudentOtherNames(Set<R1StudentOtherName> r1StudentOtherNames)
	{
		this.r1StudentOtherNames = r1StudentOtherNames;
	}


	public Set<R1StudentAddress> getR1StudentAddresses()
	{
		return r1StudentAddresses;
	}


	public void setR1StudentAddresses(Set<R1StudentAddress> r1StudentAddresses)
	{
		this.r1StudentAddresses = r1StudentAddresses;
	}


	public Set<R1StudentEmail> getR1StudentEmails()
	{
		return r1StudentEmails;
	}


	public void setR1StudentEmails(Set<R1StudentEmail> r1StudentEmails)
	{
		this.r1StudentEmails = r1StudentEmails;
	}


	public Set<R1StudentTelephone> getR1StudentTelephones()
	{
		return r1StudentTelephones;
	}


	public void setR1StudentTelephones(Set<R1StudentTelephone> r1StudentTelephones)
	{
		this.r1StudentTelephones = r1StudentTelephones;
	}


	public Set<R1StudentRace> getR1StudentRaces()
	{
		return r1StudentRaces;
	}


	public void setR1StudentRaces(Set<R1StudentRace> r1StudentRaces)
	{
		this.r1StudentRaces = r1StudentRaces;
	}

	public Set<R1StudentHealth> getR1StudentHealthRecords()
	{
		return r1StudentHealthRecords;
	}


	public void setR1StudentHealthRecords(Set<R1StudentHealth> r1StudentHealthRecords)
	{
		this.r1StudentHealthRecords = r1StudentHealthRecords;
	}


	public Set<R1StudentLanguage> getR1StudentLanguages()
	{
		return r1StudentLanguages;
	}


	public void setR1StudentLanguages(Set<R1StudentLanguage> r1StudentLanguages)
	{
		this.r1StudentLanguages = r1StudentLanguages;
	}


	public Set<R1StudentContactRelationship> getR1StudentContactRelationships()
	{
		return r1StudentContactRelationships;
	}


	public void setR1StudentContactRelationships(
			Set<R1StudentContactRelationship> r1StudentContactRelationships)
	{
		this.r1StudentContactRelationships = r1StudentContactRelationships;
	}


	public Set<R1StudentCourseSection> getR1StudentCourseSections()
	{
		return r1StudentCourseSections;
	}


	public void setR1StudentCourseSections(Set<R1StudentCourseSection> r1StudentCourseSections)
	{
		this.r1StudentCourseSections = r1StudentCourseSections;
	}


	public Set<R1StudentEnrollment> getR1StudentEnrollments()
	{
		return r1StudentEnrollments;
	}


	public void setR1StudentEnrollments(Set<R1StudentEnrollment> r1StudentEnrollments)
	{
		this.r1StudentEnrollments = r1StudentEnrollments;
	}





		
	
}
