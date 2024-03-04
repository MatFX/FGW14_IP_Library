package request.system.gateway;

import request.system.ReadSystemRequest;
import response.AResponseFGW14IP;
import response.system.gateway.ReadGatewayResponse;

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
