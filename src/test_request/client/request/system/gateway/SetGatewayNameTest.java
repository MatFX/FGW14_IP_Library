package test_request.client.request.system.gateway;

import java.io.IOException;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import eu.matfx.request.system.gateway.SetGatewayNameRequest;
import eu.matfx.response.AResponseFGW14IP;
import eu.matfx.response.system.gateway.ReadGatewayResponse;

public class SetGatewayNameTest 
{
	
	public static void main(String[] args) throws IOException
	{
		SetGatewayNameRequest setGatewayName = new SetGatewayNameRequest();
		setGatewayName.setGatewayName("My_FGW14-IP");
		
		CloseableHttpClient client = HttpClients.createDefault();
		client.execute(setGatewayName.getRequest(), response ->{
			
			
		try 
		{
			final HttpEntity entity1 = response.getEntity();
		    System.out.println("entity " + entity1.getContentType());
	        
		    
		    
            String jsonString = EntityUtils.toString(entity1);
            ReadGatewayResponse readGatewayResponse = (ReadGatewayResponse) AResponseFGW14IP.getObjectFromJSONString(jsonString, setGatewayName.getResponseClass());
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
