package eu.matfx.request.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import eu.matfx.request.json.states.Activator;
import eu.matfx.tools.JSONObject;

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
