package test_request.client.request.system.time;

import java.io.IOException;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import eu.matfx.request.system.time.ReadTimeRequest;
import eu.matfx.response.AResponseFGW14IP;
import eu.matfx.response.system.time.ReadTimeResponse;

public class ReadTimeTest 
{
	
	public static void main(String[] args) throws IOException
	{
		ReadTimeRequest readTime = new ReadTimeRequest();
		
		CloseableHttpClient client = HttpClients.createDefault();
		client.execute(readTime.getRequest(), response ->{
			
			
		try 
		{
			final HttpEntity entity1 = response.getEntity();
		    String jsonString = EntityUtils.toString(entity1);
            ReadTimeResponse readTimeResponse = (ReadTimeResponse) AResponseFGW14IP.getObjectFromJSONString(jsonString, readTime.getResponseClass());
            if(readTimeResponse != null)
            {
            	System.out.println("Response? " + readTimeResponse.toString());
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
