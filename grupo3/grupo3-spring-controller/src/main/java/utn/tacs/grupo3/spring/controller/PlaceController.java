package utn.tacs.grupo3.spring.controller;

import java.util.List;

import utn.tacs.grupo3.model.Place;

public interface PlaceController {

	/**
	 * 
	 * @return
	 */
	List<Place> places();

	/**
	 * 
	 * @param place
	 * @return
	 */
	String createPlace(Place place);

	/**
	 * 
	 * @param placeId
	 * @return
	 */
	Place placeById(String placeId);

	/**
	 * 
	 * @return
	 */
	List<Place> near();

	/**
	 * 
	 * @param placeId
	 * @return
	 */
	int numberOfInterestedUsers(String placeId);

	/**
	 * 
	 * @return
	 */
	List<Place> registeredPlaces();

}