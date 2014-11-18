package api.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import sif.dd.us32.conversion.DataModelMarshalFactory;
import sif.dd.us32.conversion.DataModelUnmarshalFactory;
import sif.dd.us32.model.K12StudentCollectionType;
import sif.dd.us32.model.K12StudentType;
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
import api.mapping.R1StudentEnrollmentMapper;
import api.model.R1StudentEnrollment;
import api.service.R1StudentEnrollmentService;

public class R1StudentEnrollmentProvider extends BaseProvider 
{
	private ObjectFactory oFac = new ObjectFactory();
	private R1StudentEnrollmentService studentEnrollmentService = new R1StudentEnrollmentService(); 
	private R1StudentEnrollmentMapper mapper = new R1StudentEnrollmentMapper();
	private static DataModelUnmarshalFactory unmarshaller = new DataModelUnmarshalFactory();
	private static DataModelMarshalFactory marshaller = new DataModelMarshalFactory();

	@Override
	public Object retrieve(SIFZone zone, SIFContext context,PagingInfo pagingInfo, RequestMetadata metadata) throws PersistenceException, UnsupportedQueryException, IllegalArgumentException 
	{
		Collection<R1StudentEnrollment> r1StudentEnrollments = studentEnrollmentService.getStudentEnrollments(zone,context, pagingInfo);
		Collection<K12StudentType> sifStudentEnrollments = new ArrayList<K12StudentType>();

		for (R1StudentEnrollment r1StudentEnrollment : r1StudentEnrollments) 
		{
			sifStudentEnrollments.add(mapper.modelToSIF(r1StudentEnrollment));
		}

		K12StudentCollectionType sifStudentEnrollmentCollection = oFac.createK12StudentCollectionType();
		sifStudentEnrollmentCollection.getK12Student().addAll(sifStudentEnrollments);

		return sifStudentEnrollmentCollection;
	}

	@Override
	public Object retrievByPrimaryKey(String resourceID, SIFZone zone,SIFContext context, RequestMetadata metadata) throws PersistenceException, IllegalArgumentException 
	{
		R1StudentEnrollment r1StudentEnrollment = studentEnrollmentService.getStudentEnrollment(resourceID, zone, context);

		if (r1StudentEnrollment == null) 
		{
			return null;
		}

		K12StudentType sifStudentEnrollment = mapper.modelToSIF(r1StudentEnrollment);
		return sifStudentEnrollment;
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
		return ModelObjectConstants.c_StudentEnrollment;
	}

	@Override
	public ModelObjectInfo getMultiObjectClassInfo() 
	{
		return ModelObjectConstants.c_StudentEnrollments;
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
