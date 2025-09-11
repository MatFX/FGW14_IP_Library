package eu.matfx.response;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import eu.matfx.tools.JSONObject;

/**
 * 
 * @author m.goerlich
 *
 */
public abstract class AResponseFGW14IP extends JSONObject
{

	
	
	/**
	 * Convert the JSON String to the corresponding class/object
	 * @param jsonString
	 * @param responseClass
	 * @return the object from the json string
	 */
	public static <T extends AResponseFGW14IP> T getObjectFromJSONString(String jsonString, Class<T> responseClass)
	{
		return getObjectFromJSONString(jsonString, responseClass, true);
	}

	public static <T extends AResponseFGW14IP> T getObjectFromJSONString(String jsonString, Class<T> responseClass, boolean isUnwrapRootValue)
	{
		
		ObjectMapper objectMapper = new ObjectMapper();
		//most cases the feature must be used
		if(isUnwrapRootValue)
			objectMapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
		
		try 
		{
		
			return objectMapper.readValue(jsonString, responseClass);
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		
		return null;
	}
	
	
	
	
	@Override
	public String toString() 
	{
		return ReflectionToStringBuilder.toString(this);
	}

}
