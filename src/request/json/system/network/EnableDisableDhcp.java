package request.json.system.network;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnableDisableDhcp extends AEthernet
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
