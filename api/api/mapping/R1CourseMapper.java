package api.mapping;

//SIF Common

//SIF Course
import sif.dd.us32.model.ObjectFactory;
import sif.dd.us32.model.K12CourseType;

import api.model.R1Course;



public class R1CourseMapper
{
	private ObjectFactory oFac = new ObjectFactory();
	
	//--Course---------------------------------------------------------------//
	public K12CourseType modelToSIF(R1Course r1Course)
	{
		K12CourseType sifCourse = oFac.createK12CourseType();	
		sifCourse.setRefId(r1Course.getCourseRefId());
		sifCourse.setSchoolInfoRefId(r1Course.getSchoolRefId());
		sifCourse.setCourseTitle(r1Course.getTitle());
		sifCourse.setCourseDescription(r1Course.getDescription());
		
		sifCourse.setScedCourseLevel(r1Course.getScedCourseLevelCode());
		sifCourse.setScedCourseSubjectArea(r1Course.getScedCourseSubjectAreaCode());
		
		sifCourse.setCourseApplicableEducationLevel(r1Course.getCourseApplicableEducationLevelCode());

		return sifCourse;
	}
	
	public R1Course sifToModel(K12CourseType sifCourse)
	{
		R1Course r1Course = new R1Course();
		r1Course.setCourseRefId(sifCourse.getRefId());	
		r1Course.setCourseApplicableEducationLevelCode(sifCourse.getCourseApplicableEducationLevel());
		r1Course.setDescription(sifCourse.getCourseDescription());
		r1Course.setScedCourseLevelCode(sifCourse.getScedCourseLevel());
		r1Course.setScedCourseSubjectAreaCode(sifCourse.getScedCourseSubjectArea());
		r1Course.setSchoolRefId(sifCourse.getSchoolInfoRefId());
		r1Course.setTitle(sifCourse.getCourseTitle());
	
		return r1Course;
	}
	

	
	
	
}
