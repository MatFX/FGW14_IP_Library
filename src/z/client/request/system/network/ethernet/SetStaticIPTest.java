package z.client.request.system.network.ethernet;

import java.io.IOException;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import request.system.network.ethernet.SetStaticEthernetIPRequest;
import response.AResponseFGW14IP;
import response.system.network.ReadNetworkResponse;

public class SetStaticIPTest 
{
	
	public static void main(String[] args) throws IOException
	{
		SetStaticEthernetIPRequest ipRequest = new SetStaticEthernetIPRequest();
		ipRequest.setIp("192.168.5.1");
		ipRequest.setSubnetMask("255.255.255.0");
		ipRequest.setStandardGateway("192.168.5.254");
		ipRequest.setDnsMain("192.168.5.254");
		ipRequest.setDnsBackup("192.168.5.254");
		
		CloseableHttpClient client = HttpClients.createDefault();
		client.execute(ipRequest.getRequest(), response ->{
			
			
		try 
		{
			final HttpEntity entity1 = response.getEntity();
		    String jsonString = EntityUtils.toString(entity1);
		    ReadNetworkResponse networkResponse = (ReadNetworkResponse) AResponseFGW14IP.getObjectFromJSONString(jsonString, ipRequest.getResponseClass());
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
