package api.mapping;

//SIF Common

import api.model.R1StudentContactTelephone;
import sif.dd.us32.model.ContactPersonCEDSType;
import sif.dd.us32.model.ContactPersonCEDSType.Contact;
import sif.dd.us32.model.ContactPersonCEDSType.Contact.PhoneNumberList;
import sif.dd.us32.model.ContactPersonCEDSType.Contact.PhoneNumberList.PhoneNumber;
import sif.dd.us32.model.ObjectFactory;

//SIF Student



public class R1StudentContactTelephoneMapper
{
	private ObjectFactory oFac = new ObjectFactory();

		
	//--Student---------------------------------------------------------------//
	public ContactPersonCEDSType modelToSIF(R1StudentContactTelephone r1StudentContactPhone)
	{
		ContactPersonCEDSType sifContactPerson = oFac.createContactPersonCEDSType();
		Contact sifContact = oFac.createContactPersonCEDSTypeContact();
		PhoneNumberList sifPhoneNumberList = oFac.createContactPersonCEDSTypeContactPhoneNumberList();
		PhoneNumber sifPhoneNumber =  oFac.createContactPersonCEDSTypeContactPhoneNumberListPhoneNumber();
			
		sifPhoneNumber.setNumber(r1StudentContactPhone.getTelephoneNumber());
		sifPhoneNumber.setPhoneNumberType(r1StudentContactPhone.getTelephoneNumberTypeCode());
		
		if(r1StudentContactPhone.isPrimaryTelephoneNumberIndicator()) //true
		{
			sifPhoneNumber.setPhoneNumberIndicator("Yes");			
		}
		else
		{
			sifPhoneNumber.setPhoneNumberIndicator("No");		
		}
		
		sifPhoneNumberList.getPhoneNumber().add(sifPhoneNumber);
		sifContact.setPhoneNumberList(sifPhoneNumberList);
		sifContactPerson.setContact(sifContact);
		sifContactPerson.setRefId(r1StudentContactPhone.getStudentContactRefId());
		
		return sifContactPerson;
	}
	
	public R1StudentContactTelephone sifToModel(ContactPersonCEDSType sifContactPerson)
	{
		R1StudentContactTelephone r1StudentContactAddress = new R1StudentContactTelephone();
		
		return r1StudentContactAddress;
		
	}
	
	
	
}
