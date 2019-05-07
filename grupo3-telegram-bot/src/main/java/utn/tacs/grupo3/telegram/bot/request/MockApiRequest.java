package utn.tacs.grupo3.telegram.bot.request;

import java.util.List;

import utn.tacs.grupo3.telegram.bot.request.entity.ListOfPlaces;
import utn.tacs.grupo3.telegram.bot.request.entity.Place;
import utn.tacs.grupo3.telegram.bot.request.entity.Venue;

public class MockApiRequest implements ApiRequest{

	@Override
	public void login(String username, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logout(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> listNames(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Venue> near(float latitude, float longitude) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Venue> searchPlacesByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Venue venueByFoursquareId(String foursquareId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListOfPlaces listByName(String username, String listName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addPlaceToList(String username, String listName, String placeId) {
		// TODO Auto-generated method stub
		
	}


}
