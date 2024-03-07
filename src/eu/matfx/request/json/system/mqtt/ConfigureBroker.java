package eu.matfx.request.json.system.mqtt;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConfigureBroker extends MQTT 
{
	
	public enum ProtocolType
	{
		MQTT("mqtt://", 1883),
		
		MQTTS("mqtts://", 8883);
		
		private String prefixProtocol;
		
		private int portNumber;
		
		
		private ProtocolType(String prefix, int portNumber)
		{
			this.prefixProtocol = prefix;
			this.portNumber = portNumber;
		}


		public String getPrefixProtocol() {
			return prefixProtocol;
		}


		public int getPortNumber() {
			return portNumber;
		}
		
	}
	
	
	/**
	 * starts with mqtt:// or mqtts://
	 */
	@JsonProperty("brokerUri")
	private String brokerUri;
	
	@JsonProperty("brokerPort")
	private int brokerPort;
	
	@JsonProperty("certificate")
	private String certificate;

	public String getBrokerUri() {
		return brokerUri;
	}

	public int getBrokerPort() {
		return brokerPort;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setBrokerUri(String brokerUri) {
		this.brokerUri = brokerUri;
	}

	public void setBrokerPort(int brokerPort) {
		this.brokerPort = brokerPort;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

}
