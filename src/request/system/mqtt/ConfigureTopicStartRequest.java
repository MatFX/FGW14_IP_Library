package request.system.mqtt;

import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.hc.core5.http.io.entity.StringEntity;
import gateway.Connection;
import request.ARequest;
import request.interfaces.ISendJSONObject;
import request.json.system.mqtt.ConfigureTopicStart;
import tools.JSONObject;

public class ConfigureTopicStartRequest extends ReadMQTTRequest implements ISendJSONObject
{
	private String topicStart;
	
	public ConfigureTopicStartRequest()
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
		ConfigureTopicStart configTopicStart = new ConfigureTopicStart();
		configTopicStart.setTopicStart(topicStart);
		return configTopicStart;
	}


	public void setTopicStart(String topicStart) {
		this.topicStart = topicStart;
	}



}
