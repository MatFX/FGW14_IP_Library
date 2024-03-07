package eu.matfx.response.system.network;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import eu.matfx.response.AResponseFGW14IP;
import eu.matfx.response.system.network.sub.Ethernet;
import eu.matfx.response.system.network.sub.Wlan;

@JsonRootName("network") 
public class ReadNetworkResponse extends AResponseFGW14IP 
{
	@JsonProperty("ethernet")
	private Ethernet ethernet;
	
	@JsonProperty("wlan")
	private Wlan wlan;
	
	@Override
	public String toString() 
	{
		return ReflectionToStringBuilder.toString(this);
	}

}
