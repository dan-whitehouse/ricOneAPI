package api.mapping;

//SIF Common

import api.model.R1StudentContactRelationship;
import sif.dd.us32.model.ContactPersonCEDSType;
import sif.dd.us32.model.ContactPersonCEDSType.Relationship;
import sif.dd.us32.model.ObjectFactory;



public class R1StudentContactRelationshipMapper
{
	private ObjectFactory oFac = new ObjectFactory();

		
	//--Student---------------------------------------------------------------//
	public ContactPersonCEDSType modelToSIF(R1StudentContactRelationship r1StudentContactRelationship)
	{
		ContactPersonCEDSType sifContactPerson = oFac.createContactPersonCEDSType();
		Relationship sifRelationship = oFac.createContactPersonCEDSTypeRelationship();
		
		
		if(r1StudentContactRelationship.isPrimaryContactIndicator()) //true
		{
			sifRelationship.setPrimaryContactIndicator("Yes");
		}
		else
		{
			sifRelationship.setPrimaryContactIndicator("No");
		}
		
		if(r1StudentContactRelationship.isLivesWithIndicator()) //true
		{
			sifRelationship.setPersonRelationshipToLearnerLivesWithIndicator("Yes");
		}
		else
		{
			sifRelationship.setPersonRelationshipToLearnerLivesWithIndicator("No");
		}

		sifContactPerson.setRelationship(sifRelationship);
		sifContactPerson.setRefId(r1StudentContactRelationship.getStudentContactRefId());
		
	
		return sifContactPerson;
	}
	
	public R1StudentContactRelationship sifToModel(ContactPersonCEDSType sifContactPerson)
	{
		R1StudentContactRelationship r1StudentContactAddress = new R1StudentContactRelationship();
		
		return r1StudentContactAddress;
		
	}
	
	
	
}
