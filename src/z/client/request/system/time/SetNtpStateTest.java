package z.client.request.system.time;

import java.io.IOException;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import request.json.states.Activator;
import request.system.gateway.SetGatewayNameRequest;
import request.system.time.ActivateDeactivateNtpRequest;
import response.AResponseFGW14IP;
import response.system.gateway.ReadGatewayResponse;
import response.system.time.ReadTimeResponse;

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
