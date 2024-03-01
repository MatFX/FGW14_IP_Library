package response;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import request.json.Login;
import tools.JSONObject;

/**
 * 
 * @author m.goerlich
 *
 */
public abstract class AResponseFGW14IP extends JSONObject
{

	
	
	
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

}
