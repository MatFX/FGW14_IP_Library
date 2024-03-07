package eu.matfx.request.devices;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;

import eu.matfx.gateway.Connection;
import eu.matfx.request.ARequest;
import eu.matfx.response.AResponseFGW14IP;
import eu.matfx.response.devices.ReadDevicesResponse;

public class ReadDevicesRequest extends ARequest
{
	
	public ReadDevicesRequest()
	{
		super("/devices");
	}

	/**
	 * Constructor for the extended classes
	 * @param followedRequestPath
	 */
	public ReadDevicesRequest(String followedRequestPath)
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
		return ReadDevicesResponse.class;
	}


}
