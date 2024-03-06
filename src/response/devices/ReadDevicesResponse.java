package response.devices;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import response.AResponseFGW14IP;
//@JsonRootName("devices") 
public class ReadDevicesResponse extends AResponseFGW14IP 
{
	//@JsonProperty("devices")
	private Devices[] devices;

	public Devices[] getDevices() {
		return devices;
	}

	public void setDevices(Devices[] devices) {
		this.devices = devices;
	}

}
