package z.client.request.system.reset;

import java.io.IOException;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import request.system.reset.ResetRequest;


public class ResetRequestTest 
{
	
	public static void main(String[] args) throws IOException
	{
		ResetRequest resetRequest = new ResetRequest();
		
		CloseableHttpClient client = HttpClients.createDefault();
		client.execute(resetRequest.getRequest(), response ->{
			
			
		try 
		{
			final HttpEntity entity1 = response.getEntity();
		    String jsonString = EntityUtils.toString(entity1);
		    System.out.println("jsonString " + jsonString);
		    /* kommt nicht vernünftiges zurück */
		    /* empty json string>> {} */
		    /*
 		    EmptyResponse readTimeResponse = (EmptyResponse) AResponseFGW14IP.getObjectFromJSONString(jsonString, resetRequest.getResponseClass());
            if(readTimeResponse != null)
            {
            	System.out.println("Response? " + readTimeResponse.toString());
            }
            */
            
            
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
     });
	
		
	}
	

}
