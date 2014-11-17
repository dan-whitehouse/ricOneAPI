package api.mapping;

//SIF Common


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
		sifCourse.setCourseTitle(r1Course.getTitle());
		return sifCourse;
	}
	
	public R1Course sifToModel(K12CourseType sifCourse)
	{
		R1Course r1Course = new R1Course();
		r1Course.setCourseRefId(sifCourse.getRefId());		
		
		
		
		return r1Course;
	}
	

	
	
	
}
