package test_request.client.request.system.mqtt;

import java.io.IOException;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import eu.matfx.request.system.mqtt.ConfigureUserPwRequest;
import eu.matfx.response.AResponseFGW14IP;
import eu.matfx.response.system.mqtt.ReadMQTTResponse;

public class ConfigureUserPasswordTest 
{
	
	public static void main(String[] args) throws IOException
	{
		
		ConfigureUserPwRequest c0onfigureUserPwRequest = new ConfigureUserPwRequest();
		c0onfigureUserPwRequest.setUser("");
		c0onfigureUserPwRequest.setPassword("");
		
		
		CloseableHttpClient client = HttpClients.createDefault();
		client.execute(c0onfigureUserPwRequest.getRequest(), response ->{
				
			try 
			{
				final HttpEntity entity1 = response.getEntity();
			    String jsonString = EntityUtils.toString(entity1);
			    ReadMQTTResponse readNetworkResponse = (ReadMQTTResponse) AResponseFGW14IP.getObjectFromJSONString(jsonString, c0onfigureUserPwRequest.getResponseClass());
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
