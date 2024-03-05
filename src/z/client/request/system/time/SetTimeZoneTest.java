package z.client.request.system.time;

import java.io.IOException;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import request.system.time.SetTimeRequest;
import request.system.time.SetTimeZoneRequest;
import response.AResponseFGW14IP;
import response.system.time.ReadTimeResponse;

public class SetTimeZoneTest 
{
	
	public static void main(String[] args) throws IOException
	{
		SetTimeZoneRequest timeZoneRequest = new SetTimeZoneRequest();
		timeZoneRequest.setTimeZone("CET-1CEST,M3.4.0,M10.5.0/3");
		
		//timeZoneRequest.setTimeZone("EET-2EEST,M3.5.0/3,M10.5.0/4");
		
		CloseableHttpClient client = HttpClients.createDefault();
		client.execute(timeZoneRequest.getRequest(), response ->{
			
			
		try 
		{
			final HttpEntity entity1 = response.getEntity();
		    String jsonString = EntityUtils.toString(entity1);
            ReadTimeResponse timeResponse = (ReadTimeResponse) AResponseFGW14IP.getObjectFromJSONString(jsonString, timeZoneRequest.getResponseClass());
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
