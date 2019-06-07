package utn.tacs.grupo3.mongo.repo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import utn.tacs.grupo3.model.ListOfPlaces;
import utn.tacs.grupo3.model.User;

@Repository
public class UserMongoRepo {
	
	@Autowired
	private MongoTemplate mongoTemplate;
			
	public User save(User user) {
		return mongoTemplate.save(user);
	}
	
	public User addList(String username, String listName) {
		Query query = new Query();
		query.addCriteria(Criteria.where("username").is(username));
		User user = mongoTemplate.findOne(query, User.class);
		
		ListOfPlaces listOfPlaces = new ListOfPlaces(listName);
		
		user.setListsOfPlaces(new ArrayList<ListOfPlaces>());
		
		user.getListsOfPlaces().add(listOfPlaces);
		
		return mongoTemplate.save(user);
	}
	
	public User getUserByUsername(String username) {
		Query query = new Query();
		query.addCriteria(Criteria.where("username").is(username));
		
		return mongoTemplate.findOne(query, User.class);
	}

}
