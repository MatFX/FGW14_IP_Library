package request.system.network.ethernet;

import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.hc.core5.http.io.entity.StringEntity;

import gateway.Connection;
import request.ARequest;
import request.interfaces.ISendJSONObject;
import request.json.system.network.ethernet.Network_Ethernet;
import request.json.system.network.ethernet.SetStaticEthernetIP;
import request.system.network.ReadNetworkRequest;
import response.AResponseFGW14IP;
import response.system.network.ReadNetworkResponse;
import tools.JSONObject;

public class SetStaticEthernetIPRequest extends ReadNetworkRequest implements ISendJSONObject
{
	private String ip;
	
	private String subnetMask;
	
	private String standardGateway;
	
	private String dnsMain;
	
	private String dnsBackup;
	
	public SetStaticEthernetIPRequest()
	{
		super();
	}
	

	@Override
	public Class<? extends AResponseFGW14IP> getResponseClass() {
		return ReadNetworkResponse.class;
	}
	
	@Override
	public HttpUriRequestBase getRequest() 
	{
		HttpPut httpPut = new HttpPut(this.getFullRequestString());
		    
	    try
	    {
	    	httpPut.setHeader("accessToken", Connection.getInstance().getCurrentAccessToken());
	    	httpPut.setHeader("Accept", "application/json");
	    	httpPut.setHeader("Content-type", "application/json");
	    	String json = ARequest.getJSONString(this.getRequestBody());
	    	System.out.println("json " + json);
	 	    final StringEntity entity = new StringEntity(json);
	 	    httpPut.setEntity(entity);
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    return httpPut;
	}


	@Override
	public JSONObject getRequestBody() 
	{
		SetStaticEthernetIP setIp = new SetStaticEthernetIP();
		setIp.setIp(this.getIp());
		setIp.setSubnetMask(this.getSubnetMask());
		setIp.setStandardGateway(this.getStandardGateway());
		setIp.setDnsMain(this.getDnsMain());
		setIp.setDnsBackup(this.getDnsBackup());
		
		
		Network_Ethernet requestBody = new Network_Ethernet();
		requestBody.setEthernetContent(setIp);
		return requestBody;
	}

	public String getIp() {
		return ip;
	}


	public String getSubnetMask() {
		return subnetMask;
	}


	public String getStandardGateway() {
		return standardGateway;
	}


	public String getDnsMain() {
		return dnsMain;
	}


	public String getDnsBackup() {
		return dnsBackup;
	}


	public void setIp(String ip) {
		this.ip = ip;
	}


	public void setSubnetMask(String subnetMask) {
		this.subnetMask = subnetMask;
	}


	public void setStandardGateway(String standardGateway) {
		this.standardGateway = standardGateway;
	}


	public void setDnsMain(String dnsMain) {
		this.dnsMain = dnsMain;
	}


	public void setDnsBackup(String dnsBackup) {
		this.dnsBackup = dnsBackup;
	}

}
