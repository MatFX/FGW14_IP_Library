package eu.matfx.request.json.system.network.wlan.station;

import com.fasterxml.jackson.annotation.JsonProperty;

import eu.matfx.request.json.system.network.wlan.AWlan;

/**
 * entry point for station
 * @author m.goerlich
 *
 */
public class Station extends AWlan
{
	@JsonProperty("station")
	private ASubStation aSubStation;
	
	
	/**
	 * method to set the different possible settings from the api
	 * @param aWlan
	 */
	public void setStationContent(ASubStation aSubStation)
	{
		this.aSubStation = aSubStation;
	}
	

}
