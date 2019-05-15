package utn.tacs.grupo3.spring.controller.impl;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import utn.tacs.grupo3.model.Place;
import utn.tacs.grupo3.model.User;
import utn.tacs.grupo3.model.exception.ExceptionbyResourceNotFound;
import utn.tacs.grupo3.repository.PlaceRepository;
import utn.tacs.grupo3.repository.UserRepository;
import utn.tacs.grupo3.retrofit.FoursquarePlacesRequest;
import utn.tacs.grupo3.retrofit.pojo.venue.FullVenue;
import utn.tacs.grupo3.spring.controller.UserController;
import utn.tacs.grupo3.spring.converter.FullVenueToPlaceConverter;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RequestMapping("/users")
public class UserControllerImpl implements UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private FoursquarePlacesRequest foursquarePlacesRequest;
    @Autowired
    private FullVenueToPlaceConverter fullVenueToPlaceConverter;

    @Override
    @GetMapping
    public List<User> users() {
        return userRepository.allUsers();
    }

    @Override
    @GetMapping("/{user-id}")
    public User userById(@PathVariable("user-id") String userId) throws ExceptionbyResourceNotFound {
        return userRepository.userByFirstName(userId);
    }

    @Override
    @PutMapping("/{user-id}/places-visited/{place-id}")
    public String markAsVisitedAPlace(@PathVariable("user-id") String userId, @PathVariable("place-id") String placeId) throws ExceptionbyResourceNotFound {
        Place place = placeRepository.placeByName(placeId);
        userRepository.userByFirstName(userId).markAsVisited(place);
        return "lugar marcado como visitado.";
    }

    @Override
    @PostMapping("/{user-id}/list-of-places/{list-id}/{place-id}")
    public String registerPlaceInListOfPlaces(@PathVariable("user-id") String userId, @PathVariable("list-id") String listId, @PathVariable("place-id") String placeId) throws ExceptionbyResourceNotFound {
    	FullVenue venue = foursquarePlacesRequest.getVenueById(placeId);
    	Place place = fullVenueToPlaceConverter.convert(venue);

        userRepository.userByFirstName(userId).registerAPlaceinAListOfPlaces(listId, placeRepository.createPlace(place));
        return "Lugar registrado correctamente.";
    }
}
