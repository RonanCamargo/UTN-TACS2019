package utn.tacs.grupo3.spring.controller;

import java.util.List;

import utn.tacs.grupo3.model.Place;
import utn.tacs.grupo3.model.RegisteredPlace;
import utn.tacs.grupo3.model.User;
import utn.tacs.grupo3.model.exception.ExceptionbyResourceNotFound;

public interface AdministratorController {
    /**
     * Searches a user by its id
     *
     * @param userId
     * @return
     */
    User userById(String userId) throws ExceptionbyResourceNotFound;
    /**
     * Searches places in common among two lists of places
     *
     * @param listId1
     * @param listId2
     * @return
     */    
    List<Place> placesInCommon(String userId1, String listName1, String userId2, String listName2);

    /**
     * Returns the number of interested users in a place
     *
     * @param placeId
     * @return
     */
    List<String> interestedUsers(String placeId) throws ExceptionbyResourceNotFound;

    /**
     * Returns the number of registered places in the last days
     *
     * @param days
     * @return
     */
    List<RegisteredPlace> registeredPlaces(int days);
}
