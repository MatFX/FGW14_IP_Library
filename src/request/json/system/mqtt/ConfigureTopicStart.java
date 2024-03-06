package request.json.system.mqtt;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConfigureTopicStart extends MQTT 
{
	@JsonProperty("topicStart")
	private String topicStart;

	public String getTopicStart() {
		return topicStart;
	}

	public void setTopicStart(String topicStart) {
		this.topicStart = topicStart;
	}
	
	

}
