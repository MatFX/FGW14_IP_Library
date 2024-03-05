package response.system.network.sub;

import com.fasterxml.jackson.annotation.JsonProperty;

import response.AResponseFGW14IP;

public class Wlan extends AResponseFGW14IP 
{
	@JsonProperty("state")
	private String state;
	
	@JsonProperty("mode")
	private String mode;
	
	@JsonProperty("accessPoint")
	private AccessPoint accessPoint;
	
	@JsonProperty("station")
	private Station station;

	public String getState() {
		return state;
	}

	public String getMode() {
		return mode;
	}

	public AccessPoint getAccessPoint() {
		return accessPoint;
	}

	public Station getStation() {
		return station;
	}

}
