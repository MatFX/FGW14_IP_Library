package request.system.network;

import request.system.ReadSystemRequest;
import response.AResponseFGW14IP;
import response.system.network.ReadNetworkResponse;


public class ReadNetworkRequest extends ReadSystemRequest
{
	
	public ReadNetworkRequest()
	{
		super("/network");
		
	}

	@Override
	public Class<? extends AResponseFGW14IP> getResponseClass() {
		return ReadNetworkResponse.class;
	}

}
