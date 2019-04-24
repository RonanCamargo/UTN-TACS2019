package utn.tacs.grupo3.spring.controller;

import java.util.List;

import utn.tacs.grupo3.model.ListOfPlaces;
import utn.tacs.grupo3.model.User;

public interface UserController {

    /**
     * @return
     */
    List<User> users();

    /**
     * @param user
     * @return
     */
    String createUser(User user);

    /**
     * @param userId
     * @return
     */
    User userById(String userId);

    /**
     * @return
     */
    List<String> listsOfFavouritePlaces();

    /**
     * @param userId
     * @param listId
     * @return
     */
    String createPlacesListById(String userId, String listId);

    /**
     * @param userId
     * @param listId
     * @return
     */
    List<ListOfPlaces> favouritePlacesListById(String userId, String listId);

    /**
     * @param userId
     * @param listId
     * @return
     */
    String deleteFavouritePlacesList(String userId, String listId);

    /**
     * @param userId
     * @param listId
     * @param newName
     * @return
     */
    String editFavouritePlacesList(String userId, String listId, String newName);

    /**
     * @param userId
     * @param listId
     * @param placeId
     * @return
     */
    String registerFavouritePlaceInList(String userId, String listId, String placeId);

    /**
     * @param list1
     * @param list2
     * @return
     */
    boolean placesInCommon(String list1, String list2);

    /**
     * @param userId
     * @param placeId
     * @return
     */
    String markAsVisitedAPlace(String userId, String placeId);

}