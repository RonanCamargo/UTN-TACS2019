package utn.tacs.grupo3.spring.controller;

import java.util.List;

import utn.tacs.grupo3.model.FavouritePlaces;
import utn.tacs.grupo3.model.Place;
import utn.tacs.grupo3.model.User;

public interface UserController {

	/**
	 * 
	 * @return
	 */
	List<User> users();

	/**
	 * 
	 * @param user
	 * @return
	 */
	String createUser(User user);

	/**
	 * 
	 * @param userId
	 * @return
	 */
	User userById(String userId);

	/**
	 * 
	 * @return
	 */
	List<String> listsOfFavouritePlaces();

	/**
	 * 
	 * @return
	 */
	List<FavouritePlaces> favouritePlacesListById();

	/**
	 * 
	 * @return
	 */
	String deleteFavouritePlacesList();

	/**
	 * 
	 * @return
	 */
	String editFavouritePlacesList();

	/**
	 * 
	 * @return
	 */
	String registerFavouritePlaceInList();

	/**
	 * 
	 * @return
	 */
	List<Place> placesInCommon();

}