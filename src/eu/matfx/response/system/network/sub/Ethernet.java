package eu.matfx.response.system.network.sub;

import com.fasterxml.jackson.annotation.JsonProperty;

import eu.matfx.response.AResponseFGW14IP;

public class Ethernet extends AResponseFGW14IP 
{
	@JsonProperty("state")
	private String state;
	
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

	public String getState() {
		return state;
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
