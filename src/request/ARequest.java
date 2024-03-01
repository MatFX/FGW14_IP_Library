package request;

import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import response.AResponseFGW14IP;
import tools.JSONObject;

public abstract class ARequest
{
	

	/**
	 * Api Name der in dem jeweiligen RequestObjekt zu überschreiben ist.
	 */
	protected String apiName = "/api";
	
	protected ARequest(String furtherRequest)
	{
		this.apiName = apiName + furtherRequest;
	}
	
	/**
	 * Der wird bei den erweiterten Klassen gebaut denn nur die wissen, was es noch für Parameter gibt
	 * @return
	 */
	public abstract String getFullRequestString();
	
	/**
	 * Aus den Daten der erweiterten Objekte wird eine Anfrage gebaut, die versendet werden kann.
	 * <br>Der Rückgabetyp wird bei der Implementierung festgelegt.
	 * @return
	 */
	public abstract HttpUriRequestBase getRequest();
	
	public abstract Class<? extends AResponseFGW14IP> getResponseClass();
	
	/**
	 * Manchmal kann es sein, dass etwas hinzugefügt werden muss siehe Profiles
	 * @param addApiName
	 */
	public void appendAPIName(String addApiName)
	{
		this.apiName = this.apiName + addApiName;
	}
	
	/**
	 * Convert the JSON object to the string for the request body.
	 * @param jsonObject
	 * @return
	 * @throws JsonProcessingException
	 */
	public static String getJSONString(JSONObject jsonObject) throws JsonProcessingException
	{
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
		String jsonString = objectMapper.writeValueAsString(jsonObject);
		return jsonString;
	}

}
