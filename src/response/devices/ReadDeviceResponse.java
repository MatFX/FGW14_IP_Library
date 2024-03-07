package response.devices;

import com.fasterxml.jackson.annotation.JsonProperty;

import response.AResponseFGW14IP;

public class ReadDeviceResponse extends AResponseFGW14IP 
{
	@JsonProperty("device")
	private DeviceWithFunction deviceWithFunction;

	public DeviceWithFunction getDeviceWithFunction() {
		return deviceWithFunction;
	}

	public void setDeviceWithFunction(DeviceWithFunction deviceWithFunction) {
		this.deviceWithFunction = deviceWithFunction;
	}

}
