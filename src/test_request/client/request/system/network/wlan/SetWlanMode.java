package test_request.client.request.system.network.wlan;

import java.io.IOException;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import eu.matfx.request.json.states.Activator;
import eu.matfx.request.system.network.ethernet.ActivateDeactivateEthernetRequest;
import eu.matfx.request.system.network.wlan.ActivateDeactivateWlanRequest;
import eu.matfx.response.AResponseFGW14IP;
import eu.matfx.response.system.network.ReadNetworkResponse;

public class SetWlanMode 
{
	
	public static void main(String[] args) throws IOException
	{
		ActivateDeactivateWlanRequest wlanState = new ActivateDeactivateWlanRequest();
		wlanState.setWlantState(Activator.ACTIVATE);
		
		CloseableHttpClient client = HttpClients.createDefault();
		client.execute(wlanState.getRequest(), response ->{
			
			
		try 
		{
			final HttpEntity entity1 = response.getEntity();
		    String jsonString = EntityUtils.toString(entity1);
		    ReadNetworkResponse networkResponse = (ReadNetworkResponse) AResponseFGW14IP.getObjectFromJSONString(jsonString, wlanState.getResponseClass());
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
