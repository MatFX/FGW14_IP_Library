package z.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import request.json.Login;

public class TestLoginSerialize {


	public static void main (String[] args) throws JsonMappingException, JsonProcessingException
	{
		
		Login test = new Login();
	
		test.setPassword("einKennwort");
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
		String field = objectMapper.writeValueAsString(test);
		System.out.println("field >> " + field);
		
		
		ObjectMapper objectMapperImport = new ObjectMapper();
		objectMapperImport.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
		Login login = objectMapperImport.readValue(field, Login.class);
		System.out.println("login object " + login);
		
		
	}


}
