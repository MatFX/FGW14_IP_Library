package request.system.reset;

import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;

import gateway.Connection;
import request.system.ReadSystemRequest;
import response.AResponseFGW14IP;
import response.EmptyResponse;
import response.system.time.ReadTimeResponse;

public class ResetRequest extends ReadSystemRequest
{
	
	public ResetRequest()
	{
		super("/reset");
		
	}
	
	@Override
	public HttpUriRequestBase getRequest() {
		HttpDelete httpGet = new HttpDelete(this.getFullRequestString());
	    httpGet.setHeader("accessToken", Connection.getInstance().getCurrentAccessToken());
	    return httpGet;
	}

	@Override
	public Class<? extends AResponseFGW14IP> getResponseClass() {
		return EmptyResponse.class;
	}

}
