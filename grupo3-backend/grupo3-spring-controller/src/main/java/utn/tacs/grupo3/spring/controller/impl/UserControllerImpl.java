package utn.tacs.grupo3.spring.controller.impl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import utn.tacs.grupo3.model.Coordinates;
import utn.tacs.grupo3.model.Place;
import utn.tacs.grupo3.model.RegisteredPlace;
import utn.tacs.grupo3.model.User;
import utn.tacs.grupo3.model.exception.ExceptionbyResourceNotFound;
import utn.tacs.grupo3.repository.mongo.RegisteredPlaceRepository;
import utn.tacs.grupo3.repository.mongo.UserRepository;
import utn.tacs.grupo3.retrofit.FoursquarePlacesRequest;
import utn.tacs.grupo3.retrofit.pojo.venue.FullVenue;
import utn.tacs.grupo3.spring.controller.UserController;
import utn.tacs.grupo3.spring.converter.FullVenueToPlaceConverter;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RequestMapping("/users")
public class UserControllerImpl implements UserController {

//    @Autowired
//    private utn.tacs.grupo3.repository.UserRepository userRepository;
//    @Autowired
//    private PlaceRepository placeRepository;
    @Autowired
    private FoursquarePlacesRequest foursquarePlacesRequest;
    @Autowired
    private FullVenueToPlaceConverter fullVenueToPlaceConverter;
    
    @Autowired
    private RegisteredPlaceRepository registeredPlaceRepository;

    @Autowired
    private UserRepository userRepoMongo;
    
    @Override
    @GetMapping
    public List<User> users() {
        return userRepoMongo.findAll();
    }

    @Override
    @PutMapping("/{user-id}/{list-id}/places-visited/{place-id}")
    public void markAsVisitedAPlace(@PathVariable("user-id") String userId, @PathVariable("list-id") String listId, @PathVariable("place-id") String placeId) throws ExceptionbyResourceNotFound {
//        Place place = placeRepository.placeByName(placeId);
//        userRepository.userByUsername(userId).markAsVisited(place);
    	userRepoMongo.markAPlaceAsVisited(userId, listId, placeId);        
    }

    @Override
    @PostMapping("/{user-id}/list-of-places/{list-id}/{place-id}")
    public void registerPlaceInListOfPlaces(@PathVariable("user-id") String userId, @PathVariable("list-id") String listId, @PathVariable("place-id") String placeId) throws ExceptionbyResourceNotFound {
    	FullVenue venue = foursquarePlacesRequest.getVenueById(placeId);
    	Place place = fullVenueToPlaceConverter.convert(venue);
    	
    	userRepoMongo.addPlaceToListOfPlaces(userId, listId, place);
    	
    	if (registeredPlaceRepository.existsBy("foursquareId", placeId)) {
			RegisteredPlace registeredPlace = registeredPlaceRepository.findBy("foursquareId", placeId).get(0);
			registeredPlaceRepository.addInterestedUser(registeredPlace.getId(), userId);
		} else {
			registeredPlaceRepository.save(getRegisteredPlace(venue, userId));
		}

//        userRepository.userByUsername(userId).registerAPlaceinAListOfPlaces(listId, placeRepository.createPlace(place));
    }
    
    //TODO extraer
    private RegisteredPlace getRegisteredPlace(FullVenue venue, String username) {
    	RegisteredPlace registeredPlace = new RegisteredPlace();
    	registeredPlace.setName(venue.getName());
    	registeredPlace.setAddress(venue.getLocation().getAddress());
    	registeredPlace.setRegistrationDate(LocalDate.now());
    	registeredPlace.setFoursquareId(venue.getId());
    	registeredPlace.setCoordinates(new Coordinates(venue.getLocation().getLat().floatValue(), venue.getLocation().getLng().floatValue()));
    	registeredPlace.setUsersWhoMarkedAsFavourite(Arrays.asList(username));
    	
    	return registeredPlace;
    	
    }
}
