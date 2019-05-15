package utn.tacs.grupo3.spring.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;


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
     * Searches a user by its id
     *
     * @param userId
     * @return
     */
    User userById(String userId) throws ExceptionbyResourceNotFound;


    /**
     * Register a new place in an user's list of places
     *
     * @param userId
     * @param listId
     * @param placeId
     * @return
     */
    String registerPlaceInListOfPlaces(String userId, String listId, String placeId) throws ExceptionbyResourceNotFound;


    /**
     * Marks a place as visited
     *
     * @param userId
     * @param placeId
     * @return
     */
    String markAsVisitedAPlace(String userId, String placeId) throws ExceptionbyResourceNotFound;
}