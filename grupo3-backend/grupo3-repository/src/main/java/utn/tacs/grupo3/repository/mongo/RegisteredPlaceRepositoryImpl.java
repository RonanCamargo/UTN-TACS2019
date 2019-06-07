package utn.tacs.grupo3.repository.mongo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import utn.tacs.grupo3.model.RegisteredPlace;

@Repository
public class RegisteredPlaceRepositoryImpl extends GenericRepositoryImpl<RegisteredPlace, String> implements RegisteredPlaceRepository{

	@Override
	protected Class<RegisteredPlace> getClassType() {
		return RegisteredPlace.class;
	}

	@Override
	protected String getCollectionName() {
		return "registeredPlace";
	}

	@Override
	public List<String> usernamesOfInterestedInPlaceUsers(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RegisteredPlace> placesRegisteredUntil(LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInterestedUser(String id, String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addInterestedUser(String id, String username) {
		// TODO Auto-generated method stub
		
	}
	

}
