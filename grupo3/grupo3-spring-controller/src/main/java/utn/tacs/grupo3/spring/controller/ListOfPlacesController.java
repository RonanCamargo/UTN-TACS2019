package utn.tacs.grupo3.spring.controller;

import utn.tacs.grupo3.model.ListOfPlaces;

import java.util.List;

public interface ListOfPlacesController {

    /**
     * Returns all lists of list-of-places that belong to a user
     *
     * @param userId
     * @return
     */
    List<ListOfPlaces> listsOfListOfPlaces(String userId);

    /**
     * Creates a new list-of-places for a user
     *
     * @param userId
     * @param listId
     * @return
     */
    String createListOfPlaces(String userId, String listId);

    /**
     * Returns a specific list-of-places that belongs to a user
     *
     * @param userId
     * @param listId
     * @return
     */
    List<ListOfPlaces> listOfPlacesListById(String userId, String listId);


    /**
     * Deletes a specific list-of-places places that belongs to a user
     *
     * @param userId
     * @param listId
     * @return
     */
    String deleteListOfPlacesList(String userId, String listId);


    /**
     * Changes the name of a list-of-places list that belongs to a user
     *
     * @param userId
     * @param listId
     * @param newName
     * @return
     */
    String editListOfPlacesList(String userId, String listId, String newName);

}
