package utn.tacs.grupo3.spring.controller;

import utn.tacs.grupo3.model.exception.ExceptionbyResourceNotFound;
import utn.tacs.grupo3.spring.controller.response.Response;

public interface ListOfPlacesController {

    /**
     * Returns all lists of list-of-places that belong to a user
     *
     * @param userId
     * @return
     */
    Response listsOfListOfPlaces(String userId) throws ExceptionbyResourceNotFound;
    
    /**
     * Creates a new list-of-places for a user
     *
     * @param userId
     * @param listId
     */
    Response createListOfPlaces(String userId, String listId) throws ExceptionbyResourceNotFound;

    /**
     * Returns a specific list-of-places that belongs to a user
     *
     * @param userId
     * @param listId
     * @return
     */
    Response listOfPlacesListById(String userId, String listId) throws ExceptionbyResourceNotFound;


    /**
     * Deletes a specific list-of-places places that belongs to a user
     *
     * @param userId
     * @param listId
     */
    Response deleteListOfPlacesList(String userId, String listId) throws ExceptionbyResourceNotFound;


    /**
     * Changes the name of a list-of-places list that belongs to a user
     *
     * @param userId
     * @param listId
     * @param newName
     */
    Response editListOfPlacesList(String userId, String listId, String newName) throws ExceptionbyResourceNotFound;

}
