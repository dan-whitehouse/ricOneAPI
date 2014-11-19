package api.mapping;

//SIF Common

//SIF Course
import sif.dd.us32.model.K12SectionType;
import sif.dd.us32.model.K12SectionType.Course;
import sif.dd.us32.model.K12SectionType.Directory;
import sif.dd.us32.model.ObjectFactory;
import sif.dd.us32.model.K12CourseType;
import api.model.R1CourseSectionSchedule;



public class R1CourseSectionScheduleMapper
{
	private ObjectFactory oFac = new ObjectFactory();
	
	//--Course---------------------------------------------------------------//
	public K12CourseType modelToSIF(R1CourseSectionSchedule r1CourseSectionSchedule)
	{
		K12CourseType sifCourse = oFac.createK12CourseType();
		/*K12SectionType sifSection = oFac.createK12SectionType();
		Course sifCourse = oFac.createK12SectionTypeCourse();
		//Directory sifDirectory = oFac.createK12SectionTypeDirectory();
		
		//sifDirectory.set
		sifCourse.setCourseIdentifier(r1CourseSection.getCourseRefId());
		sifSection.setRefId(r1CourseSection.getCourseSectionRefId());
		//sifSection.setDirectory(sifDirectory);
		sifSection.setCourse(sifCourse);*/
		
		
		return sifCourse;
	}
	
	public R1CourseSectionSchedule sifToModel(K12CourseType sifCourseIdentifier)
	{
		R1CourseSectionSchedule r1CourseSectionSchedule= new R1CourseSectionSchedule();
		
	
		return r1CourseSectionSchedule;
	}
	

	
	
	
}
