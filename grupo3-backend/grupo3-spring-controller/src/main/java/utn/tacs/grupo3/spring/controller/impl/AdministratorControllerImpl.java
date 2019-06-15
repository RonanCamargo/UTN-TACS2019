package utn.tacs.grupo3.spring.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import utn.tacs.grupo3.model.Place;
import utn.tacs.grupo3.model.RegisteredPlace;
import utn.tacs.grupo3.model.User;
import utn.tacs.grupo3.model.exception.ExceptionbyResourceNotFound;
import utn.tacs.grupo3.service.AdministratorService;
import utn.tacs.grupo3.spring.controller.AdministratorController;

@RestController
@RequestMapping("/administrator")
public class AdministratorControllerImpl implements AdministratorController {

	@Autowired
	private AdministratorService administratorService;

    @Override
    @GetMapping("users/{user-id}")
    public User userById(@PathVariable("user-id") String userId) throws ExceptionbyResourceNotFound {
    	return administratorService.userById(userId);
    }

    @Override
    @GetMapping("places/{place-id}/interested-users")
    public List<String> interestedUsers(@PathVariable("place-id") String placeId) throws ExceptionbyResourceNotFound {
    	return administratorService.interestedUsersInAPlace(placeId);
    }

    @Override
    @GetMapping("places/registered-places")
    public List<RegisteredPlace> registeredPlaces(@RequestParam("days") int days) {
    	return administratorService.registeredPlaces(days);
    }

	@Override
    @GetMapping("places/places-in-common")
	public List<Place> placesInCommon(
			@RequestParam("user-id-1")String userId1, 
			@RequestParam("list-id-1")String listName1,
			@RequestParam("user-id-2")String userId2, 
			@RequestParam("list-id-2")String listName2) {
		
		return administratorService.placesInCommon(userId1, listName1, userId2, listName2);
	}
}
