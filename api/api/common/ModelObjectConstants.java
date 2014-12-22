package api.common;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import sif.dd.us32.model.ContactPersonCEDSCollectionType;
import sif.dd.us32.model.ContactPersonCEDSType;
import sif.dd.us32.model.K12CourseCollectionType;
import sif.dd.us32.model.K12CourseType;
import sif.dd.us32.model.K12SchoolCollectionType;
import sif.dd.us32.model.K12SchoolType;
import sif.dd.us32.model.K12SectionCollectionType;
import sif.dd.us32.model.K12SectionType;
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

	public static final ModelObjectInfo c_StudentContacts = new ModelObjectInfo("k12StudentContacts", ContactPersonCEDSCollectionType.class);
	public static final ModelObjectInfo c_StudentContact = new ModelObjectInfo("k12StudentContact", ContactPersonCEDSType.class);
	
	public static final ModelObjectInfo c_StudentHealths = new ModelObjectInfo("k12StudentHealths", K12StudentCollectionType.class);
	public static final ModelObjectInfo c_StudentHealth = new ModelObjectInfo("k12StudentHealth", K12StudentType.class);
	
	/**********************************************STAFF STUFF**********************************************/
	public static final ModelObjectInfo c_Staffs = new ModelObjectInfo("k12Staffs", K12StaffCollectionType.class);
	public static final ModelObjectInfo c_Staff = new ModelObjectInfo("k12Staff", K12StaffType.class);
	
		
	/**********************************************SCHOOL STUFF**********************************************/
	public static final ModelObjectInfo c_LEAs = new ModelObjectInfo("leas", LeaCEDSCollectionType.class);
	public static final ModelObjectInfo c_LEA = new ModelObjectInfo("lea", LeaCEDSType.class);
	
	public static final ModelObjectInfo c_Schools = new ModelObjectInfo("k12Schools", K12SchoolCollectionType.class);
	public static final ModelObjectInfo c_School = new ModelObjectInfo("k12School", K12SchoolType.class);
	
	public static final ModelObjectInfo c_SchoolCalendars = new ModelObjectInfo("k12SchoolCalendars", K12SchoolCollectionType.class);
	public static final ModelObjectInfo c_SchoolCalendar = new ModelObjectInfo("k12SchoolCalendar", K12SchoolType.class);
	
	
	/**********************************************COURSE STUFF**********************************************/	
	public static final ModelObjectInfo c_Courses = new ModelObjectInfo("k12Courses", K12CourseCollectionType.class);
	public static final ModelObjectInfo c_Course = new ModelObjectInfo("k12Course", K12CourseType.class);
	
	public static final ModelObjectInfo c_CourseSections = new ModelObjectInfo("k12Rosters", K12SectionCollectionType.class);
	public static final ModelObjectInfo c_CourseSection = new ModelObjectInfo("k12Roster", K12SectionType.class);
	
	/**********************************************MISC STUFF**********************************************/	
	public static final ModelObjectInfo c_CSVs= new ModelObjectInfo("csvs", null);
	public static final ModelObjectInfo c_CSV = new ModelObjectInfo("csv", null);
	




}
