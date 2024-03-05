package z.client.request.system.network.wlan;

import java.io.IOException;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import request.json.states.Activator;
import request.json.system.network.wlan.SwitchModeStation.Mode;
import request.system.network.ethernet.ActivateDeactivateEthernetRequest;
import request.system.network.wlan.ActivateDeactivateWlanRequest;
import request.system.network.wlan.SwitchModeWlanRequest;
import response.AResponseFGW14IP;
import response.system.network.ReadNetworkResponse;

public class SetWlanStateTest 
{
	
	public static void main(String[] args) throws IOException
	{
		SwitchModeWlanRequest switchModeWlan = new SwitchModeWlanRequest();
		switchModeWlan.setWlanMode(Mode.ACCESS_POINT);
		
		CloseableHttpClient client = HttpClients.createDefault();
		client.execute(switchModeWlan.getRequest(), response ->{
			
			
		try 
		{
			final HttpEntity entity1 = response.getEntity();
		    String jsonString = EntityUtils.toString(entity1);
		    ReadNetworkResponse networkResponse = (ReadNetworkResponse) AResponseFGW14IP.getObjectFromJSONString(jsonString, switchModeWlan.getResponseClass());
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
