package utn.tacs.grupo3.telegram.bot.request;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ApiRequestImpl implements ApiRequest{
	
	private static final String API_BASE_URL = "http://localhost:8080";
	private static final String NEAR_PLACES = "/places/near?coordinates=";
	private RestTemplate rest = new RestTemplate();
	private ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public ResponseEntity<String> near(String coordinates) {		
		ResponseEntity<String> response = rest.getForEntity(API_BASE_URL + NEAR_PLACES + coordinates, String.class);
		
		return response;
		
	}

	@Override
	public ResponseEntity<String> listOfPlaces(String user, String listName) {
		String url = API_BASE_URL + "/users/" + user + "/list-of-places/" + listName;
		return rest.getForEntity(url, String.class);
	}

	@Override
	public List<String> listsOfPlacesNames(String user) {
		String url = API_BASE_URL + "/users/" + user + "/list-of-places";
		ResponseEntity<String> response = rest.getForEntity(url, String.class);
		
		JsonNode node;
		try {
			 node = mapper.readTree(response.getBody());
			 List<JsonNode> nodes = node.findParents("listName");
			 List<String> names = nodes.stream().map(aNode -> aNode.findValue("listName").asText()).collect(Collectors.toList());
			 return names;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return Arrays.asList("");
	}
}
