package test_request.client.request.devices;

import java.io.IOException;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import eu.matfx.request.devices.ReadDeviceRequest;
import eu.matfx.request.devices.ReadDevicesRequest;
import eu.matfx.response.AResponseFGW14IP;
import eu.matfx.response.devices.ReadDeviceResponse;
import eu.matfx.response.devices.ReadDevicesResponse;


public class ReadDeviceTest 
{
	
	public static void main(String[] args) throws IOException
	{
		ReadDeviceRequest readDeviceRequest = new ReadDeviceRequest(1);
		
		CloseableHttpClient client = HttpClients.createDefault();
		client.execute(readDeviceRequest.getRequest(), response ->{
			
			
		try 
		{
			final HttpEntity entity1 = response.getEntity();
		    String jsonString = EntityUtils.toString(entity1);
		    ReadDeviceResponse readNetworkResponse = (ReadDeviceResponse) AResponseFGW14IP.getObjectFromJSONString(jsonString, readDeviceRequest.getResponseClass(), false);
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
