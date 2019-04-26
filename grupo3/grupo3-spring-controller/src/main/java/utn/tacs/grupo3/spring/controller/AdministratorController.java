package utn.tacs.grupo3.spring.controller;

public interface AdministratorController {

    /**
     * Searches places in common among two lists of places
     *
     * @param listId1
     * @param listId2
     * @return
     */
    boolean placesInCommon(int listId1, int listId2);

    /**
     * Returns the number of interested users in a place
     *
     * @param placeId
     * @return
     */
    long numberOfInterestedUsers(String placeId);

    /**
     * Returns the number of registered places in the last days
     *
     * @param days
     * @return
     */
    long registeredPlaces(int days);
}
