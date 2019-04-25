package utn.tacs.grupo3.spring.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utn.tacs.grupo3.model.ListOfPlaces;
import utn.tacs.grupo3.model.Place;
import utn.tacs.grupo3.repository.PlaceRepository;
import utn.tacs.grupo3.repository.UserRepository;
import utn.tacs.grupo3.spring.controller.AdministratorController;

import java.time.LocalDate;

@RestController
@RequestMapping("/places")
public class AdministratorControllerImpl implements AdministratorController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PlaceRepository placeRepository;

    @Override
    @GetMapping("/places-in-common")
    public boolean placesInCommon(@RequestParam("list-1") String list1, @RequestParam("list-2") String list2) {
        ListOfPlaces listOfPlaces1 = userRepository.listOfPlacesByName(list1);
        ListOfPlaces listOfPlaces2 = userRepository.listOfPlacesByName(list2);
        return listOfPlaces1.areTherePlacesInCommonWith(listOfPlaces2);
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
        placeRepository.setCurrentDate(LocalDate.now());
        return placeRepository.amountOfPlacesRegisteredInTheSystemInTheLast(days);
    }
}
