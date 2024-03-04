package z.client.request.login;

import java.io.IOException;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import gateway.Connection;
import request.login.LoginRequest;
import response.AResponseFGW14IP;
import response.login.LoginResponse;

/**
 * Sample class to test the connection with real gateway
 * @author m.goerlich
 *
 */
public class LoginTest 
{
	public static void main(String[] args) throws IOException
	{
		LoginRequest login = new LoginRequest();
		login.setPassword(Connection.DEFAULT_PASSWORD);
	
		CloseableHttpClient client = HttpClients.createDefault();
		client.execute(login.getRequest(), response ->{
			
			
		try 
		{
			final HttpEntity entity1 = response.getEntity();
		    System.out.println("entity " + entity1.getContentType());
	           
            String jsonString = EntityUtils.toString(entity1);
            //TODO im LoginResposne die weitere Verarbeitung über eine allgemeine Methode hinterlegen?
            LoginResponse loginResponse = (LoginResponse) AResponseFGW14IP.getObjectFromJSONString(jsonString, login.getResponseClass());
            if(loginResponse != null)
            {
            	Connection.getInstance().setCurrentAccessToken(loginResponse.getAccessToken());
            }
            System.out.println("loginResponse " + loginResponse.toString());
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
     });
		
		
	}

}
