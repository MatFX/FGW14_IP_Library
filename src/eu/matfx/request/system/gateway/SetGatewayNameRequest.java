package eu.matfx.request.system.gateway;

import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.hc.core5.http.io.entity.StringEntity;

import eu.matfx.gateway.Connection;
import eu.matfx.request.ARequest;
import eu.matfx.request.interfaces.ISendJSONObject;
import eu.matfx.request.json.system.gateway.SetGatewayName;
import eu.matfx.response.AResponseFGW14IP;
import eu.matfx.response.system.gateway.ReadGatewayResponse;
import eu.matfx.tools.JSONObject;

public class SetGatewayNameRequest extends ReadGatewayRequest implements ISendJSONObject
{
	private String gatewayName = "";
	
	public SetGatewayNameRequest()
	{
		//same api path as ReadGatewayRequest
		super();
	}
	
	//need other uri request and respond
	
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
	public Class<? extends AResponseFGW14IP> getResponseClass() {
		return ReadGatewayResponse.class;
	}

	@Override
	public JSONObject getRequestBody() {
		SetGatewayName setGatewayName = new SetGatewayName();
		setGatewayName.setName(gatewayName);
		return setGatewayName;
	}

	public void setGatewayName(String gatewayName) {
		this.gatewayName = gatewayName;
	}
	
	
}
