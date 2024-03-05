package request.json.system.network.wlan.station;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


public class EnableDisableDhcp extends ASubStation
{
	@JsonProperty("dhcpClient")
	private String dhcpClient;

	public String getDhcpClient() {
		return dhcpClient;
	}

	public void setDhcpClient(String dhcpClient) {
		this.dhcpClient = dhcpClient;
	}

	
	
}
