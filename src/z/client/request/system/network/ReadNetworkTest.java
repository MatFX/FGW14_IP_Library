package z.client.request.system.network;

import java.io.IOException;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import request.system.network.ReadNetworkRequest;
import response.AResponseFGW14IP;
import response.system.network.ReadNetworkResponse;

public class ReadNetworkTest 
{
	
	public static void main(String[] args) throws IOException
	{
		ReadNetworkRequest readNetworkRequest = new ReadNetworkRequest();
		
		CloseableHttpClient client = HttpClients.createDefault();
		client.execute(readNetworkRequest.getRequest(), response ->{
			
			
		try 
		{
			final HttpEntity entity1 = response.getEntity();
		    String jsonString = EntityUtils.toString(entity1);
		    ReadNetworkResponse readNetworkResponse = (ReadNetworkResponse) AResponseFGW14IP.getObjectFromJSONString(jsonString, readNetworkRequest.getResponseClass());
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
