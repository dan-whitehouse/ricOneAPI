package api.mapping;

//SIF Common


import api.model.R1StudentAddress;
import sif.dd.us32.model.K12StudentType;
import sif.dd.us32.model.K12StudentType.Contact;
import sif.dd.us32.model.K12StudentType.Contact.AddressList;
import sif.dd.us32.model.K12StudentType.Contact.AddressList.Address;
import sif.dd.us32.model.K12StudentType.Contact.AddressList.Address.Street;

import sif.dd.us32.model.ObjectFactory;

//SIF Student
import sif.dd.us32.model.AddressType;


public class R1StudentAddressMapper
{
	private ObjectFactory oFac = new ObjectFactory();

		
	//--Student---------------------------------------------------------------//
	public K12StudentType modelToSIF(R1StudentAddress r1Student)
	{
		K12StudentType sifStudent = oFac.createK12StudentType();
		Contact sifContact = oFac.createK12StudentTypeContact();
		AddressList sifAddressList = oFac.createK12StudentTypeContactAddressList();
		Address sifAddress = oFac.createK12StudentTypeContactAddressListAddress();
		Street sifStreet = oFac.createK12StudentTypeContactAddressListAddressStreet();
		
		//Set Street
		sifStreet.setLine1(r1Student.getStreetNumberAndName());
		sifStreet.setApartmentNumber(r1Student.getApartmentRoomOrSuiteNumber());
		
		//Set Address
		sifAddress.setAddressType(r1Student.getAddressTypeCode());
		sifAddress.setCity(r1Student.getCity());
		sifAddress.setCounty(r1Student.getAddressCountyName());
		sifAddress.setPostalCode(r1Student.getPostalCode());
		sifAddress.setStateProvince(r1Student.getStateCode());
		sifAddress.setCountry(r1Student.getCountryCode());
				
		sifAddress.setStreet(sifStreet);
		sifAddressList.getAddress().add(sifAddress);
		sifContact.setAddressList(sifAddressList);		
		sifStudent.setContact(sifContact);
		
		sifStudent.setRefId(r1Student.getStudentRefId());



			
		return sifStudent;
	}
	
	public R1StudentAddress sifToModel(AddressType sifAddress)
	{
		R1StudentAddress r1StudentAddress = new R1StudentAddress();
		
		return r1StudentAddress;
		
	}
	
	
	
}
