package request.system.time;

import request.system.ReadSystemRequest;
import response.AResponseFGW14IP;
import response.system.time.ReadTimeResponse;

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
