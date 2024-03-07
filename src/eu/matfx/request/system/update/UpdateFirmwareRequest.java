package eu.matfx.request.system.update;

import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;

import eu.matfx.gateway.Connection;
import eu.matfx.request.system.ReadSystemRequest;
import eu.matfx.response.AResponseFGW14IP;
import eu.matfx.response.EmptyResponse;

/**
 * the data is not clear at the moment; I think its a hex string or equivalent
 * @author m.goerlich
 *
 */
public class UpdateFirmwareRequest extends ReadSystemRequest
{
	
	public UpdateFirmwareRequest()
	{
		super("/update");
		
	}
	
	@Override
	public HttpUriRequestBase getRequest() {
		HttpPost httpGet = new HttpPost(this.getFullRequestString());
	    httpGet.setHeader("accessToken", Connection.getInstance().getCurrentAccessToken());
	    httpGet.setHeader("Content-type", "text/plain");
	    return httpGet;
	}

	@Override
	public Class<? extends AResponseFGW14IP> getResponseClass() {
		return EmptyResponse.class;
	}

}
