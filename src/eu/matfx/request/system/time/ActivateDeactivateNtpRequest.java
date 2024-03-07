package eu.matfx.request.system.time;

import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.hc.core5.http.io.entity.StringEntity;

import eu.matfx.gateway.Connection;
import eu.matfx.request.ARequest;
import eu.matfx.request.interfaces.ISendJSONObject;
import eu.matfx.request.json.ActivateDeactivateNtpState;
import eu.matfx.request.json.states.Activator;
import eu.matfx.response.AResponseFGW14IP;
import eu.matfx.response.system.time.ReadTimeResponse;
import eu.matfx.tools.JSONObject;

public class ActivateDeactivateNtpRequest extends ReadTimeRequest implements ISendJSONObject
{
	
	private Activator ntpState = Activator.ACTIVATE;
	
	public ActivateDeactivateNtpRequest()
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
		ActivateDeactivateNtpState ntpStateToSet = new ActivateDeactivateNtpState();
		ntpStateToSet.setNtpState(ntpState);
		return ntpStateToSet;
	}


	public void setNtpState(Activator ntpState) {
		this.ntpState = ntpState;
	}

}
