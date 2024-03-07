package eu.matfx.request.system.gateway;

import eu.matfx.request.system.ReadSystemRequest;
import eu.matfx.response.AResponseFGW14IP;
import eu.matfx.response.system.gateway.ReadGatewayResponse;

public class ReadGatewayRequest extends ReadSystemRequest
{
	
	public ReadGatewayRequest()
	{
		super("/gateway");
		
	}

	@Override
	public Class<? extends AResponseFGW14IP> getResponseClass() {
		return ReadGatewayResponse.class;
	}

}
