package request.system.gateway;

import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.hc.core5.http.io.entity.StringEntity;

import gateway.Connection;
import request.ARequest;
import request.interfaces.ISendJSONObject;
import request.json.system.gateway.SetGatewayName;
import response.AResponseFGW14IP;
import response.system.gateway.ReadGatewayResponse;
import tools.JSONObject;

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
