package eu.matfx.request.devices;

import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.hc.core5.http.io.entity.StringEntity;

import eu.matfx.gateway.Connection;
import eu.matfx.request.ARequest;
import eu.matfx.request.interfaces.ISendJSONObject;
import eu.matfx.request.json.system.devices.FriendlyID;
import eu.matfx.response.AResponseFGW14IP;
import eu.matfx.response.devices.ReadDeviceResponse;
import eu.matfx.tools.JSONObject;

public class SetFriendlyDeviceRequest extends ReadDeviceRequest implements ISendJSONObject
{


	private String friendlyId;

	public SetFriendlyDeviceRequest(int busNumber) 
	{
		super(busNumber);
	}

	@Override
	public Class<? extends AResponseFGW14IP> getResponseClass() {
		return ReadDeviceResponse.class;
	}
	
	@Override
	public HttpUriRequestBase getRequest() 
	{
		HttpPut httpPut = new HttpPut(this.getFullRequestString());
		    
	    try
	    {
	    	httpPut.setHeader("accessToken", Connection.getInstance().getCurrentAccessToken());
	    	httpPut.setHeader("Accept", "application/json");
	    	httpPut.setHeader("Content-type", "application/json");
	    	String json = ARequest.getJSONString(this.getRequestBody());
	 	    final StringEntity entity = new StringEntity(json);
	 	    httpPut.setEntity(entity);
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    return httpPut;
	}
	
	
	@Override
	public JSONObject getRequestBody() 
	{
		FriendlyID friendly_id = new FriendlyID();
		friendly_id.setFriendlyId(friendlyId);
		return friendly_id;
	}
	
	public void setFriendlyId(String friendlyId) {
		this.friendlyId = friendlyId;
	}


}
