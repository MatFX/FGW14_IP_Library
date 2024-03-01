package response.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import response.AResponseFGW14IP;

/**
 * Get the accessToken when the login request was correct.
 * @author m.goerlich
 *
 */
@JsonRootName("login") 
public class LoginResponse extends AResponseFGW14IP 
{
	
	@JsonProperty("accessToken")
	private String accessToken;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
}
