package utn.tacs.grupo3.repository.mongo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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
		return findById(id).getUsersWhoMarkedAsFavourite();
	}

	@Override
	public List<RegisteredPlace> placesRegisteredBetween(LocalDate from, LocalDate to) {
		Query query = new Query().addCriteria(Criteria.where("registrationDate").gte(from).lte(to));
		
		return mongoOps.find(query, getClassType(), getCollectionName());
	}

	@Override
	public void deleteInterestedUser(String id, String username) {
		Query query = new Query().addCriteria(Criteria.where("id").is(id));
		
		Update update = new Update().pull("usersWhoMarkedAsFavourite", username);
		
		mongoOps.updateFirst(query, update, getClassType());
	}

	@Override
	public void addInterestedUser(String id, String username) {
		Query query = new Query().addCriteria(Criteria.where("id").is(id));
		
		Update update = new Update().addToSet("usersWhoMarkedAsFavourite", username);
		
		mongoOps.updateFirst(query, update, getClassType());
	}
	

}
