package api.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import sif.dd.us32.conversion.DataModelMarshalFactory;
import sif.dd.us32.conversion.DataModelUnmarshalFactory;
import sif.dd.us32.model.ContactPersonCEDSCollectionType;
import sif.dd.us32.model.ContactPersonCEDSType;
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
import api.mapping.R1StudentContactTelephoneMapper;
import api.model.R1StudentContactTelephone;
import api.service.R1StudentContactTelephoneService;

public class R1StudentContactTelephoneProvider extends BaseProvider 
{
	private ObjectFactory oFac = new ObjectFactory();
	private R1StudentContactTelephoneService studentContactTelephoneService = new R1StudentContactTelephoneService(); 
	private R1StudentContactTelephoneMapper mapper = new R1StudentContactTelephoneMapper();
	private static DataModelUnmarshalFactory unmarshaller = new DataModelUnmarshalFactory();
	private static DataModelMarshalFactory marshaller = new DataModelMarshalFactory();

	@Override
	public Object retrieve(SIFZone zone, SIFContext context,PagingInfo pagingInfo, RequestMetadata metadata) throws PersistenceException, UnsupportedQueryException, IllegalArgumentException 
	{
		Collection<R1StudentContactTelephone> r1StudentContactTelephonees = studentContactTelephoneService.getStudentContactTelephones(zone,context, pagingInfo);
		Collection<ContactPersonCEDSType> sifStudentContactTelephonees = new ArrayList<ContactPersonCEDSType>();

		for (R1StudentContactTelephone r1StudentContactTelephone : r1StudentContactTelephonees) 
		{
			sifStudentContactTelephonees.add(mapper.modelToSIF(r1StudentContactTelephone));
		}

		ContactPersonCEDSCollectionType sifStudentContactTelephoneCollection = oFac.createContactPersonCEDSCollectionType();
		sifStudentContactTelephoneCollection.getContactPersonCEDS().addAll(sifStudentContactTelephonees);

		return sifStudentContactTelephoneCollection;
	}

	@Override
	public Object retrievByPrimaryKey(String resourceID, SIFZone zone,SIFContext context, RequestMetadata metadata) throws PersistenceException, IllegalArgumentException 
	{
		R1StudentContactTelephone r1StudentContactTelephone = studentContactTelephoneService.getStudentContactTelephone(resourceID, zone, context);

		if (r1StudentContactTelephone == null) 
		{
			return null;
		}

		ContactPersonCEDSType sifStudentContactTelephone = mapper.modelToSIF(r1StudentContactTelephone);
		return sifStudentContactTelephone;
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
		return ModelObjectConstants.c_StudentContactTelephone;
	}

	@Override
	public ModelObjectInfo getMultiObjectClassInfo() 
	{
		return ModelObjectConstants.c_StudentContactTelephones;
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
