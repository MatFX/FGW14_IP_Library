package eu.matfx.response.devices;



import eu.matfx.response.AResponseFGW14IP;

public class ReadDevicesResponse extends AResponseFGW14IP 
{
	private Device[] devices;

	public Device[] getDevices() {
		return devices;
	}

	public void setDevices(Device[] devices) {
		this.devices = devices;
	}

}
