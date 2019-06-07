package utn.tacs.grupo3.repository.mongo;

import java.time.LocalDate;
import java.util.List;

import utn.tacs.grupo3.model.RegisteredPlace;

public interface RegisteredPlaceRepository extends GenericRepository<RegisteredPlace, String>{
	
	/**
	 * Returns a list of usernames who are interested in a specific place. 
	 * Interested users are the ones who saved a place into a list of places
	 * @param id
	 * @return
	 */
	List<String> usernamesOfInterestedInPlaceUsers(String id);
	
	/**
	 * Returns all places registered in the system until a given date
	 * @param date
	 * @return
	 */
	List<RegisteredPlace> placesRegisteredUntil(LocalDate date);
	
	

}
