package request.system.mqtt;

import request.system.ReadSystemRequest;
import response.AResponseFGW14IP;
import response.system.mqtt.ReadMQTTResponse;


public class ReadMQTTRequest extends ReadSystemRequest
{
	public ReadMQTTRequest()
	{
		super("/mqtt");
	}


	@Override
	public Class<? extends AResponseFGW14IP> getResponseClass() {
		return ReadMQTTResponse.class;
	}
}
