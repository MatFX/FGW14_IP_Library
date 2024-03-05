package request.system.network.ethernet;

import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.hc.core5.http.io.entity.StringEntity;

import gateway.Connection;
import request.ARequest;
import request.interfaces.ISendJSONObject;
import request.json.states.Activator;
import request.json.system.network.ethernet.EnableDisableEthernet;
import request.json.system.network.ethernet.Network_Ethernet;
import request.system.network.ReadNetworkRequest;
import request.system.time.ReadTimeRequest;
import response.AResponseFGW14IP;
import response.system.network.ReadNetworkResponse;
import tools.JSONObject;

public class ActivateDeactivateEthernetRequest extends ReadNetworkRequest implements ISendJSONObject
{
	
	private Activator ethernetActivation = Activator.ACTIVATE;
	
	public ActivateDeactivateEthernetRequest()
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
		EnableDisableEthernet enableDisableEthernet = new EnableDisableEthernet();
		enableDisableEthernet.setState(ethernetActivation.getValueToSet());
		
		Network_Ethernet requestBody = new Network_Ethernet();
		requestBody.setEthernetContent(enableDisableEthernet);
		return requestBody;
	}


	public void setEthernetState(Activator ethernetActivation) {
		this.ethernetActivation = ethernetActivation;
	}

}
