package utn.tacs.grupo3.telegram.bot.request;

import java.util.List;

import utn.tacs.grupo3.telegram.bot.request.entity.ListOfPlaces;
import utn.tacs.grupo3.telegram.bot.request.entity.Place;
import utn.tacs.grupo3.telegram.bot.request.entity.Venue;

/**
 * Interface for backend api requests
 *
 */
public interface ApiRequest {
		
	void login(String username, String password);
	
	void logout(String username);
	
	List<String> listNames(String username);	
	
	List<Venue> near(float latitude, float longitude);
	
	List<Venue> searchPlacesByName(String name);
	
	void addPlaceToList(String username, String listName);
	
	Venue venueByFoursquareId(String foursquareId);
	
	ListOfPlaces listByName(String username, String listName);
}
