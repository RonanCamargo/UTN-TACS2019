package utn.tacs.grupo3.repository.mongo;

import utn.tacs.grupo3.model.User;

public interface UserRepository extends GenericRepository<User, String>{
	
	User userByUsername(String username);

	void createListOfPlaces(String username, String listName);

}
