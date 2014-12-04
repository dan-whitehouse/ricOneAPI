/*
 * DataModelUnmarshalFactory.java
 * Created: 23/09/2014
 * 
 * Copyright 2014 Systemic Pty Ltd
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package api.common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import sif3.common.conversion.UnmarshalFactory;
import sif3.common.exception.UnmarshalException;
import sif3.common.exception.UnsupportedMediaTypeExcpetion;
import sif3.common.utils.JAXBUtils;

public class DataModelUnmarshalFactory implements UnmarshalFactory
{
	protected final Logger logger = Logger.getLogger(getClass());
	private final static MediaType TEXT_CSV_TYPE = new MediaType("text","csv");


	public Object unmarshalFromCSV(String payload, Class<?> clazz) throws UnmarshalException, UnsupportedMediaTypeExcpetion
	{
		Object result = null;
		try
		{
			String fileName = new SimpleDateFormat("yyyy-MM-dd-HH:mm-ss").format(new Date());
			File file = new File(fileName + ".csv");
			
			if(!file.exists())
			{
				file.createNewFile();
				
				FileWriter fwriter = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bwriter = new BufferedWriter(fwriter);
				bwriter.write(payload);
				bwriter.close();			
			}
					
		}
		catch (Exception e)
		{
			logger.error("An error occurred unmarshalling object from CSV", e);
			throw new UnmarshalException("An error occurred unmarshalling object from CSV", e);
		}
		return result;
	}


	public Object unmarshal(String payload, Class<?> clazz, MediaType mediaType) throws UnmarshalException, UnsupportedMediaTypeExcpetion
	{
		if (mediaType != null)
		{
			if (TEXT_CSV_TYPE.isCompatible(mediaType))
			{
				return unmarshalFromCSV(payload, clazz);
			}

		}

		// If we get here then we deal with an unknown media type
		throw new UnsupportedMediaTypeExcpetion("Unsupported media type: " + mediaType + ". Cannot unmarshal the given input from this media type.");
	}


	@Override
	public Object unmarshalFromJSON(String arg0, Class<?> arg1)
			throws UnmarshalException, UnsupportedMediaTypeExcpetion
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Object unmarshalFromXML(String arg0, Class<?> arg1)
			throws UnmarshalException, UnsupportedMediaTypeExcpetion
	{
		// TODO Auto-generated method stub
		return null;
	}

}
