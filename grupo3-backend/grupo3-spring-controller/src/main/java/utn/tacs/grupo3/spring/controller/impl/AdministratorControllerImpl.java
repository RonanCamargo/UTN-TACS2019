package utn.tacs.grupo3.spring.controller.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import utn.tacs.grupo3.model.ListOfPlaces;
import utn.tacs.grupo3.model.Place;
import utn.tacs.grupo3.model.RegisteredPlace;
import utn.tacs.grupo3.model.User;
import utn.tacs.grupo3.model.exception.ExceptionbyResourceNotFound;
import utn.tacs.grupo3.repository.mongo.RegisteredPlaceRepository;
import utn.tacs.grupo3.repository.mongo.UserRepository;
import utn.tacs.grupo3.spring.controller.AdministratorController;
import utn.tacs.grupo3.spring.helper.TodayHelper;

@RestController
@RequestMapping("/administrator")
public class AdministratorControllerImpl implements AdministratorController {

   
    @Autowired
    private UserRepository userRepository;    
    @Autowired
    private RegisteredPlaceRepository registeredPlaceRepository;
    @Autowired
    private TodayHelper todayHelper;

    @Override
    @GetMapping("users/{user-id}")
    public User userById(@PathVariable("user-id") String userId) throws ExceptionbyResourceNotFound {
    	return userRepository.userByUsername(userId);
    }

    @Deprecated
    @Override
//    @GetMapping("places/places-in-common")
    public Map<String, Boolean> placesInCommon(@RequestParam("list-id-1") int listId1, @RequestParam("list-id-2") int listId2) throws ExceptionbyResourceNotFound {
//        ListOfPlaces listOfPlaces1 = userRepository.listOfPlacesById(listId1);
//        ListOfPlaces listOfPlaces2 = userRepository.listOfPlacesById(listId2);
        return Collections.singletonMap("placesInCommon", false);
    }

    @Override
    @GetMapping("places/{place-id}/interested-users")
    public List<String> interestedUsers(@PathVariable("place-id") String placeId) throws ExceptionbyResourceNotFound {
    	return registeredPlaceRepository.usernamesOfInterestedInPlaceUsers(placeId);
    }

    @Override
    @GetMapping("places/registered-places")
    public List<RegisteredPlace> registeredPlaces(@RequestParam("days") int days) {
    	if (days == 0) {
			return registeredPlaceRepository.findAll();
		} else {
			LocalDate today = todayHelper.today();
			LocalDate initialDate = today.minus(days-1, ChronoUnit.DAYS);
			
			return registeredPlaceRepository.placesRegisteredBetween(initialDate, today);			
		}
    	
    }

	@Override
    @GetMapping("places/places-in-common")
	public List<Place> placesInCommon2(
			@RequestParam("user-id-1")String userId1, 
			@RequestParam("list-id-1")String listName1,
			@RequestParam("user-id-2")String userId2, 
			@RequestParam("list-id-2")String listName2) {
		
		ListOfPlaces list1 = userRepository.findListOfPlaces(userId1, listName1);
		ListOfPlaces list2 = userRepository.findListOfPlaces(userId2, listName2);
		
		return list1.placesInCommonWith(list2);
	}
}
