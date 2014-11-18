package api.mapping;

//SIF Common

import api.model.R1StudentContactAddress;
import sif.dd.us32.model.ContactPersonCEDSType;
import sif.dd.us32.model.ContactPersonCEDSType.Contact;
import sif.dd.us32.model.ContactPersonCEDSType.Contact.AddressList;
import sif.dd.us32.model.ContactPersonCEDSType.Contact.AddressList.Address;
import sif.dd.us32.model.ContactPersonCEDSType.Contact.AddressList.Address.Street;
import sif.dd.us32.model.K12StudentType;
import sif.dd.us32.model.ObjectFactory;



public class R1StudentContactAddressMapper
{
	private ObjectFactory oFac = new ObjectFactory();

		
	//--Student---------------------------------------------------------------//
	public ContactPersonCEDSType modelToSIF(R1StudentContactAddress r1StudentContactAddress)
	{
		ContactPersonCEDSType sifContactPerson = oFac.createContactPersonCEDSType();
		Contact sifContact = oFac.createContactPersonCEDSTypeContact();
		AddressList sifAddressList = oFac.createContactPersonCEDSTypeContactAddressList();
		Address sifAddress = oFac.createContactPersonCEDSTypeContactAddressListAddress();
		Street sifStreet = oFac.createContactPersonCEDSTypeContactAddressListAddressStreet();
		
		sifStreet.setLine1(r1StudentContactAddress.getStreetNumberAndName());
		
		sifAddress.setAddressType(r1StudentContactAddress.getAddressTypeCode());
		sifAddress.setStreet(sifStreet);
		sifAddress.setCity(r1StudentContactAddress.getCity());
		sifAddress.setCountry(r1StudentContactAddress.getCountryCode());
		sifAddress.setCounty(r1StudentContactAddress.getAddressCountyName());
		sifAddress.setPostalCode(r1StudentContactAddress.getPostalCode());
		sifAddress.setStateProvince(r1StudentContactAddress.getStateCode());

		sifAddressList.getAddress().add(sifAddress);
		sifContact.setAddressList(sifAddressList);
		sifContactPerson.setContact(sifContact);
		sifContactPerson.setRefId(r1StudentContactAddress.getStudentContactRefId());	
		return sifContactPerson;
	}
	
	public R1StudentContactAddress sifToModel(ContactPersonCEDSType sifContactPerson)
	{
		R1StudentContactAddress r1StudentContactAddress = new R1StudentContactAddress();
		
		return r1StudentContactAddress;
		
	}
	
	
	
}
