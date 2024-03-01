package request.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import tools.JSONObject;

@JsonRootName("password") 
public class Password extends JSONObject 
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
