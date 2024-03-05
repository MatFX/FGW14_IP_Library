package request.json.system.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("network") 
public class Network {

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
