package utn.tacs.grupo3.spring.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import utn.tacs.grupo3.model.Place;
import utn.tacs.grupo3.repository.PlaceRepository;
import utn.tacs.grupo3.retrofit.ForsquarePlacesRequest;
import utn.tacs.grupo3.spring.controller.PlaceController;

@RestController
@RequestMapping("/places")
public class PlaceControllerImpl implements PlaceController {

    @Autowired
    private PlaceRepository placeRepository;


    @Override
    @GetMapping
    public List<Place> places() {
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
        return placeRepository.placesByName(placeId).get(0);
    }

    @Override
    @GetMapping("/near")

    public String near(@RequestParam("coordinates") String coordinates) {
        ForsquarePlacesRequest forsquarePlacesRequest = new ForsquarePlacesRequest();
        return forsquarePlacesRequest.getAllPlaces(coordinates).get(0).getName();
    }

    @Override
    @GetMapping("/{place-id}/interested-users")
    public int numberOfInterestedUsers(@PathVariable("place-id") String placeId) {
        return 5;
    }

    @Override
    @GetMapping("/registered-places")
    public List<Place> registeredPlaces(@RequestParam("date") String date) {
        return placeRepository.allPlaces();
    }
}
