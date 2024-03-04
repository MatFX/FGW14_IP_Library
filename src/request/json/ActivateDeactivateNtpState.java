package request.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import tools.JSONObject;

@JsonRootName("time") 
public class ActivateDeactivateNtpState extends JSONObject 
{
	public enum NTP_STATE
	{
		ACTIVATE("active"),
		
		INACTIVE("inactive");
		
		private String valueToSet = "";
		
		private NTP_STATE(String valueToSet)
		{
			this.valueToSet = valueToSet;
		}
		
		public String getValueToSet()
		{
			return this.valueToSet;
		}
	}
	
	@JsonProperty("ntpState")
	private String ntpState ="";
	
	public void setNtpState(NTP_STATE enumToSet)
	{
		ntpState = enumToSet.getValueToSet();
	}

	
	
}
