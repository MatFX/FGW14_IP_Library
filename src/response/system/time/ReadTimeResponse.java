package response.system.time;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import response.AResponseFGW14IP;

@JsonRootName("time") 
public class ReadTimeResponse extends AResponseFGW14IP 
{

	@JsonProperty("ntpState")
	private String ntpState;
	
	@JsonProperty("ntpUri")
	private String ntpUri;
	
	@JsonProperty("timeZone")
	private String timeZone;


	@JsonProperty("time")
	private String time;
	
	public String getTime() {
		return time;
	}

	public String getNtpState() {
		return ntpState;
	}

	public String getNtpUri() {
		return ntpUri;
	}

	public String getTimeZone() {
		return timeZone;
	}
}
