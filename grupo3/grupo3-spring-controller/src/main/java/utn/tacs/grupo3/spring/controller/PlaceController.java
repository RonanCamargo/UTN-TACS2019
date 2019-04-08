package utn.tacs.grupo3.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import utn.tacs.grupo3.model.Place;
import utn.tacs.grupo3.repository.PlaceRepository;

@RestController
@RequestMapping("/places")
public class PlaceController{
	
	@Autowired
	private PlaceRepository placeRepository;


	@GetMapping
	public List<Place> places(){
		return placeRepository.allPlaces();
	}

	@PostMapping
	public String createPlace(@RequestBody Place place) {
		placeRepository.createPlace(place);
		
		return "Lugar creado correctamente";
	}
	
	@GetMapping("/{place-id}")
	public Place placeById(@PathVariable("place-id") String placeId) {
		return placeRepository.placesByName(placeId).get(0);
	}
	
	@GetMapping("/near")
	public List<Place> near(){
		return placeRepository.allPlaces();
	}
	
	@GetMapping("/{place-id}/interested-users")
	public int numberOfInterestedUsers(@PathVariable("place-id") String placeId) {
		return 5;
	}
	
	@GetMapping("/registered-places")
	public List<Place> registeredPlaces() {
		return placeRepository.allPlaces();
	}
}
