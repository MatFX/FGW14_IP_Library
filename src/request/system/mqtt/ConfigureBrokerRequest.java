package request.system.mqtt;



import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.hc.core5.http.io.entity.StringEntity;

import gateway.Connection;
import request.ARequest;
import request.interfaces.ISendJSONObject;
import request.json.system.mqtt.ConfigureBroker;
import tools.JSONObject;

public class ConfigureBrokerRequest extends ReadMQTTRequest implements ISendJSONObject
{
	
	private String brokerUri;
	
	private int brokerPort;
	
	private String certificate;
	
	public ConfigureBrokerRequest()
	{
		super();
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
		ConfigureBroker configureBroker = new ConfigureBroker();
		
		configureBroker.setBrokerUri(brokerUri);
		configureBroker.setBrokerPort(brokerPort);
		configureBroker.setCertificate(certificate);
		return configureBroker;
	}
	
	public void setBrokerUri(String brokerUri) {
		this.brokerUri = brokerUri;
	}

	public void setBrokerPort(int brokerPort) {
		this.brokerPort = brokerPort;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	
	
	

}
