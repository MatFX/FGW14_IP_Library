package eu.matfx.request.json.system.network.ethernet;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


public class EnableDisableEthernet extends AEthernet
{
	@JsonProperty("state")
	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
	
}
