package z.client.request.devices;

import java.io.IOException;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import request.devices.ReadDevicesRequest;
import response.AResponseFGW14IP;
import response.devices.ReadDevicesResponse;


public class ReadDevicesTest 
{
	
	public static void main(String[] args) throws IOException
	{
		ReadDevicesRequest readDevicesRequest = new ReadDevicesRequest();
		
		CloseableHttpClient client = HttpClients.createDefault();
		client.execute(readDevicesRequest.getRequest(), response ->{
			
			
		try 
		{
			final HttpEntity entity1 = response.getEntity();
		    String jsonString = EntityUtils.toString(entity1);
		    ReadDevicesResponse readNetworkResponse = (ReadDevicesResponse) AResponseFGW14IP.getObjectFromJSONString(jsonString, readDevicesRequest.getResponseClass(), false);
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
