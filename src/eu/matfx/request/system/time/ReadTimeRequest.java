package eu.matfx.request.system.time;

import eu.matfx.request.system.ReadSystemRequest;
import eu.matfx.response.AResponseFGW14IP;
import eu.matfx.response.system.time.ReadTimeResponse;

public class ReadTimeRequest extends ReadSystemRequest
{
	
	public ReadTimeRequest()
	{
		super("/time");
		
	}

	@Override
	public Class<? extends AResponseFGW14IP> getResponseClass() {
		return ReadTimeResponse.class;
	}

}
