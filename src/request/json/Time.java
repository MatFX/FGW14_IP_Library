package request.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import tools.JSONObject;

@JsonRootName("time") 
public class Time extends JSONObject
{
	@JsonProperty("time")
	private String time;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	

}