package request.json.system.network;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SetStaticEthernetIP extends AEthernet
{
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

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setSubnetMask(String subnetMask) {
		this.subnetMask = subnetMask;
	}

	public void setStandardGateway(String standardGateway) {
		this.standardGateway = standardGateway;
	}

	public void setDnsMain(String dnsMain) {
		this.dnsMain = dnsMain;
	}

	public void setDnsBackup(String dnsBackup) {
		this.dnsBackup = dnsBackup;
	}

	
}
