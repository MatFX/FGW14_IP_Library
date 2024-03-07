package eu.matfx.response.system.network.sub;

import com.fasterxml.jackson.annotation.JsonProperty;

import eu.matfx.response.AResponseFGW14IP;

public class Station extends AResponseFGW14IP 
{
	
	@JsonProperty("ssid")
	private String ssid;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("dhcpClient")
	private String dhcpClient;
	
	@JsonProperty("ip")
	private String ip;
	
	@JsonProperty("subnetMask")
	private String subnetMask;
	
	@JsonProperty("standardGateway")
	private String standardGateway;
	
	@JsonProperty("dnsMain")
	private String dnsMain;
	
	@JsonProperty("dnsBackup")
	private String dnsBackup;

	public String getSsid() {
		return ssid;
	}

	public String getPassword() {
		return password;
	}

	public String getDhcpClient() {
		return dhcpClient;
	}

	public String getIp() {
		return ip;
	}

	public String getSubnetMask() {
		return subnetMask;
	}

	public String getStandardGateway() {
		return standardGateway;
	}

	public String getDnsMain() {
		return dnsMain;
	}

	public String getDnsBackup() {
		return dnsBackup;
	}
	
	
	
	

}
