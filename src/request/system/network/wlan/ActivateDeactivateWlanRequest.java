package request.system.network.wlan;

import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.hc.core5.http.io.entity.StringEntity;

import gateway.Connection;
import request.ARequest;
import request.interfaces.ISendJSONObject;
import request.json.states.Activator;
import request.json.system.network.wlan.EnableDisableWlan;
import request.json.system.network.wlan.Network_Wlan;
import request.system.network.ReadNetworkRequest;
import response.AResponseFGW14IP;
import response.system.network.ReadNetworkResponse;
import tools.JSONObject;

public class ActivateDeactivateWlanRequest extends ReadNetworkRequest implements ISendJSONObject
{
	
	private Activator wlanActivator = Activator.ACTIVATE;
	
	public ActivateDeactivateWlanRequest()
	{
		super();
	}
	

	@Override
	public Class<? extends AResponseFGW14IP> getResponseClass() {
		return ReadNetworkResponse.class;
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
		EnableDisableWlan enableDisableWlan = new EnableDisableWlan();
		enableDisableWlan.setState(wlanActivator.getValueToSet());
		Network_Wlan requestBody = new Network_Wlan();
		requestBody.setWlanContent(enableDisableWlan);
		return requestBody;
	}


	public void setWlantState(Activator wlanActivator) {
		this.wlanActivator = wlanActivator;
	}

}
