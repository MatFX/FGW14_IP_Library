package eu.matfx.request.json.system.network.wlan;

import com.fasterxml.jackson.annotation.JsonProperty;

import eu.matfx.request.json.system.network.wlan.station.ASubStation;

public class SwitchModeStation extends AWlan
{
	
	public enum Mode
	{
		STATION("station"),
		
		ACCESS_POINT("accessPoint");
		
		private String valueToSet = "";
		
		private Mode(String valueToSet)
		{
			this.valueToSet = valueToSet;
		}
		
		public String getValueToSet()
		{
			return this.valueToSet;
		}
	}

	@JsonProperty("mode")
	private String mode;

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

}
