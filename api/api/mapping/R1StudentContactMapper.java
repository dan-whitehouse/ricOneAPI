package api.mapping;

//SIF Common

import api.model.R1StudentContact;
import sif.dd.us32.model.ContactPersonCEDSType;
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
	public K12StudentType modelToSIF(R1StudentContact r1StudentContact)
	{
		K12StudentType sifStudent = oFac.createK12StudentType();
		ContactPersonCEDSType sifContactPerson = oFac.createContactPersonCEDSType();
		Identity sifIdentity = oFac.createContactPersonCEDSTypeIdentity();
		Name sifName = oFac.createContactPersonCEDSTypeIdentityName();
		
		sifName.setFirstName(r1StudentContact.getFirstName());
		sifName.setMiddleName(r1StudentContact.getMiddleName());
		sifName.setLastName(r1StudentContact.getLastName());
		sifName.setPrefix(r1StudentContact.getPrefix());
		
		sifIdentity.setName(sifName);
		
		sifContactPerson.setIdentity(sifIdentity);
		sifContactPerson.setRefId(r1StudentContact.getStudentContactRefId());
		
		
		
			
		return sifStudent;
	}
	
	public R1StudentContact sifToModel(AddressType sifAddress)
	{
		R1StudentContact r1StudentAddress = new R1StudentContact();
		
		return r1StudentAddress;
		
	}
	
	
	
}
