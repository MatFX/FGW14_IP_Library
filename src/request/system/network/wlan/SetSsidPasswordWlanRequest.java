package request.system.network.wlan;

import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.hc.core5.http.io.entity.StringEntity;

import gateway.Connection;
import request.ARequest;
import request.interfaces.ISendJSONObject;
import request.json.system.network.wlan.Network_Wlan;
import request.json.system.network.wlan.station.SetSsidPassword;
import request.json.system.network.wlan.station.Station;
import request.system.network.ReadNetworkRequest;
import response.AResponseFGW14IP;
import response.system.network.ReadNetworkResponse;
import tools.JSONObject;

public class SetSsidPasswordWlanRequest extends ReadNetworkRequest implements ISendJSONObject
{
	private String ssid;
	
	private String password;
	
	public SetSsidPasswordWlanRequest()
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
		
		SetSsidPassword setIp = new SetSsidPassword();
		setIp.setSsid(this.getSsid());
		setIp.setPassword(this.getPassword());
		
		//station
		Station station = new Station();
		station.setStationContent(setIp);
		
		Network_Wlan requestBody = new Network_Wlan();
		requestBody.setWlanContent(station);
		return requestBody;
	}


	public String getSsid() {
		return ssid;
	}


	public String getPassword() {
		return password;
	}


	public void setSsid(String ssid) {
		this.ssid = ssid;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	

}
