package eu.matfx.request.json.system.time;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import eu.matfx.tools.JSONObject;

@JsonRootName("time") 
public class TimeZone extends JSONObject
{
	@JsonProperty("timeZone")
	private String timeZone;

	public String getTimeZone() {
		return timeZone;
	}

	/**
	 * "CET-1CEST,M3.4.0,M10.5.0/3"
	 * @param timeZone
	 */
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

}
