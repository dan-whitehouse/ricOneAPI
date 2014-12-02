package api.mapping;

//SIF Common

import sif.dd.us32.model.K12SchoolType.PhoneNumberList;
import sif.dd.us32.model.ObjectFactory;

//SIF School
import sif.dd.us32.model.K12SchoolType;
import sif.dd.us32.model.K12SchoolType.AddressList;
import sif.dd.us32.model.K12SchoolType.AddressList.Address;
import sif.dd.us32.model.K12SchoolType.AddressList.Address.Street;
import sif.dd.us32.model.K12SchoolType.Identification;
import sif.dd.us32.model.K12SchoolType.PhoneNumberList.PhoneNumber;
import api.model.R1School;
import api.model.R1SchoolTelephone;


public class R1SchoolMapper
{
	private ObjectFactory oFac = new ObjectFactory();

		
	//--School---------------------------------------------------------------//
	public K12SchoolType modelToSIF(R1School r1School)
	{
		K12SchoolType sifSchool = oFac.createK12SchoolType();
		Identification sifIdentification = oFac.createK12SchoolTypeIdentification();
		AddressList sifAddressList = oFac.createK12SchoolTypeAddressList();
		Address sifAddress = oFac.createK12SchoolTypeAddressListAddress();
		Street sifStreet = oFac.createK12SchoolTypeAddressListAddressStreet();
		PhoneNumberList sifPhoneNumberList = oFac.createK12SchoolTypePhoneNumberList();
		
		//Identification Data
		sifIdentification.setName(r1School.getLeaName());

		//Address Data
		sifStreet.setLine1(r1School.getStreetNumberAndName());
		sifAddress.setStreet(sifStreet);
		sifAddress.setCity(r1School.getCity());
		sifAddress.setCounty(r1School.getAddressCountyName());
		sifAddress.setStateProvince(r1School.getStateCode());
		sifAddress.setPostalCode(r1School.getPostalCode());			
		sifAddressList.getAddress().add(sifAddress);
				
		
		/********** PhoneNumber**********/
		for(R1SchoolTelephone phone : r1School.getR1SchoolTelephones())
		{
			PhoneNumber sifPhoneNumber = oFac.createK12SchoolTypePhoneNumberListPhoneNumber();
			sifPhoneNumber.setNumber(phone.getTelephoneNumber());
			sifPhoneNumber.setPhoneNumberType(phone.getTelephoneNumberTypeCode());
			
			if(phone.isPrimaryTelephoneNumberIndicator() == true)
			{
				sifPhoneNumber.setPhoneNumberIndicator("True");
			}
			else if(phone.isPrimaryTelephoneNumberIndicator() == false)
			{
				sifPhoneNumber.setPhoneNumberIndicator("False");
			}
			else
			{
				sifPhoneNumber.setPhoneNumberIndicator("Null");
			}						
			sifPhoneNumberList.getPhoneNumber().add(sifPhoneNumber);
		}
		
		
		//Fill Object
		sifSchool.setRefId(r1School.getSchoolRefId());
		sifSchool.setIdentification(sifIdentification);
		sifSchool.setAddressList(sifAddressList);
		sifSchool.setPhoneNumberList(sifPhoneNumberList);
			
		return sifSchool;
	}
	
	public R1School sifToModel(K12SchoolType sifSchool)
	{
		R1School r1School = new R1School();
		
		//Identification Data
		r1School.setSchoolRefId(sifSchool.getRefId());
		
		//Address Data
		r1School.setStreetNumberAndName(sifSchool.getIdentification().getName());		
		
		for(Address address : sifSchool.getAddressList().getAddress())
		{
			r1School.setStreetNumberAndName(address.getStreet().getLine1());
			r1School.setCity(address.getCity());
			r1School.setAddressCountyName(address.getCounty());
			r1School.setStateCode(address.getStateProvince());
			r1School.setPostalCode(address.getPostalCode());
		}
		
		return r1School;
		
	}
	
	
	
}
