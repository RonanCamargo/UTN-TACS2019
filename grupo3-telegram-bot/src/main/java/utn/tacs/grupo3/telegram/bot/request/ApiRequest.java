package utn.tacs.grupo3.telegram.bot.request;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface ApiRequest {
	
	ResponseEntity<String> near(String coordinates);
	
	ResponseEntity<String> listOfPlaces(String user, String listName);
	
	List<String> listsOfPlacesNames(String user);
	
}
