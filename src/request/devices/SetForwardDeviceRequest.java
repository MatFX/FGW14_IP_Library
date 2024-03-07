package request.devices;

import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.hc.core5.http.io.entity.StringEntity;

import gateway.Connection;
import request.ARequest;
import request.interfaces.ISendJSONObject;
import request.json.system.devices.MQTT_Forward;
import request.json.system.devices.MQTT_Forward.Forward;
import response.AResponseFGW14IP;
import response.devices.ReadDeviceResponse;
import tools.JSONObject;

public class SetForwardDeviceRequest extends ReadDeviceRequest implements ISendJSONObject
{
	private Forward forward;

	public SetForwardDeviceRequest(int busNumber) 
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
		MQTT_Forward mqttForware = new MQTT_Forward();
		mqttForware.setForwardOnMqtt(forward.getValueToSet());
		return mqttForware;
	}

	public void setForward(Forward forward) {
		this.forward = forward;
	}

}
