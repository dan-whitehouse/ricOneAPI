/*
 * ModelObjectConstants.java
 * Created: 30/09/2014
 *
 * Copyright 2014 Systemic Pty Ltd
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License 
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */

package api.common;
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
	
	public static final ModelObjectInfo c_StudentContacts = new ModelObjectInfo("k12StudentContacts", K12StudentCollectionType.class);
	public static final ModelObjectInfo c_StudentContact = new ModelObjectInfo("k12StudentContact", K12StudentType.class);
	
	public static final ModelObjectInfo c_StudentContactAddresses = new ModelObjectInfo("k12StudentContactAddresses", K12StudentCollectionType.class);
	public static final ModelObjectInfo c_StudentContactAddress = new ModelObjectInfo("k12StudentContactAddress", K12StudentType.class);
	
	public static final ModelObjectInfo c_StudentContactEmails = new ModelObjectInfo("k12StudentContactEmails", K12StudentCollectionType.class);
	public static final ModelObjectInfo c_StudentContactEmail = new ModelObjectInfo("k12StudentContactEmail", K12StudentType.class);
	
	public static final ModelObjectInfo c_StudentContactRelationships = new ModelObjectInfo("k12StudentContactRelationships", K12StudentCollectionType.class);
	public static final ModelObjectInfo c_StudentContactRelationship = new ModelObjectInfo("k12StudentContactRelationship", K12StudentType.class);
	
	public static final ModelObjectInfo c_StudentContactTelephones = new ModelObjectInfo("k12StudentContactTelephons", K12StudentCollectionType.class);
	public static final ModelObjectInfo c_StudentContactTelephone = new ModelObjectInfo("k12StudentContactTelephone", K12StudentType.class);
	
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
