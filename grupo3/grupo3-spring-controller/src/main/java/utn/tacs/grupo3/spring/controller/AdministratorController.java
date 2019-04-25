package utn.tacs.grupo3.spring.controller;

public interface AdministratorController {

    /**
     * Searches places in common among two lists of places
     *
     * @param list1
     * @param list2
     * @return
     */
    boolean placesInCommon(String list1, String list2);

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
