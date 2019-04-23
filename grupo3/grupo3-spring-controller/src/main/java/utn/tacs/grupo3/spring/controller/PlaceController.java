package utn.tacs.grupo3.spring.controller;

import java.util.List;

import utn.tacs.grupo3.model.Place;

public interface PlaceController {

    /**
     * @return
     */
    List<Place> places();

    /**
     * @param place
     * @return
     */
    String createPlace(Place place);

    /**
     * @param placeId
     * @return
     */
    Place placeById(String placeId);

    /**
     * @param coordinates
     * @return
     */
    String near(String coordinates);

    /**
     * @param placeId
     * @return
     */
    long numberOfInterestedUsers(String placeId);

    /**
     * @param days
     * @return
     */
    long registeredPlaces(int days);

}