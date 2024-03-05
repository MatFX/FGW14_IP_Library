package request.json.system.network;

import com.fasterxml.jackson.annotation.JsonProperty;

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
