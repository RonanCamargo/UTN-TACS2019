package utn.tacs.grupo3.telegram.bot.request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import utn.tacs.grupo3.telegram.bot.request.entity.ListOfPlace;
import utn.tacs.grupo3.telegram.bot.request.entity.Place;
import utn.tacs.grupo3.telegram.bot.request.entity.Venue;

public class ApiRequestImpl implements ApiRequest{
	
	private static final String API_BASE_URL = "http://localhost:8080";
	private static final String NEAR_PLACES = "/places/near?coordinates=:lat,:long";
	private static final String USER_LISTS_OF_PLACES = "/users/:user-id/list-of-places";
	
	private static Map<String, String> userTokenMap;
	
	static {
		userTokenMap = new HashMap<String, String>();		
	}
	
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
		
		ResponseEntity<List<ListOfPlace>> lists = rest.exchange(
				uri,
				HttpMethod.GET, null,
				new ParameterizedTypeReference<List<ListOfPlace>>() {});
		
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
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void addPlaceToList(String username, String listName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Venue venueByFoursquareId(String foursquareId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private String getToken(String username) {
		return userTokenMap.get(username);
	}


	@Override
	public List<Place> listByName(String username, String listName) {
		// TODO Auto-generated method stub
		return null;
	}

}
