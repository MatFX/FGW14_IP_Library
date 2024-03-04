package z.client.request.system.gateway;

import java.io.IOException;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import request.password.ReadPasswordRequest;
import request.system.gateway.ReadGatewayRequest;
import response.AResponseFGW14IP;
import response.password.ReadPasswordResponse;
import response.system.gateway.ReadGatewayResponse;

public class ReadGatewayTest 
{
	
	public static void main(String[] args) throws IOException
	{
		ReadGatewayRequest readGateway = new ReadGatewayRequest();
		
		CloseableHttpClient client = HttpClients.createDefault();
		client.execute(readGateway.getRequest(), response ->{
			
			
		try 
		{
			final HttpEntity entity1 = response.getEntity();
		    System.out.println("entity " + entity1.getContentType());
	        
		    
		    
            String jsonString = EntityUtils.toString(entity1);
            ReadGatewayResponse readGatewayResponse = (ReadGatewayResponse) AResponseFGW14IP.getObjectFromJSONString(jsonString, readGateway.getResponseClass());
            if(readGatewayResponse != null)
            {
            	System.out.println("Gateway? " + readGatewayResponse.toString());
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
