package api.mapping.sif32;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import sif.dd.us32.model.K12SectionType;
import sif.dd.us32.model.K12SectionType.Course;
import sif.dd.us32.model.K12StaffType.Employment;
import sif.dd.us32.model.K12StaffType.Identity.Identification;
import sif.dd.us32.model.K12StaffType.Identity;
import sif.dd.us32.model.K12StaffType.Assignment;
import sif.dd.us32.model.ObjectFactory;
import sif.dd.us32.model.K12StaffType;
import sif.dd.us32.model.K12StaffType.Demographic;
import sif.dd.us32.model.K12StaffType.Identity;
import sif.dd.us32.model.K12StaffType.Identity.Name;
import sif.dd.us32.model.K12StaffType.Contact;
import sif.dd.us32.model.K12StaffType.Contact.EmailList;
import sif.dd.us32.model.K12StaffType.Contact.EmailList.Email;
import api.model.R1Staff;
import api.model.R1StaffCourseSection;
import api.model.R1StaffEmail;
import api.model.R1StaffAssignment;
import api.model.R1StaffIdentifier;


public class R1StaffMapper
{
	private ObjectFactory oFac = new ObjectFactory();
	private DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	
	//--Staff---------------------------------------------------------------//
		public K12StaffType modelToSIF(R1Staff r1Staff)
		{
			K12StaffType sifStaff = oFac.createK12StaffType();		
			Identity sifIdentity = oFac.createK12StaffTypeIdentity();
			Demographic sifDemographic = oFac.createK12StaffTypeDemographic();
			Contact sifContact = oFac.createK12StaffTypeContact();
			EmailList sifEmailList = oFac.createK12StaffTypeContactEmailList();
						
			//Identity
			Name name = new Name();
			name.setFirstName(r1Staff.getFirstName());
			name.setMiddleName(r1Staff.getMiddleName());
			name.setLastName(r1Staff.getLastName());
			name.setPrefix(r1Staff.getPrefix());
			name.setSuffix(r1Staff.getGenerationCode());
			sifIdentity.setName(name);
			
			//Demographics
			sifDemographic.setSex(r1Staff.getSexCode());
			
			//Error for these
			if(sifStaff.getDemographic() != null)
			{
				if(sifStaff.getDemographic().getHispanicOrLatinoEthnicity().equalsIgnoreCase("Yes"))
				{
					r1Staff.setHispanicLatinoEthnicity(true);
				}
				else
				{
					r1Staff.setHispanicLatinoEthnicity(false);
				}
				
				try
				{
					r1Staff.setBirthdate(format.parse(sifStaff.getDemographic().getBirthdate()));
				} 
				catch (ParseException e)
				{
					System.out.println("R1StudentMapper: failed to format date of: birthdate");
					e.printStackTrace();
				}
			}
			
			
			/********** Email **********/
			for(R1StaffEmail email : r1Staff.getR1StaffEmails())
			{
				Email sifEmail = oFac.createK12StaffTypeContactEmailListEmail();		
				sifEmail.setEmailType(email.getEmailTypeCode());

				sifEmailList.getEmail().add(sifEmail);
			}						
			sifContact.setEmailList(sifEmailList);
			
			
			/********** Assignment **********/
			Assignment sifAssignment = oFac.createK12StaffTypeAssignment();
			for(R1StaffAssignment assignment : r1Staff.getR1StaffAssignments())
			{		
				//sifAssignment.setLeaId(assignment.getR1School().getLeaRefId());
				//sifAssignment.setSchoolId(assignment.getSchoolRefId());
				sifAssignment.setClassroomPositionType(assignment.getPositionTitle());
			}	
			
			
			/********** Course Section **********/
			for(R1StaffCourseSection courseSection : r1Staff.getR1StaffCourseSections())
			{
				K12SectionType sifSection = oFac.createK12SectionType();

				
				//Course sifCourse = oFac.createK12SectionTypeCourse();
				//sifSection.setCourse(sifCourse);
				sifSection.setRefId(courseSection.getStaffCourseSectionRefId());
				
			}
			
			
			
			/********** Identification **********/
			for(R1StaffIdentifier identifier : r1Staff.getR1StaffIdentifiers())
			{
				Identification sifIdentification = oFac.createK12StaffTypeIdentityIdentification();
				sifIdentification.setStaffId(identifier.getStaffId());			
				sifIdentity.setIdentification(sifIdentification);
			}
			
			
			//Fill Object
			
			sifStaff.setRefId(r1Staff.getStaffRefId());
			sifStaff.setIdentity(sifIdentity);
			sifStaff.setDemographic(sifDemographic);
			sifStaff.setContact(sifContact);
			sifStaff.setAssignment(sifAssignment);

			
			
			
			return sifStaff;
		}
		
		public R1Staff sifToModel(K12StaffType sifStaff)
		{
			R1Staff r1Staff = new R1Staff();
			r1Staff.setStaffRefId(sifStaff.getRefId());
			r1Staff.setFirstName(sifStaff.getIdentity().getName().getFirstName());
			r1Staff.setMiddleName(sifStaff.getIdentity().getName().getMiddleName());
			r1Staff.setLastName(sifStaff.getIdentity().getName().getLastName());
			r1Staff.setSexCode(sifStaff.getDemographic().getSex());
			return r1Staff;
		}
	

}
