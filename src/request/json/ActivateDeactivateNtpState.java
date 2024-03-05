package request.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import request.json.states.Activator;
import tools.JSONObject;

@JsonRootName("time") 
public class ActivateDeactivateNtpState extends JSONObject 
{
	
	@JsonProperty("ntpState")
	private String ntpState ="";
	
	public void setNtpState(Activator enumToSet)
	{
		ntpState = enumToSet.getValueToSet();
	}

	
	
}
