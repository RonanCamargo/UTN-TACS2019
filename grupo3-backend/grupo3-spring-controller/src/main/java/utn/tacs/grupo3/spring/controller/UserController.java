package utn.tacs.grupo3.spring.controller;

import java.util.List;


import utn.tacs.grupo3.model.exception.ExceptionbyResourceNotFound;
import utn.tacs.grupo3.model.User;

/**
 * Interface for user-related controller methods
 */
public interface UserController {

    /**
     * Returns all registered users
     *
     * @return a list of users
     */
    List<User> users();



    /**
     * Register a new place in an user's list of places
     *
     * @param userId
     * @param listId
     * @param placeId
     */
    void registerPlaceInListOfPlaces(String userId, String listId, String placeId) throws ExceptionbyResourceNotFound;


    /**
     * Marks a place as visited
     *
     * @param userId
     * @param placeId
     */
    void markAsVisitedAPlace(String userId, String listId, String placeId) throws ExceptionbyResourceNotFound;
}