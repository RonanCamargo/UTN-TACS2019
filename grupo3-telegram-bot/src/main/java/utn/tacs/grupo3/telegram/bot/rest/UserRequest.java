package utn.tacs.grupo3.telegram.bot.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class UserRequest {
	
	private static final String API_BASE_URL = "http://localhost:8080";
	private static final String USER_BY_ID = "/users/";
	
	public ResponseEntity<String> userById(String name){
		RestTemplate template = new RestTemplate();
		return template.getForEntity(API_BASE_URL + USER_BY_ID + name, String.class);	
	}

}
