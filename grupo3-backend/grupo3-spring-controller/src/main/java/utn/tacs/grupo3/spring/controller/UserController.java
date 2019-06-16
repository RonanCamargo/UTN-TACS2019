package utn.tacs.grupo3.spring.controller;

import utn.tacs.grupo3.model.exception.ExceptionbyResourceNotFound;
import utn.tacs.grupo3.spring.controller.response.Response;

/**
 * Interface for user-related controller methods
 */
public interface UserController {

    /**
     * Returns all registered users
     *
     * @return a list of users
     */
    Response users();

    /**
     * Register a new place in an user's list of places
     *
     * @param userId
     * @param listId
     * @param placeId
     */
    Response registerPlaceInListOfPlaces(String userId, String listId, String placeId) throws ExceptionbyResourceNotFound;


    /**
     * Marks a place as visited
     *
     * @param userId
     * @param placeId
     */
    Response markAsVisitedAPlace(String userId, String listId, String placeId) throws ExceptionbyResourceNotFound;
}