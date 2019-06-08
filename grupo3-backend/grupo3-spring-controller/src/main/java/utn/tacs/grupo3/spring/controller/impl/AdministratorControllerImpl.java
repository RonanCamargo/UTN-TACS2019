package utn.tacs.grupo3.spring.controller.impl;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import utn.tacs.grupo3.model.Place;
import utn.tacs.grupo3.model.User;
import utn.tacs.grupo3.model.exception.ExceptionbyResourceNotFound;
import utn.tacs.grupo3.repository.PlaceRepository;
import utn.tacs.grupo3.repository.mongo.UserRepository;
import utn.tacs.grupo3.spring.controller.AdministratorController;

@RestController
@RequestMapping("/administrator")
public class AdministratorControllerImpl implements AdministratorController {

//    @Autowired
    private utn.tacs.grupo3.repository.UserRepository userRepository;
    @Autowired
    private PlaceRepository placeRepository;
    
    @Autowired
    private UserRepository userRepoMongo;

    @Override
    @GetMapping("users/{user-id}")
    public User userById(@PathVariable("user-id") String userId) throws ExceptionbyResourceNotFound {
//        return userRepository.userByUsername(userId);
    	return userRepoMongo.userByUsername(userId);
    }

    @Override
    @GetMapping("places/places-in-common")
    public Map<String, Boolean> placesInCommon(@RequestParam("list-id-1") int listId1, @RequestParam("list-id-2") int listId2) throws ExceptionbyResourceNotFound {
//        ListOfPlaces listOfPlaces1 = userRepository.listOfPlacesById(listId1);
//        ListOfPlaces listOfPlaces2 = userRepository.listOfPlacesById(listId2);
        return Collections.singletonMap("placesInCommon", false);
    }

    @Override
    @GetMapping("places/{place-id}/interested-users")
    public Map<String, Long> numberOfInterestedUsers(@PathVariable("place-id") String placeId) throws ExceptionbyResourceNotFound {
        Place place = placeRepository.placeByName(placeId);
        return Collections.singletonMap("totalOfUsersInterested", userRepository.amountOfUsersInterestedIn(place));
    }

    @Override
    @GetMapping("places/registered-places")
    public Map<String, Long> registeredPlaces(@RequestParam("days") int days) {
        placeRepository.setCurrentDate(LocalDate.now());
//        return Collections.singletonMap("totalRegisteredPlaces", placeRepository.amountOfPlacesRegisteredInTheSystemInTheLast(days));
        return Collections.singletonMap("totalRegisteredPlaces", 1111111111L);

    }
}
