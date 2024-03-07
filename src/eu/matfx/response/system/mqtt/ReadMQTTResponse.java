package eu.matfx.response.system.mqtt;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import eu.matfx.response.AResponseFGW14IP;

@JsonRootName("mqtt") 
public class ReadMQTTResponse extends AResponseFGW14IP
{
	@JsonProperty("brokerUri")
	private String brokerUri;
	
	@JsonProperty("brokerPort")
	private String brokerPort;
	
	@JsonProperty("clientId")
	private String clientId;
	
	@JsonProperty("user")
	private String user;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("certificate")
	private String certificate;
	
	@JsonProperty("topicStart")
	private String topicStart;
	
	@JsonProperty("isConnected")
	private boolean isConnected;

	public String getBrokerUri() {
		return brokerUri;
	}

	public String getBrokerPort() {
		return brokerPort;
	}

	public String getClientId() {
		return clientId;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public String getCertificate() {
		return certificate;
	}

	public String getTopicStart() {
		return topicStart;
	}

	public boolean isConnected() {
		return isConnected;
	}

	public void setBrokerUri(String brokerUri) {
		this.brokerUri = brokerUri;
	}

	public void setBrokerPort(String brokerPort) {
		this.brokerPort = brokerPort;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public void setTopicStart(String topicStart) {
		this.topicStart = topicStart;
	}

	public void setConnected(boolean isConnected) {
		this.isConnected = isConnected;
	}
	

}
