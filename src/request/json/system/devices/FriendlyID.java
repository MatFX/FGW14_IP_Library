package request.json.system.devices;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FriendlyID extends Device
{
	@JsonProperty("friendlyId")
	private String friendlyId;

	public String getFriendlyId() {
		return friendlyId;
	}

	public void setFriendlyId(String friendlyId) {
		this.friendlyId = friendlyId;
	}

}
