package api.mapping;

//SIF Common

//SIF Course
import sif.dd.us32.model.K12SectionType;
import sif.dd.us32.model.K12SectionType.Course;
import sif.dd.us32.model.K12SectionType.Directory;
import sif.dd.us32.model.ObjectFactory;
import sif.dd.us32.model.K12CourseType;
import api.model.R1Course;
import api.model.R1CourseSection;



public class R1CourseSectionMapper
{
	private ObjectFactory oFac = new ObjectFactory();
	
	//--Course---------------------------------------------------------------//
	public K12CourseType modelToSIF(R1CourseSection r1CourseSection)
	{
		K12CourseType sifSection = oFac.createK12CourseType();
		//K12SectionType sifSection = oFac.createK12SectionType();
		//Course sifCourse = oFac.createK12SectionTypeCourse();
		//Directory sifDirectory = oFac.createK12SectionTypeDirectory();
		
		
		
		
		//sifDirectory.setclass
		
		//sifSection.setDirectory(sifDirectory);
		//sifSection.setEnrollment(Enrollment);
		//sifSection.setCourse(sifCourse);
		//sifSection.setRefId(r1CourseSection.getCourseSectionRefId());
				
		return sifSection;
	}
	
	public R1CourseSection sifToModel(K12CourseType sifCourseIdentifier)
	{
		R1CourseSection r1CourseIdentifier = new R1CourseSection();
		
	
		return r1CourseIdentifier;
	}
	

	
	
	
}