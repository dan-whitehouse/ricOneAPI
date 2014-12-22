package api.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="StudentContact")
public class R1StudentContact implements Serializable
{
	private static final long serialVersionUID = 4255199616263324174L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="StudentContactRefId", unique=true, nullable=false)
	private String studentContactRefId;
	
	@Column(name="FirstName")
	private String firstName;
	
	@Column(name="MiddleName")
	private String middleName;
	
	@Column(name="LastName")
	private String lastName;
	
	@Column(name="GenerationCode")
	private String generationCode;
	
	@Column(name="Prefix")
	private String prefix; 
	
	@Column(name="SexCode")
	private String sexCode;   
	
	@Column(name="LanguageCode")
	private String languageCode;
	
	@Column(name="LanguageUseTypeCode")
	private String languageUseTypeCode;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="r1StudentContact")
	private Set<R1StudentContactRelationship> r1StudentContactRelationships = new HashSet<R1StudentContactRelationship>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="r1StudentContact")
	private Set<R1StudentContactAddress> r1StudentContactAddresses = new HashSet<R1StudentContactAddress>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="r1StudentContact")
	private Set<R1StudentContactTelephone> r1StudentContactTelephones = new HashSet<R1StudentContactTelephone>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="r1StudentContact")
	private Set<R1StudentContactEmail> r1StudentContactEmails = new HashSet<R1StudentContactEmail>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="r1StudentContact")
	private Set<R1StudentContactIdentifier> r1StudentContactIdentifiers = new HashSet<R1StudentContactIdentifier>(0);
		
	//--
	public R1StudentContact() {}

	public R1StudentContact(String studentContactRefId, String firstName,
			String middleName, String lastName, String generationCode,
			String prefix, String sexCode, String languageCode,
			String languageUseTypeCode,
			Set<R1StudentContactRelationship> r1StudentContactRelationships,
			Set<R1StudentContactAddress> r1StudentContactAddresses,
			Set<R1StudentContactTelephone> r1StudentContactTelephones,
			Set<R1StudentContactEmail> r1StudentContactEmails,
			Set<R1StudentContactIdentifier> r1StudentContactIdentifiers) 
	{
		this.studentContactRefId = studentContactRefId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.generationCode = generationCode;
		this.prefix = prefix;
		this.sexCode = sexCode;
		this.languageCode = languageCode;
		this.languageUseTypeCode = languageUseTypeCode;
		this.r1StudentContactRelationships = r1StudentContactRelationships;
		this.r1StudentContactAddresses = r1StudentContactAddresses;
		this.r1StudentContactTelephones = r1StudentContactTelephones;
		this.r1StudentContactEmails = r1StudentContactEmails;
		this.r1StudentContactIdentifiers = r1StudentContactIdentifiers;
	}

	public String getStudentContactRefId() 
	{
		return studentContactRefId;
	}


	public void setStudentContactRefId(String studentContactRefId) 
	{
		this.studentContactRefId = studentContactRefId;
	}
	
	public String getFirstName() {
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

	public String getSexCode() 
	{
		return sexCode;
	}

	public void setSexCode(String sexCode) 
	{
		this.sexCode = sexCode;
	}

	public String getLanguageCode() 
	{
		return languageCode;
	}

	public void setLanguageCode(String languageCode) 
	{
		this.languageCode = languageCode;
	}
	
	public String getLanguageUseTypeCode() 
	{
		return languageUseTypeCode;
	}
	
	public void setLanguageUseTypeCode(String languageUseTypeCode) 
	{
		this.languageUseTypeCode = languageUseTypeCode;
	}

	public Set<R1StudentContactRelationship> getR1StudentContactRelationships()
	{
		return r1StudentContactRelationships;
	}

	public void setR1StudentContactRelationships(Set<R1StudentContactRelationship> r1StudentContactRelationships)
	{
		this.r1StudentContactRelationships = r1StudentContactRelationships;
	}

	public Set<R1StudentContactAddress> getR1StudentContactAddresses()
	{
		return r1StudentContactAddresses;
	}

	public void setR1StudentContactAddresses(Set<R1StudentContactAddress> r1StudentContactAddresses)
	{
		this.r1StudentContactAddresses = r1StudentContactAddresses;
	}

	public Set<R1StudentContactTelephone> getR1StudentContactTelephones()
	{
		return r1StudentContactTelephones;
	}

	public void setR1StudentContactTelephones(Set<R1StudentContactTelephone> r1StudentContactTelephones)
	{
		this.r1StudentContactTelephones = r1StudentContactTelephones;
	}

	public Set<R1StudentContactEmail> getR1StudentContactEmails()
	{
		return r1StudentContactEmails;
	}

	public void setR1StudentContactEmails(Set<R1StudentContactEmail> r1StudentContactEmails)
	{
		this.r1StudentContactEmails = r1StudentContactEmails;
	}

	public Set<R1StudentContactIdentifier> getR1StudentContactIdentifiers()
	{
		return r1StudentContactIdentifiers;
	}

	public void setR1StudentContactIdentifiers(Set<R1StudentContactIdentifier> r1StudentContactIdentifiers)
	{
		this.r1StudentContactIdentifiers = r1StudentContactIdentifiers;
	}   
	
	@Override
	public String toString() 
	{
		return "R1StudentContact [studentContactRefId=" + studentContactRefId
				+ ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", generationCode="
				+ generationCode + ", prefix=" + prefix + ", sexCode="
				+ sexCode + ", languageCode=" + languageCode
				+ ", languageUseTypeCode=" + languageUseTypeCode + "]";
	}
}
