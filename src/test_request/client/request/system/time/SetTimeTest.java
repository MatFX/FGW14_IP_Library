package test_request.client.request.system.time;

import java.io.IOException;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import eu.matfx.request.system.time.SetTimeRequest;
import eu.matfx.response.AResponseFGW14IP;
import eu.matfx.response.system.time.ReadTimeResponse;

public class SetTimeTest 
{
	
	public static void main(String[] args) throws IOException
	{
		SetTimeRequest timeRequest = new SetTimeRequest();
		timeRequest.setTime("2024-02-29T01:01:01");
		
		CloseableHttpClient client = HttpClients.createDefault();
		client.execute(timeRequest.getRequest(), response ->{
			
			
		try 
		{
			final HttpEntity entity1 = response.getEntity();
		    String jsonString = EntityUtils.toString(entity1);
            ReadTimeResponse timeResponse = (ReadTimeResponse) AResponseFGW14IP.getObjectFromJSONString(jsonString, timeRequest.getResponseClass());
            if(timeResponse != null)
            {
            	System.out.println("Response: " + timeResponse.toString());
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
