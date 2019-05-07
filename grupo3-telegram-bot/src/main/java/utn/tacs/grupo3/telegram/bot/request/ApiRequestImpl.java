package utn.tacs.grupo3.telegram.bot.request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import utn.tacs.grupo3.telegram.bot.request.entity.ListOfPlaces;
import utn.tacs.grupo3.telegram.bot.request.entity.Venue;

public class ApiRequestImpl implements ApiRequest{
	
	private static final String API_BASE_URL = "http://localhost:8080";
	private static final String NEAR_PLACES = "/places/near?coordinates=:lat,:long";
	private static final String USER_LISTS_OF_PLACES = "/users/:user-id/list-of-places";
	private static final String PLACES_BY_NAME = "/places/near-by-name?name=:name";
	private static final String LIST_BY_NAME = "/users/:user-id/list-of-places/:list-name";
	private static final String ADD_PLACE_TO_SELECTED_LIST = "/users/:user-id/list-of-places/:list-name/:place-id";
		
	
	private RestTemplate rest = new RestTemplate();
	
		
	@Override
	public void login(String username, String password) {
		// TODO Auto-generated method stub
	}
	
	
	@Override
	public void logout(String username) {
		// TODO Auto-generated method stub		
	}

	public List<String> listNames(String username){
		String uri = new URIBuilder()
				.setBaseUri(API_BASE_URL)
				.setRelativeUri(USER_LISTS_OF_PLACES)
				.setParameter(":user-id", username)
				.build();
		
		ResponseEntity<List<ListOfPlaces>> lists = rest.exchange(
				uri,
				HttpMethod.GET, null,
				new ParameterizedTypeReference<List<ListOfPlaces>>() {});
		
		return lists.getBody().stream().map(list -> list.getListName()).collect(Collectors.toList());
	}


	@Override
	public List<Venue> near(float latitude, float longitude) {
		String uri = new URIBuilder()
				.setBaseUri(API_BASE_URL)
				.setRelativeUri(NEAR_PLACES)
				.setParameter(":lat", latitude)
				.setParameter(":long", longitude)
				.build();
		
		ResponseEntity<List<Venue>> venuesNearLocation = rest.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<Venue>>() {});
		
		return venuesNearLocation.getBody();
	}


	@Override
	public List<Venue> searchPlacesByName(String name) {
		String uri = new URIBuilder()
				.setBaseUri(API_BASE_URL)
				.setRelativeUri(PLACES_BY_NAME)
				.setParameter(":name", name)
				.build();
		ResponseEntity<List<Venue>> venuesByName = rest.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<Venue>>() {});
		
		return venuesByName.getBody();
	}


	@Override
	public void addPlaceToList(String username, String listName, String placeId) {
		String uri = new URIBuilder()
				.setBaseUri(API_BASE_URL)
				.setRelativeUri(ADD_PLACE_TO_SELECTED_LIST)
				.setParameter(":user-id", username)
				.setParameter(":list-name", listName)
				.setParameter(":place-id", placeId)
				.build();
		
		ResponseEntity<String> response = rest.exchange(uri, HttpMethod.POST, null, String.class);
		response.getBody();
	}

	@Override
	public Venue venueByFoursquareId(String foursquareId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListOfPlaces listByName(String username, String listName) {
		String uri = new URIBuilder()
				.setBaseUri(API_BASE_URL)
				.setRelativeUri(LIST_BY_NAME)
				.setParameter(":user-id", username)
				.setParameter(":list-name", listName)
				.build();
		ResponseEntity<ListOfPlaces> listOfPlaces = rest.exchange(uri, HttpMethod.GET, null, ListOfPlaces.class);
		
		return listOfPlaces.getBody();
	}

}
