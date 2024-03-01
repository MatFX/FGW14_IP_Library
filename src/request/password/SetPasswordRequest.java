package request.password;

import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.hc.core5.http.io.entity.StringEntity;

import gateway.Connection;
import request.ARequest;
import request.interfaces.ISendJSONObject;
import request.json.Password;
import response.AResponseFGW14IP;
import response.password.SetPasswordResponse;
import tools.JSONObject;

public class SetPasswordRequest extends ARequest implements ISendJSONObject
{

	private String passwordToSet ="";
	
	public SetPasswordRequest()
	{
		super("/password");
	}

	@Override
	public JSONObject getRequestBody() {
		Password login = new Password();
		login.setPassword(passwordToSet);
		return login;
	}

	@Override
	public String getFullRequestString() 
	{
		StringBuilder sb = new StringBuilder(Connection.getInstance().getDestinationIP());
		sb.append(this.apiName);
		System.out.println("anfrage: "+sb.toString());
		return sb.toString();
	}

	@Override
	public HttpUriRequestBase getRequest() 
	{
		HttpPut httpPut = new HttpPut(this.getFullRequestString());
		    
	    try
	    {
	    	httpPut.setHeader("accessToken", Connection.getInstance().getCurrentAccessToken());
	    	httpPut.setHeader("Accept", "application/json");
	    	httpPut.setHeader("Content-type", "application/json");
	    	String json = ARequest.getJSONString(this.getRequestBody());
	 	    final StringEntity entity = new StringEntity(json);
	 	    httpPut.setEntity(entity);
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    return httpPut;
	}

	@Override
	public Class<? extends AResponseFGW14IP> getResponseClass() {
		return SetPasswordResponse.class;
	}
	
	public String getPasswordToSet() {
		return passwordToSet;
	}

	public void setPasswordToSet(String password) {
		this.passwordToSet = password;
	}

}
