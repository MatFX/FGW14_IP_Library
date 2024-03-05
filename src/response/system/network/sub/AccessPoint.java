package response.system.network.sub;

import com.fasterxml.jackson.annotation.JsonProperty;

import response.AResponseFGW14IP;

public class AccessPoint extends AResponseFGW14IP 
{
	@JsonProperty("ssid")
	private String ssid;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("ip")
	private String ip;
	
	@JsonProperty("subnetMask")
	private String subnetMask;
	
	@JsonProperty("dhcpStartAddress")
	private String dhcpStartAddress;
	
	@JsonProperty("dhcpEndAddress")
	private String dhcpEndAddress;

	public String getSsid() {
		return ssid;
	}

	public String getPassword() {
		return password;
	}

	public String getIp() {
		return ip;
	}

	public String getSubnetMask() {
		return subnetMask;
	}

	public String getDhcpStartAddress() {
		return dhcpStartAddress;
	}

	public String getDhcpEndAddress() {
		return dhcpEndAddress;
	}
	
	

}
