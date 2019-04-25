package utn.tacs.grupo3.spring.controller;

import java.util.List;

import utn.tacs.grupo3.model.Place;

/**
 * Interface for place-related controller methods
 * 
 */
public interface PlaceController {

    /**
     * Returns all registered places
     * @return a list of places
     */
    List<Place> places();

    /**
     * Registers a new place
     * @param place
     * @return
     */
    String createPlace(Place place);

    /**
     * Searches a place by its id
     * 
     * @param placeId
     * @return
     */
    Place placeById(String placeId);

    /**
     * Searches near places based on coordinates
     * @param coordinates
     * @return
     */
    String near(String coordinates);

    /**
     * Returns the number of interested users in a place
     * @param placeId
     * @return
     */
    long numberOfInterestedUsers(String placeId);

    /**
     * Returns the number of registered places in the last days
     * @param days
     * @return
     */
    long registeredPlaces(int days);

}