package test_request.client.request.system.mqtt;

import java.io.IOException;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import eu.matfx.request.system.mqtt.ConfigureTopicStartRequest;
import eu.matfx.request.system.mqtt.ConfigureUserPwRequest;
import eu.matfx.response.AResponseFGW14IP;
import eu.matfx.response.system.mqtt.ReadMQTTResponse;

public class ConfigureTopicStartTest 
{
	
	public static void main(String[] args) throws IOException
	{
		
		ConfigureTopicStartRequest configureTopicStartRequest = new ConfigureTopicStartRequest();
		configureTopicStartRequest.setTopicStart("FGW14-IP");
		
		
		
		CloseableHttpClient client = HttpClients.createDefault();
		client.execute(configureTopicStartRequest.getRequest(), response ->{
				
			try 
			{
				final HttpEntity entity1 = response.getEntity();
			    String jsonString = EntityUtils.toString(entity1);
			    ReadMQTTResponse readNetworkResponse = (ReadMQTTResponse) AResponseFGW14IP.getObjectFromJSONString(jsonString, configureTopicStartRequest.getResponseClass());
	            if(readNetworkResponse != null)
	            {
	            	System.out.println("Response? " + readNetworkResponse.toString());
	            }
	      	
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			return null;
		});
	}

}
