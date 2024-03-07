package request.json.system.devices;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MQTT_Forward extends Device
{
	public enum Forward
	{
		FORWARD(true),
		
		NO_FORWARD(false);
		
		private boolean valueToSet;
		
		private Forward(boolean valueToSet)
		{
			this.valueToSet = valueToSet;
		}
		
		public boolean getValueToSet()
		{
			return this.valueToSet;
		}
	}
	
	@JsonProperty("forwardOnMqtt")
	private boolean forwardOnMqtt;

	public boolean isForwardOnMqtt() {
		return forwardOnMqtt;
	}

	public void setForwardOnMqtt(boolean forwardOnMqtt) {
		this.forwardOnMqtt = forwardOnMqtt;
	}
	
	

}
