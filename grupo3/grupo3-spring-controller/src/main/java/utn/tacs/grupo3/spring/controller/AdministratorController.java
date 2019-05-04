package utn.tacs.grupo3.spring.controller;

import utn.tacs.grupo3.model.exception.ExceptionbyResourceNotFound;

import java.util.Map;

public interface AdministratorController {

    /**
     * Searches places in common among two lists of places
     *
     * @param listId1
     * @param listId2
     * @return
     */
    Map<String, Boolean> placesInCommon(int listId1, int listId2) throws ExceptionbyResourceNotFound;

    /**
     * Returns the number of interested users in a place
     *
     * @param placeId
     * @return
     */
    Map<String, Long> numberOfInterestedUsers(String placeId) throws ExceptionbyResourceNotFound;

    /**
     * Returns the number of registered places in the last days
     *
     * @param days
     * @return
     */
    Map<String, Long> registeredPlaces(int days);
}
