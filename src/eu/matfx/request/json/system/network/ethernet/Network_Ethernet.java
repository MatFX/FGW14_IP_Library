package eu.matfx.request.json.system.network.ethernet;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import eu.matfx.tools.JSONObject;

@JsonRootName("network") 
public class Network_Ethernet extends JSONObject 
{

	@JsonProperty("ethernet")
	private AEthernet aEthernet;
	
	/**
	 * method to set the different possible settings from the api
	 * @param aEthernet
	 */
	public void setEthernetContent(AEthernet aEthernet)
	{
		this.aEthernet = aEthernet;
	}
}
