package api.mapping;

//SIF Common
import sif.dd.us32.model.LeaCEDSType.PhoneNumberList;
import sif.dd.us32.model.LeaCEDSType.PhoneNumberList.PhoneNumber;
import sif.dd.us32.model.LeaCEDSType.AddressList.Address;
import sif.dd.us32.model.LeaCEDSType.AddressList.Address.Street;
import sif.dd.us32.model.LeaCEDSType.AddressList;
import sif.dd.us32.model.ObjectFactory;
import sif.dd.us32.model.LeaCEDSType;
import sif.dd.us32.model.LeaCEDSType.Identification;
import api.model.R1LEA;
import api.model.R1LEATelephone;


public class R1LEAMapper
{
	private ObjectFactory oFac = new ObjectFactory();
	
	
	//--LEA---------------------------------------------------------------//
		public LeaCEDSType modelToSIF(R1LEA r1LEA)
		{
			LeaCEDSType sifLEA = oFac.createLeaCEDSType();		
			Identification sifIdentification = oFac.createLeaCEDSTypeIdentification();
			AddressList sifAddressList = oFac.createLeaCEDSTypeAddressList();
			PhoneNumberList sifPhoneNumberList = oFac.createLeaCEDSTypePhoneNumberList();
			
			//Identification
			sifIdentification.setLeaId(r1LEA.getLeaId());
			sifIdentification.setName(r1LEA.getLeaName());
			
			/********** Address **********/
			Address sifAddress = oFac.createLeaCEDSTypeAddressListAddress();
			Street sifStreet = oFac.createLeaCEDSTypeAddressListAddressStreet();
			
			sifStreet.setLine1(r1LEA.getStreetNumberAndName());
			
			//Set Address
			sifAddress.setCity(r1LEA.getCity());
			sifAddress.setCounty(r1LEA.getAddressCountyName());
			sifAddress.setPostalCode(r1LEA.getPostalCode());
			sifAddress.setStateProvince(r1LEA.getStateCode());			
			sifAddress.setStreet(sifStreet);
			
			sifAddressList.getAddress().add(sifAddress);	

			
			/********** PhoneNumber**********/
			for(R1LEATelephone phone : r1LEA.getR1LEATelephones())
			{
				PhoneNumber sifPhoneNumber = oFac.createLeaCEDSTypePhoneNumberListPhoneNumber();
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
			sifLEA.setRefId(r1LEA.getLeaRefId());			
			sifLEA.setIdentification(sifIdentification);
			sifLEA.setAddressList(sifAddressList);
			sifLEA.setPhoneNumberList(sifPhoneNumberList);
			return sifLEA;
		}
		
		public R1LEA sifToModel(LeaCEDSType sifLEA)
		{
			R1LEA r1LEA = new R1LEA();
			r1LEA.setLeaRefId(sifLEA.getRefId());
			r1LEA.setLeaId(sifLEA.getIdentification().getLeaId());
			r1LEA.setLeaName(sifLEA.getIdentification().getName());
			return r1LEA;
		}
	

}
