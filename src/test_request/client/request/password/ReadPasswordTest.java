package test_request.client.request.password;

import java.io.IOException;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import eu.matfx.request.password.ReadPasswordRequest;
import eu.matfx.response.AResponseFGW14IP;
import eu.matfx.response.password.ReadPasswordResponse;

public class ReadPasswordTest 
{
	
	public static void main(String[] args) throws IOException
	{
		ReadPasswordRequest readPasswordRequest = new ReadPasswordRequest();
		
		CloseableHttpClient client = HttpClients.createDefault();
		client.execute(readPasswordRequest.getRequest(), response ->{
			
			
		try 
		{
			final HttpEntity entity1 = response.getEntity();
		    System.out.println("entity " + entity1.getContentType());
	           
            String jsonString = EntityUtils.toString(entity1);
            ReadPasswordResponse readPasswordResponse = (ReadPasswordResponse) AResponseFGW14IP.getObjectFromJSONString(jsonString, readPasswordRequest.getResponseClass());
            if(readPasswordResponse != null)
            {
            	System.out.println("Password? " + readPasswordResponse.toString());
            	//Connection.getInstance().setCurrentAccessToken(loginResponse.getAccessToken());
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
