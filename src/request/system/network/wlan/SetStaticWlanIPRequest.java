package request.system.network.wlan;

import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.hc.core5.http.io.entity.StringEntity;

import gateway.Connection;
import request.ARequest;
import request.interfaces.ISendJSONObject;
import request.json.system.network.ethernet.Network_Ethernet;
import request.json.system.network.ethernet.SetStaticEthernetIP;
import request.json.system.network.wlan.Network_Wlan;
import request.json.system.network.wlan.station.SetStaticWlanIp;
import request.json.system.network.wlan.station.Station;
import request.system.network.ReadNetworkRequest;
import response.AResponseFGW14IP;
import response.system.network.ReadNetworkResponse;
import tools.JSONObject;

public class SetStaticWlanIPRequest extends ReadNetworkRequest implements ISendJSONObject
{
	private String ip;
	
	private String subnetMask;
	
	private String standardGateway;
	
	private String dnsMain;
	
	private String dnsBackup;
	
	public SetStaticWlanIPRequest()
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
		
		SetStaticWlanIp setIp = new SetStaticWlanIp();
		setIp.setIp(this.getIp());
		setIp.setSubnetMask(this.getSubnetMask());
		setIp.setStandardGateway(this.getStandardGateway());
		setIp.setDnsMain(this.getDnsMain());
		setIp.setDnsBackup(this.getDnsBackup());
		
		//station
		Station station = new Station();
		station.setStationContent(setIp);
		
		Network_Wlan requestBody = new Network_Wlan();
		requestBody.setWlanContent(station);
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
