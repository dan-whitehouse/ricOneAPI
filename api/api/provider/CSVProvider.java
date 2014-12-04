package api.provider;


import java.util.List;

import api.common.DataModelUnmarshalFactory;
import api.common.ModelObjectConstants;
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


public class CSVProvider extends BaseProvider 
{

	private static DataModelUnmarshalFactory unmarshaller = new DataModelUnmarshalFactory();

	

	@Override
	public MarshalFactory getMarshaller() 
	{
		return null;
	}

	@Override
	public UnmarshalFactory getUnmarshaller() 
	{
		return unmarshaller;
	}

	@Override
	public ModelObjectInfo getSingleObjectClassInfo() 
	{
		return ModelObjectConstants.c_CSV;
	}

	@Override
	public ModelObjectInfo getMultiObjectClassInfo() 
	{
		return ModelObjectConstants.c_CSVs;
	}

	// Not Implemented Yet
	@Override
	public List<CreateOperationStatus> createMany(Object arg0, boolean arg1, SIFZone arg2, SIFContext arg3, RequestMetadata arg4)throws IllegalArgumentException,sif3.common.exception.PersistenceException 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object createSingle(Object data, boolean useAdvisory, SIFZone zone, SIFContext context, RequestMetadata meta)throws IllegalArgumentException,sif3.common.exception.PersistenceException 
	{
		if (data instanceof String)
    	{
    		String csv = null;
    		if (data != null)
    		{
    			csv = (String)data;
    			
    		}
    		return csv;
    	}
    	else
    	{
    		throw new IllegalArgumentException("Expected Object Type  = CSV. Received Object Type = "+data.getClass().getSimpleName());
    	}
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

	@Override
	public Object retrievByPrimaryKey(String arg0, SIFZone arg1,
			SIFContext arg2, RequestMetadata arg3)
			throws IllegalArgumentException, PersistenceException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object retrieve(SIFZone arg0, SIFContext arg1, PagingInfo arg2,
			RequestMetadata arg3) throws PersistenceException,
			UnsupportedQueryException
	{
		// TODO Auto-generated method stub
		return null;
	}
}
