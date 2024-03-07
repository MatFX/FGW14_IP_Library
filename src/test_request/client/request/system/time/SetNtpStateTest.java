package test_request.client.request.system.time;

import java.io.IOException;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import eu.matfx.request.json.states.Activator;
import eu.matfx.request.system.gateway.SetGatewayNameRequest;
import eu.matfx.request.system.time.ActivateDeactivateNtpRequest;
import eu.matfx.response.AResponseFGW14IP;
import eu.matfx.response.system.gateway.ReadGatewayResponse;
import eu.matfx.response.system.time.ReadTimeResponse;

public class SetNtpStateTest 
{
	
	public static void main(String[] args) throws IOException
	{
		ActivateDeactivateNtpRequest ntpState = new ActivateDeactivateNtpRequest();
		ntpState.setNtpState(Activator.INACTIVE);
		
		CloseableHttpClient client = HttpClients.createDefault();
		client.execute(ntpState.getRequest(), response ->{
			
			
		try 
		{
			final HttpEntity entity1 = response.getEntity();
		    String jsonString = EntityUtils.toString(entity1);
            ReadTimeResponse timeResponse = (ReadTimeResponse) AResponseFGW14IP.getObjectFromJSONString(jsonString, ntpState.getResponseClass());
            if(timeResponse != null)
            {
            	System.out.println("Response: " + timeResponse.toString());
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
