package test_request.client.request.system.network.ethernet;

import java.io.IOException;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import eu.matfx.request.json.states.Activator;
import eu.matfx.request.system.network.ethernet.ActivateDeactivateEthernetRequest;
import eu.matfx.response.AResponseFGW14IP;
import eu.matfx.response.system.network.ReadNetworkResponse;

public class SetEthernetStateTest 
{
	
	public static void main(String[] args) throws IOException
	{
		ActivateDeactivateEthernetRequest ethernetState = new ActivateDeactivateEthernetRequest();
		ethernetState.setEthernetState(Activator.ACTIVATE);
		
		CloseableHttpClient client = HttpClients.createDefault();
		client.execute(ethernetState.getRequest(), response ->{
			
			
		try 
		{
			final HttpEntity entity1 = response.getEntity();
		    String jsonString = EntityUtils.toString(entity1);
		    ReadNetworkResponse networkResponse = (ReadNetworkResponse) AResponseFGW14IP.getObjectFromJSONString(jsonString, ethernetState.getResponseClass());
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
