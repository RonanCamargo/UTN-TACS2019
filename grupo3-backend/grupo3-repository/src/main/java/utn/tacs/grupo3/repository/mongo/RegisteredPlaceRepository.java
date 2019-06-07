package utn.tacs.grupo3.repository.mongo;

import java.time.LocalDate;
import java.util.List;

import utn.tacs.grupo3.model.RegisteredPlace;

public interface RegisteredPlaceRepository extends GenericRepository<RegisteredPlace, String>{
	
	List<String> usernamesOfInterestedInPlaceUsers(String id);
	
	List<RegisteredPlace> placesRegisteredUntil(LocalDate date);
	
	

}
