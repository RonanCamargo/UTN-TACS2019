package utn.tacs.grupo3.service.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utn.tacs.grupo3.model.ListOfPlaces;
import utn.tacs.grupo3.model.Place;
import utn.tacs.grupo3.model.RegisteredPlace;
import utn.tacs.grupo3.model.User;
import utn.tacs.grupo3.repository.mongo.RegisteredPlaceRepository;
import utn.tacs.grupo3.repository.mongo.UserRepository;
import utn.tacs.grupo3.service.AdministratorService;
import utn.tacs.grupo3.service.helper.TodayHelper;

@Service
public class AdministratorServiceImpl implements AdministratorService{

    @Autowired
    private UserRepository userRepository;    
    @Autowired
    private RegisteredPlaceRepository registeredPlaceRepository;
    @Autowired
    private TodayHelper todayHelper;
	
	@Override
	public User userById(String username) {
		return userRepository.userByUsername(username);
	}

	@Override
	public List<String> interestedUsersInAPlace(String placeId) {
		return registeredPlaceRepository.usernamesOfInterestedInPlaceUsers(placeId);
	}

	@Override
	public List<RegisteredPlace> registeredPlaces(int days) {
    	if (days == 0) {
			return registeredPlaceRepository.findAll();
		} else {
			LocalDate today = todayHelper.today();
			LocalDate initialDate = today.minus(days-1, ChronoUnit.DAYS);
			
			return registeredPlaceRepository.placesRegisteredBetween(initialDate, today);			
		}
	}

	@Override
	public List<Place> placesInCommon(String username1, String listName1, String username2, String listName2) {
		ListOfPlaces list1 = userRepository.findListOfPlaces(username1, listName1);
		ListOfPlaces list2 = userRepository.findListOfPlaces(username2, listName2);
		
		return list1.placesInCommonWith(list2);
	}

}
