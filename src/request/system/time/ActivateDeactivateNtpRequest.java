package request.system.time;

import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.hc.core5.http.io.entity.StringEntity;

import gateway.Connection;
import request.ARequest;
import request.interfaces.ISendJSONObject;
import request.json.ActivateDeactivateNtpState;
import request.json.ActivateDeactivateNtpState.NTP_STATE;
import request.system.ReadSystemRequest;
import response.AResponseFGW14IP;
import response.system.time.ReadTimeResponse;
import tools.JSONObject;

public class ActivateDeactivateNtpRequest extends ReadTimeRequest implements ISendJSONObject
{
	
	private NTP_STATE ntpState = NTP_STATE.ACTIVATE;
	
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


	public void setNtpState(NTP_STATE ntpState) {
		this.ntpState = ntpState;
	}

}
