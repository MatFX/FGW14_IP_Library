package request.json.system.network.wlan;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import tools.JSONObject;

@JsonRootName("network") 
public class Network_Wlan extends JSONObject 
{

	@JsonProperty("wlan")
	private AWlan aWlan;
	
	/**
	 * method to set the different possible settings from the api
	 * @param aWlan
	 */
	public void setWlanContent(AWlan aWlan)
	{
		this.aWlan = aWlan;
	}
}
