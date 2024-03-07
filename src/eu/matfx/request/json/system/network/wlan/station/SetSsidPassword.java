package eu.matfx.request.json.system.network.wlan.station;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SetSsidPassword extends ASubStation
{
	
	@JsonProperty("ssid")
	private String ssid;
	
	@JsonProperty("password")
	private String password;

	public String getSsid() {
		return ssid;
	}

	public String getPassword() {
		return password;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
