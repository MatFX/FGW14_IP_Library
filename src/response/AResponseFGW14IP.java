package response;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import tools.JSONObject;

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
		ObjectMapper objectMapper = new ObjectMapper();
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
