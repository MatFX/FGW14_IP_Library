package test_request.client.request.system.network.wlan;

import java.io.IOException;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import eu.matfx.request.system.network.wlan.SetSsidPasswordWlanRequest;
import eu.matfx.request.system.network.wlan.SetStaticWlanIPRequest;
import eu.matfx.response.AResponseFGW14IP;
import eu.matfx.response.system.network.ReadNetworkResponse;

public class SetSsidPasswordTest 
{
	
	public static void main(String[] args) throws IOException
	{
		SetSsidPasswordWlanRequest ssidRequest = new SetSsidPasswordWlanRequest();
		ssidRequest.setSsid("my_network");
		ssidRequest.setPassword("my_password");
		
		CloseableHttpClient client = HttpClients.createDefault();
		client.execute(ssidRequest.getRequest(), response ->{
			
			
		try 
		{
			final HttpEntity entity1 = response.getEntity();
		    String jsonString = EntityUtils.toString(entity1);
		    ReadNetworkResponse networkResponse = (ReadNetworkResponse) AResponseFGW14IP.getObjectFromJSONString(jsonString, ssidRequest.getResponseClass());
            if(networkResponse != null)
            {
            	System.out.println("Response: " + networkResponse.toString());
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
