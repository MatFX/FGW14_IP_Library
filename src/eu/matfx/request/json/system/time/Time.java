package eu.matfx.request.json.system.time;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import eu.matfx.tools.JSONObject;

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
