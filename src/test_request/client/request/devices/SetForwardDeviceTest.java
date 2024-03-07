package test_request.client.request.devices;

import java.io.IOException;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import eu.matfx.request.devices.SetForwardDeviceRequest;
import eu.matfx.request.json.system.devices.MQTT_Forward.Forward;
import eu.matfx.response.AResponseFGW14IP;
import eu.matfx.response.devices.ReadDeviceResponse;


public class SetForwardDeviceTest 
{
	
	public static void main(String[] args) throws IOException
	{
		SetForwardDeviceRequest setDeviceRequest = new SetForwardDeviceRequest(1);
		
		setDeviceRequest.setForward(Forward.FORWARD);
		
		
		CloseableHttpClient client = HttpClients.createDefault();
		client.execute(setDeviceRequest.getRequest(), response ->{
			
			
		try 
		{
			final HttpEntity entity1 = response.getEntity();
		    String jsonString = EntityUtils.toString(entity1);
		    ReadDeviceResponse readNetworkResponse = (ReadDeviceResponse) AResponseFGW14IP.getObjectFromJSONString(jsonString, setDeviceRequest.getResponseClass(), false);
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
