package utn.tacs.grupo3.telegram.bot.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PlaceRequest {
	
	private static final String API_BASE_URL = "http://localhost:8080";
	private static final String NEAR_PLACES = "/places/near?coordinates=";
	
	public ResponseEntity<String> near(String coordinates) {
		RestTemplate rest = new RestTemplate();
		
		
		ResponseEntity<String> response = rest.getForEntity(API_BASE_URL + NEAR_PLACES + coordinates, String.class);
		
		return response;
		
	}

}
