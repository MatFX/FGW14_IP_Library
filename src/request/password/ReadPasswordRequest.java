package request.password;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import gateway.Connection;
import request.ARequest;
import response.AResponseFGW14IP;
import response.password.ReadPasswordResponse;

public class ReadPasswordRequest extends ARequest 
{
	public ReadPasswordRequest() 
	{
		super("/password");
	}


	//TODO doch noch nicht abstrakt scheint so, dass Parameter ausschließlich über json gesetzt werden.
	@Override
	public String getFullRequestString() 
	{
		StringBuilder sb = new StringBuilder(Connection.getInstance().getDestinationIP());
		sb.append(this.apiName);
		System.out.println("anfrage: "+sb.toString());
		return sb.toString();
	}

	@Override
	public HttpUriRequestBase getRequest() {
		HttpGet httpGet = new HttpGet(this.getFullRequestString());
	    httpGet.setHeader("accessToken", Connection.getInstance().getCurrentAccessToken());
	    return httpGet;
	}

	@Override
	public Class<? extends AResponseFGW14IP> getResponseClass() 
	{
		return ReadPasswordResponse.class;
		
	}

}
