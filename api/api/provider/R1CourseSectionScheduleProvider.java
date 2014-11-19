package api.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import sif.dd.us32.conversion.DataModelMarshalFactory;
import sif.dd.us32.conversion.DataModelUnmarshalFactory;
import sif.dd.us32.model.K12CourseCollectionType;
import sif.dd.us32.model.K12CourseType;
import sif.dd.us32.model.ObjectFactory;
import sif3.common.conversion.MarshalFactory;
import sif3.common.conversion.ModelObjectInfo;
import sif3.common.conversion.UnmarshalFactory;
import sif3.common.exception.PersistenceException;
import sif3.common.exception.UnsupportedQueryException;
import sif3.common.model.PagingInfo;
import sif3.common.model.RequestMetadata;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.infra.rest.provider.BaseProvider;

import api.common.ModelObjectConstants;
import api.mapping.R1CourseSectionScheduleMapper;
import api.model.R1CourseSectionSchedule;
import api.service.R1CourseSectionScheduleService;

public class R1CourseSectionScheduleProvider extends BaseProvider 
{
	private ObjectFactory oFac = new ObjectFactory();
	private R1CourseSectionScheduleService CourseSectionScheduleService = new R1CourseSectionScheduleService(); 
	private R1CourseSectionScheduleMapper mapper = new R1CourseSectionScheduleMapper();
	private static DataModelUnmarshalFactory unmarshaller = new DataModelUnmarshalFactory();
	private static DataModelMarshalFactory marshaller = new DataModelMarshalFactory();

	@Override
	public Object retrieve(SIFZone zone, SIFContext context,PagingInfo pagingInfo, RequestMetadata metadata) throws PersistenceException, UnsupportedQueryException, IllegalArgumentException 
	{
		Collection<R1CourseSectionSchedule> r1CourseSectionSchedules = CourseSectionScheduleService.getCourseSectionSchedules(zone,context, pagingInfo);
		Collection<K12CourseType> sifCourseSectionSchedules = new ArrayList<K12CourseType>();

		for (R1CourseSectionSchedule r1CourseSectionSchedule : r1CourseSectionSchedules) 
		{
			sifCourseSectionSchedules.add(mapper.modelToSIF(r1CourseSectionSchedule));
		}

		K12CourseCollectionType sifCourseSectionScheduleCollection = oFac.createK12CourseCollectionType();
		sifCourseSectionScheduleCollection.getK12Course().addAll(sifCourseSectionSchedules);

		return sifCourseSectionScheduleCollection;
	}

	@Override
	public Object retrievByPrimaryKey(String resourceID, SIFZone zone,SIFContext context, RequestMetadata metadata) throws PersistenceException, IllegalArgumentException 
	{
		R1CourseSectionSchedule r1CourseSectionSchedule = CourseSectionScheduleService.getCourseSectionSchedule(resourceID, zone, context);

		if (r1CourseSectionSchedule == null) 
		{
			return null;
		}

		K12CourseType sifCourseSectionSchedule = mapper.modelToSIF(r1CourseSectionSchedule);
		return sifCourseSectionSchedule;
	}

	@Override
	public MarshalFactory getMarshaller() 
	{
		return marshaller;
	}

	@Override
	public UnmarshalFactory getUnmarshaller() 
	{
		return unmarshaller;
	}

	@Override
	public ModelObjectInfo getSingleObjectClassInfo() 
	{
		return ModelObjectConstants.c_CourseSectionSchedule;
	}

	@Override
	public ModelObjectInfo getMultiObjectClassInfo() 
	{
		return ModelObjectConstants.c_CourseSectionSchedules;
	}

	// Not Implemented Yet
	@Override
	public List<CreateOperationStatus> createMany(Object arg0, boolean arg1, SIFZone arg2, SIFContext arg3, RequestMetadata arg4)throws IllegalArgumentException,sif3.common.exception.PersistenceException 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object createSingle(Object arg0, boolean arg1, SIFZone arg2, SIFContext arg3, RequestMetadata arg4)throws IllegalArgumentException,sif3.common.exception.PersistenceException 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OperationStatus> deleteMany(List<String> arg0, SIFZone arg1, SIFContext arg2, RequestMetadata arg3) throws IllegalArgumentException,sif3.common.exception.PersistenceException 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteSingle(String arg0, SIFZone arg1, SIFContext arg2,RequestMetadata arg3) throws IllegalArgumentException,sif3.common.exception.PersistenceException 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<OperationStatus> updateMany(Object arg0, SIFZone arg1,SIFContext arg2, RequestMetadata arg3) throws IllegalArgumentException,sif3.common.exception.PersistenceException 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateSingle(Object arg0, String arg1, SIFZone arg2, SIFContext arg3, RequestMetadata arg4) throws IllegalArgumentException,sif3.common.exception.PersistenceException 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void shutdown() 
	{
		// TODO Auto-generated method stub

	}
}
