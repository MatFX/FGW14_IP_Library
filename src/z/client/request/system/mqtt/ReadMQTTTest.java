package z.client.request.system.mqtt;

import java.io.IOException;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import request.system.mqtt.ReadMQTTRequest;
import response.AResponseFGW14IP;
import response.system.mqtt.ReadMQTTResponse;

public class ReadMQTTTest 
{
	
	public static void main(String[] args) throws IOException
	{
		ReadMQTTRequest readMQTTRequest = new ReadMQTTRequest();
		
		CloseableHttpClient client = HttpClients.createDefault();
		client.execute(readMQTTRequest.getRequest(), response ->{
			
			
		try 
		{
			final HttpEntity entity1 = response.getEntity();
		    String jsonString = EntityUtils.toString(entity1);
		    ReadMQTTResponse readNetworkResponse = (ReadMQTTResponse) AResponseFGW14IP.getObjectFromJSONString(jsonString, readMQTTRequest.getResponseClass());
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
