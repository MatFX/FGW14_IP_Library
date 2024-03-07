package eu.matfx.request.json.system.network.wlan;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnableDisableWlan extends AWlan
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
