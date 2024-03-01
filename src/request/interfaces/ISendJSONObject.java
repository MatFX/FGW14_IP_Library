package request.interfaces;

import tools.JSONObject;

/**
 * All request object with json body need this interface
 * @author m.goerlich
 *
 */
public interface ISendJSONObject 
{
	
	public JSONObject getRequestBody();

}
