package eu.matfx.request.system.network;

import eu.matfx.request.system.ReadSystemRequest;
import eu.matfx.response.AResponseFGW14IP;
import eu.matfx.response.system.network.ReadNetworkResponse;


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
