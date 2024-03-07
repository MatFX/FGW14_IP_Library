package eu.matfx.request.system.mqtt;

import eu.matfx.request.system.ReadSystemRequest;
import eu.matfx.response.AResponseFGW14IP;
import eu.matfx.response.system.mqtt.ReadMQTTResponse;


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
