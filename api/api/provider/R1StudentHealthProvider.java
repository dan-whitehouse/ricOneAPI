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
import api.mapping.sif32.R1StudentHealthMapper;
import api.model.R1StudentHealth;
import api.service.R1StudentHealthService;

public class R1StudentHealthProvider extends BaseProvider 
{
	private ObjectFactory oFac = new ObjectFactory();
	private R1StudentHealthService studentHealthService = new R1StudentHealthService(); 
	private R1StudentHealthMapper mapper = new R1StudentHealthMapper();
	private static DataModelUnmarshalFactory unmarshaller = new DataModelUnmarshalFactory();
	private static DataModelMarshalFactory marshaller = new DataModelMarshalFactory();

	@Override
	public Object retrieve(SIFZone zone, SIFContext context,PagingInfo pagingInfo, RequestMetadata metadata) throws PersistenceException, UnsupportedQueryException, IllegalArgumentException 
	{
		Collection<R1StudentHealth> r1StudentHealths = studentHealthService.getStudentHealths(zone,context, pagingInfo);
		Collection<K12StudentType> sifStudentHealths = new ArrayList<K12StudentType>();

		for (R1StudentHealth r1StudentHealth : r1StudentHealths) 
		{
			sifStudentHealths.add(mapper.modelToSIF(r1StudentHealth));
		}

		K12StudentCollectionType sifStudentHealthCollection = oFac.createK12StudentCollectionType();
		sifStudentHealthCollection.getK12Student().addAll(sifStudentHealths);

		return sifStudentHealthCollection;
	}

	@Override
	public Object retrievByPrimaryKey(String resourceID, SIFZone zone,SIFContext context, RequestMetadata metadata) throws PersistenceException, IllegalArgumentException 
	{
		R1StudentHealth r1StudentHealth = studentHealthService.getStudentHealth(resourceID, zone, context);

		if (r1StudentHealth == null) 
		{
			return null;
		}

		K12StudentType sifStudentHealth = mapper.modelToSIF(r1StudentHealth);
		return sifStudentHealth;
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
		return ModelObjectConstants.c_StudentHealth;
	}

	@Override
	public ModelObjectInfo getMultiObjectClassInfo() 
	{
		return ModelObjectConstants.c_StudentHealths;
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
	public boolean deleteSingle(String refId, SIFZone zone, SIFContext context,RequestMetadata meta) throws IllegalArgumentException,sif3.common.exception.PersistenceException 
	{
		boolean isDeleted = studentHealthService.deleteStudentHealth(refId, zone, context);
		return isDeleted;
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
