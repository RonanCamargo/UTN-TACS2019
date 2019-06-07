package utn.tacs.grupo3.repository.mongo;

import utn.tacs.grupo3.model.ListOfPlaces;
import utn.tacs.grupo3.model.Place;
import utn.tacs.grupo3.model.User;

public interface UserRepository extends GenericRepository<User, String>{
	
	User userByUsername(String username);

	void createListOfPlaces(String username, String listName);
	
	void deleteListOfPlaces(String username, String listName);
	
	void renameListOfPlaces(String username, String actualListName, String newListName);
	
	ListOfPlaces findListOfPlaces(String username, String listName);
	
	void addPlaceToListOfPlaces(String username, String listName, Place place);
	
	void deletePlaceFromListOfPlaces(String username, String listName, String foursquareId);
	
	void markAPlaceAsVisited(String username, String listName, String foursquareId);

}
