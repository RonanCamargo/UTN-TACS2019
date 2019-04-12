package utn.tacs.grupo3.spring.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import utn.tacs.grupo3.model.GetDataService;
import utn.tacs.grupo3.model.Place;
import utn.tacs.grupo3.model.RetrofitClientInstance;
import utn.tacs.grupo3.model.pojoFoursquare.Json;
import utn.tacs.grupo3.repository.PlaceRepository;
import utn.tacs.grupo3.spring.controller.PlaceController;

@RestController
@RequestMapping("/places")
public class PlaceControllerImpl implements PlaceController{
	
	@Autowired
	private PlaceRepository placeRepository;


	@Override
	@GetMapping
	public List<Place> places(){
		return placeRepository.allPlaces();
	}

	@Override
	@PostMapping
	public String createPlace(@RequestBody Place place) {
		placeRepository.createPlace(place);
		
		return "Lugar creado correctamente";
	}
	
	@Override
	@GetMapping("/{place-id}")
	public Place placeById(@PathVariable("place-id") String placeId) {

		/*Create handle for the RetrofitInstance interface*/
		final String CLIENT_ID = "0CIZ4KNH3ALVF0GUOZ12A143LUYBUFLGDKF1GBNFF0G0JSSR";
		final String CLIENT_SECRET = "BEK4JRCQKDEIZJB3GUBLE3SUNY33WXNRQ5EWBNJFOTOYSHN5";
		final String DATE = "20180703";

		GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
		Call<Json> call = service.getAllPlaces(CLIENT_ID,CLIENT_SECRET,DATE,"-34.598599800,-58.419921700",5);
		call.enqueue(new Callback<Json>() {
			@Override
			public void onResponse(Call<Json> call, Response<Json> response) {
				response.body();
			}

			@Override
			public void onFailure(Call<Json> call, Throwable t) {
				int sds;

			}
		});

		return placeRepository.placesByName(placeId).get(0);
	}
	
	@Override
	@GetMapping("/near")
	public List<Place> near(){
		return placeRepository.allPlaces();
	}
	
	@Override
	@GetMapping("/{place-id}/interested-users")
	public int numberOfInterestedUsers(@PathVariable("place-id") String placeId) {
		return 5;
	}

	@Override
	@GetMapping("/registered-places")
	public List<Place> registeredPlaces() {
		return placeRepository.allPlaces();
	}
}
