package api.mapping;

//SIF Common
import sif.dd.us32.model.ObjectFactory;
import sif.dd.us32.model.LeaCEDSType;
import sif.dd.us32.model.LeaCEDSType.Identification;

/*import sif.dd.us32.model.LeaCEDSType.Accountability;
import sif.dd.us32.model.LeaCEDSType.Directory;
import sif.dd.us32.model.LeaCEDSType.FederalFunds;
import sif.dd.us32.model.LeaCEDSType.Finance;
import sif.dd.us32.model.LeaCEDSType.ProgramFederalReporting;
import sif.dd.us32.model.LeaCEDSType.ProgramsServices;*/

import api.model.R1LEA;


public class R1LEAMapper
{
	private ObjectFactory oFac = new ObjectFactory();
	
	
	//--LEA---------------------------------------------------------------//
		public LeaCEDSType modelToSIF(R1LEA r1LEA)
		{
			LeaCEDSType sifLEA = oFac.createLeaCEDSType();		
			Identification sifIdentification = oFac.createLeaCEDSTypeIdentification();
			//Directory sifDirectory = oFac.createLeaCEDSTypeDirectory();
			//FederalFunds sifFederalFunds = oFac.createLeaCEDSTypeFederalFunds();
			//Accountability sifAccountability = oFac.createLeaCEDSTypeAccountability();
			//Finance sifFinance = oFac.createLeaCEDSTypeFinance();
			//ProgramFederalReporting sifProgramFederalReporting = oFac.createLeaCEDSTypeProgramFederalReporting();
			//ProgramsServices sifProgramsServices = oFac.createLeaCEDSTypeProgramsServices();
			
			//Identification
			sifIdentification.setLeaId(r1LEA.getLeaId());
			sifIdentification.setName(r1LEA.getLeaName());
			
			//Fill Object
			sifLEA.setRefId(r1LEA.getLeaId());			
			sifLEA.setIdentification(sifIdentification);
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
