package z.client.request.system.mqtt;

import java.io.IOException;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import request.json.system.mqtt.ConfigureBroker;
import request.json.system.mqtt.ConfigureBroker.ProtocolType;
import request.json.system.mqtt.MQTT;
import request.system.mqtt.ConfigureBrokerRequest;
import response.AResponseFGW14IP;
import response.system.mqtt.ReadMQTTResponse;

public class ConfigureBrokerTest 
{
	
	public static void main(String[] args) throws IOException
	{
		
		ConfigureBrokerRequest configureBrokerRequest = new ConfigureBrokerRequest();
		configureBrokerRequest.setBrokerUri(ProtocolType.MQTT.getPrefixProtocol() + "192.168.150.81");
		configureBrokerRequest.setBrokerPort(ProtocolType.MQTT.getPortNumber());
		configureBrokerRequest.setCertificate("");
		
		CloseableHttpClient client = HttpClients.createDefault();
		client.execute(configureBrokerRequest.getRequest(), response ->{
				
			try 
			{
				final HttpEntity entity1 = response.getEntity();
			    String jsonString = EntityUtils.toString(entity1);
			    ReadMQTTResponse readNetworkResponse = (ReadMQTTResponse) AResponseFGW14IP.getObjectFromJSONString(jsonString, configureBrokerRequest.getResponseClass());
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
