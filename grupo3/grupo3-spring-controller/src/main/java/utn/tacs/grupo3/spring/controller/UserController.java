package utn.tacs.grupo3.spring.controller;

import java.util.List;

import utn.tacs.grupo3.model.ListOfPlaces;
import utn.tacs.grupo3.model.User;

/**
 * Interface for user-related controller methods
 *
 */
public interface UserController {

    /**
     * Returns all registered users
     * @return a list of users
     */
    List<User> users();

    /**
     * Registers a new user
     * @param user
     * @return
     */
    String createUser(User user);

    /**
     * Searches a user by its id
     * @param userId
     * @return
     */
    User userById(String userId);

    /**
     * Returns all lists of favourite places that belong to a user
     * @param userId
     * @return
     */
    List<ListOfPlaces> listsOfFavouritePlaces(String userId);

    /**
     * Creates a new list of favourite places for a user
     * @param userId
     * @param listId
     * @return
     */
    String createPlacesListById(String userId, String listId);

    /**
     * Returns a specific list of favourite places that belongs to a user
     * @param userId
     * @param listId
     * @return
     */
    List<ListOfPlaces> favouritePlacesListById(String userId, String listId);

    /**
     * Deletes a specific list of favourite places that belongs to a user
     * @param userId
     * @param listId
     * @return
     */
    String deleteFavouritePlacesList(String userId, String listId);

    /**
     * Changes the name of a favourite-places list that belongs to a user
     * @param userId
     * @param listId
     * @param newName
     * @return
     */
    String editFavouritePlacesList(String userId, String listId, String newName);

    /**
     * Register a new favourite place in an user's list
     * @param userId
     * @param listId
     * @param placeId
     * @return
     */
    String registerFavouritePlaceInList(String userId, String listId, String placeId);

    /**
     * Searches places in common among two lists of places
     * @param list1
     * @param list2
     * @return
     */
    boolean placesInCommon(String list1, String list2);

    /**
     * Marks a place as visited
     * @param userId
     * @param placeId
     * @return
     */
    String markAsVisitedAPlace(String userId, String placeId);

}