package response.devices;

import com.fasterxml.jackson.annotation.JsonProperty;

import response.AResponseFGW14IP;

public class Devices extends AResponseFGW14IP
{

	@JsonProperty("deviceType") 
	private String deviceType;
	
	@JsonProperty("busAddress") 
	private int busAddress;
	
	@JsonProperty("friendlyId") 
	private String friendlyId;
	
	@JsonProperty("forwardOnMqtt") 
	private boolean forwardOnMqtt;
	
	public String getDeviceType() {
		return deviceType;
	}

	public int getBusAddress() {
		return busAddress;
	}

	public String getFriendlyId() {
		return friendlyId;
	}

	public boolean isForwardOnMqtt() {
		return forwardOnMqtt;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public void setBusAddress(int busAddress) {
		this.busAddress = busAddress;
	}

	public void setFriendlyId(String friendlyId) {
		this.friendlyId = friendlyId;
	}

	public void setForwardOnMqtt(boolean forwardOnMqtt) {
		this.forwardOnMqtt = forwardOnMqtt;
	}
	

}
