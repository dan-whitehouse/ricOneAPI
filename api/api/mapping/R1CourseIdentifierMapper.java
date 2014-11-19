package api.mapping;

//SIF Common

//SIF Course
import sif.dd.us32.model.ObjectFactory;
import sif.dd.us32.model.K12CourseType;
import api.model.R1Course;
import api.model.R1CourseIdentifier;



public class R1CourseIdentifierMapper
{
	private ObjectFactory oFac = new ObjectFactory();
	
	//--Course---------------------------------------------------------------//
	public K12CourseType modelToSIF(R1CourseIdentifier r1CourseIdentifier)
	{
		K12CourseType sifCourse = oFac.createK12CourseType();	
		
		sifCourse.setRefId(r1CourseIdentifier.getCourseRefId());
		sifCourse.setCourseIdentifier(r1CourseIdentifier.getCourseId());
		return sifCourse;
	}
	
	public R1CourseIdentifier sifToModel(K12CourseType sifCourseIdentifier)
	{
		R1CourseIdentifier r1CourseIdentifier = new R1CourseIdentifier();
		
	
		return r1CourseIdentifier;
	}
	

	
	
	
}
