package utn.tacs.grupo3.spring.controller.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import utn.tacs.grupo3.model.Place;
import utn.tacs.grupo3.repository.PlaceRepository;
import utn.tacs.grupo3.repository.UserRepository;
import utn.tacs.grupo3.retrofit.ForsquarePlacesRequest;
import utn.tacs.grupo3.spring.controller.PlaceController;

@RestController
@RequestMapping("/places")
public class PlaceControllerImpl implements PlaceController {

    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private UserRepository userRepository;


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
    public long numberOfInterestedUsers(@PathVariable("place-id") String placeId) {
        Place place = placeRepository.placesByName(placeId).get(0);
        return userRepository.amountOfUsersInterestedIn(place);
    }

    @Override
    @GetMapping("/registered-places")
    public long registeredPlaces(@RequestParam("days") int days) {
        placeRepository.setCurrentDate(Calendar.getInstance().getTime());
        return placeRepository.amountOfPlacesRegisteredInTheSystemInTheLast(days);
    }
}
