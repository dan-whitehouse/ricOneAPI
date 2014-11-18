package api.common;
import sif.dd.us32.model.ContactPersonCEDSCollectionType;
import sif.dd.us32.model.ContactPersonCEDSType;
import sif.dd.us32.model.K12CourseCollectionType;
import sif.dd.us32.model.K12CourseType;
import sif.dd.us32.model.K12SchoolCollectionType;
import sif.dd.us32.model.K12SchoolType;
import sif.dd.us32.model.K12StudentCollectionType;
import sif.dd.us32.model.K12StudentType;
import sif.dd.us32.model.K12StaffCollectionType;
import sif.dd.us32.model.K12StaffType;
import sif.dd.us32.model.LeaCEDSCollectionType;
import sif.dd.us32.model.LeaCEDSType;
import sif3.common.conversion.ModelObjectInfo;

/**
 * @author Joerg Huber
 *
 */

//can you call object name (k12Students) whatever you want?
public class ModelObjectConstants
{
	/**********************************************STUDENT STUFF**********************************************/
	public static final ModelObjectInfo c_Students = new ModelObjectInfo("k12Students", K12StudentCollectionType.class);
	public static final ModelObjectInfo c_Student = new ModelObjectInfo("k12Student", K12StudentType.class);
	
	public static final ModelObjectInfo c_StudentAddresses = new ModelObjectInfo("k12StudentAddresses", K12StudentCollectionType.class);
	public static final ModelObjectInfo c_StudentAddress = new ModelObjectInfo("k12StudentAddress", K12StudentType.class);
	
	public static final ModelObjectInfo c_StudentContacts = new ModelObjectInfo("k12StudentContacts", ContactPersonCEDSCollectionType.class);
	public static final ModelObjectInfo c_StudentContact = new ModelObjectInfo("k12StudentContact", ContactPersonCEDSType.class);
	
	public static final ModelObjectInfo c_StudentContactAddresses = new ModelObjectInfo("k12StudentContactAddresses", ContactPersonCEDSCollectionType.class);
	public static final ModelObjectInfo c_StudentContactAddress = new ModelObjectInfo("k12StudentContactAddress", ContactPersonCEDSType.class);
	
	public static final ModelObjectInfo c_StudentContactEmails = new ModelObjectInfo("k12StudentContactEmails", ContactPersonCEDSCollectionType.class);
	public static final ModelObjectInfo c_StudentContactEmail = new ModelObjectInfo("k12StudentContactEmail", ContactPersonCEDSType.class);
	
	public static final ModelObjectInfo c_StudentContactRelationships = new ModelObjectInfo("k12StudentContactRelationships", ContactPersonCEDSCollectionType.class);
	public static final ModelObjectInfo c_StudentContactRelationship = new ModelObjectInfo("k12StudentContactRelationship", ContactPersonCEDSType.class);
	
	public static final ModelObjectInfo c_StudentContactTelephones = new ModelObjectInfo("k12StudentContactTelephons", ContactPersonCEDSCollectionType.class);
	public static final ModelObjectInfo c_StudentContactTelephone = new ModelObjectInfo("k12StudentContactTelephone", ContactPersonCEDSType.class);
	
	public static final ModelObjectInfo c_StudentCourseSections = new ModelObjectInfo("k12StudentCourseSections", K12StudentCollectionType.class);
	public static final ModelObjectInfo c_StudentCourseSection = new ModelObjectInfo("k12StudentCourseSection", K12StudentType.class);
	
	public static final ModelObjectInfo c_StudentEnrollments = new ModelObjectInfo("k12StudentEnrollments", K12StudentCollectionType.class);
	public static final ModelObjectInfo c_StudentEnrollment = new ModelObjectInfo("k12StudentEnrollment", K12StudentType.class);
	
	
	/**********************************************STAFF STUFF**********************************************/
	public static final ModelObjectInfo c_Staffs = new ModelObjectInfo("k12Staffs", K12StaffCollectionType.class);
	public static final ModelObjectInfo c_Staff = new ModelObjectInfo("k12Staff", K12StaffType.class);
	
		
	/**********************************************SCHOOL STUFF**********************************************/
	public static final ModelObjectInfo c_LEAs = new ModelObjectInfo("leas", LeaCEDSCollectionType.class);
	public static final ModelObjectInfo c_LEA = new ModelObjectInfo("lea", LeaCEDSType.class);
	
	public static final ModelObjectInfo c_Schools = new ModelObjectInfo("k12Schools", K12SchoolCollectionType.class);
	public static final ModelObjectInfo c_School = new ModelObjectInfo("k12School", K12SchoolType.class);
	
	public static final ModelObjectInfo c_SchoolIdentifier = new ModelObjectInfo("k12SchoolIdentifiers", K12SchoolCollectionType.class);
	public static final ModelObjectInfo c_SchoolIdentifiers = new ModelObjectInfo("k12SchoolIdentifier", K12SchoolType.class);
	
	
	/**********************************************COURSE STUFF**********************************************/	
	public static final ModelObjectInfo c_Courses = new ModelObjectInfo("k12Courses", K12CourseCollectionType.class);
	public static final ModelObjectInfo c_Course = new ModelObjectInfo("k12Course", K12CourseType.class);

}
