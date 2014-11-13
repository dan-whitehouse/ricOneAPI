package api.mapping;

//SIF Common


import sif.dd.us32.model.ObjectFactory;

//SIF School
import sif.dd.us32.model.K12SchoolType;
import sif.dd.us32.model.K12SchoolType.AddressList;
import sif.dd.us32.model.K12SchoolType.AddressList.Address;
import sif.dd.us32.model.K12SchoolType.AddressList.Address.Street;
import sif.dd.us32.model.K12SchoolType.Identification;
import api.model.R1School;


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
				
		//Fill Object
		sifSchool.setRefId(r1School.getSchoolRefId());
		sifSchool.setIdentification(sifIdentification);
		sifSchool.setAddressList(sifAddressList);
			
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
