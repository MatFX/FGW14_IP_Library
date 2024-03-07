package eu.matfx.request.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import eu.matfx.tools.JSONObject;

@JsonRootName("login") 
public class Login extends JSONObject
{

	@JsonProperty("password")
	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
