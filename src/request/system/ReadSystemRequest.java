package request.system;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;

import gateway.Connection;
import request.ARequest;
import response.AResponseFGW14IP;

public class ReadSystemRequest extends ARequest
{
	
	public ReadSystemRequest()
	{
		super("/system");
	}

	/**
	 * Constructor for the extended classes
	 * @param followedRequestPath
	 */
	public ReadSystemRequest(String followedRequestPath)
	{
		this();
		this.appendAPIName(followedRequestPath);
	}

	@Override
	public String getFullRequestString() {
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
	public Class<? extends AResponseFGW14IP> getResponseClass() {
		// TODO Auto-generated method stub
		return null;
	}


}
