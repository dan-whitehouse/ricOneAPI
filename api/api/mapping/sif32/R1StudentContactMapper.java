package api.mapping.sif32;

//SIF Common

import api.model.R1StudentContact;
import sif.dd.us32.model.ContactPersonCEDSType;
import sif.dd.us32.model.ContactPersonCEDSType.Demographic;
import sif.dd.us32.model.ContactPersonCEDSType.Identity;
import sif.dd.us32.model.ContactPersonCEDSType.Identity.Name;
import sif.dd.us32.model.K12StudentType;
import sif.dd.us32.model.ObjectFactory;

//SIF Student
import sif.dd.us32.model.AddressType;


public class R1StudentContactMapper
{
	private ObjectFactory oFac = new ObjectFactory();

		
	//--Student---------------------------------------------------------------//
	public ContactPersonCEDSType modelToSIF(R1StudentContact r1StudentContact)
	{
		ContactPersonCEDSType sifContactPerson = oFac.createContactPersonCEDSType();
		Identity sifIdentity = oFac.createContactPersonCEDSTypeIdentity();
		Demographic sifDemographic = oFac.createContactPersonCEDSTypeDemographic();
		Name sifName = oFac.createContactPersonCEDSTypeIdentityName();
		
		sifName.setFirstName(r1StudentContact.getFirstName());
		sifName.setMiddleName(r1StudentContact.getMiddleName());
		sifName.setLastName(r1StudentContact.getLastName());
		sifName.setPrefix(r1StudentContact.getPrefix());
		
		sifDemographic.setSex(r1StudentContact.getSexCode());
		
		
		sifIdentity.setName(sifName);	
		sifContactPerson.setIdentity(sifIdentity);
		sifContactPerson.setDemographic(sifDemographic);
		sifContactPerson.setRefId(r1StudentContact.getStudentContactRefId());
				
		return sifContactPerson;
	}
	
	public R1StudentContact sifToModel(AddressType sifAddress)
	{
		R1StudentContact r1StudentAddress = new R1StudentContact();
		
		return r1StudentAddress;
		
	}
	
	
	
}
