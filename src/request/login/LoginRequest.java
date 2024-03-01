package request.login;

import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.hc.core5.http.io.entity.StringEntity;

import gateway.Connection;
import request.ARequest;
import request.interfaces.ISendJSONObject;
import request.json.Login;
import response.AResponseFGW14IP;
import response.login.LoginResponse;
import tools.JSONObject;


public class LoginRequest extends ARequest implements ISendJSONObject
{
	
	private String password ="";

	public LoginRequest() 
	{
		super("/login");
	}

	@Override
	public String getFullRequestString() {
		StringBuilder sb = new StringBuilder(Connection.getInstance().getDestinationIP());
		sb.append(this.apiName);
		System.out.println("anfrage: "+sb.toString());
		return sb.toString();
	}

	@Override
	public HttpUriRequestBase getRequest() {
	    HttpPost httpPost = new HttpPost(this.getFullRequestString());
	    
	    try
	    {
	    	httpPost.setHeader("Accept", "application/json");
	    	httpPost.setHeader("Content-type", "application/json");
	    	String json = ARequest.getJSONString(this.getRequestBody());
	 	    final StringEntity entity = new StringEntity(json);
	 	    httpPost.setEntity(entity);
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    return httpPost;
	}

	@Override
	public Class<? extends AResponseFGW14IP> getResponseClass() {
		return LoginResponse.class;
	}

	@Override
	public JSONObject getRequestBody() 
	{
		Login login = new Login();
		login.setPassword(password);
		return login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
