package request.json.system.mqtt;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConfigureUserPw extends MQTT 
{
	
	@JsonProperty("user")
	private String user;
	
	@JsonProperty("password")
	private String password;
	
	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
