package response.devices;


import com.fasterxml.jackson.annotation.JsonProperty;

public class DeviceWithFunction extends Device
{
	@JsonProperty("manufacturer") 
	private String manufacturer;
	
	@JsonProperty("functions") 
	private Functions[] functions;
	
	@JsonProperty("firstSeen") 
	private String firstSeen;
	
	@JsonProperty("lastSeen") 
	private String lastSeen;

	public Functions[] getFunctions() {
		return functions;
	}

	public String getFirstSeen() {
		return firstSeen;
	}

	public String getLastSeen() {
		return lastSeen;
	}

	public void setFunctions(Functions[] functions) {
		this.functions = functions;
	}

	public void setFirstSeen(String firstSeen) {
		this.firstSeen = firstSeen;
	}

	public void setLastSeen(String lastSeen) {
		this.lastSeen = lastSeen;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	

}
