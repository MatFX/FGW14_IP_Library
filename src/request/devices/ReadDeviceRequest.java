package request.devices;


import response.AResponseFGW14IP;
import response.devices.ReadDeviceResponse;


/**
 * 
 * Request for a specific device
 * @author m.goerlich
 *
 */
public class ReadDeviceRequest extends ReadDevicesRequest
{
	private int busNumber;
	
	public ReadDeviceRequest(int busNumber)
	{
		super();
		this.appendAPIName("/"+busNumber);
	}

	@Override
	public Class<? extends AResponseFGW14IP> getResponseClass() {
		return ReadDeviceResponse.class;
	}


}
