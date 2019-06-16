package utn.tacs.grupo3.spring.controller;

import utn.tacs.grupo3.spring.controller.response.Response;

public interface AdministratorController {
    /**
     * Searches a user by its id
     *
     * @param userId
     * @return
     */
    Response userById(String userId);
    /**
     * Searches places in common among two lists of places
     *
     * @param listId1
     * @param listId2
     * @return
     */    
    Response placesInCommon(String userId1, String listName1, String userId2, String listName2);

    /**
     * Returns the number of interested users in a place
     *
     * @param placeId
     * @return
     */
    Response interestedUsers(String placeId);

    /**
     * Returns the number of registered places in the last days
     *
     * @param days
     * @return
     */
    Response registeredPlaces(int days);
}
