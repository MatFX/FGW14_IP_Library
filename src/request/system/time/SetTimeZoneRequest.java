package request.system.time;

import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.hc.core5.http.io.entity.StringEntity;

import gateway.Connection;
import request.ARequest;
import request.interfaces.ISendJSONObject;
import request.json.TimeZone;
import response.AResponseFGW14IP;
import response.system.time.ReadTimeResponse;
import tools.JSONObject;

public class SetTimeZoneRequest extends ReadTimeRequest implements ISendJSONObject
{
	private String timeZoneToSet;
	
	public SetTimeZoneRequest()
	{
		super();
	}
	

	@Override
	public Class<? extends AResponseFGW14IP> getResponseClass() {
		return ReadTimeResponse.class;
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
	    	System.out.println("json " + json);
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
		TimeZone time = new TimeZone();
		time.setTimeZone(timeZoneToSet);
		return time;
	}

	/**
	 * Format of the time string value eg CET-1CEST,M3.5.0,M10.5.0/3
	 * @param timeToSet
	 */
	public void setTimeZone(String timeZoneToSet) {
		this.timeZoneToSet = timeZoneToSet;
	}

}
