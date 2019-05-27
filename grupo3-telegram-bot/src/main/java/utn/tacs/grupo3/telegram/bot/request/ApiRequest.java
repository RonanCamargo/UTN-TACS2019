package utn.tacs.grupo3.telegram.bot.request;

import java.util.List;

import utn.tacs.grupo3.telegram.bot.request.entity.ListOfPlaces;
import utn.tacs.grupo3.telegram.bot.request.entity.Venue;
import utn.tacs.grupo3.telegram.bot.request.exception.BadCredentialsException;
import utn.tacs.grupo3.telegram.bot.user.UserCredentials;

/**
 * Interface for backend api requests
 *
 */
public interface ApiRequest {
		
	String login(UserCredentials user) throws BadCredentialsException;
	
	void logout(String username);
	
	List<String> listNames(String username, Integer telegramUserId);	
	
	List<Venue> near(float latitude, float longitude, Integer telegramUserId);
	
	List<Venue> searchPlacesByName(String name, Integer telegramUserId);
	
	void addPlaceToList(String username, String listName, String placeId, Integer telegramUserId);
	
	Venue venueByFoursquareId(String foursquareId);
	
	ListOfPlaces listByName(String username, String listName, Integer telegramUserId);

}
