package utn.tacs.grupo3.spring.controller;

import java.util.List;

import utn.tacs.grupo3.model.Place;
import utn.tacs.grupo3.model.exception.ExceptionbyResourceNotFound;

/**
 * Interface for place-related controller methods
 */
public interface PlaceController {

    /**
     * Returns all registered places
     *
     * @return a list of places
     */
    List<Place> places();

    /**
     * Registers a new place
     *
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
    Place placeById(String placeId) throws ExceptionbyResourceNotFound;

    /**
     * Searches near places based on coordinates
     *
     * @param coordinates
     * @return
     */
    String near(String coordinates);

}