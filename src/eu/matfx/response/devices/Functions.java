package eu.matfx.response.devices;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Functions 
{
	@JsonProperty("key") 
	private String key;
	
	@JsonProperty("value") 
	private double value;
	
	@JsonProperty("unit") 
	private String unit;
	
	@JsonProperty("timestamp") 
	private String timestamp;

	public String getKey() {
		return key;
	}

	public double getValue() {
		return value;
	}

	public String getUnit() {
		return unit;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
	

}
