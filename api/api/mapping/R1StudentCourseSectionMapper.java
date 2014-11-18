package api.mapping;

import sif.dd.us32.model.K12StudentType.CourseList;
import sif.dd.us32.model.K12StudentType.CourseList.Course;
import sif.dd.us32.model.ObjectFactory;
import sif.dd.us32.model.K12StudentType;
import api.model.R1StudentCourseSection;



public class R1StudentCourseSectionMapper
{
	private ObjectFactory oFac = new ObjectFactory();
	
	//--Student---------------------------------------------------------------//
	public K12StudentType modelToSIF(R1StudentCourseSection r1StudentCourseSection)
	{
		K12StudentType sifStudent = oFac.createK12StudentType();
		CourseList sifCourseList = oFac.createK12StudentTypeCourseList();
		Course sifCourse = oFac.createK12StudentTypeCourseListCourse();
		
		
		sifCourse.setGradeLevelWhenCourseTaken(r1StudentCourseSection.getGradeLevelWhenCourseTakenCode());	
		sifCourseList.getCourse().add(sifCourse);
		sifStudent.setCourseList(sifCourseList);
		sifStudent.setRefId(r1StudentCourseSection.getStudentRefId());
		

		return sifStudent;
	}
	
	public R1StudentCourseSection sifToModel(K12StudentType sifStudent)
	{
		R1StudentCourseSection r1StudentCourseSection = new R1StudentCourseSection();
		r1StudentCourseSection.setStudentRefId(sifStudent.getRefId());		
		
	
		
		return r1StudentCourseSection;
	}
	

	
	
	
}
