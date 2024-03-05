package z.client.request.system.network.ethernet;

import java.io.IOException;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import request.json.states.Activator;
import request.system.network.ethernet.ActivateDeactivateDhcpRequest;
import request.system.network.ethernet.ActivateDeactivateEthernetRequest;
import response.AResponseFGW14IP;
import response.system.network.ReadNetworkResponse;

public class SetDhcpStateTest 
{
	
	public static void main(String[] args) throws IOException
	{
		ActivateDeactivateDhcpRequest dhcpState = new ActivateDeactivateDhcpRequest();
		dhcpState.setDhcpState(Activator.ACTIVATE);
		
		CloseableHttpClient client = HttpClients.createDefault();
		client.execute(dhcpState.getRequest(), response ->{
			
			
		try 
		{
			final HttpEntity entity1 = response.getEntity();
		    String jsonString = EntityUtils.toString(entity1);
		    ReadNetworkResponse networkResponse = (ReadNetworkResponse) AResponseFGW14IP.getObjectFromJSONString(jsonString, dhcpState.getResponseClass());
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
