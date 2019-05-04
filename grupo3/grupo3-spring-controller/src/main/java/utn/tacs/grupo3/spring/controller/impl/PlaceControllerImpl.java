package utn.tacs.grupo3.spring.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import utn.tacs.grupo3.model.Place;
import utn.tacs.grupo3.model.exception.ExceptionbyResourceNotFound;
import utn.tacs.grupo3.repository.PlaceRepository;
import utn.tacs.grupo3.retrofit.FoursquarePlacesRequest;
import utn.tacs.grupo3.retrofit.pojo.Venue;
import utn.tacs.grupo3.spring.controller.PlaceController;

@RestController
@RequestMapping("/places")
public class PlaceControllerImpl implements PlaceController {

    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private FoursquarePlacesRequest foursquarePlacesRequest;

    @Override
    @GetMapping
    public List<Place> places() {
        return placeRepository.allPlaces();
    }

    @Override
    @PostMapping
    public String createPlace(@RequestBody Place place) {
        placeRepository.createPlace(place.getName());
        return "Lugar creado correctamente";
    }

    @Override
    @GetMapping("/{place-id}")
    public Place placeById(@PathVariable("place-id") String placeId) throws ExceptionbyResourceNotFound {
        return placeRepository.placeByName(placeId);
    }

    @Override
    @GetMapping("/near")
    public List<Venue> near(@RequestParam("coordinates") String coordinates) {
        return foursquarePlacesRequest.getAllPlaces(coordinates);
    }

}
