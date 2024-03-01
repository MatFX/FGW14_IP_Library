package response.password;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import response.AResponseFGW14IP;

/**
 * Repsonse when user make a get password request
 * @author m.goerlich
 *
 */
@JsonRootName("password") 
public class ReadPasswordResponse extends AResponseFGW14IP 
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
