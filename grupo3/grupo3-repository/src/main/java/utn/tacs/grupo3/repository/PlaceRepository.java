package utn.tacs.grupo3.repository;

import org.springframework.stereotype.Repository;
import utn.tacs.grupo3.model.Place;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PlaceRepository {

	private List<Place> places;

	public PlaceRepository() {
		places = new ArrayList<Place>();
		places.add(new Place("McDonalds Callao", "Av. Callao 131"));
		places.add(new Place("On Tap Retiro ", "Marcelo Torcuato de Alvear 834"));
	}

	public List<Place> allPlaces(){
		return places;
	}
	
	public List<Place> placesByName(String name){
		return places.stream().
				filter(lugar -> lugar.getName().equalsIgnoreCase(name)).
				collect(Collectors.toList());
	}
	
	public void createPlace(String name, String location) {
		places.add(new Place(name, location));
	}

}
