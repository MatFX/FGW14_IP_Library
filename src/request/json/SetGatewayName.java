package request.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import tools.JSONObject;

@JsonRootName("gateway") 
public class SetGatewayName extends JSONObject 
{
	@JsonProperty("name")
	private String name ="";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
