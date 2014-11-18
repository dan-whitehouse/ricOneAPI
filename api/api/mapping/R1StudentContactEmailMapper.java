package api.mapping;

//SIF Common

import api.model.R1StudentContactEmail;
import sif.dd.us32.model.ContactPersonCEDSType;
import sif.dd.us32.model.ContactPersonCEDSType.Contact;
import sif.dd.us32.model.ContactPersonCEDSType.Contact.EmailList;
import sif.dd.us32.model.ContactPersonCEDSType.Contact.EmailList.Email;

import sif.dd.us32.model.ObjectFactory;

//SIF Student



public class R1StudentContactEmailMapper
{
	private ObjectFactory oFac = new ObjectFactory();

		
	//--Student---------------------------------------------------------------//
	public ContactPersonCEDSType modelToSIF(R1StudentContactEmail r1StudentContactEmail)
	{
		ContactPersonCEDSType sifContactPerson = oFac.createContactPersonCEDSType();
		Contact sifContact = oFac.createContactPersonCEDSTypeContact();
		EmailList sifEmailList = oFac.createContactPersonCEDSTypeContactEmailList();
		Email sifEmail = oFac.createContactPersonCEDSTypeContactEmailListEmail();
		
		sifEmail.setEmailType(r1StudentContactEmail.getEmailTypeCode());
		
			
		sifEmailList.getEmail().add(sifEmail);
		sifContact.setEmailList(sifEmailList);
		sifContactPerson.setContact(sifContact);
		sifContactPerson.setRefId(r1StudentContactEmail.getStudentContactRefId());
		
		return sifContactPerson;
	}
	
	public R1StudentContactEmail sifToModel(ContactPersonCEDSType sifContactPerson)
	{
		R1StudentContactEmail r1StudentContactAddress = new R1StudentContactEmail();
		
		return r1StudentContactAddress;
		
	}
	
	
	
}
