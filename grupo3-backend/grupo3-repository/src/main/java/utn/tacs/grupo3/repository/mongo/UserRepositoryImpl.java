package utn.tacs.grupo3.repository.mongo;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import utn.tacs.grupo3.model.ListOfPlaces;
import utn.tacs.grupo3.model.Place;
import utn.tacs.grupo3.model.User;
import utn.tacs.grupo3.repository.exception.DocumentNotUniqueException;
import utn.tacs.grupo3.repository.exception.UserNotFoundException;

@Repository
public class UserRepositoryImpl extends GenericRepositoryImpl<User, String> implements UserRepository{
	
	@Override
	protected Class<User> getClassType() {
		return User.class;
	}	

	@Override
	protected String getCollectionName() {
		return "user";
	}

	@Override
	public User userByUsername(String username) {
		List<User> users = findBy("username", username);
		
		if (users == null || (users != null && users.isEmpty())) {
			throw new UserNotFoundException("User with username [" + username + "] does not exist");
		} else if (users.size() > 1) {
			throw new DocumentNotUniqueException("Multiple users with username [" + username + "] were found");
		} else {
			return users.get(0);
		}
	}

	@Override
	public void createListOfPlaces(String username, String listName) {
		Query queryListExists = new Query();
		queryListExists.addCriteria(
				Criteria.where("username").is(username)
				.and("listsOfPlaces.listName").is(listName)
				);
		
		if (mongoOps.exists(queryListExists, getCollectionName())) {
			throw new DocumentNotUniqueException("User [" + username + "] already has a list of places named [" + listName + "]");
		}
		
		Update update = new Update();
		update.addToSet("listsOfPlaces", new ListOfPlaces(listName));
		Query query = new Query();
		query.addCriteria(Criteria.where("username").is(username));
		
		mongoOps.updateFirst(query, update, getCollectionName());
	}

	@Override
	public void deleteListOfPlaces(String username, String listName) {
		Query query = new Query();
		query.addCriteria(Criteria.where("username").is(username));
		Update update = new Update().pull("listsOfPlaces", new ListOfPlaces(listName));
		
		mongoOps.updateMulti(query, update, getCollectionName());
	}

	@Override
	public void renameListOfPlaces(String username, String actualListName, String newListName) {		
		Query query = new Query();
		query.addCriteria(
				Criteria.where("username").is(username)
				.and("listsOfPlaces")
				.elemMatch(Criteria.where("listName").is(actualListName)));
		
		Update update = new Update().set("listsOfPlaces.$.listName", newListName);
		
		mongoOps.updateFirst(query, update, getCollectionName());
	}

	@Override
	public ListOfPlaces findListOfPlaces(String username, String listName) {
//		List<AggregationOperation> aggs = new ArrayList<AggregationOperation>();
//		aggs.add(Aggregation.unwind("listsOfPlaces"));
//		aggs.add(Aggregation.match(Criteria.where("listName").is(listName)));
//		
//		TypedAggregation<User> tAgg = new TypedAggregation<User>(User.class, aggs);
//
//		
//		return mongoOps.aggregate(tAgg, User.class, ListOfPlaces.class).getUniqueMappedResult();
		Query query = new Query();
		query.addCriteria(Criteria.where("username").is(username));
		
		User user = mongoOps.findOne(query, getClassType());
		return user.getListsOfPlaces().stream().filter(list -> list.getListName().contentEquals(listName)).findFirst().get();
	}

	@Override
	public void addPlaceToListOfPlaces(String username, String listName, Place place) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePlaceFromListOfPlaces(String username, String listName, String foursquareId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void markAPlaceAsVisited(String username, String listName, String foursquareId) {
		// TODO Auto-generated method stub
		
	}

}
