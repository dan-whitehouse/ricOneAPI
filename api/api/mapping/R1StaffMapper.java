package api.mapping;

//SIF Common



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import sif.dd.us32.model.ObjectFactory;
import sif.dd.us32.model.K12StaffType;
import sif.dd.us32.model.K12StaffType.Demographic;
import sif.dd.us32.model.K12StaffType.Identity;
import sif.dd.us32.model.K12StaffType.Identity.Name;
import api.model.R1Staff;


public class R1StaffMapper
{
	private ObjectFactory oFac = new ObjectFactory();
	
	
	//--Staff---------------------------------------------------------------//
		public K12StaffType modelToSIF(R1Staff r1Staff)
		{
			K12StaffType sifStaff = oFac.createK12StaffType();		
			Identity sifIdentity = oFac.createK12StaffTypeIdentity();
			Demographic sifDemographic = oFac.createK12StaffTypeDemographic();
						
			//Identity
			Name name = new Name();
			name.setFirstName(r1Staff.getFirstName());
			name.setMiddleName(r1Staff.getMiddleName());
			name.setLastName(r1Staff.getLastName());
			name.setPrefix(r1Staff.getPrefix());
			sifIdentity.setName(name);
			
			//Demographics
			sifDemographic.setSex(r1Staff.getSexCode());
			
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			try
			{
				r1Staff.setBirthdate(format.parse(sifStaff.getDemographic().getBirthdate()));
			} 
			catch (ParseException e)
			{
				System.out.println("R1StudentMapper: failed to format date of: birthdate");
				e.printStackTrace();
			}
			
			if(sifStaff.getDemographic().getHispanicOrLatinoEthnicity().equalsIgnoreCase("Yes"))
			{
				r1Staff.setHispanicLatinoEthnicity(true);
			}
			else
			{
				r1Staff.setHispanicLatinoEthnicity(false);
			}
			
			//Fill Object
			sifStaff.setRefId(r1Staff.getStaffRefId());
			sifStaff.setIdentity(sifIdentity);
			sifStaff.setDemographic(sifDemographic);
			
			return sifStaff;
		}
		
		public R1Staff sifToModel(K12StaffType sifStaff)
		{
			R1Staff r1Staff = new R1Staff();
			r1Staff.setStaffRefId(sifStaff.getRefId());
			return r1Staff;
		}
	

}
