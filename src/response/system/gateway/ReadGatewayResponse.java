package response.system.gateway;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import response.AResponseFGW14IP;

@JsonRootName("gateway") 
public class ReadGatewayResponse extends AResponseFGW14IP 
{
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("version")
	private String version;
	
	/* 9B4C9465-D4B8-4460-B4A9-B3F2AF21977A */
	@JsonProperty("serialNumber")
	private String serialNumber;

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public String getVersion() {
		return version;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

}
