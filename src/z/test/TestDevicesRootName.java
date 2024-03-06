package z.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import response.devices.Devices;
import response.devices.ReadDevicesResponse;

public class TestDevicesRootName 
{
	
	public static void main(String[] args) throws JsonProcessingException
	{
		Devices[] devices = new Devices[1];
		devices[0] = new Devices();
		devices[0].setBusAddress(2);
		devices[0].setDeviceType("FWZ14");
		devices[0].setFriendlyId("friendlyIdToSet");
		devices[0].setForwardOnMqtt(false);
		
		
		ReadDevicesResponse rdResponse = new ReadDevicesResponse();
		rdResponse.setDevices(devices);
		
		ObjectMapper objectMapper = new ObjectMapper();
		//objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
		String field = objectMapper.writeValueAsString(rdResponse);
		System.out.println("field >> " + field);
	}

}
